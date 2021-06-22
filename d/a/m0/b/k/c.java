package d.a.m0.b.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f50054a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f50054a == null) {
                f50054a = new b();
            }
            bVar = f50054a;
        }
        return bVar;
    }
}
