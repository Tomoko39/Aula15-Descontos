import java.util.ArrayList;

public abstract class Pedido {
    private int quantidade;
    private double precoUnitario;
    private Cliente cliente;
    private ArrayList<Desconto> descontos;
    private MeioPagamento meioPagamento;

    public enum MeioPagamento {
        DINHEIRO, PIX, CARTAO
    }

    

    public Pedido(int quantidade, double precoUnitario, Cliente cliente, MeioPagamento meioPagamento) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.cliente = cliente;
        this.meioPagamento = meioPagamento;
        this.descontos = new ArrayList<Desconto>();

    if (cliente.isFidelidade()) {
        descontos.add(new DescontoFixo(this, 0.05));
    }
    if (meioPagamento == MeioPagamento.DINHEIRO || meioPagamento == MeioPagamento.PIX) {
        descontos.add(new DescontoFixo(this, 0.04));
    }
    }

    public void addDesconto(Desconto desconto) {
        descontos.add(desconto);
    }

    /**
     * Calcula o preco cheio (sem descontos ou acrescimos)
     * do pedido
     * @return o preco total
     */
    public final double getPrecoTotal() {
        return quantidade * precoUnitario;
    }

    public final double getDescontoTotal() {
        double total = 0.0;

        for(Desconto desconto : descontos) {
            total += desconto.getDesconto();
        }

        return total;
    }

    public abstract double getAcrescimos();

    /**
     * @return
     */
    public final double getPrecoFinal() {
        return getPrecoTotal() - getDescontoTotal();
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    @Override
    public String toString() {
        return
            String.format("Preco total: %.2f\n", getPrecoTotal())
            + String.format("Preco final: %.2f\n", getPrecoFinal())
            
        ;
    }
}
