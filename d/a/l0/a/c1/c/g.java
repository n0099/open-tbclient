package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f40943a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f40943a == null) {
                f40943a = new f();
            }
            fVar = f40943a;
        }
        return fVar;
    }
}
