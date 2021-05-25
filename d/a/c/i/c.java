package d.a.c.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f39199a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f39199a == null) {
                f39199a = new b();
            }
            bVar = f39199a;
        }
        return bVar;
    }
}
