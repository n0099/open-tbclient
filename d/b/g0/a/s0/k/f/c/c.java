package d.b.g0.a.s0.k.f.c;
/* loaded from: classes2.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.g0.a.s0.k.f.a f45902a = new d.b.g0.a.s0.k.f.a();

    public c(String str) {
    }

    @Override // d.b.g0.a.s0.k.f.c.b, d.b.g0.a.s0.k.f.c.a
    public void a() {
        if (this.f45902a.d("video_will_play")) {
            this.f45902a.h("video_play_cancel");
        }
        c();
    }

    @Override // d.b.g0.a.s0.k.f.c.b, d.b.g0.a.s0.k.f.c.a
    public void b(boolean z) {
        if (this.f45902a.f()) {
            this.f45902a.j();
            d.b.g0.a.s0.k.f.b.e();
            return;
        }
        this.f45902a.g("fmpArrived", z ? "1" : "0");
    }

    public final void c() {
        this.f45902a.c();
        if (this.f45902a.e("fmpArrived")) {
            this.f45902a.j();
            d.b.g0.a.s0.k.f.b.e();
        }
    }
}
