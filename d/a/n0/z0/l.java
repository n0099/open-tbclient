package d.a.n0.z0;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static long f54833a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f54833a;
        if (j > currentTimeMillis) {
            f54833a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - j < 500) {
            return true;
        } else {
            f54833a = currentTimeMillis;
            return false;
        }
    }
}
