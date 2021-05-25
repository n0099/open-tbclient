package d.a.l0.b.o;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f46448a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f46448a == null) {
                f46448a = new b();
            }
            bVar = f46448a;
        }
        return bVar;
    }
}
