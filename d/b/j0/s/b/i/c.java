package d.b.j0.s.b.i;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61814a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61814a == null) {
                f61814a = new b();
            }
            bVar = f61814a;
        }
        return bVar;
    }
}
