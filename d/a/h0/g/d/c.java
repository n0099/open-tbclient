package d.a.h0.g.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f46218b;

    /* renamed from: a  reason: collision with root package name */
    public a f46219a = new a();

    static {
        boolean z = a.f46216a;
    }

    public static c b() {
        if (f46218b == null) {
            synchronized (c.class) {
                if (f46218b == null) {
                    f46218b = new c();
                }
            }
        }
        return f46218b;
    }

    public void a(String str, d.a.h0.g.d.i.b bVar) {
        e.l().o(str, bVar);
    }

    public boolean c() {
        a aVar = this.f46219a;
        if (aVar == null) {
            return false;
        }
        return aVar.a();
    }

    public boolean d(String str) {
        a aVar = this.f46219a;
        return aVar != null && aVar.b(str);
    }

    public void e(boolean z) {
    }
}
