package d.a.m0.a.c1.c;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f44705a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f44705a == null) {
                f44705a = new a();
            }
            aVar = f44705a;
        }
        return aVar;
    }
}
