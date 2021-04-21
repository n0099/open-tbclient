package d.b.j0.i1;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.i1.a f57424a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f57425a = new c();
    }

    public static c b() {
        return b.f57425a;
    }

    public void a(boolean z) {
        d.b.j0.i1.a aVar = this.f57424a;
        if (aVar != null) {
            aVar.cancel();
            this.f57424a = null;
        }
        d.b.j0.i1.a aVar2 = new d.b.j0.i1.a(z);
        this.f57424a = aVar2;
        aVar2.execute(new String[0]);
    }

    public void c() {
        d.b.j0.i1.a aVar = this.f57424a;
        if (aVar == null) {
            return;
        }
        aVar.cancel();
        this.f57424a = null;
    }

    public c() {
    }
}
