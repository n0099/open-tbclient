package d.b.i0.y2;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f64209a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f64209a == null) {
                f64209a = new i();
            }
            iVar = f64209a;
        }
        return iVar;
    }
}
