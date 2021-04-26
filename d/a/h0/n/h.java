package d.a.h0.n;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f47490a;

    /* renamed from: b  reason: collision with root package name */
    public final int f47491b;

    /* renamed from: c  reason: collision with root package name */
    public final int f47492c;

    /* renamed from: d  reason: collision with root package name */
    public long f47493d;

    /* renamed from: e  reason: collision with root package name */
    public int f47494e;

    public h(String str, int i2, int i3) {
        this.f47490a = str;
        this.f47491b = i2;
        this.f47492c = i3;
    }

    public String a() {
        return this.f47490a;
    }

    public boolean b() {
        if (this.f47491b != 0 && this.f47492c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (this.f47493d != 0 && (valueOf.longValue() - this.f47493d) / 1000 <= this.f47491b && this.f47494e >= this.f47492c) {
                return true;
            }
            if (this.f47493d == 0) {
                this.f47493d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f47493d) / 1000 > this.f47491b) {
                this.f47493d = valueOf.longValue();
                this.f47494e = 0;
            }
            this.f47494e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f47494e;
        return i2 != 0 && i2 == this.f47492c;
    }
}
