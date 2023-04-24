package uniandes.dpoo.taller4.modelo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class InterfazJuego extends JPanel {

	private boolean[][] lights = Tablero.darTablero();
	
	static int x = input("De que tamaño desea el tablero: ");
	
    private static int columnas = x;
    private static final int filas = x;
    private static final int tamano = 80;
    private static final int GRID_WIDTH = 2;
    private static final int ancho = columnas * tamano + 2 * tamano;
    private static final int alto = filas * tamano + 2 * tamano;
    private static final Color Color_Fondo = Color.BLACK;
    private static final Color Color_Prend = Color.YELLOW;
    private static final Color Color_Apag = Color.GRAY;
    
    

    public InterfazJuego() {
        setBackground(Color_Fondo);
        addMouseListener(new MouseAdapter() {
        	
        	
        	
            private void cambiocolor(int fila, int columna)
            {
                lights[fila][columna] = !lights[fila][columna];
                if (fila > 0) {
                    lights[fila-1][columna] = !lights[fila-1][columna];
                }
                if (fila < filas-1) {
                    lights[fila+1][columna] = !lights[fila+1][columna];
                }
                if (columna > 0) {
                    lights[fila][columna-1] = !lights[fila][columna-1];
                }
                if (columna < columnas-1) {
                    lights[fila][columna+1] = !lights[fila][columna+1];
                }
            }
            
            
            public void mouseClicked(MouseEvent e) {
                int fila = (e.getY() - tamano) / tamano;
                int columna = (e.getX() - tamano) / tamano;
                if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
                    cambiocolor(fila, columna);
                    repaint();
                }
            }
        });
    }

    
    	private static int input(String string) {
		// TODO Auto-generated method stub
		return 0;
	}


		//Creación lista
    	
        JPanel lista = new JPanel(new GridLayout(10, 2,20, 20));

      
        JTextField txtprimero = new JTextField(1);
        JTextField txtsegundo = new JTextField(8);
        JTextField txttercero = new JTextField(8);
        JTextField txtcuarto = new JTextField(8);
        JTextField txtquinto = new JTextField(8);
        JTextField txtsexto = new JTextField(8);
        JTextField txtseptimo = new JTextField(8);
        JTextField txtoctavo = new JTextField(8);
        JTextField txtnoveno = new JTextField(8);
        JTextField txtdecimo = new JTextField(8);



        //Add labels here
        JLabel lblprimero = new JLabel("Primero : ");
        JLabel lblsegundo = new JLabel("Segundo:");
        JLabel lbltercero = new JLabel("Tercero:");
        JLabel lblcuarto = new JLabel("Cuarto:");
        JLabel lblquinto = new JLabel("Quinto:");
        JLabel lblsexto = new JLabel("Sexto:");
        JLabel lblseptimo = new JLabel("Septimo:");
        JLabel lbloctavo = new JLabel("Octavo:");
        JLabel lblnoveno = new JLabel("Noveno:");
        JLabel lbldecimo = new JLabel("Décimo:");

        
        lista.add(lblprimero);
        lista.add(txtprimero);

    
        lista.add(lblsegundo);
        lista.add(txtsegundo);


        lista.add(lbltercero);
        lista.add(txttercero);


        lista.add(lblcuarto);
        lista.add(txtcuarto);

 
        lista.add(lblquinto);
        lista.add(txtquinto);

   
        lista.add(lblsexto);
        lista.add(txtsexto);

 
        lista.add(lblseptimo);
        lista.add(txtseptimo);
        
        lista.add(lbloctavo);
        lista.add(txtoctavo);
        
        lista.add(lblnoveno);
        lista.add(txtnoveno);
        
        lista.add(lbldecimo);
        lista.add(txtdecimo);


       int final = JOptionPane.showConfirmDialog(null, lista, "Top 10",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)
        if (final == JOptionPane.OK_OPTION)
        {

        }

    	
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color_Prend);
        for (int row = 0; row < filas; row++) {
            for (int col = 0; col < columnas; col++) {
                if (lights[row][col]) {
                    g.fillRect(col * tamano + tamano, row * tamano + tamano, tamano, tamano);
                }
            }
        }
        g.setColor(Color_Apag);
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (!lights[fila][columna]) {
                    g.fillRect(columna * tamano + tamano, fila * tamano + tamano, tamano, tamano);
                }
            }
        }
        g.setColor(Color.WHITE);
        for (int fila = 0; fila <= filas; fila++) {
            g.fillRect(tamano, fila * tamano + tamano - GRID_WIDTH / 2, columnas * tamano, GRID_WIDTH);
        }
        for (int columna = 0; columna <= columnas ; columna++) {
            g.fillRect(columna * tamano + tamano - GRID_WIDTH / 2, tamano, GRID_WIDTH, filas * tamano);
        }
    }

    public static void main(String[] args) {
        JFrame juego = new JFrame("Lights Out");
        juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        juego.setSize(ancho, alto);
    
    }}