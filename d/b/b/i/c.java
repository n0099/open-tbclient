package d.b.b.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f42331a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f42331a == null) {
                f42331a = new b();
            }
            bVar = f42331a;
        }
        return bVar;
    }
}
