package d.a.h0.d.j.b;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f45698a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f45698a == null) {
                f45698a = new b();
            }
            bVar = f45698a;
        }
        return bVar;
    }
}
