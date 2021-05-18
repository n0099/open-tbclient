package d.b.b;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class v1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f65074a;

    /* renamed from: b  reason: collision with root package name */
    public int f65075b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65076c;

    public v1(Context context) {
        this.f65074a = context;
    }

    public abstract boolean a();

    public abstract long b();

    public abstract long[] c();

    public abstract boolean d();

    public abstract String e();

    public void f() {
        this.f65076c = true;
    }

    public boolean g() {
        return this.f65076c;
    }

    public final long h() {
        boolean z;
        long j;
        if (!a() || o0.a(this.f65074a)) {
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
                    this.f65075b = 0;
                    j = b() - System.currentTimeMillis();
                } else {
                    long[] c2 = c();
                    int i2 = this.f65075b;
                    this.f65075b = i2 + 1;
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
