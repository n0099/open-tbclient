package d.b.h0.b.i;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f48025a;

    public static synchronized w a() {
        w wVar;
        synchronized (x.class) {
            if (f48025a == null) {
                f48025a = new w();
            }
            wVar = f48025a;
        }
        return wVar;
    }
}
