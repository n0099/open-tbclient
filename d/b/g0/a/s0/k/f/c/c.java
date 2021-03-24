package d.b.g0.a.s0.k.f.c;
/* loaded from: classes3.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.g0.a.s0.k.f.a f45901a = new d.b.g0.a.s0.k.f.a();

    public c(String str) {
    }

    @Override // d.b.g0.a.s0.k.f.c.b, d.b.g0.a.s0.k.f.c.a
    public void a() {
        if (this.f45901a.d("video_will_play")) {
            this.f45901a.h("video_play_cancel");
        }
        c();
    }

    @Override // d.b.g0.a.s0.k.f.c.b, d.b.g0.a.s0.k.f.c.a
    public void b(boolean z) {
        if (this.f45901a.f()) {
            this.f45901a.j();
            d.b.g0.a.s0.k.f.b.e();
            return;
        }
        this.f45901a.g("fmpArrived", z ? "1" : "0");
    }

    public final void c() {
        this.f45901a.c();
        if (this.f45901a.e("fmpArrived")) {
            this.f45901a.j();
            d.b.g0.a.s0.k.f.b.e();
        }
    }
}
