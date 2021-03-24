package d.b.j.i;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f63762a;

    public b() {
        this(0L);
    }

    public b(long j) {
        this.f63762a = j;
    }

    public boolean a(long j, long j2) {
        long j3 = this.f63762a;
        long j4 = (j & j2) | (((-1) ^ j2) & j3);
        this.f63762a = j4;
        return (j4 ^ j3) != 0;
    }
}
