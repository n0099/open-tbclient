package d.a.j0.y2;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f62918a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f62918a == null) {
                f62918a = new q();
            }
            qVar = f62918a;
        }
        return qVar;
    }
}
