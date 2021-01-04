package com.google.gson.internal;
/* loaded from: classes5.dex */
public final class c {
    private static final int pKZ = eBX();

    private static int eBX() {
        return ZM(System.getProperty("java.version"));
    }

    static int ZM(String str) {
        int ZN = ZN(str);
        if (ZN == -1) {
            ZN = ZO(str);
        }
        if (ZN == -1) {
            return 6;
        }
        return ZN;
    }

    private static int ZN(String str) {
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

    private static int ZO(String str) {
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

    public static int eBY() {
        return pKZ;
    }

    public static boolean eBZ() {
        return pKZ >= 9;
    }
}
