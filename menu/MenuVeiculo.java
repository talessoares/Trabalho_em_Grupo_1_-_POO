package menu;

import java.util.Scanner;

import controlelista.ListaVeiculos;
import veiculo.*;

public class MenuVeiculo {
    
    /**
     * O atributo listaVeiculos, do tipo ListaVeiculos, e utilizado para indentificar a lista de veiculos
     */
    private ListaVeiculos listaVeiculos;

    /**
     * Construtor default da classe MenuVeiculo<br>
     * <b>Uso: </b>
     * MenuVeiculo menuVeiculo = new MenuVeiculo(listaVeiculos);<br><br>
     * @param listaVeiculos ListaVeiculos que identifica a lista de veiculos
     */
    public MenuVeiculo(ListaVeiculos listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    /**
     * @return ListaVeiculos que identifica a lista de veiculos
     */
    public ListaVeiculos getListaVeiculos() {
        return listaVeiculos;
    }

    /** 
     * Verifica se possui veículos na listaVeiculos, caso possua imprime uma lista com as informações de todos os veículos.
     */
    public void imprimirInfoVeiculos() {
        if(listaVeiculos.getInfo() != null) {
            System.out.println("\n====== INFORMAÇÕES DE TODOS OS VEICULOS ======");
            System.out.println(listaVeiculos.getInfo());
        } else {
            System.out.println("\nNão existem veículos");
        }
    }

    /** 
     * Recebe uma placa, verifica se ela existe na listaVeiculos e caso possua imprime as informações do veículo.
     */
    public void getInformacaoVeiculo() {
        Scanner input = new Scanner(System.in);
        String placa = null;

        System.out.print("\nDigite a placa que se deseja obter as informaçôes: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            System.out.println("\n====== INFORMAÇÕES DO VEICULO ======");
            System.out.println(listaVeiculos.getInfo(placa));
        } else {
            System.out.println("Veiculo não existente!");
        }
    }

    /** 
     * Verifica se possui veículos na listaVeiculos, caso possua imprime uma lista com as informções da placa, diária e ano.
     */
    public void imprimirResumoVeiculos() {
        if(listaVeiculos.getResumoInfo() != null) {
           System.out.println("\n====== RESUMO DAS INFORMAÇÕES DE TODOS OS VEICULOS ======");
           System.out.println(listaVeiculos.getResumoInfo());
        } else {
            System.out.println("\nNão existem veículos");
        }   
    }

    /** 
     * Recebe uma placa e verifica se a placa já existe no sistema;
     * Recebe um ano e verifica se o ano é válido;
     * Recebe uma diária e verifica se a diária é valida;
     * Logo em seguida, pede qual veículo será adicionado e encaminha para o menu de sua escolha.
     */
    public void adicionaVeiculo() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        double diaria = 0.0;
        int modeloCarro = 0;
        int ano = 0;
        
        do {
            System.out.print("\nDigite a placa do veiculo: ");
            placa = input.nextLine();

            if(placa == null) {
                System.out.println("Placa inválida!");
            } else {
                if(listaVeiculos.existe(placa)) {
                    System.out.println("A placa já está adicionada no sistema!");
                }
            }
        } while(placa == null || listaVeiculos.existe(placa));

        do {
            System.out.print("Digite o ano do veiculo: ");
            ano = input.nextInt();

            if (ano <= 0){
                System.out.println("Ano inválido!");
            }
        } while (ano <= 0);

        do {
            System.out.print("Digite a diaria do veiculo: ");
            diaria = input.nextDouble();

            if (diaria <= 0){
                System.out.println("Valor da diária inválido");
            }
        } while (diaria <= 0);

        do {
            System.out.println("1) Ônibus");
            System.out.println("2) Carro");
            System.out.println("3) Caminhão");
            System.out.print("Digite o modelo do veículo: ");
            modeloCarro = input.nextInt();

            input.nextLine();

            if(modeloCarro >= 1 && modeloCarro <= 3) {

                switch(modeloCarro) {

                    case 1:
                        cadastrarOnibus(placa, ano, diaria);
                        break;

                    case 2:
                        cadastrarCarro(placa, ano, diaria);
                        break;

                    case 3:
                        cadastrarCaminhao(placa, ano, diaria);
                        break;
                }

            } else {
                System.out.println("Resposta inválida!");
            }

        } while(modeloCarro < 1 || modeloCarro > 3);

    }

     /** 
     * Recebe uma quantidade de passageiros e verifica se a quantidade é válida;
     * Recebe uma quantidade de portas e verifica se a quantidade é válida;
     * Recebe uma média de KM'S e verifica se a média é válida;
     * Recebe se o carro possui ar-condicionado e verifica se a resposta é válida;
     * @param placa 
     * @param ano
     * @param diaria 
     */
    public void cadastrarCarro(String placa, int ano, double diaria) {
        Scanner input = new Scanner(System.in);
        
        int numeroPassageiros = 0;
        int numeroPortas = 0;
        double mediaKM = 0.0;
        boolean arcondicionado = false;

        int escolha = 0;

        do {
            System.out.print("Digite a quantidade de passageiros: ");
            numeroPassageiros = input.nextInt();

            if (numeroPassageiros <= 0 || numeroPassageiros > 5){
                System.out.println("Número de passageiros inválido!");
            }
        } while (numeroPassageiros <= 0 || numeroPassageiros > 5);

        do {
            System.out.print("Digite a quantidade de portas: ");
            numeroPortas = input.nextInt();

            if(numeroPortas <= 0 || numeroPortas > 4){
                System.out.println("Número de portas inválido!");
            }
        } while (numeroPortas <=0 || numeroPortas > 4);

        do{
            System.out.print("Digite a media de KM por litro: ");
            mediaKM = input.nextDouble();

            if (mediaKM <=0){
                System.out.println("Média de KM inválida!");
            }
        } while (mediaKM <= 0);

        do {
            System.out.println("Possui Ar-Condicionado?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 2) {
                System.out.println("Escolha inválida!");
            } else {
                if(escolha == 1) {
                    arcondicionado = true;
                } else {
                    arcondicionado = false;
                }
            }
        } while(escolha < 1 || escolha > 2);

        listaVeiculos.add(new Carro(placa, ano, diaria, numeroPassageiros, numeroPortas, mediaKM, arcondicionado));
        System.out.println("Carro adicionado com sucesso");
    }


    /** 
     * Recebe uma quantidade de eixos e verifica se a quantidade é válida;
     * Recebe uma carga máxima e verifica se a carga é válida.
     * @param placa 
     * @param ano
     * @param diaria 
     */
    public void cadastrarCaminhao(String placa, int ano, double diaria) {
        Scanner input = new Scanner(System.in);

        int numeroEixos = 0;
        int cargaMaxima = 0;

        do {
            System.out.print("Digite o numero de eixos: ");
            numeroEixos = input.nextInt();
            if(numeroEixos <= 0 || numeroEixos > 10) {
                System.out.println("Número de eixos inválido!");
            }
        } while(numeroEixos <= 0 || numeroEixos > 10);

        do {
            System.out.print("Digite a carga máxima: ");
            cargaMaxima = input.nextInt();

            if(cargaMaxima <= 0 || cargaMaxima > 100000) {
                System.out.println("Carga máxima inválida!");
            }
        } while(cargaMaxima <= 0 || cargaMaxima > 100000);
        
        listaVeiculos.add(new Caminhao(placa, ano, diaria, numeroEixos, cargaMaxima));
        System.out.println("Caminhão adicionado com sucesso");
    }

    /** 
     * Recebe uma quantidade de passageiros e verifica se a quantidade é válida;
     * Recebe se o ônibus possui wifi e verifica se a resposta é válida;
     * Recebe se o ônibus possui ar-condicionado e verifica se a resposta é válida;
     * Recebe a categoria do assento e verifica se a resposta é válida;
     * Caso passar por todos verificações adiciona um ônibus.
     * @param placa 
     * @param ano
     * @param diaria 
     */
    public void cadastrarOnibus(String placa, int ano, double diaria) {
        Scanner input = new Scanner(System.in);

        int numeroPassageiros = 0;
        Categoria categoria = Categoria.CONVENCIONAL;
        boolean wifi = false;
        boolean arcondicionado = false;

        int escolha = 0;

        do{
            System.out.print("Digite a quantidade de passageiros: ");
            numeroPassageiros = input.nextInt();

            if (numeroPassageiros <=0 || numeroPassageiros > 61){
                System.out.println("Número de passageiros inválido!");
            }
        } while (numeroPassageiros <=0 || numeroPassageiros > 61);

        do {
            System.out.println("Possui wifi?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 2) {
                System.out.println("Escolha inválida!");
            } else {
                if(escolha == 1) {
                    wifi = true;
                } else {
                    wifi = false;
                }
            }
        } while(escolha < 1 || escolha > 2);
                        
        do {
            System.out.println("Possui Ar-Condicionado?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 2) {
                System.out.println("Escolha inválida!");
            } else {
                if(escolha == 1) {
                    arcondicionado = true;
                } else if(escolha == 2) {
                    arcondicionado = false;
                }
            }
        } while(escolha < 1 || escolha > 2);

        do {
            System.out.println("Categorias: ");
            System.out.println("1) Leito");
            System.out.println("2) Convencional");
            System.out.println("3) Executivo");
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 3) {
                System.out.println("Escolha inválida!");
            } else {
                if(escolha == 1) {
                    categoria = Categoria.LEITO;
                } else if(escolha == 2) {
                    categoria = Categoria.CONVENCIONAL;
                } else if(escolha == 3) {
                    categoria = Categoria.EXECUTIVO;
                }
            }
        } while(escolha < 1 || escolha > 3);

        listaVeiculos.add(new Onibus(placa, ano, diaria, numeroPassageiros, categoria, wifi, arcondicionado));
        System.out.println("Ônibus adicionado com sucesso");

    }
    /** 
     * Recebe um novo ano e altera;
     * @param placa 
     */
    public void alteraAno(String placa) {
        Scanner input = new Scanner(System.in);
        int ano = 0;

        System.out.print("Digite o novo ano: ");
        ano = input.nextInt();
        listaVeiculos.setAno(placa, ano);
        System.out.println("Ano alterado com sucesso!");
    }

    /** 
     * Recebe uma nova diária e altera;
     * @param placa 
     */
    public void alteraDiaria(String placa) {
        Scanner input = new Scanner(System.in);
        double diaria = 0.0;

        System.out.print("Digite a nova diaria: ");
        diaria = input.nextDouble();
        listaVeiculos.setDiaria(placa, diaria);
        System.out.println("Diaria alterada com sucesso!");
    }

    /* FAZER OS SETS DE CADA CATEGORIA DE VEICULO */

    /* ALTERA DO CARRO */

    /** 
     * Recebe um novo número de passageiros e altera;
     * @param placa 
     */
    public void alteraNumeroPassageiroCarro(String placa) {
        Scanner input = new Scanner(System.in);
        int numeroPasseiros = 0;

        System.out.print("Digite o novo número de passageiros: ");
        numeroPasseiros = input.nextInt();

        if(numeroPasseiros <= 0 || numeroPasseiros > 5) {
            System.out.println("Número de passageiros inválido!");
        } else {
            listaVeiculos.setNumeroPassageiroCarro(placa, numeroPasseiros);
            System.out.println("Número de passageiros alterado com sucesso!");
        }             
            
    }

    /** 
     * Recebe um novo número de portas e altera;
     * @param placa 
     */
    public void alteraNumeroPortaCarro(String placa) {
        Scanner input = new Scanner(System.in);
        int numeroPortas = 0;

        System.out.print("Digite o novo número de portas: ");
        numeroPortas = input.nextInt();
                
        if(numeroPortas <= 0 || numeroPortas > 5) {
            System.out.println("Número de portas inválido!");
        } else {
            listaVeiculos.setNumeroPortaCarro(placa, numeroPortas);
            System.out.print("Número de portas alterado com sucesso!");
        }
                    
            
    }

    /** 
     * Recebe uma nova média de KM's e altera;
     * @param placa 
     */
    public void alteraMediaKmCarro(String placa) {
        Scanner input = new Scanner(System.in);

        double mediaKm = 0.0;
        
        System.out.print("Digite a nova media de km: ");
        mediaKm = input.nextDouble();

        if(mediaKm <= 0){
            System.out.println("A media de km não pode ser negativa!");
        } else {
            listaVeiculos.setMediaKMCarro(placa, mediaKm);         
            System.out.println("Média de KM'S alterada com sucesso!");  
        }
    }

    /** 
     * Recebe uma nova atribuição para o ar-condicionado e altera;
     * @param placa 
     */
    public void alteraArCondicionadoCarro(String placa) {
        Scanner input = new Scanner(System.in);
        int escolha = 0;
        boolean arcondicionado = false;

        do {
            System.out.println("Seu carro possui ar-condicionado?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
                    
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 2) {
                System.out.println("Opção inválida!");
            } else {
                if(escolha == 1)  {
                    arcondicionado = true;
                } else if(escolha == 2) {
                    arcondicionado = false;
                }
                listaVeiculos.setArcondicionadoCarro(placa, arcondicionado);
                System.out.println("Ar-condicionado alterado com sucesso!");
            }
        } while(escolha < 1 || escolha > 2);
                
           
    }

    /* ALTERA DO ONIBUS  */
    
    /** 
     * Recebe um novo número de passageiros e altera;
     * @param placa 
     */
    public void alteraNumeroPassageiroOnibus(String placa) {
        Scanner input = new Scanner(System.in);
        int numeroPassageiros = 0;
        
        System.out.print("Digite o novo número de passageiros: ");
        numeroPassageiros = input.nextInt();
        listaVeiculos.setNumeroPassageiroOnibus(placa, numeroPassageiros);
        System.out.println("Número de passageiros alterado com sucesso!");
            
    }
     /** 
     * Recebe uma nova categoria de assento e altera;
     * @param placa 
     */
    public void alteraCategoriaOnibus(String placa) {
        Scanner input = new Scanner(System.in);

        int escolha = 0;
        Categoria categoria = Categoria.CONVENCIONAL;
        
        do {
            System.out.println("Qual a nova categoria do ônibus? ");
            System.out.println("1) Leito");
            System.out.println("2) Convencional");
            System.out.println("3) Executivo");
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 3) {
                System.out.println("Escolha inválida!");
            } else {
                if(escolha == 1) {
                    categoria = Categoria.LEITO;
                } else if(escolha == 2) {
                    categoria = Categoria.CONVENCIONAL;
                } else if(escolha == 3) {
                    categoria = Categoria.EXECUTIVO;
                }
                listaVeiculos.setCategoriaOnibus(placa, categoria);
                System.out.println("Categoria alterada com sucesso");
            }
        } while(escolha < 1 || escolha > 2);
            
    }

   
    /** 
     * Recebe uma nova atribuição para o wifi e altera;
     * @param placa 
     */
    public void alteraWifiOnibus(String placa) {
        Scanner input = new Scanner(System.in);
        int escolha = 0;
        boolean wifi = false;

        do {
            System.out.println("Possui wifi?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 2) {
                System.out.println("Escolha inválida!");
            } else {
                if(escolha == 1) {
                    wifi = true;
                } else {
                    wifi = false;
                }
                listaVeiculos.setWifiOnibus(placa, wifi);
                System.out.println("Wifi alterado com sucesso");
            }
        } while(escolha < 1 || escolha > 2);

            
    }
        
    /** 
     * Recebe uma nova atribuição para o ar-condicionado e altera;
     * @param placa 
     */
    public void alteraArCondicionadoOnibus(String placa) {
        Scanner input = new Scanner(System.in);
        int escolha = 0;
        boolean arcondicionado = false;

        do {
            System.out.println("Possui ar condicionado?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("Opção: ");
            escolha = input.nextInt();

            if(escolha < 1 || escolha > 2) {
                System.out.println("Escolha inválida!");
            } else {
                if(escolha == 1) {
                    arcondicionado = true;
                } else {
                    arcondicionado = false;
                }
                listaVeiculos.setArcondicionadoOnibus(placa, arcondicionado);
                System.out.println("Ar-condicionado alterado com sucesso");
            }
        } while(escolha < 1 || escolha > 2);

            
    }

    /* ALTERA DO CAMINHAO */

    public void alteraEixoCaminhao(String placa) {
        Scanner input = new Scanner(System.in);
        int numeroEixos = 0;
        
        System.out.print("Digite o novo número de eixos: ");
        numeroEixos = input.nextInt();

        if (numeroEixos > 1 || numeroEixos > 10) {
            listaVeiculos.setNumeroEixoCaminhao(placa, numeroEixos);
            System.out.println("Número de eixos alterado com sucesso");
        } else {
            System.out.println("Número de eixos inválido!");
        }
            
    }

    public void alteraCargaMaximaCaminhao(String placa) {
        Scanner input = new Scanner(System.in);
        int cargaMaxima = 0;
        
        System.out.print("Digite a carga máxima: ");
        cargaMaxima = input.nextInt();

        if(cargaMaxima <= 0 || cargaMaxima > 100000) {
            System.out.println("Carga máxima inválida!");
        }
    }

    public void removerVeiculo() {
        Scanner input = new Scanner(System.in);
        String placa = null;

        System.out.print("\nA placa do veiculo que deseja remover: ");
        placa = input.nextLine();
        System.out.println("Veículo removido com sucesso!");

        if(!listaVeiculos.remove(placa)) {
            System.out.println("A placa do veículo não existe");
        }
    }

    public String receberPlaca() {
        Scanner input = new Scanner(System.in);
        String placa = null;

        System.out.print("\nDigite a placa do veiculo que deseja alterar: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            return placa;
        }

        return null;
    }

    public int receberTipo(String placa) {
        Veiculo veiculo = listaVeiculos.get(placa);

        if(veiculo instanceof Carro) {
            return 1;
        } else if(veiculo instanceof Caminhao) {
            return 2;
        } else if(veiculo instanceof Onibus) {
            return 3;
        }
        return 0;
    }

}