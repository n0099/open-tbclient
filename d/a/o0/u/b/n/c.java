package d.a.o0.u.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65140a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f65140a == null) {
                f65140a = new b();
            }
            bVar = f65140a;
        }
        return bVar;
    }
}
