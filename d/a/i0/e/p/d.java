package d.a.i0.e.p;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46401a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46401a == null) {
                f46401a = new c();
            }
            cVar = f46401a;
        }
        return cVar;
    }
}
