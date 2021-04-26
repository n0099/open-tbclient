package d.b.b;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class v1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64388a;

    /* renamed from: b  reason: collision with root package name */
    public int f64389b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64390c;

    public v1(Context context) {
        this.f64388a = context;
    }

    public abstract boolean a();

    public abstract long b();

    public abstract long[] c();

    public abstract boolean d();

    public abstract String e();

    public void f() {
        this.f64390c = true;
    }

    public boolean g() {
        return this.f64390c;
    }

    public final long h() {
        boolean z;
        long j;
        if (!a() || o0.a(this.f64388a)) {
            long b2 = b();
            long currentTimeMillis = System.currentTimeMillis();
            if (b2 <= 1000 + currentTimeMillis) {
                try {
                    z = d();
                } catch (Exception e2) {
                    r0.b(e2);
                    z = false;
                }
                if (z) {
                    this.f64389b = 0;
                    j = b() - System.currentTimeMillis();
                } else {
                    long[] c2 = c();
                    int i2 = this.f64389b;
                    this.f64389b = i2 + 1;
                    j = c2[i2 % c2.length];
                }
                r0.e(e() + " worked:" + z + " " + j, null);
                return j;
            }
            return b2 - currentTimeMillis;
        }
        return 60000L;
    }
}
