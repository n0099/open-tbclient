package d.a.m0.b.n.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.m0.a.m.a f50159a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.m0.a.m.a f50160b = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.a.m0.a.m.a {
        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
        }
    }

    public static d.a.m0.a.m.a a() {
        d.a.m0.a.m.a aVar = f50159a;
        return aVar == null ? f50160b : aVar;
    }

    public static void b() {
        f50159a = null;
    }

    public static void c(d.a.m0.a.m.a aVar) {
        if (f50159a != aVar) {
            f50159a = aVar;
        }
    }
}
