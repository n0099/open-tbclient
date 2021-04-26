package d.a.j0.y2;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f62913a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f62913a == null) {
                f62913a = new i();
            }
            iVar = f62913a;
        }
        return iVar;
    }
}
