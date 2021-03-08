package com.google.gson.internal;
/* loaded from: classes4.dex */
public final class c {
    private static final int pTB = eBp();

    private static int eBp() {
        return ZY(System.getProperty("java.version"));
    }

    static int ZY(String str) {
        int ZZ = ZZ(str);
        if (ZZ == -1) {
            ZZ = aaa(str);
        }
        if (ZZ == -1) {
            return 6;
        }
        return ZZ;
    }

    private static int ZZ(String str) {
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

    private static int aaa(String str) {
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

    public static int eBq() {
        return pTB;
    }

    public static boolean eBr() {
        return pTB >= 9;
    }
}
