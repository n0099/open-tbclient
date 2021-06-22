package d.a.o0.j1;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.j1.a f60069a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f60070a = new c();
    }

    public static c b() {
        return b.f60070a;
    }

    public void a(boolean z) {
        d.a.o0.j1.a aVar = this.f60069a;
        if (aVar != null) {
            aVar.cancel();
            this.f60069a = null;
        }
        d.a.o0.j1.a aVar2 = new d.a.o0.j1.a(z);
        this.f60069a = aVar2;
        aVar2.execute(new String[0]);
    }

    public void c() {
        d.a.o0.j1.a aVar = this.f60069a;
        if (aVar == null) {
            return;
        }
        aVar.cancel();
        this.f60069a = null;
    }

    public c() {
    }
}
