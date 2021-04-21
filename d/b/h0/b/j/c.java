package d.b.h0.b.j;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f48031a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f48031a == null) {
                f48031a = new b();
            }
            bVar = f48031a;
        }
        return bVar;
    }
}
