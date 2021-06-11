package d.a.l0.h.f0;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f51048a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f51048a == null) {
                f51048a = new f();
            }
            fVar = f51048a;
        }
        return fVar;
    }
}
