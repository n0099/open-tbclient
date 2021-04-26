package d.a.c.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f40290a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f40290a == null) {
                f40290a = new b();
            }
            bVar = f40290a;
        }
        return bVar;
    }
}
