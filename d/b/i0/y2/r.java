package d.b.i0.y2;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f64214a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f64214a == null) {
                f64214a = new q();
            }
            qVar = f64214a;
        }
        return qVar;
    }
}
