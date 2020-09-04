package com.google.gson.internal;
/* loaded from: classes3.dex */
public final class d {
    private static final int nDm = dXk();

    private static int dXk() {
        return UP(System.getProperty("java.version"));
    }

    static int UP(String str) {
        int UQ = UQ(str);
        if (UQ == -1) {
            UQ = UR(str);
        }
        if (UQ == -1) {
            return 6;
        }
        return UQ;
    }

    private static int UQ(String str) {
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

    private static int UR(String str) {
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

    public static int dXl() {
        return nDm;
    }

    public static boolean dXm() {
        return nDm >= 9;
    }
}
