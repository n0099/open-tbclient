package d.b.h0.n;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f49962a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49963b;

    /* renamed from: c  reason: collision with root package name */
    public final int f49964c;

    /* renamed from: d  reason: collision with root package name */
    public long f49965d;

    /* renamed from: e  reason: collision with root package name */
    public int f49966e;

    public h(String str, int i, int i2) {
        this.f49962a = str;
        this.f49963b = i;
        this.f49964c = i2;
    }

    public String a() {
        return this.f49962a;
    }

    public boolean b() {
        if (this.f49963b != 0 && this.f49964c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (this.f49965d != 0 && (valueOf.longValue() - this.f49965d) / 1000 <= this.f49963b && this.f49966e >= this.f49964c) {
                return true;
            }
            if (this.f49965d == 0) {
                this.f49965d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f49965d) / 1000 > this.f49963b) {
                this.f49965d = valueOf.longValue();
                this.f49966e = 0;
            }
            this.f49966e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f49966e;
        return i != 0 && i == this.f49964c;
    }
}
