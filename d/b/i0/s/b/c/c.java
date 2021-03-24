package d.b.i0.s.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60060a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60060a == null) {
                f60060a = new b();
            }
            bVar = f60060a;
        }
        return bVar;
    }
}
