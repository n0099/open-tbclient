package com.google.gson.internal;
/* loaded from: classes7.dex */
public final class d {
    private static final int mEl = dCY();

    private static int dCY() {
        return Qm(System.getProperty("java.version"));
    }

    static int Qm(String str) {
        int Qn = Qn(str);
        if (Qn == -1) {
            Qn = Qo(str);
        }
        if (Qn == -1) {
            return 6;
        }
        return Qn;
    }

    private static int Qn(String str) {
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

    private static int Qo(String str) {
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

    public static int dCZ() {
        return mEl;
    }

    public static boolean dDa() {
        return mEl >= 9;
    }
}
