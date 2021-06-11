package d.a.p0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f67706f = l.f67705a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f67707g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f67708a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67709b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67710c;

    /* renamed from: d  reason: collision with root package name */
    public long f67711d;

    /* renamed from: e  reason: collision with root package name */
    public int f67712e;

    public m(String str, int i2, int i3) {
        this.f67708a = str;
        this.f67709b = i2;
        this.f67710c = i3;
    }

    public String a() {
        return this.f67708a;
    }

    public boolean b() {
        if (this.f67709b != 0 && this.f67710c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f67706f) {
                Log.d(f67707g, "id " + this.f67708a + " mLimitUnit " + this.f67709b + " mLimitCnt " + this.f67710c + "mCount =  " + this.f67712e + " duration " + ((valueOf.longValue() - this.f67711d) / 1000));
            }
            if (this.f67711d != 0 && (valueOf.longValue() - this.f67711d) / 1000 <= this.f67709b && this.f67712e >= this.f67710c) {
                if (f67706f) {
                    Log.d(f67707g, "control");
                }
                return true;
            }
            if (this.f67711d == 0) {
                this.f67711d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f67711d) / 1000 > this.f67709b) {
                this.f67711d = valueOf.longValue();
                this.f67712e = 0;
                if (f67706f) {
                    Log.d(f67707g, "reset");
                }
            }
            this.f67712e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f67712e;
        return i2 != 0 && i2 == this.f67710c;
    }
}
