package d.b.h0.a.t1;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46966a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46966a == null) {
                f46966a = new c();
            }
            cVar = f46966a;
        }
        return cVar;
    }
}
