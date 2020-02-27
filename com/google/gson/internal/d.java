package com.google.gson.internal;
/* loaded from: classes7.dex */
public final class d {
    private static final int mKz = dAD();

    private static int dAD() {
        return QI(System.getProperty("java.version"));
    }

    static int QI(String str) {
        int QJ = QJ(str);
        if (QJ == -1) {
            QJ = QK(str);
        }
        if (QJ == -1) {
            return 6;
        }
        return QJ;
    }

    private static int QJ(String str) {
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

    private static int QK(String str) {
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

    public static int dAE() {
        return mKz;
    }

    public static boolean dAF() {
        return mKz >= 9;
    }
}
