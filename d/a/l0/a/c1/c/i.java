package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f44620a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f44620a == null) {
                f44620a = new h();
            }
            hVar = f44620a;
        }
        return hVar;
    }
}
