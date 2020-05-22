package com.google.gson.internal;
/* loaded from: classes7.dex */
public final class d {
    private static final int mCY = dCK();

    private static int dCK() {
        return Ql(System.getProperty("java.version"));
    }

    static int Ql(String str) {
        int Qm = Qm(str);
        if (Qm == -1) {
            Qm = Qn(str);
        }
        if (Qm == -1) {
            return 6;
        }
        return Qm;
    }

    private static int Qm(String str) {
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

    private static int Qn(String str) {
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

    public static int dCL() {
        return mCY;
    }

    public static boolean dCM() {
        return mCY >= 9;
    }
}
