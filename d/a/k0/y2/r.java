package d.a.k0.y2;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f63642a;

    public static synchronized q a() {
        q qVar;
        synchronized (r.class) {
            if (f63642a == null) {
                f63642a = new q();
            }
            qVar = f63642a;
        }
        return qVar;
    }
}
