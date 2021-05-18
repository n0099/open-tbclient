package d.a.m0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f63975f = l.f63974a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f63976g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f63977a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63978b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63979c;

    /* renamed from: d  reason: collision with root package name */
    public long f63980d;

    /* renamed from: e  reason: collision with root package name */
    public int f63981e;

    public m(String str, int i2, int i3) {
        this.f63977a = str;
        this.f63978b = i2;
        this.f63979c = i3;
    }

    public String a() {
        return this.f63977a;
    }

    public boolean b() {
        if (this.f63978b != 0 && this.f63979c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f63975f) {
                Log.d(f63976g, "id " + this.f63977a + " mLimitUnit " + this.f63978b + " mLimitCnt " + this.f63979c + "mCount =  " + this.f63981e + " duration " + ((valueOf.longValue() - this.f63980d) / 1000));
            }
            if (this.f63980d != 0 && (valueOf.longValue() - this.f63980d) / 1000 <= this.f63978b && this.f63981e >= this.f63979c) {
                if (f63975f) {
                    Log.d(f63976g, "control");
                }
                return true;
            }
            if (this.f63980d == 0) {
                this.f63980d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f63980d) / 1000 > this.f63978b) {
                this.f63980d = valueOf.longValue();
                this.f63981e = 0;
                if (f63975f) {
                    Log.d(f63976g, "reset");
                }
            }
            this.f63981e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f63981e;
        return i2 != 0 && i2 == this.f63979c;
    }
}
