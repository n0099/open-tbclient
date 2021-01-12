package com.google.gson.internal;
/* loaded from: classes4.dex */
public final class c {
    private static final int pIg = eyJ();

    private static int eyJ() {
        return YF(System.getProperty("java.version"));
    }

    static int YF(String str) {
        int YG = YG(str);
        if (YG == -1) {
            YG = YH(str);
        }
        if (YG == -1) {
            return 6;
        }
        return YG;
    }

    private static int YG(String str) {
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

    private static int YH(String str) {
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

    public static int eyK() {
        return pIg;
    }

    public static boolean eyL() {
        return pIg >= 9;
    }
}
