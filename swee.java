import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane; 

public class swee {
	public static void main(String[] args) {
        int codigo, qtd;
        float valor = 0, dinheiro;

        int estoqueMM = 10;
        int estoqueFinni = 15;
        int estoqueBIS = 20;

        List<String> carrinho = new ArrayList<>();

        JOptionPane.showMessageDialog(null,
                "1 - M&M R$ 3,00 (estoque: " + estoqueMM + ")\n" +
                "2 - Finni R$ 4,00 (estoque: " + estoqueFinni + ")\n" +
                "3 - BIS R$ 5,00 (estoque: " + estoqueBIS + ")\n" +
                "Insira o código do produto (0 para sair do carrinho):");

        while (true) {
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do produto (0 para sair do carrinho):"));
            if (codigo == 0) {
                break; 
            }
            if (codigo >= 1 && codigo <= 3) {
                do {
                    qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantos você deseja:"));

                    switch (codigo) {
                        case 1:
                            if (qtd <= estoqueMM) {
                                valor += qtd * 3.00f;
                                estoqueMM -= qtd;
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantidade indisponível em estoque. Estoque atual: " + estoqueMM);
                                continue;
                            }
                            break;
                        case 2:
                            if (qtd <= estoqueFinni) {
                                valor += qtd * 4.00f;
                                estoqueFinni -= qtd;
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantidade indisponível em estoque. Estoque atual: " + estoqueFinni);
                                continue;
                            }
                            break;
                        case 3:
                            if (qtd <= estoqueBIS) {
                                valor += qtd * 5.00f;
                                estoqueBIS -= qtd;
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantidade indisponível em estoque. Estoque atual: " + estoqueBIS);
                                continue;
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Código inválido");
                            continue;
                    }
                    carrinho.add(qtd + " " + getCodigoNome(codigo));
                    JOptionPane.showMessageDialog(null, "Item adicionado ao carrinho.");
                    break; 
                } while (true);
            } else {
                JOptionPane.showMessageDialog(null, "Código inválido");
            }
        }

        StringBuilder carrinhoStr = new StringBuilder("Itens no carrinho:\n");
        for (String item : carrinho) {
            carrinhoStr.append(item).append("\n");
        }
        carrinhoStr.append(String.format("Valor total: R$ %.2f\n", valor));
        JOptionPane.showMessageDialog(null, carrinhoStr.toString());

        dinheiro = Float.parseFloat(JOptionPane.showInputDialog("Valor do cliente:"));

        if (dinheiro >= valor) {
            JOptionPane.showMessageDialog(null, "Dinheiro suficiente\nSeu troco: R$ " + String.format("%.2f", (dinheiro - valor)) + "\nvolte sempre");
        } else {
            JOptionPane.showMessageDialog(null, "Dinheiro insuficiente");
        }
    }

    public static String getCodigoNome(int codigo) {
        switch (codigo) {
            case 1:
                return "M&M";
            case 2:
                return "Finni";
            case 3:
                return "BIS";
            default:
                return "desconhecido";
        }
    }

}
