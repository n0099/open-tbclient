package d.a.c.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f39535a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f39535a == null) {
                f39535a = new b();
            }
            bVar = f39535a;
        }
        return bVar;
    }
}
