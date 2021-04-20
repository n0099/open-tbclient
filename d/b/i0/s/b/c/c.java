package d.b.i0.s.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61362a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61362a == null) {
                f61362a = new b();
            }
            bVar = f61362a;
        }
        return bVar;
    }
}
