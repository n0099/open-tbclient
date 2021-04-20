package d.b.i0.s.b.s;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61433a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61433a == null) {
                f61433a = new b();
            }
            bVar = f61433a;
        }
        return bVar;
    }
}
