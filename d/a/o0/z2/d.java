package d.a.o0.z2;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f67637a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f67637a == null) {
                f67637a = new c();
            }
            cVar = f67637a;
        }
        return cVar;
    }
}
