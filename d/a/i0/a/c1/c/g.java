package d.a.i0.a.c1.c;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f40769a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f40769a == null) {
                f40769a = new f();
            }
            fVar = f40769a;
        }
        return fVar;
    }
}
