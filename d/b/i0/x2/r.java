package d.b.i0.x2;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f62529a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f62529a == null) {
                f62529a = new q();
            }
            qVar = f62529a;
        }
        return qVar;
    }
}
