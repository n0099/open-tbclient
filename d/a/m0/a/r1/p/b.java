package d.a.m0.a.r1.p;
/* loaded from: classes3.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f48338a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f48339b = -1;

    @Override // d.a.m0.a.r1.p.e
    public long a() {
        long j = this.f48338a;
        if (j >= 0) {
            long j2 = this.f48339b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.a.m0.a.r1.p.e
    public void b(long j) {
        this.f48339b = j;
    }

    @Override // d.a.m0.a.r1.p.e
    public void c(long j) {
        this.f48338a = j;
    }

    @Override // d.a.m0.a.r1.p.e
    public String getType() {
        return "PageSwitchCost";
    }
}
