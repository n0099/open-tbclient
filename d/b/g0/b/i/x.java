package d.b.g0.b.i;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f47303a;

    public static synchronized w a() {
        w wVar;
        synchronized (x.class) {
            if (f47303a == null) {
                f47303a = new w();
            }
            wVar = f47303a;
        }
        return wVar;
    }
}
