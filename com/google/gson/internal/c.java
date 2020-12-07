package com.google.gson.internal;
/* loaded from: classes5.dex */
public final class c {
    private static final int ptX = eyk();

    private static int eyk() {
        return ZC(System.getProperty("java.version"));
    }

    static int ZC(String str) {
        int ZD = ZD(str);
        if (ZD == -1) {
            ZD = ZE(str);
        }
        if (ZD == -1) {
            return 6;
        }
        return ZD;
    }

    private static int ZD(String str) {
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

    private static int ZE(String str) {
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

    public static int eyl() {
        return ptX;
    }

    public static boolean eym() {
        return ptX >= 9;
    }
}
