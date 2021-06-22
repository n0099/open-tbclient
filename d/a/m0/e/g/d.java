package d.a.m0.e.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f50312a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f50312a == null) {
                f50312a = new c();
            }
            cVar = f50312a;
        }
        return cVar;
    }
}
