package d.a.l0.b.j;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f49940a;

    public static synchronized w a() {
        w wVar;
        synchronized (x.class) {
            if (f49940a == null) {
                f49940a = new w();
            }
            wVar = f49940a;
        }
        return wVar;
    }
}
