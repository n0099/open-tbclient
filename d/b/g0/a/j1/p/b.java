package d.b.g0.a.j1.p;
/* loaded from: classes2.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f44950a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f44951b = -1;

    @Override // d.b.g0.a.j1.p.e
    public long a() {
        long j = this.f44950a;
        if (j >= 0) {
            long j2 = this.f44951b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.b.g0.a.j1.p.e
    public void b(long j) {
        this.f44950a = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public void c(long j) {
        this.f44951b = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public String getType() {
        return "PageSwitchCost";
    }
}
