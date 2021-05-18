package d.a.k0.y2;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f63638a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f63638a == null) {
                f63638a = new k();
            }
            kVar = f63638a;
        }
        return kVar;
    }
}
