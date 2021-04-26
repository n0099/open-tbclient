package d.a.j0.s.b.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f59989a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f59989a == null) {
                f59989a = new c();
            }
            cVar = f59989a;
        }
        return cVar;
    }
}
