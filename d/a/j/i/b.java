package d.a.j.i;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f44011a;

    public b() {
        this(0L);
    }

    public b(long j) {
        this.f44011a = j;
    }

    public boolean a(long j, long j2) {
        long j3 = this.f44011a;
        long j4 = (j & j2) | ((~j2) & j3);
        this.f44011a = j4;
        return (j4 ^ j3) != 0;
    }
}
