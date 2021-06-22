package d.a.m0.a.c1.c;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f44728a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f44728a == null) {
                f44728a = new h();
            }
            hVar = f44728a;
        }
        return hVar;
    }
}
