package d.b.h0.a.j1.p;
/* loaded from: classes2.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f45669a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f45670b = -1;

    @Override // d.b.h0.a.j1.p.e
    public long a() {
        long j = this.f45669a;
        if (j >= 0) {
            long j2 = this.f45670b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.b.h0.a.j1.p.e
    public void b(long j) {
        this.f45669a = j;
    }

    @Override // d.b.h0.a.j1.p.e
    public void c(long j) {
        this.f45670b = j;
    }

    @Override // d.b.h0.a.j1.p.e
    public String getType() {
        return "PageInitRender";
    }
}
