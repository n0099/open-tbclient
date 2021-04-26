package d.a.h0.a.s0.k.f.c;
/* loaded from: classes2.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.h0.a.s0.k.f.a f43994a = new d.a.h0.a.s0.k.f.a();

    public c(String str) {
    }

    @Override // d.a.h0.a.s0.k.f.c.b, d.a.h0.a.s0.k.f.c.a
    public void a() {
        if (this.f43994a.d("video_will_play")) {
            this.f43994a.h("video_play_cancel");
        }
        c();
    }

    @Override // d.a.h0.a.s0.k.f.c.b, d.a.h0.a.s0.k.f.c.a
    public void b(boolean z) {
        if (this.f43994a.f()) {
            this.f43994a.j();
            d.a.h0.a.s0.k.f.b.e();
            return;
        }
        this.f43994a.g("fmpArrived", z ? "1" : "0");
    }

    public final void c() {
        this.f43994a.c();
        if (this.f43994a.e("fmpArrived")) {
            this.f43994a.j();
            d.a.h0.a.s0.k.f.b.e();
        }
    }
}
