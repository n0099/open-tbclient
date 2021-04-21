package d.b.h0.a.j1.p;
/* loaded from: classes2.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f45671a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f45672b = -1;

    @Override // d.b.h0.a.j1.p.e
    public long a() {
        long j = this.f45671a;
        if (j >= 0) {
            long j2 = this.f45672b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.b.h0.a.j1.p.e
    public void b(long j) {
        this.f45671a = j;
    }

    @Override // d.b.h0.a.j1.p.e
    public void c(long j) {
        this.f45672b = j;
    }

    @Override // d.b.h0.a.j1.p.e
    public String getType() {
        return "PageSwitchCost";
    }
}
