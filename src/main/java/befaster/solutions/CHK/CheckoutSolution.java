package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CheckoutSolution {
    private final Map<String, Integer> prices;

    public CheckoutSolution() {
        prices = new HashMap<>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
    }


    public Integer checkout(String skus) {

        final Map<String, AtomicInteger> itemUnitsOnChart = new HashMap<>();

        Arrays.stream(skus.split("")).forEach(sku -> {
            itemUnitsOnChart.putIfAbsent(sku, new AtomicInteger(0));
            itemUnitsOnChart.get(sku).incrementAndGet();
        });



        return itemUnitsOnChart.keySet().stream().map(sku -> addToTotal(sku, itemUnitsOnChart.get(sku))).collect(Collectors.summingInt(Integer::intValue));
    }

    private Integer addToTotal(String sku, AtomicInteger units) {
        return units.get()*prices.get(sku);
    }
}


