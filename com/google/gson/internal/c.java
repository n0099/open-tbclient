package com.google.gson.internal;
/* loaded from: classes5.dex */
public final class c {
    private static final int peO = esI();

    private static int esI() {
        return Yh(System.getProperty("java.version"));
    }

    static int Yh(String str) {
        int Yi = Yi(str);
        if (Yi == -1) {
            Yi = Yj(str);
        }
        if (Yi == -1) {
            return 6;
        }
        return Yi;
    }

    private static int Yi(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 1 && split.length > 1) {
                return Integer.parseInt(split[1]);
            }
            return parseInt;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int Yj(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int esJ() {
        return peO;
    }

    public static boolean esK() {
        return peO >= 9;
    }
}
