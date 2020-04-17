package com.google.gson.internal;
/* loaded from: classes7.dex */
public final class d {
    private static final int mjd = dvv();

    private static int dvv() {
        return Ou(System.getProperty("java.version"));
    }

    static int Ou(String str) {
        int Ov = Ov(str);
        if (Ov == -1) {
            Ov = Ow(str);
        }
        if (Ov == -1) {
            return 6;
        }
        return Ov;
    }

    private static int Ov(String str) {
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

    private static int Ow(String str) {
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

    public static int dvw() {
        return mjd;
    }

    public static boolean dvx() {
        return mjd >= 9;
    }
}
