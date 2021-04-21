package d.b.l0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f64946f = l.f64945a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f64947g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f64948a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64949b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64950c;

    /* renamed from: d  reason: collision with root package name */
    public long f64951d;

    /* renamed from: e  reason: collision with root package name */
    public int f64952e;

    public m(String str, int i, int i2) {
        this.f64948a = str;
        this.f64949b = i;
        this.f64950c = i2;
    }

    public String a() {
        return this.f64948a;
    }

    public boolean b() {
        if (this.f64949b != 0 && this.f64950c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f64946f) {
                Log.d(f64947g, "id " + this.f64948a + " mLimitUnit " + this.f64949b + " mLimitCnt " + this.f64950c + "mCount =  " + this.f64952e + " duration " + ((valueOf.longValue() - this.f64951d) / 1000));
            }
            if (this.f64951d != 0 && (valueOf.longValue() - this.f64951d) / 1000 <= this.f64949b && this.f64952e >= this.f64950c) {
                if (f64946f) {
                    Log.d(f64947g, "control");
                }
                return true;
            }
            if (this.f64951d == 0) {
                this.f64951d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f64951d) / 1000 > this.f64949b) {
                this.f64951d = valueOf.longValue();
                this.f64952e = 0;
                if (f64946f) {
                    Log.d(f64947g, "reset");
                }
            }
            this.f64952e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f64952e;
        return i != 0 && i == this.f64950c;
    }
}
