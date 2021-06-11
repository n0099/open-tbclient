package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f44597a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f44597a == null) {
                f44597a = new a();
            }
            aVar = f44597a;
        }
        return aVar;
    }
}
