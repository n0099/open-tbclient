package d.b.i0.v3.s;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f63437a;

    public static long a(CharSequence charSequence) {
        double d2 = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt > ' ') {
                d2 += (charAt <= 0 || charAt >= 127) ? 1.0d : 0.5d;
            }
        }
        return Math.round(d2);
    }

    public static boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f63437a;
        if (0 >= j || j >= 1000) {
            f63437a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
