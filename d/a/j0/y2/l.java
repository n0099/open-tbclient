package d.a.j0.y2;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f62914a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f62914a == null) {
                f62914a = new k();
            }
            kVar = f62914a;
        }
        return kVar;
    }
}
