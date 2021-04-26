package d.a.h0.g.a0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f46049a;

    /* renamed from: b  reason: collision with root package name */
    public long f46050b;

    /* renamed from: c  reason: collision with root package name */
    public long f46051c;

    public b(long j, long j2, long j3) {
        this.f46049a = j;
        this.f46050b = j2;
        this.f46051c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f46047a = Math.max(this.f46049a - this.f46050b, 0L);
            aVar.f46048b = this.f46049a + this.f46051c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f46049a;
        if (j >= 0) {
            long j2 = this.f46050b;
            if (j2 >= 0) {
                long j3 = this.f46051c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f46049a + "; mLeftOffset = " + this.f46050b + "; mRightOffset = " + this.f46051c + " ]";
    }
}
