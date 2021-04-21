package d.b.j0.y2;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f64635a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f64635a == null) {
                f64635a = new q();
            }
            qVar = f64635a;
        }
        return qVar;
    }
}
