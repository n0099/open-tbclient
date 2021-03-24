package d.b.g0.g.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f48029b;

    /* renamed from: a  reason: collision with root package name */
    public a f48030a = new a();

    static {
        boolean z = a.f48027a;
    }

    public static c b() {
        if (f48029b == null) {
            synchronized (c.class) {
                if (f48029b == null) {
                    f48029b = new c();
                }
            }
        }
        return f48029b;
    }

    public void a(String str, d.b.g0.g.d.i.b bVar) {
        e.l().o(str, bVar);
    }

    public boolean c() {
        a aVar = this.f48030a;
        if (aVar == null) {
            return false;
        }
        return aVar.a();
    }

    public boolean d(String str) {
        a aVar = this.f48030a;
        return aVar != null && aVar.b(str);
    }

    public void e(boolean z) {
    }
}
