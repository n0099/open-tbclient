package d.a.m0.f.j.m;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50655a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50655a == null) {
                f50655a = new a();
            }
            aVar = f50655a;
        }
        return aVar;
    }
}
