package d.a.o0.u.b.k;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65137a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f65137a == null) {
                f65137a = new b();
            }
            bVar = f65137a;
        }
        return bVar;
    }
}
