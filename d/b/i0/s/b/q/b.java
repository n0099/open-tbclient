package d.b.i0.s.b.q;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60120a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60120a == null) {
                f60120a = new a();
            }
            aVar = f60120a;
        }
        return aVar;
    }
}
