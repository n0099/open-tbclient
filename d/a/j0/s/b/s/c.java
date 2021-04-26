package d.a.j0.s.b.s;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60015a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60015a == null) {
                f60015a = new b();
            }
            bVar = f60015a;
        }
        return bVar;
    }
}
