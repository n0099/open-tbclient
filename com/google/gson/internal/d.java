package com.google.gson.internal;
/* loaded from: classes7.dex */
public final class d {
    private static final int nar = dHE();

    private static int dHE() {
        return QZ(System.getProperty("java.version"));
    }

    static int QZ(String str) {
        int Ra = Ra(str);
        if (Ra == -1) {
            Ra = Rb(str);
        }
        if (Ra == -1) {
            return 6;
        }
        return Ra;
    }

    private static int Ra(String str) {
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

    private static int Rb(String str) {
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

    public static int dHF() {
        return nar;
    }

    public static boolean dHG() {
        return nar >= 9;
    }
}
