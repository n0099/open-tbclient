package d.b.q.g.c.a;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f64451a;

    public e() {
        this(0L);
    }

    public long a(long j) {
        return j & this.f64451a;
    }

    public void b(long j) {
        this.f64451a = j;
    }

    public boolean c(long j, long j2) {
        long j3 = this.f64451a;
        long j4 = (j & j2) | (((-1) ^ j2) & j3);
        this.f64451a = j4;
        return (j4 ^ j3) != 0;
    }

    public long d() {
        return this.f64451a;
    }

    public e(long j) {
        this.f64451a = j;
    }
}
