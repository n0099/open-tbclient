package d.b.h0.a.s0.k.f.c;
/* loaded from: classes2.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.h0.a.s0.k.f.a f46623a = new d.b.h0.a.s0.k.f.a();

    public c(String str) {
    }

    @Override // d.b.h0.a.s0.k.f.c.b, d.b.h0.a.s0.k.f.c.a
    public void a() {
        if (this.f46623a.d("video_will_play")) {
            this.f46623a.h("video_play_cancel");
        }
        c();
    }

    @Override // d.b.h0.a.s0.k.f.c.b, d.b.h0.a.s0.k.f.c.a
    public void b(boolean z) {
        if (this.f46623a.f()) {
            this.f46623a.j();
            d.b.h0.a.s0.k.f.b.e();
            return;
        }
        this.f46623a.g("fmpArrived", z ? "1" : "0");
    }

    public final void c() {
        this.f46623a.c();
        if (this.f46623a.e("fmpArrived")) {
            this.f46623a.j();
            d.b.h0.a.s0.k.f.b.e();
        }
    }
}
