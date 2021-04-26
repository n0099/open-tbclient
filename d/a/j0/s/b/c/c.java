package d.a.j0.s.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f59941a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f59941a == null) {
                f59941a = new b();
            }
            bVar = f59941a;
        }
        return bVar;
    }
}
