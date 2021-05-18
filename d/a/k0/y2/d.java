package d.a.k0.y2;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f63630a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f63630a == null) {
                f63630a = new c();
            }
            cVar = f63630a;
        }
        return cVar;
    }
}
