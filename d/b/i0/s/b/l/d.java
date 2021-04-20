package d.b.i0.s.b.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f61408a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f61408a == null) {
                f61408a = new c();
            }
            cVar = f61408a;
        }
        return cVar;
    }
}
