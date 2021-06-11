package d.a.n0.z2;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f67524a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f67524a == null) {
                f67524a = new q();
            }
            qVar = f67524a;
        }
        return qVar;
    }
}
