package d.a.k0.i1;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.i1.a f56071a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f56072a = new c();
    }

    public static c b() {
        return b.f56072a;
    }

    public void a(boolean z) {
        d.a.k0.i1.a aVar = this.f56071a;
        if (aVar != null) {
            aVar.cancel();
            this.f56071a = null;
        }
        d.a.k0.i1.a aVar2 = new d.a.k0.i1.a(z);
        this.f56071a = aVar2;
        aVar2.execute(new String[0]);
    }

    public void c() {
        d.a.k0.i1.a aVar = this.f56071a;
        if (aVar == null) {
            return;
        }
        aVar.cancel();
        this.f56071a = null;
    }

    public c() {
    }
}
