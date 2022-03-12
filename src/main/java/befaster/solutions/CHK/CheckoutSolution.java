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

        // Validate input
        if (Arrays.stream(skus.split("")).anyMatch(sku -> prices.get(sku) == null))
            return -1;


        final Map<String, AtomicInteger> itemUnitsOnChart = new HashMap<>();
        Arrays.stream(skus.split("")).forEach(sku -> {
            itemUnitsOnChart.putIfAbsent(sku, new AtomicInteger(0));
            itemUnitsOnChart.get(sku).incrementAndGet();
        });


        return itemUnitsOnChart.keySet().stream()
                .map(sku -> addToTotal(sku, itemUnitsOnChart.get(sku)))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    private Integer addToTotal(String sku, AtomicInteger units) {

        if ("A".equals(sku))
            return units.get()/3*130 + units.get()%3*prices.get(sku);

        if ("B".equals(sku))
            return units.get()/2*45 + units.get()%2*prices.get(sku);


        return units.get()*prices.get(sku);


    }
}




