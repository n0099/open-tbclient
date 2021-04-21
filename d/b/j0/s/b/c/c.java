package d.b.j0.s.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61783a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61783a == null) {
                f61783a = new b();
            }
            bVar = f61783a;
        }
        return bVar;
    }
}
