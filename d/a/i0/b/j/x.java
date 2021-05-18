package d.a.i0.b.j;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f46090a;

    public static synchronized w a() {
        w wVar;
        synchronized (x.class) {
            if (f46090a == null) {
                f46090a = new w();
            }
            wVar = f46090a;
        }
        return wVar;
    }
}
