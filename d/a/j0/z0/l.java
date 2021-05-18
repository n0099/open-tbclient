package d.a.j0.z0;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static long f50975a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f50975a;
        if (j > currentTimeMillis) {
            f50975a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - j < 500) {
            return true;
        } else {
            f50975a = currentTimeMillis;
            return false;
        }
    }
}
