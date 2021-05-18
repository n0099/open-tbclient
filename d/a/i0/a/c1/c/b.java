package d.a.i0.a.c1.c;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f40747a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f40747a == null) {
                f40747a = new a();
            }
            aVar = f40747a;
        }
        return aVar;
    }
}
