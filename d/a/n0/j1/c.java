package d.a.n0.j1;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.j1.a f59944a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f59945a = new c();
    }

    public static c b() {
        return b.f59945a;
    }

    public void a(boolean z) {
        d.a.n0.j1.a aVar = this.f59944a;
        if (aVar != null) {
            aVar.cancel();
            this.f59944a = null;
        }
        d.a.n0.j1.a aVar2 = new d.a.n0.j1.a(z);
        this.f59944a = aVar2;
        aVar2.execute(new String[0]);
    }

    public void c() {
        d.a.n0.j1.a aVar = this.f59944a;
        if (aVar == null) {
            return;
        }
        aVar.cancel();
        this.f59944a = null;
    }

    public c() {
    }
}
