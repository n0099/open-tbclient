package d.b.k0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f64665f = l.f64664a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f64666g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f64667a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64668b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64669c;

    /* renamed from: d  reason: collision with root package name */
    public long f64670d;

    /* renamed from: e  reason: collision with root package name */
    public int f64671e;

    public m(String str, int i, int i2) {
        this.f64667a = str;
        this.f64668b = i;
        this.f64669c = i2;
    }

    public String a() {
        return this.f64667a;
    }

    public boolean b() {
        if (this.f64668b != 0 && this.f64669c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f64665f) {
                Log.d(f64666g, "id " + this.f64667a + " mLimitUnit " + this.f64668b + " mLimitCnt " + this.f64669c + "mCount =  " + this.f64671e + " duration " + ((valueOf.longValue() - this.f64670d) / 1000));
            }
            if (this.f64670d != 0 && (valueOf.longValue() - this.f64670d) / 1000 <= this.f64668b && this.f64671e >= this.f64669c) {
                if (f64665f) {
                    Log.d(f64666g, "control");
                }
                return true;
            }
            if (this.f64670d == 0) {
                this.f64670d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f64670d) / 1000 > this.f64668b) {
                this.f64670d = valueOf.longValue();
                this.f64671e = 0;
                if (f64665f) {
                    Log.d(f64666g, "reset");
                }
            }
            this.f64671e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f64671e;
        return i != 0 && i == this.f64669c;
    }
}
