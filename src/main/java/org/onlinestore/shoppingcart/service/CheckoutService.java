package org.onlinestore.shoppingcart.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.onlinestore.shoppingcart.exception.EmptyCartException;
import org.onlinestore.shoppingcart.model.Fruit;

/**
 * online store checkout Service.
 */
public class CheckoutService {
	
    private static final Map<Fruit, Double> priceCatalog = new HashMap<Fruit, Double>();

    static {
        priceCatalog.put(Fruit.APPLE, 0.60);
        priceCatalog.put(Fruit.ORANGE, 0.25);
    }
    
    public double total(final List<Fruit> shoppingBasket) {
    	if(shoppingBasket == null || shoppingBasket.isEmpty()){
    		throw new EmptyCartException("Cart should not be empty before checkout");
    	}
    	 return shoppingBasket.stream().map(priceCatalog::get)
    			 	.reduce(0D, (runningResult, currElement) -> runningResult + currElement);
    }
}
