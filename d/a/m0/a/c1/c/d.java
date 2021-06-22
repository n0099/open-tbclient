package d.a.m0.a.c1.c;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f44706a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f44706a == null) {
                f44706a = new c();
            }
            cVar = f44706a;
        }
        return cVar;
    }
}
