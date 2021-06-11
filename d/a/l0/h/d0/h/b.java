package d.a.l0.h.d0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f50967a;

    /* renamed from: b  reason: collision with root package name */
    public long f50968b;

    /* renamed from: c  reason: collision with root package name */
    public long f50969c;

    public b(long j, long j2, long j3) {
        this.f50967a = j;
        this.f50968b = j2;
        this.f50969c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f50965a = Math.max(this.f50967a - this.f50968b, 0L);
            aVar.f50966b = this.f50967a + this.f50969c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f50967a;
        if (j >= 0) {
            long j2 = this.f50968b;
            if (j2 >= 0) {
                long j3 = this.f50969c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f50967a + "; mLeftOffset = " + this.f50968b + "; mRightOffset = " + this.f50969c + " ]";
    }
}
