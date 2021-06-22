package d.a.o0.z2;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f67645a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f67645a == null) {
                f67645a = new k();
            }
            kVar = f67645a;
        }
        return kVar;
    }
}
