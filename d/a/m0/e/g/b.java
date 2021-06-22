package d.a.m0.e.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50309a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50309a == null) {
                f50309a = new a();
            }
            aVar = f50309a;
        }
        return aVar;
    }
}
