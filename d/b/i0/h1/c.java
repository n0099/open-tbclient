package d.b.i0.h1;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.h1.a f55145a;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f55146a = new c();
    }

    public static c b() {
        return b.f55146a;
    }

    public void a(boolean z) {
        d.b.i0.h1.a aVar = this.f55145a;
        if (aVar != null) {
            aVar.cancel();
            this.f55145a = null;
        }
        d.b.i0.h1.a aVar2 = new d.b.i0.h1.a(z);
        this.f55145a = aVar2;
        aVar2.execute(new String[0]);
    }

    public void c() {
        d.b.i0.h1.a aVar = this.f55145a;
        if (aVar == null) {
            return;
        }
        aVar.cancel();
        this.f55145a = null;
    }

    public c() {
    }
}
