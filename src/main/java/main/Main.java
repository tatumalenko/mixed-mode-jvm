package main;

import model.DiPdoAudience;

public class Main {
    public static void main(String[] args) {
        var decoded = DiPdoAudience.Companion.decode("\n" +
                "CONTACT, 102443, 123, 12412414\n" +
                "CONTACT, 102445, 126, 12412417\n" +
                "CONTACT, 102445,, 12412417\n" +
                "\n");
        System.out.println(decoded);
        System.out.println(decoded.get(0).getCampaignCategory());
    }
}
