package d.a.i0.b.n.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.i0.a.m.a f46201a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.i0.a.m.a f46202b = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.a.i0.a.m.a {
        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
        }
    }

    public static d.a.i0.a.m.a a() {
        d.a.i0.a.m.a aVar = f46201a;
        return aVar == null ? f46202b : aVar;
    }

    public static void b() {
        f46201a = null;
    }

    public static void c(d.a.i0.a.m.a aVar) {
        if (f46201a != aVar) {
            f46201a = aVar;
        }
    }
}
