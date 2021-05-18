package d.a.i0.h.d0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f47117a;

    /* renamed from: b  reason: collision with root package name */
    public long f47118b;

    /* renamed from: c  reason: collision with root package name */
    public long f47119c;

    public b(long j, long j2, long j3) {
        this.f47117a = j;
        this.f47118b = j2;
        this.f47119c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f47115a = Math.max(this.f47117a - this.f47118b, 0L);
            aVar.f47116b = this.f47117a + this.f47119c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f47117a;
        if (j >= 0) {
            long j2 = this.f47118b;
            if (j2 >= 0) {
                long j3 = this.f47119c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f47117a + "; mLeftOffset = " + this.f47118b + "; mRightOffset = " + this.f47119c + " ]";
    }
}
