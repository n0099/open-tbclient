package d.a.m0.a.c1.c;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f44727a;

    public static synchronized f a() {
        f fVar;
        synchronized (g.class) {
            if (f44727a == null) {
                f44727a = new f();
            }
            fVar = f44727a;
        }
        return fVar;
    }
}
