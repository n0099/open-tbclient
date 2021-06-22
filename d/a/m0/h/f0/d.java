package d.a.m0.h.f0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f51155a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f51155a == null) {
                f51155a = new c();
            }
            cVar = f51155a;
        }
        return cVar;
    }
}
