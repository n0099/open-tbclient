package d.a.h0.b.m.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f45611a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f45611a == null) {
                f45611a = new a();
            }
            aVar = f45611a;
        }
        return aVar;
    }
}
