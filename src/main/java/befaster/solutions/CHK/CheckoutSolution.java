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
        prices.put("E", 40);
    }


    public Integer checkout(String skus) {

        // Validate input
        if (skus != null  && skus.equals(""))
            return 0;
        else if ( skus == null || Arrays.stream(skus.split("")).anyMatch(sku -> prices.get(sku) == null))
            return -1;


        final Map<String, AtomicInteger> itemUnitsOnChart = new HashMap<>();
        Arrays.stream(skus.split("")).forEach(sku -> {
            itemUnitsOnChart.putIfAbsent(sku, new AtomicInteger(0));
            itemUnitsOnChart.get(sku).incrementAndGet();
        });

        itemUnitsOnChart.keySet().stream().forEach(sku -> discountFreeItems(sku, itemUnitsOnChart));

        return itemUnitsOnChart.keySet().stream()
                .map(sku -> addToTotal(sku, itemUnitsOnChart.get(sku)))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    private void discountFreeItems(String sku, Map<String, AtomicInteger> itemUnitsOnChart) {
        if ("E".equals(sku) && itemUnitsOnChart.get("B") != null){
            for (int i = 0; i < itemUnitsOnChart.get("E").get() / 2; i++)
              itemUnitsOnChart.get("B").decrementAndGet();
        }
    }

    private Integer addToTotal(String sku, AtomicInteger units) {

        if(units.get() < 0)
            return 0;

        if ("A".equals(sku))
            return units.get()/5*200 + (units.get()%5)/3*130 + (units.get()%5)%3*prices.get(sku);

        if ("B".equals(sku))
            return units.get()/2*45 + units.get()%2*prices.get(sku);


        return units.get()*prices.get(sku);


    }
}




