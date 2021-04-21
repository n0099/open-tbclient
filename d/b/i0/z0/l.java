package d.b.i0.z0;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static long f52476a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f52476a;
        if (j > currentTimeMillis) {
            f52476a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - j < 500) {
            return true;
        } else {
            f52476a = currentTimeMillis;
            return false;
        }
    }
}
