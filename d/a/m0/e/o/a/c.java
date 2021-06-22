package d.a.m0.e.o.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f50343a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f50343a == null) {
                f50343a = new b();
            }
            bVar = f50343a;
        }
        return bVar;
    }
}
