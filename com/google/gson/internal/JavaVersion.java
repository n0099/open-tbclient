package com.google.gson.internal;
/* loaded from: classes10.dex */
public final class JavaVersion {
    public static final int majorJavaVersion = determineMajorJavaVersion();

    public static int determineMajorJavaVersion() {
        return getMajorJavaVersion(System.getProperty("java.version"));
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static boolean isJava9OrLater() {
        if (majorJavaVersion >= 9) {
            return true;
        }
        return false;
    }

    public static int extractBeginningInt(String str) {
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
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion(String str) {
        int parseDotted = parseDotted(str);
        if (parseDotted == -1) {
            parseDotted = extractBeginningInt(str);
        }
        if (parseDotted == -1) {
            return 6;
        }
        return parseDotted;
    }

    public static int parseDotted(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 1 && split.length > 1) {
                return Integer.parseInt(split[1]);
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
