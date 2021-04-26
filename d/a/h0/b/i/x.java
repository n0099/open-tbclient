package d.a.h0.b.i;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f45465a;

    public static synchronized w a() {
        w wVar;
        synchronized (x.class) {
            if (f45465a == null) {
                f45465a = new w();
            }
            wVar = f45465a;
        }
        return wVar;
    }
}
