package d.a.h0.b.m.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.h0.a.m.a f45582a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.h0.a.m.a f45583b = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.a.h0.a.m.a {
        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
        }
    }

    public static d.a.h0.a.m.a a() {
        d.a.h0.a.m.a aVar = f45582a;
        return aVar == null ? f45583b : aVar;
    }

    public static void b() {
        f45582a = null;
    }

    public static void c(d.a.h0.a.m.a aVar) {
        if (f45582a != aVar) {
            f45582a = aVar;
        }
    }
}
