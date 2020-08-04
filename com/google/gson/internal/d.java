package com.google.gson.internal;
/* loaded from: classes10.dex */
public final class d {
    private static final int njd = dLa();

    private static int dLa() {
        return RL(System.getProperty("java.version"));
    }

    static int RL(String str) {
        int RM = RM(str);
        if (RM == -1) {
            RM = RN(str);
        }
        if (RM == -1) {
            return 6;
        }
        return RM;
    }

    private static int RM(String str) {
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

    private static int RN(String str) {
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

    public static int dLb() {
        return njd;
    }

    public static boolean dLc() {
        return njd >= 9;
    }
}
