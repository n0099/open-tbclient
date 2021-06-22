package d.a.m0.b.j;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f50048a;

    public static synchronized w a() {
        w wVar;
        synchronized (x.class) {
            if (f50048a == null) {
                f50048a = new w();
            }
            wVar = f50048a;
        }
        return wVar;
    }
}
