package d.a.m0.j;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f51622a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f51622a == null) {
                f51622a = new i();
            }
            iVar = f51622a;
        }
        return iVar;
    }
}
