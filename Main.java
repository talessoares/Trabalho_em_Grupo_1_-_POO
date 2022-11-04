

import controlelista.ListaClientes;
import controlelista.ListaLocacoes;
import controlelista.ListaVeiculos;
import menu.MenuLocadora;

public class Main {
    public static void main(String[] args) {
       MenuLocadora menuLocadora = new MenuLocadora(new ListaClientes(), new ListaLocacoes(), new ListaVeiculos());
       menuLocadora.menu();
    }
}