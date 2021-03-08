package com.bytedance.sdk.openadsdk.preload.a.b;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5007a = c();

    private static int c() {
        return a(System.getProperty("java.version"));
    }

    static int a(String str) {
        int b = b(str);
        if (b == -1) {
            b = c(str);
        }
        if (b == -1) {
            return 6;
        }
        return b;
    }

    private static int b(String str) {
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

    private static int c(String str) {
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

    public static int a() {
        return f5007a;
    }

    public static boolean b() {
        return f5007a >= 9;
    }
}
