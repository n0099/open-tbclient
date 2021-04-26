package d.a.j0.i1;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.i1.a f55364a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f55365a = new c();
    }

    public static c b() {
        return b.f55365a;
    }

    public void a(boolean z) {
        d.a.j0.i1.a aVar = this.f55364a;
        if (aVar != null) {
            aVar.cancel();
            this.f55364a = null;
        }
        d.a.j0.i1.a aVar2 = new d.a.j0.i1.a(z);
        this.f55364a = aVar2;
        aVar2.execute(new String[0]);
    }

    public void c() {
        d.a.j0.i1.a aVar = this.f55364a;
        if (aVar == null) {
            return;
        }
        aVar.cancel();
        this.f55364a = null;
    }

    public c() {
    }
}
