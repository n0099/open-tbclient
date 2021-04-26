package d.a.j.i;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f50342a;

    public b() {
        this(0L);
    }

    public b(long j) {
        this.f50342a = j;
    }

    public boolean a(long j, long j2) {
        long j3 = this.f50342a;
        long j4 = (j & j2) | ((~j2) & j3);
        this.f50342a = j4;
        return (j4 ^ j3) != 0;
    }
}
