package d.b.j0.s.b.r;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f61853a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f61853a == null) {
                f61853a = new c();
            }
            cVar = f61853a;
        }
        return cVar;
    }
}
