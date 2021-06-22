package d.a.o0.u.b.f;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65107a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f65107a == null) {
                f65107a = new b();
            }
            bVar = f65107a;
        }
        return bVar;
    }
}
