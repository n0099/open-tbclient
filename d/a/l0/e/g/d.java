package d.a.l0.e.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46530a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46530a == null) {
                f46530a = new c();
            }
            cVar = f46530a;
        }
        return cVar;
    }
}
