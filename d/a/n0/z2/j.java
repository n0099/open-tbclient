package d.a.n0.z2;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f63801a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f63801a == null) {
                f63801a = new i();
            }
            iVar = f63801a;
        }
        return iVar;
    }
}
