package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f40921a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f40921a == null) {
                f40921a = new a();
            }
            aVar = f40921a;
        }
        return aVar;
    }
}
