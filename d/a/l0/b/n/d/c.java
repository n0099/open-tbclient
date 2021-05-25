package d.a.l0.b.n.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.l0.a.m.a f46377a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.l0.a.m.a f46378b = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.a.l0.a.m.a {
        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
        }
    }

    public static d.a.l0.a.m.a a() {
        d.a.l0.a.m.a aVar = f46377a;
        return aVar == null ? f46378b : aVar;
    }

    public static void b() {
        f46377a = null;
    }

    public static void c(d.a.l0.a.m.a aVar) {
        if (f46377a != aVar) {
            f46377a = aVar;
        }
    }
}
