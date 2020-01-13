package com.google.gson.internal;
/* loaded from: classes5.dex */
public final class d {
    private static final int mJP = dzt();

    private static int dzt() {
        return Qv(System.getProperty("java.version"));
    }

    static int Qv(String str) {
        int Qw = Qw(str);
        if (Qw == -1) {
            Qw = Qx(str);
        }
        if (Qw == -1) {
            return 6;
        }
        return Qw;
    }

    private static int Qw(String str) {
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

    private static int Qx(String str) {
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

    public static int dzu() {
        return mJP;
    }

    public static boolean dzv() {
        return mJP >= 9;
    }
}
