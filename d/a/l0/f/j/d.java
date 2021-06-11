package d.a.l0.f.j;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f50542a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f50542a == null) {
                f50542a = new c();
            }
            cVar = f50542a;
        }
        return cVar;
    }
}
