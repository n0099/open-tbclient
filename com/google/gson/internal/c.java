package com.google.gson.internal;
/* loaded from: classes5.dex */
public final class c {
    private static final int pSM = eBj();

    private static int eBj() {
        return ZT(System.getProperty("java.version"));
    }

    static int ZT(String str) {
        int ZU = ZU(str);
        if (ZU == -1) {
            ZU = ZV(str);
        }
        if (ZU == -1) {
            return 6;
        }
        return ZU;
    }

    private static int ZU(String str) {
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

    private static int ZV(String str) {
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

    public static int eBk() {
        return pSM;
    }

    public static boolean eBl() {
        return pSM >= 9;
    }
}
