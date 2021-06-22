package d.a.o0.z2;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f67644a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f67644a == null) {
                f67644a = new i();
            }
            iVar = f67644a;
        }
        return iVar;
    }
}
