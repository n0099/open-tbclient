package d.a.n0.z2;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f67520a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f67520a == null) {
                f67520a = new k();
            }
            kVar = f67520a;
        }
        return kVar;
    }
}
