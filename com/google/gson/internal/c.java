package com.google.gson.internal;
/* loaded from: classes23.dex */
public final class c {
    private static final int nNi = ebi();

    private static int ebi() {
        return Vr(System.getProperty("java.version"));
    }

    static int Vr(String str) {
        int Vs = Vs(str);
        if (Vs == -1) {
            Vs = Vt(str);
        }
        if (Vs == -1) {
            return 6;
        }
        return Vs;
    }

    private static int Vs(String str) {
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

    private static int Vt(String str) {
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

    public static int ebj() {
        return nNi;
    }

    public static boolean ebk() {
        return nNi >= 9;
    }
}
