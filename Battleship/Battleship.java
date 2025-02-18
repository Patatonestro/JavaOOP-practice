import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");
        Scanner scanner = new Scanner(System.in);

        // 创建两个玩家
        Player player1 = new Player();
        Player player2 = new Player();

        // 玩家布置战船
        System.out.println("Player 1, choose your ships:");
        player1.chooseCoordinates(scanner);
        player1.displaySetupMap();

        System.out.println("Player 2, choose your ships:");
        player2.chooseCoordinates(scanner);
        player2.displaySetupMap();

        // 轮流攻击
        int player1Hits = 0;
        int player2Hits = 0;

        while (player1Hits < 5 && player2Hits < 5) {
            System.out.println("Player 1, it's your turn to hit. Enter coordinates x y:");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            if (player2.fireAt(x1, y1)) player1Hits++;
            player2.displayGameMap();

            if (player1Hits >= 5) {
                System.out.println("Player 1 wins!");
                break;
            }

            System.out.println("Player 2, it's your turn to hit. Enter coordinates x y:");
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            if (player1.fireAt(x2, y2)) player2Hits++;
            player1.displayGameMap();

            if (player2Hits >= 5) {
                System.out.println("Player 2 wins!");
                break;
            }
        }

        scanner.close();
    }

    static class Map {
        private char[][] hiddenMap = new char[5][5];
        private boolean[][] shipCoordinates = new boolean[5][5];

        public Map() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    hiddenMap[i][j] = '-';
                }
            }
        }

        public void placeShip(int x, int y) {
            shipCoordinates[x][y] = true;
        }

        public void displaySetupMap() {
            System.out.print("  ");
            for (int i = 0; i < 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < 5; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 5; j++) {
                    if (shipCoordinates[i][j]) {
                        System.out.print("@ ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
        }

        public void displayGameMap() {
            System.out.print("  ");
            for (int i = 0; i < 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < 5; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(hiddenMap[i][j] + " ");
                }
                System.out.println();
            }
        }

        public boolean fireAt(int x, int y) {
            if (x < 0 || x >= 5 || y < 0 || y >= 5) { // 合并检查逻辑
                System.out.println("Invalid coordinates. Choose different coordinates.");
                return false;
            }
            if (hiddenMap[x][y] != '-') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                return false;
            }

            hiddenMap[x][y] = shipCoordinates[x][y] ? 'X' : 'O'; // 根据命中情况设置
            System.out.println(shipCoordinates[x][y] ? "Hit!" : "Miss!");
            return shipCoordinates[x][y];
        }
    }

    static class Player {
        private Map map = new Map();

        public void chooseCoordinates(Scanner scanner) {
            System.out.println("Choose your ship coordinates (enter x and y between 0 and 4):");
            for (int i = 0; i < 5; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x < 0 || x >= 5 || y < 0 || y >= 5 || map.shipCoordinates[x][y]) {
                    System.out.println("Invalid or already chosen coordinate. Try again.");
                    i--; // 重新输入
                } else {
                    map.placeShip(x, y);
                }
            }
        }

        public void displaySetupMap() {
            map.displaySetupMap();
        }

        public void displayGameMap() {
            map.displayGameMap();
        }

        public boolean fireAt(int x, int y) {
            return map.fireAt(x, y);
        }
    }
}
