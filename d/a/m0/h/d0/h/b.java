package d.a.m0.h.d0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51075a;

    /* renamed from: b  reason: collision with root package name */
    public long f51076b;

    /* renamed from: c  reason: collision with root package name */
    public long f51077c;

    public b(long j, long j2, long j3) {
        this.f51075a = j;
        this.f51076b = j2;
        this.f51077c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f51073a = Math.max(this.f51075a - this.f51076b, 0L);
            aVar.f51074b = this.f51075a + this.f51077c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f51075a;
        if (j >= 0) {
            long j2 = this.f51076b;
            if (j2 >= 0) {
                long j3 = this.f51077c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f51075a + "; mLeftOffset = " + this.f51076b + "; mRightOffset = " + this.f51077c + " ]";
    }
}
