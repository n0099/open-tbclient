package d.a.h0.a.j1.p;
/* loaded from: classes3.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f42996a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f42997b = -1;

    @Override // d.a.h0.a.j1.p.e
    public long a() {
        long j = this.f42996a;
        if (j >= 0) {
            long j2 = this.f42997b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.a.h0.a.j1.p.e
    public void b(long j) {
        this.f42997b = j;
    }

    @Override // d.a.h0.a.j1.p.e
    public void c(long j) {
        this.f42996a = j;
    }

    @Override // d.a.h0.a.j1.p.e
    public String getType() {
        return "PageSwitchCost";
    }
}
