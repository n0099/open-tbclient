package d.b.i0.s.b.s;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60131a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60131a == null) {
                f60131a = new b();
            }
            bVar = f60131a;
        }
        return bVar;
    }
}
