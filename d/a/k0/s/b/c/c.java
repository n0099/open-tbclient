package d.a.k0.s.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60686a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60686a == null) {
                f60686a = new b();
            }
            bVar = f60686a;
        }
        return bVar;
    }
}
