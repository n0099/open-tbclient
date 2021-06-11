package d.a.l0.e.o.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f50235a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f50235a == null) {
                f50235a = new b();
            }
            bVar = f50235a;
        }
        return bVar;
    }
}
