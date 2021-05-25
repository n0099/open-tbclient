package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f40944a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f40944a == null) {
                f40944a = new h();
            }
            hVar = f40944a;
        }
        return hVar;
    }
}
