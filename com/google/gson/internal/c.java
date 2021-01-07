package com.google.gson.internal;
/* loaded from: classes5.dex */
public final class c {
    private static final int pMH = eCB();

    private static int eCB() {
        return ZN(System.getProperty("java.version"));
    }

    static int ZN(String str) {
        int ZO = ZO(str);
        if (ZO == -1) {
            ZO = ZP(str);
        }
        if (ZO == -1) {
            return 6;
        }
        return ZO;
    }

    private static int ZO(String str) {
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

    private static int ZP(String str) {
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

    public static int eCC() {
        return pMH;
    }

    public static boolean eCD() {
        return pMH >= 9;
    }
}
