package d.a.l0.e.p;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f50251a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f50251a == null) {
                f50251a = new c();
            }
            cVar = f50251a;
        }
        return cVar;
    }
}
