package d.b.g0.b.m.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.g0.a.m.a f47415a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.b.g0.a.m.a f47416b = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.b.g0.a.m.a {
        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
        }
    }

    public static d.b.g0.a.m.a a() {
        d.b.g0.a.m.a aVar = f47415a;
        return aVar == null ? f47416b : aVar;
    }

    public static void b() {
        f47415a = null;
    }

    public static void c(d.b.g0.a.m.a aVar) {
        if (f47415a != aVar) {
            f47415a = aVar;
        }
    }
}
