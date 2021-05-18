package d.a.i0.a.c1.c;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f40770a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f40770a == null) {
                f40770a = new h();
            }
            hVar = f40770a;
        }
        return hVar;
    }
}
