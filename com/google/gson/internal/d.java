package com.google.gson.internal;
/* loaded from: classes4.dex */
public final class d {
    private static final int mFX = dyk();

    private static int dyk() {
        return Qk(System.getProperty("java.version"));
    }

    static int Qk(String str) {
        int Ql = Ql(str);
        if (Ql == -1) {
            Ql = Qm(str);
        }
        if (Ql == -1) {
            return 6;
        }
        return Ql;
    }

    private static int Ql(String str) {
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

    private static int Qm(String str) {
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

    public static int dyl() {
        return mFX;
    }

    public static boolean dym() {
        return mFX >= 9;
    }
}
