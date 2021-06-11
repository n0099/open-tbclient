package d.a.l0.a.c1.c;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f44598a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f44598a == null) {
                f44598a = new c();
            }
            cVar = f44598a;
        }
        return cVar;
    }
}
