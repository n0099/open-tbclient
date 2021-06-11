package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f44619a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f44619a == null) {
                f44619a = new f();
            }
            fVar = f44619a;
        }
        return fVar;
    }
}
