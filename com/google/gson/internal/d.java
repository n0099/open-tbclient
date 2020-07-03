package com.google.gson.internal;
/* loaded from: classes7.dex */
public final class d {
    private static final int nao = dHA();

    private static int dHA() {
        return QY(System.getProperty("java.version"));
    }

    static int QY(String str) {
        int QZ = QZ(str);
        if (QZ == -1) {
            QZ = Ra(str);
        }
        if (QZ == -1) {
            return 6;
        }
        return QZ;
    }

    private static int QZ(String str) {
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

    private static int Ra(String str) {
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

    public static int dHB() {
        return nao;
    }

    public static boolean dHC() {
        return nao >= 9;
    }
}
