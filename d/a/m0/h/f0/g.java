package d.a.m0.h.f0;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f51156a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f51156a == null) {
                f51156a = new f();
            }
            fVar = f51156a;
        }
        return fVar;
    }
}
