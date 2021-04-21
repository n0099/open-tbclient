package d.b.h0.g.a0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f48587a;

    /* renamed from: b  reason: collision with root package name */
    public long f48588b;

    /* renamed from: c  reason: collision with root package name */
    public long f48589c;

    public b(long j, long j2, long j3) {
        this.f48587a = j;
        this.f48588b = j2;
        this.f48589c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f48585a = Math.max(this.f48587a - this.f48588b, 0L);
            aVar.f48586b = this.f48587a + this.f48589c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f48587a;
        if (j >= 0) {
            long j2 = this.f48588b;
            if (j2 >= 0) {
                long j3 = this.f48589c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f48587a + "; mLeftOffset = " + this.f48588b + "; mRightOffset = " + this.f48589c + " ]";
    }
}
