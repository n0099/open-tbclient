package d.b.g0.a.j1.p;
/* loaded from: classes2.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f45342a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f45343b = -1;

    @Override // d.b.g0.a.j1.p.e
    public long a() {
        long j = this.f45342a;
        if (j >= 0) {
            long j2 = this.f45343b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.b.g0.a.j1.p.e
    public void b(long j) {
        this.f45342a = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public void c(long j) {
        this.f45343b = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public String getType() {
        return "PageSwitchCost";
    }
}
