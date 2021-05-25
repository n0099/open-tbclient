package d.a.j.i;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f40227a;

    public b() {
        this(0L);
    }

    public b(long j) {
        this.f40227a = j;
    }

    public boolean a(long j, long j2) {
        long j3 = this.f40227a;
        long j4 = (j & j2) | ((~j2) & j3);
        this.f40227a = j4;
        return (j4 ^ j3) != 0;
    }
}
