package d.b.j0.s.b.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f61829a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f61829a == null) {
                f61829a = new c();
            }
            cVar = f61829a;
        }
        return cVar;
    }
}
