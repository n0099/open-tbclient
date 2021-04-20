package d.b.g0.g.a0.h;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f48258a;

    /* renamed from: b  reason: collision with root package name */
    public long f48259b;

    /* renamed from: c  reason: collision with root package name */
    public long f48260c;

    public b(long j, long j2, long j3) {
        this.f48258a = j;
        this.f48259b = j2;
        this.f48260c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        return new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d));
    }

    public a a() {
        if (c()) {
            a aVar = new a();
            aVar.f48256a = Math.max(this.f48258a - this.f48259b, 0L);
            aVar.f48257b = this.f48258a + this.f48260c;
            return aVar;
        }
        return null;
    }

    public boolean c() {
        long j = this.f48258a;
        if (j >= 0) {
            long j2 = this.f48259b;
            if (j2 >= 0) {
                long j3 = this.f48260c;
                if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "[ mBaseline = " + this.f48258a + "; mLeftOffset = " + this.f48259b + "; mRightOffset = " + this.f48260c + " ]";
    }
}
