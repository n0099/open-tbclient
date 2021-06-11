package d.a.l0.j;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f51514a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f51514a == null) {
                f51514a = new i();
            }
            iVar = f51514a;
        }
        return iVar;
    }
}
