package d.b.i0.s.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60061a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60061a == null) {
                f60061a = new b();
            }
            bVar = f60061a;
        }
        return bVar;
    }
}
