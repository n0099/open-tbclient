package d.a.k0.y2;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f63637a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f63637a == null) {
                f63637a = new i();
            }
            iVar = f63637a;
        }
        return iVar;
    }
}
