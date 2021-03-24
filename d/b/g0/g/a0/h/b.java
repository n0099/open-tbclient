package d.b.g0.g.a0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f47865a;

    /* renamed from: b  reason: collision with root package name */
    public long f47866b;

    /* renamed from: c  reason: collision with root package name */
    public long f47867c;

    public b(long j, long j2, long j3) {
        this.f47865a = j;
        this.f47866b = j2;
        this.f47867c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f47863a = Math.max(this.f47865a - this.f47866b, 0L);
            aVar.f47864b = this.f47865a + this.f47867c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f47865a;
        if (j >= 0) {
            long j2 = this.f47866b;
            if (j2 >= 0) {
                long j3 = this.f47867c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f47865a + "; mLeftOffset = " + this.f47866b + "; mRightOffset = " + this.f47867c + " ]";
    }
}
