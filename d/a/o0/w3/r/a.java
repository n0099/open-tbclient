package d.a.o0.w3.r;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f66768a;

    public static long a(CharSequence charSequence) {
        double d2 = 0.0d;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            if (charAt > ' ') {
                d2 += (charAt <= 0 || charAt >= 127) ? 1.0d : 0.5d;
            }
        }
        return Math.round(d2);
    }

    public static boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f66768a;
        if (0 >= j || j >= 1000) {
            f66768a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
