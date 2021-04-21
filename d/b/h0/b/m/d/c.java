package d.b.h0.b.m.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.h0.a.m.a f48136a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.b.h0.a.m.a f48137b = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.b.h0.a.m.a {
        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
        }
    }

    public static d.b.h0.a.m.a a() {
        d.b.h0.a.m.a aVar = f48136a;
        return aVar == null ? f48137b : aVar;
    }

    public static void b() {
        f48136a = null;
    }

    public static void c(d.b.h0.a.m.a aVar) {
        if (f48136a != aVar) {
            f48136a = aVar;
        }
    }
}
