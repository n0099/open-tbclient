package d.a.i0.a.r1.p;
/* loaded from: classes3.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f44380a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f44381b = -1;

    @Override // d.a.i0.a.r1.p.e
    public long a() {
        long j = this.f44380a;
        if (j >= 0) {
            long j2 = this.f44381b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.a.i0.a.r1.p.e
    public void b(long j) {
        this.f44381b = j;
    }

    @Override // d.a.i0.a.r1.p.e
    public void c(long j) {
        this.f44380a = j;
    }

    @Override // d.a.i0.a.r1.p.e
    public String getType() {
        return "PageSwitchCost";
    }
}
