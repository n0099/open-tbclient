package d.b.j0.y2;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f64630a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f64630a == null) {
                f64630a = new i();
            }
            iVar = f64630a;
        }
        return iVar;
    }
}
