package d.b.h0.g.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f48751b;

    /* renamed from: a  reason: collision with root package name */
    public a f48752a = new a();

    static {
        boolean z = a.f48749a;
    }

    public static c b() {
        if (f48751b == null) {
            synchronized (c.class) {
                if (f48751b == null) {
                    f48751b = new c();
                }
            }
        }
        return f48751b;
    }

    public void a(String str, d.b.h0.g.d.i.b bVar) {
        e.l().o(str, bVar);
    }

    public boolean c() {
        a aVar = this.f48752a;
        if (aVar == null) {
            return false;
        }
        return aVar.a();
    }

    public boolean d(String str) {
        a aVar = this.f48752a;
        return aVar != null && aVar.b(str);
    }

    public void e(boolean z) {
    }
}
