package com.google.gson.internal;
/* loaded from: classes17.dex */
public final class c {
    private static final int ocA = eeT();

    private static int eeT() {
        return Wf(System.getProperty("java.version"));
    }

    static int Wf(String str) {
        int Wg = Wg(str);
        if (Wg == -1) {
            Wg = Wh(str);
        }
        if (Wg == -1) {
            return 6;
        }
        return Wg;
    }

    private static int Wg(String str) {
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

    private static int Wh(String str) {
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

    public static int eeU() {
        return ocA;
    }

    public static boolean eeV() {
        return ocA >= 9;
    }
}
