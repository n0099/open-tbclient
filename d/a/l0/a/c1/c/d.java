package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f40922a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f40922a == null) {
                f40922a = new c();
            }
            cVar = f40922a;
        }
        return cVar;
    }
}
