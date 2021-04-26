package d.a.h0.a.h1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f42650a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f42650a == null) {
                f42650a = new a();
            }
            aVar = f42650a;
        }
        return aVar;
    }
}
