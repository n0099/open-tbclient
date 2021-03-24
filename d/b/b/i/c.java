package d.b.b.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f42330a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f42330a == null) {
                f42330a = new b();
            }
            bVar = f42330a;
        }
        return bVar;
    }
}
