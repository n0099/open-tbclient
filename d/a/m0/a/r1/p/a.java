package d.a.m0.a.r1.p;
/* loaded from: classes3.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f48336a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f48337b = -1;

    @Override // d.a.m0.a.r1.p.e
    public long a() {
        long j = this.f48336a;
        if (j >= 0) {
            long j2 = this.f48337b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.a.m0.a.r1.p.e
    public void b(long j) {
        this.f48337b = j;
    }

    @Override // d.a.m0.a.r1.p.e
    public void c(long j) {
        this.f48336a = j;
    }

    @Override // d.a.m0.a.r1.p.e
    public String getType() {
        return "PageInitRender";
    }
}
