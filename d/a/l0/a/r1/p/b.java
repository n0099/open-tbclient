package d.a.l0.a.r1.p;
/* loaded from: classes3.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f44556a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f44557b = -1;

    @Override // d.a.l0.a.r1.p.e
    public long a() {
        long j = this.f44556a;
        if (j >= 0) {
            long j2 = this.f44557b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.a.l0.a.r1.p.e
    public void b(long j) {
        this.f44557b = j;
    }

    @Override // d.a.l0.a.r1.p.e
    public void c(long j) {
        this.f44556a = j;
    }

    @Override // d.a.l0.a.r1.p.e
    public String getType() {
        return "PageSwitchCost";
    }
}
