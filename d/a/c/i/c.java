package d.a.c.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f42955a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f42955a == null) {
                f42955a = new b();
            }
            bVar = f42955a;
        }
        return bVar;
    }
}
