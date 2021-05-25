package d.a.p0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f63988f = l.f63987a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f63989g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f63990a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63991b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63992c;

    /* renamed from: d  reason: collision with root package name */
    public long f63993d;

    /* renamed from: e  reason: collision with root package name */
    public int f63994e;

    public m(String str, int i2, int i3) {
        this.f63990a = str;
        this.f63991b = i2;
        this.f63992c = i3;
    }

    public String a() {
        return this.f63990a;
    }

    public boolean b() {
        if (this.f63991b != 0 && this.f63992c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f63988f) {
                Log.d(f63989g, "id " + this.f63990a + " mLimitUnit " + this.f63991b + " mLimitCnt " + this.f63992c + "mCount =  " + this.f63994e + " duration " + ((valueOf.longValue() - this.f63993d) / 1000));
            }
            if (this.f63993d != 0 && (valueOf.longValue() - this.f63993d) / 1000 <= this.f63991b && this.f63994e >= this.f63992c) {
                if (f63988f) {
                    Log.d(f63989g, "control");
                }
                return true;
            }
            if (this.f63993d == 0) {
                this.f63993d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f63993d) / 1000 > this.f63991b) {
                this.f63993d = valueOf.longValue();
                this.f63994e = 0;
                if (f63988f) {
                    Log.d(f63989g, "reset");
                }
            }
            this.f63994e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f63994e;
        return i2 != 0 && i2 == this.f63992c;
    }
}
