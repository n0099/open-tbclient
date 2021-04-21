package d.b.c.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f43068a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f43068a == null) {
                f43068a = new b();
            }
            bVar = f43068a;
        }
        return bVar;
    }
}
