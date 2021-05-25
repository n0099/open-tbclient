package d.a.l0.h.f0;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f47374a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f47374a == null) {
                f47374a = new f();
            }
            fVar = f47374a;
        }
        return fVar;
    }
}
