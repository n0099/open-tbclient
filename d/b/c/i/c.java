package d.b.c.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f42828a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f42828a == null) {
                f42828a = new b();
            }
            bVar = f42828a;
        }
        return bVar;
    }
}
