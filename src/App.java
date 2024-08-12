public class App {
    public static void main(String[] args) throws Exception {
        Cliente cliente1 = new Cliente("Fulano", "a@a.a");

        Pedido pedido1 = new PedidoProntaEntrega(
            100,
            10.0,
            cliente1,
            Pedido.MeioPagamento.CARTAO);
            
    }
}
