package d.b.g0.a.j1.p;
/* loaded from: classes2.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public long f44948a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f44949b = -1;

    @Override // d.b.g0.a.j1.p.e
    public long a() {
        long j = this.f44948a;
        if (j >= 0) {
            long j2 = this.f44949b;
            if (j2 < 0) {
                return -1L;
            }
            return j2 - j;
        }
        return -1L;
    }

    @Override // d.b.g0.a.j1.p.e
    public void b(long j) {
        this.f44948a = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public void c(long j) {
        this.f44949b = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public String getType() {
        return "PageInitRender";
    }
}
