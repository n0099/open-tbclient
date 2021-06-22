package d.a.m0.e.p;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f50359a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f50359a == null) {
                f50359a = new c();
            }
            cVar = f50359a;
        }
        return cVar;
    }
}
