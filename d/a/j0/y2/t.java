package d.a.j0.y2;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f62919a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f62919a == null) {
                f62919a = new s();
            }
            sVar = f62919a;
        }
        return sVar;
    }
}
