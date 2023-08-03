import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Cell {
        private int x;
        private int y;
        private static final int SIZE = 35;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void paint(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, SIZE, SIZE);
        }
    }

    class Grid extends JPanel {
        private static final int GRID_SIZE = 20;
        private Cell[][] cells;

        public Grid() {
            setPreferredSize(new Dimension(720, 720));
            initializeGrid();
        }

        private void initializeGrid() {
            cells = new Cell[GRID_SIZE][GRID_SIZE];
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    cells[i][j] = new Cell(i * 35, j * 35);
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    cells[i][j].paint(g);
                }
            }
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grid grid = new Grid();
        this.setContentPane(grid);
        this.pack();
        this.setVisible(true);
    }
}
