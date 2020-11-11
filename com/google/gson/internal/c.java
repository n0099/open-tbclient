package com.google.gson.internal;
/* loaded from: classes17.dex */
public final class c {
    private static final int pdl = esI();

    private static int esI() {
        return Yw(System.getProperty("java.version"));
    }

    static int Yw(String str) {
        int Yx = Yx(str);
        if (Yx == -1) {
            Yx = Yy(str);
        }
        if (Yx == -1) {
            return 6;
        }
        return Yx;
    }

    private static int Yx(String str) {
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

    private static int Yy(String str) {
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

    public static int esJ() {
        return pdl;
    }

    public static boolean esK() {
        return pdl >= 9;
    }
}
