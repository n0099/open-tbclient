package d.g.c.b;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f66100a = a();

    public static int a() {
        return d(System.getProperty("java.version"));
    }

    public static int b(String str) {
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

    public static int c() {
        return f66100a;
    }

    public static int d(String str) {
        int f2 = f(str);
        if (f2 == -1) {
            f2 = b(str);
        }
        if (f2 == -1) {
            return 6;
        }
        return f2;
    }

    public static boolean e() {
        return f66100a >= 9;
    }

    public static int f(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
