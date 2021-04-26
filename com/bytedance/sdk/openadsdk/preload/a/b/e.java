package com.bytedance.sdk.openadsdk.preload.a.b;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f30645a = c();

    public static int a(String str) {
        int b2 = b(str);
        if (b2 == -1) {
            b2 = c(str);
        }
        if (b2 == -1) {
            return 6;
        }
        return b2;
    }

    public static int b(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c() {
        return a(System.getProperty("java.version"));
    }

    public static int a() {
        return f30645a;
    }

    public static int c(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
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

    public static boolean b() {
        return f30645a >= 9;
    }
}
