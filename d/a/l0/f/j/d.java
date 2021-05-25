package d.a.l0.f.j;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46868a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46868a == null) {
                f46868a = new c();
            }
            cVar = f46868a;
        }
        return cVar;
    }
}
