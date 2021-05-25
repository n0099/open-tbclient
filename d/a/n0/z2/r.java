package d.a.n0.z2;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f63806a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f63806a == null) {
                f63806a = new q();
            }
            qVar = f63806a;
        }
        return qVar;
    }
}
