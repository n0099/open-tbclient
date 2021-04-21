package d.b.j0.s.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61839a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61839a == null) {
                f61839a = new b();
            }
            bVar = f61839a;
        }
        return bVar;
    }
}
