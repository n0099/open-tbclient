package d.a.l0.b.j;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f46266a;

    public static synchronized w a() {
        w wVar;
        synchronized (x.class) {
            if (f46266a == null) {
                f46266a = new w();
            }
            wVar = f46266a;
        }
        return wVar;
    }
}
