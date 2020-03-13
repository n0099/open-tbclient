package com.google.gson.internal;
/* loaded from: classes7.dex */
public final class d {
    private static final int mKM = dAG();

    private static int dAG() {
        return QJ(System.getProperty("java.version"));
    }

    static int QJ(String str) {
        int QK = QK(str);
        if (QK == -1) {
            QK = QL(str);
        }
        if (QK == -1) {
            return 6;
        }
        return QK;
    }

    private static int QK(String str) {
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

    private static int QL(String str) {
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

    public static int dAH() {
        return mKM;
    }

    public static boolean dAI() {
        return mKM >= 9;
    }
}
