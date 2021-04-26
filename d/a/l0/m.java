package d.a.l0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f63251f = l.f63250a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f63252g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f63253a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63254b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63255c;

    /* renamed from: d  reason: collision with root package name */
    public long f63256d;

    /* renamed from: e  reason: collision with root package name */
    public int f63257e;

    public m(String str, int i2, int i3) {
        this.f63253a = str;
        this.f63254b = i2;
        this.f63255c = i3;
    }

    public String a() {
        return this.f63253a;
    }

    public boolean b() {
        if (this.f63254b != 0 && this.f63255c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f63251f) {
                Log.d(f63252g, "id " + this.f63253a + " mLimitUnit " + this.f63254b + " mLimitCnt " + this.f63255c + "mCount =  " + this.f63257e + " duration " + ((valueOf.longValue() - this.f63256d) / 1000));
            }
            if (this.f63256d != 0 && (valueOf.longValue() - this.f63256d) / 1000 <= this.f63254b && this.f63257e >= this.f63255c) {
                if (f63251f) {
                    Log.d(f63252g, "control");
                }
                return true;
            }
            if (this.f63256d == 0) {
                this.f63256d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f63256d) / 1000 > this.f63254b) {
                this.f63256d = valueOf.longValue();
                this.f63257e = 0;
                if (f63251f) {
                    Log.d(f63252g, "reset");
                }
            }
            this.f63257e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f63257e;
        return i2 != 0 && i2 == this.f63255c;
    }
}
