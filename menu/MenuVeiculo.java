package menu;

import java.util.Scanner;

import controlelista.ListaVeiculos;
import veiculo.Caminhao;
import veiculo.Carro;
import veiculo.Categoria;
import veiculo.Onibus;

public class MenuVeiculo {
    
    private ListaVeiculos listaVeiculos;

    public MenuVeiculo() {
        listaVeiculos = new ListaVeiculos();
    }

    public ListaVeiculos getListaVeiculos() {
        return listaVeiculos;
    }

    public void imprimirInfoVeiculos() {
        if(listaVeiculos.getInfo() != null) {
            System.out.println(listaVeiculos.getInfo());
        } else {
            System.out.println("\nNão existem veículos");
        }
    }

    public void getInformacaoVeiculo() {
        Scanner input = new Scanner(System.in);
        String placa = null;

        System.out.print("\nDigite a placa que se deseja pegar as informaçôes: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            System.out.println(listaVeiculos.getInfo(placa));
        } else {
            System.out.println("Veiculo não existente!");
        }
    }

    public void imprimirResumoVeiculos() {
        if(listaVeiculos.getResumoInfo() != null) {
           System.out.println(listaVeiculos.getResumoInfo());
        } else {
            System.out.println("\nNão existem veículos");
        }   
    }

    public void adicionaVeiculo() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        int ano = 0;
        double diaria = 0.0;
        int modeloCarro = 0; 

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

        System.out.print("Digite o ano do veiculo: ");
        ano = input.nextInt();

        System.out.print("Digite a diaria do veiculo: ");
        diaria = input.nextDouble();

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

    public void cadastrarCarro(String placa, int ano, double diaria) {
        Scanner input = new Scanner(System.in);
        
        int numeroPassageiros = 0;
        int numeroPortas = 0;
        double mediaKM = 0.0;
        boolean arcondicionado = false;

        int escolha = 0;

        System.out.print("Digite a quantidade de passageiros: ");
        numeroPassageiros = input.nextInt();

        System.out.print("Digite a quantidade de portas: ");
        numeroPortas = input.nextInt();

        System.out.print("Digite a media de KM por litro: ");
        mediaKM = input.nextDouble();

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

    public void cadastrarCaminhao(String placa, int ano, double diaria) {
        Scanner input = new Scanner(System.in);

        int numeroEixos = 0;
        int cargaMaxima = 0;

        System.out.print("Digite o numero de eixos: ");
        numeroEixos = input.nextInt();

        System.out.print("Digite a carga máxima: ");
        cargaMaxima = input.nextInt();

        listaVeiculos.add(new Caminhao(placa, ano, diaria, numeroEixos, cargaMaxima));
        System.out.println("Caminhão adicionado com sucesso");
    }

    public void cadastrarOnibus(String placa, int ano, double diaria) {
        Scanner input = new Scanner(System.in);

        int numeroPassageiros = 0;
        Categoria categoria = Categoria.CONVENCIONAL;
        boolean wifi = false;
        boolean arcondicionado = false;

        int escolha = 0;

        System.out.print("Digite a quantidade de passageiros: ");
        numeroPassageiros = input.nextInt();

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

    public void alteraAno() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        int ano = 0;

        System.out.print("\nDigite a placa que deseja alterar o ano: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            System.out.print("Digite o novo ano: ");
            ano = input.nextInt();
            listaVeiculos.setAno(placa, ano);
        } else {
            System.out.println("A placa informada!");
        }
    }

    public void alteraDiaria() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        double diaria = 0.0;

        System.out.print("\nDigite a placa do carro que deseja alterar a diaria: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            System.out.print("Digite a nova diaria: ");
            diaria = input.nextDouble();
            listaVeiculos.setDiaria(placa, diaria);
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    /* FAZER OS SETS DE CADA CATEGORIA DE VEICULO */

    /* ALTERA DO CARRO */
    public void alteraNumeroPassageiroCarro() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        
        System.out.print("\nDigite a placa do carro que deseja alterar o número de passageiros: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Carro) {
                System.out.print("Digite o novo número de passageiros: ");
                listaVeiculos.setNumeroPassageiroCarro(placa, input.nextInt());
            } else {
                System.out.println("A placa informada não é de um carro!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    public void alteraNumeroPortaCarro() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        
        System.out.print("\nDigite a placa do carro que deseja alterar o número de portas: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Carro) {
                System.out.print("Digite o novo número de portas: ");
                listaVeiculos.setNumeroPortaCarro(placa, input.nextInt());
            } else {
                System.out.println("A placa informada não é de um carro!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    public void alteraMediaKmCarro() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        
        System.out.print("\nDigite a placa do carro que deseja alterar a media de km: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Carro) {
                System.out.print("Digite a nova media de km: ");
                listaVeiculos.setMediaKMCarro(placa, input.nextDouble());
            } else {
                System.out.println("A placa informada não é de um carro!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    public void alteraArCondicionadoCarro() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        int escolha = 0;
        boolean arcondicionado = false;
        
        System.out.print("\nDigite a placa do carro que deseja alterar a existência do ar-condicionado: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Carro) {
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
                    }
                } while(escolha < 1 || escolha > 2);
                
            } else {
                System.out.println("A placa informada não é de um carro!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    /* ALTERA DO ONIBUS  */
    public void alteraNumeroPassageiroOnibus() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        
        System.out.print("\nDigite a placa do ônibus que deseja alterar o número de passageiros: ");
        placa = input.nextLine();
        
         if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Onibus) {
                System.out.print("Digite o novo número de passageiros: ");
                listaVeiculos.setNumeroPassageiroOnibus(placa, 0);
            } else {
                System.out.println("A placa informada não é de um ônibus!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    public void alteraCategoriaOnibus() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        int escolha = 0;
        Categoria categoria = Categoria.CONVENCIONAL;
        
        System.out.print("\nDigite a placa do ônibus que deseja alterar a categoria: ");
        placa = input.nextLine();
        
        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Onibus) {
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
                    }
                } while(escolha < 1 || escolha > 2);
            } else {
                System.out.println("A placa informada não é de um ônibus!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    public void alteraWifiOnibus() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        int escolha = 0;
        boolean wifi = false;

        System.out.print("\n Digite a placa do ônibus que deseja alterar a existência do wifi: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Onibus) {
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
                    }
                } while(escolha < 1 || escolha > 2);

            } else {
                System.out.println("A placa informada não é de um ônibus!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }
        
    public void alteraArCondicionadoOnibus() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        int escolha = 0;
        boolean arcondicionado = false;

        System.out.print("\nDigite a placa do ônibus que deseja alterar a existência do arcondicionado: ");
        placa = input.nextLine();

        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Onibus) {
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
                    }
                } while(escolha < 1 || escolha > 2);

            } else {
                System.out.println("A placa informada não é de um ônibus!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    /* ALTERA DO CAMINHAO */

    public void alteraEixoCaminhao() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        
        System.out.print("\nDigite a placa do caminhão que deseja alterar o número de eixos: ");
        placa = input.nextLine();
        
         if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Caminhao) {
                System.out.print("Digite o novo número de eixos: ");
                listaVeiculos.setNumeroEixoCaminhao(placa, 0);
            } else {
                System.out.println("A placa informada não é de um caminhão!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    public void alteraCargaMaximaCaminhao() {
        Scanner input = new Scanner(System.in);

        String placa = null;
        
        System.out.print("\n Digite a placa do caminhão que deseja alterar a carga máxima: ");
        placa = input.nextLine();
        
        if(listaVeiculos.existe(placa)) {
            if(listaVeiculos.get(placa) instanceof Caminhao) {
                System.out.print("Digite a nova carga máxima: ");
                listaVeiculos.setCargaMaximaCaminhao(placa, 0);
            } else {
                System.out.println("A placa informada não é de um caminhão!");
            }
        } else {
            System.out.println("A placa informada não existe!");
        }
    }

    public void removerVeiculo() {
        Scanner input = new Scanner(System.in);
        String placa = null;

        System.out.print("\n A placa do veiculo que deseja remover: ");
        placa = input.nextLine();

        if(!listaVeiculos.remove(placa)) {
            System.out.println("A placa do veículo não existe");
        }
    }

}