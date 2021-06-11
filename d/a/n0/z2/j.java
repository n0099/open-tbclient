package d.a.n0.z2;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f67519a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f67519a == null) {
                f67519a = new i();
            }
            iVar = f67519a;
        }
        return iVar;
    }
}
