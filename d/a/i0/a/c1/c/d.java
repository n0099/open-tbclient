package d.a.i0.a.c1.c;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f40748a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f40748a == null) {
                f40748a = new c();
            }
            cVar = f40748a;
        }
        return cVar;
    }
}
