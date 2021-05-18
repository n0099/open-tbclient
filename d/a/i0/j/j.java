package d.a.i0.j;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f47664a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f47664a == null) {
                f47664a = new i();
            }
            iVar = f47664a;
        }
        return iVar;
    }
}
