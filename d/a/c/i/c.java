package d.a.c.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f42852a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f42852a == null) {
                f42852a = new b();
            }
            bVar = f42852a;
        }
        return bVar;
    }
}
