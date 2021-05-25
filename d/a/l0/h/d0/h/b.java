package d.a.l0.h.d0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f47293a;

    /* renamed from: b  reason: collision with root package name */
    public long f47294b;

    /* renamed from: c  reason: collision with root package name */
    public long f47295c;

    public b(long j, long j2, long j3) {
        this.f47293a = j;
        this.f47294b = j2;
        this.f47295c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f47291a = Math.max(this.f47293a - this.f47294b, 0L);
            aVar.f47292b = this.f47293a + this.f47295c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f47293a;
        if (j >= 0) {
            long j2 = this.f47294b;
            if (j2 >= 0) {
                long j3 = this.f47295c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f47293a + "; mLeftOffset = " + this.f47294b + "; mRightOffset = " + this.f47295c + " ]";
    }
}
