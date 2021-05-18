package d.a.i0.h.f0;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f47198a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f47198a == null) {
                f47198a = new f();
            }
            fVar = f47198a;
        }
        return fVar;
    }
}
