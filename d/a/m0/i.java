package d.a.m0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f63954a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f63954a == null) {
                f63954a = new h();
            }
            hVar = f63954a;
        }
        return hVar;
    }
}
