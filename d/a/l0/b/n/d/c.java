package d.a.l0.b.n.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.l0.a.m.a f50051a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.l0.a.m.a f50052b = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.a.l0.a.m.a {
        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
        }
    }

    public static d.a.l0.a.m.a a() {
        d.a.l0.a.m.a aVar = f50051a;
        return aVar == null ? f50052b : aVar;
    }

    public static void b() {
        f50051a = null;
    }

    public static void c(d.a.l0.a.m.a aVar) {
        if (f50051a != aVar) {
            f50051a = aVar;
        }
    }
}
