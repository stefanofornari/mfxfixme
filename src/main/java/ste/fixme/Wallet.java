package ste.fixme;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Wallet {

    public final String address;

    public String privateKey = "";
    public String mnemonicPhrase = "";

    final public Map<String, BigDecimal> balances = new HashMap<>();

    public Wallet(String address) {
        this.address = address;
    }
}
