package d.a.m0.z0;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static long f54725a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f54725a;
        if (j > currentTimeMillis) {
            f54725a = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - j < 500) {
            return true;
        } else {
            f54725a = currentTimeMillis;
            return false;
        }
    }
}
