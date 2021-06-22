package d.a.q0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f68120f = l.f68119a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f68121g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f68122a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68123b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68124c;

    /* renamed from: d  reason: collision with root package name */
    public long f68125d;

    /* renamed from: e  reason: collision with root package name */
    public int f68126e;

    public m(String str, int i2, int i3) {
        this.f68122a = str;
        this.f68123b = i2;
        this.f68124c = i3;
    }

    public String a() {
        return this.f68122a;
    }

    public boolean b() {
        if (this.f68123b != 0 && this.f68124c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f68120f) {
                Log.d(f68121g, "id " + this.f68122a + " mLimitUnit " + this.f68123b + " mLimitCnt " + this.f68124c + "mCount =  " + this.f68126e + " duration " + ((valueOf.longValue() - this.f68125d) / 1000));
            }
            if (this.f68125d != 0 && (valueOf.longValue() - this.f68125d) / 1000 <= this.f68123b && this.f68126e >= this.f68124c) {
                if (f68120f) {
                    Log.d(f68121g, "control");
                }
                return true;
            }
            if (this.f68125d == 0) {
                this.f68125d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f68125d) / 1000 > this.f68123b) {
                this.f68125d = valueOf.longValue();
                this.f68126e = 0;
                if (f68120f) {
                    Log.d(f68121g, "reset");
                }
            }
            this.f68126e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f68126e;
        return i2 != 0 && i2 == this.f68124c;
    }
}
