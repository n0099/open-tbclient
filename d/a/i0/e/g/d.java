package d.a.i0.e.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46354a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46354a == null) {
                f46354a = new c();
            }
            cVar = f46354a;
        }
        return cVar;
    }
}
