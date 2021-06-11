package d.a.l0.e.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f50204a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f50204a == null) {
                f50204a = new c();
            }
            cVar = f50204a;
        }
        return cVar;
    }
}
