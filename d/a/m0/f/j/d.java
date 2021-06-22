package d.a.m0.f.j;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f50650a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f50650a == null) {
                f50650a = new c();
            }
            cVar = f50650a;
        }
        return cVar;
    }
}
