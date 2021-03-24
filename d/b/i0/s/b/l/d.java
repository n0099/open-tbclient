package d.b.i0.s.b.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f60106a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f60106a == null) {
                f60106a = new c();
            }
            cVar = f60106a;
        }
        return cVar;
    }
}
