package d.a.o0.u.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65093a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f65093a == null) {
                f65093a = new b();
            }
            bVar = f65093a;
        }
        return bVar;
    }
}
