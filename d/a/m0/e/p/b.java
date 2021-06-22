package d.a.m0.e.p;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50358a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50358a == null) {
                f50358a = new a();
            }
            aVar = f50358a;
        }
        return aVar;
    }
}
