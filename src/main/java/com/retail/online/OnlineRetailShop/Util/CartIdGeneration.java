package com.retail.online.OnlineRetailShop.Util;

import java.util.UUID;

public class CartIdGeneration {

    public String generateCartId(){
        UUID uuid = UUID.randomUUID();
        String  uuids = uuid.toString();
        return uuids;
    }

}
