package d.a.l0.j;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f47840a;

    public static synchronized i a() {
        i iVar;
        synchronized (j.class) {
            if (f47840a == null) {
                f47840a = new i();
            }
            iVar = f47840a;
        }
        return iVar;
    }
}
