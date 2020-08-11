import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    /**
     * 获取商品的最佳价格
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 计算商品的最佳价格
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 模拟延时
     */
    public static void delay() {
        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将同步方法转换成异步方法
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }
}
