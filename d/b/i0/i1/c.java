package d.b.i0.i1;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.i1.a f57003a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f57004a = new c();
    }

    public static c b() {
        return b.f57004a;
    }

    public void a(boolean z) {
        d.b.i0.i1.a aVar = this.f57003a;
        if (aVar != null) {
            aVar.cancel();
            this.f57003a = null;
        }
        d.b.i0.i1.a aVar2 = new d.b.i0.i1.a(z);
        this.f57003a = aVar2;
        aVar2.execute(new String[0]);
    }

    public void c() {
        d.b.i0.i1.a aVar = this.f57003a;
        if (aVar == null) {
            return;
        }
        aVar.cancel();
        this.f57003a = null;
    }

    public c() {
    }
}
