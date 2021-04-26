package d.a.h0.b.j;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f45471a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f45471a == null) {
                f45471a = new b();
            }
            bVar = f45471a;
        }
        return bVar;
    }
}
