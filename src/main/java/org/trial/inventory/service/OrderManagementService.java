package org.trial.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.trial.inventory.entity.Order;
import org.trial.inventory.entity.Stock;
import org.trial.inventory.repository.InventoryRepo;
import org.trial.inventory.repository.OrderRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderManagementService {

    private final OrderRepo orderRepo;
    private final InventoryRepo inventoryRepo;

    public Order placeOrder(List<String> orderList) {

        Double totalPrice = 0.0;
        Map<String, Double> itemsWithPrice = new HashMap<>();

        for (String itemName : orderList) {

            Stock stockDetails = inventoryRepo.findByItemName(itemName).orElseGet(() ->
                    Stock.builder().build());

            itemsWithPrice.put(stockDetails.getItemName(), stockDetails.getItemPrice());
            totalPrice += stockDetails.getItemPrice();
        }

        Order finalOrder = Order.builder().orderTotalPrice(totalPrice)
                .itemsWithPrice(itemsWithPrice).build();

        return orderRepo.save(finalOrder);
    }

}
