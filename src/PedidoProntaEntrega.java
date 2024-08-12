public class PedidoProntaEntrega extends Pedido{
    private static final double TAXA_DESCONTO = 0.03;

    public PedidoProntaEntrega(int quantidade, double precoUnitario, Cliente cliente, Pedido.MeioPagamento meioPagamento) {
        super(quantidade, precoUnitario, cliente, meioPagamento);
        addDesconto(new DescontoFixo(this, TAXA_DESCONTO));
    }
    @Override
    public double getAcrescimos() {
        return 0.0;
    }
}
