package d.b.k0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f63965f = l.f63964a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f63966g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f63967a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63968b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63969c;

    /* renamed from: d  reason: collision with root package name */
    public long f63970d;

    /* renamed from: e  reason: collision with root package name */
    public int f63971e;

    public m(String str, int i, int i2) {
        this.f63967a = str;
        this.f63968b = i;
        this.f63969c = i2;
    }

    public String a() {
        return this.f63967a;
    }

    public boolean b() {
        if (this.f63968b != 0 && this.f63969c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f63965f) {
                Log.d(f63966g, "id " + this.f63967a + " mLimitUnit " + this.f63968b + " mLimitCnt " + this.f63969c + "mCount =  " + this.f63971e + " duration " + ((valueOf.longValue() - this.f63970d) / 1000));
            }
            if (this.f63970d != 0 && (valueOf.longValue() - this.f63970d) / 1000 <= this.f63968b && this.f63971e >= this.f63969c) {
                if (f63965f) {
                    Log.d(f63966g, "control");
                }
                return true;
            }
            if (this.f63970d == 0) {
                this.f63970d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f63970d) / 1000 > this.f63968b) {
                this.f63970d = valueOf.longValue();
                this.f63971e = 0;
                if (f63965f) {
                    Log.d(f63966g, "reset");
                }
            }
            this.f63971e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f63971e;
        return i != 0 && i == this.f63969c;
    }
}
