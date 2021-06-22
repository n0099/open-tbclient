package d.a.m0.b.o;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f50230a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f50230a == null) {
                f50230a = new b();
            }
            bVar = f50230a;
        }
        return bVar;
    }
}
