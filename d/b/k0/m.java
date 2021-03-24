package d.b.k0;

import android.util.Log;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f63964f = l.f63963a & true;

    /* renamed from: g  reason: collision with root package name */
    public static String f63965g = "ControlData";

    /* renamed from: a  reason: collision with root package name */
    public final String f63966a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63967b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63968c;

    /* renamed from: d  reason: collision with root package name */
    public long f63969d;

    /* renamed from: e  reason: collision with root package name */
    public int f63970e;

    public m(String str, int i, int i2) {
        this.f63966a = str;
        this.f63967b = i;
        this.f63968c = i2;
    }

    public String a() {
        return this.f63966a;
    }

    public boolean b() {
        if (this.f63967b != 0 && this.f63968c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f63964f) {
                Log.d(f63965g, "id " + this.f63966a + " mLimitUnit " + this.f63967b + " mLimitCnt " + this.f63968c + "mCount =  " + this.f63970e + " duration " + ((valueOf.longValue() - this.f63969d) / 1000));
            }
            if (this.f63969d != 0 && (valueOf.longValue() - this.f63969d) / 1000 <= this.f63967b && this.f63970e >= this.f63968c) {
                if (f63964f) {
                    Log.d(f63965g, "control");
                }
                return true;
            }
            if (this.f63969d == 0) {
                this.f63969d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f63969d) / 1000 > this.f63967b) {
                this.f63969d = valueOf.longValue();
                this.f63970e = 0;
                if (f63964f) {
                    Log.d(f63965g, "reset");
                }
            }
            this.f63970e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f63970e;
        return i != 0 && i == this.f63968c;
    }
}
