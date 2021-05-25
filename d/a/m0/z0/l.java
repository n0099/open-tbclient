package d.a.m0.z0;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static long f51048a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f51048a;
        if (j > currentTimeMillis) {
            f51048a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - j < 500) {
            return true;
        } else {
            f51048a = currentTimeMillis;
            return false;
        }
    }
}
