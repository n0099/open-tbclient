package d.b.h0.z0;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static long f52140a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f52140a;
        if (j > currentTimeMillis) {
            f52140a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - j < 500) {
            return true;
        } else {
            f52140a = currentTimeMillis;
            return false;
        }
    }
}
