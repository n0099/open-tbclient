package d.b.h0.z0;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static long f51716a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f51716a;
        if (j > currentTimeMillis) {
            f51716a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - j < 500) {
            return true;
        } else {
            f51716a = currentTimeMillis;
            return false;
        }
    }
}
