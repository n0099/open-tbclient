package d.b.q.g.c.a;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f65410a;

    public e() {
        this(0L);
    }

    public long a(long j) {
        return j & this.f65410a;
    }

    public void b(long j) {
        this.f65410a = j;
    }

    public boolean c(long j, long j2) {
        long j3 = this.f65410a;
        long j4 = (j & j2) | ((~j2) & j3);
        this.f65410a = j4;
        return (j4 ^ j3) != 0;
    }

    public long d() {
        return this.f65410a;
    }

    public e(long j) {
        this.f65410a = j;
    }
}
