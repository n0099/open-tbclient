package com.google.gson.internal;
/* loaded from: classes4.dex */
public final class c {
    private static final int pIh = eyJ();

    private static int eyJ() {
        return YG(System.getProperty("java.version"));
    }

    static int YG(String str) {
        int YH = YH(str);
        if (YH == -1) {
            YH = YI(str);
        }
        if (YH == -1) {
            return 6;
        }
        return YH;
    }

    private static int YH(String str) {
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

    private static int YI(String str) {
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
        return pIh;
    }

    public static boolean eyL() {
        return pIh >= 9;
    }
}
