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
        prices.put("A", 50); //    | 3A for 130, 5A for 200 |
        prices.put("B", 30); //    | 2B for 45              |
        prices.put("C", 20); //    |                        |
        prices.put("D", 15); //    |                        |
        prices.put("E", 40); //    | 2E get one B free      |
        prices.put("F", 10); //    | 2F get one F free      |
        prices.put("G", 20); //    |                        |
        prices.put("H", 10); //    | 5H for 45, 10H for 80  |
        prices.put("I", 35); //    |                        |
        prices.put("J", 60); //    |                        |
        prices.put("K", 80); //    | 2K for 150             |
        prices.put("L", 90); //    |                        |
        prices.put("M", 15); //    |                        |
        prices.put("N", 40); //    | 3N get one M free      |
        prices.put("O", 10); //    |                        |
        prices.put("P", 50); //    | 5P for 200             |
        prices.put("Q", 30); //    | 3Q for 80              |
        prices.put("R", 50); //    | 3R get one Q free      |
        prices.put("S", 30); //    |                        |
        prices.put("T", 20); //    |                        |
        prices.put("U", 40); //    | 3U get one U free      |
        prices.put("V", 50); //    | 2V for 90, 3V for 130  |
        prices.put("W", 20); //    |                        |
        prices.put("X", 90); //    |                        |
        prices.put("Y", 10); //    |                        |
        prices.put("Z", 50); //    |                        |
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

        if ("F".equals(sku))
            return units.get()/3*20 + units.get()%3*prices.get(sku);


        return units.get()*prices.get(sku);


    }
}



