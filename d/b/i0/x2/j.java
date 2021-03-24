package d.b.i0.x2;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f62523a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f62523a == null) {
                f62523a = new i();
            }
            iVar = f62523a;
        }
        return iVar;
    }
}
