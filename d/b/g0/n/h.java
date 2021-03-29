package d.b.g0.n;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f49241a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49242b;

    /* renamed from: c  reason: collision with root package name */
    public final int f49243c;

    /* renamed from: d  reason: collision with root package name */
    public long f49244d;

    /* renamed from: e  reason: collision with root package name */
    public int f49245e;

    public h(String str, int i, int i2) {
        this.f49241a = str;
        this.f49242b = i;
        this.f49243c = i2;
    }

    public String a() {
        return this.f49241a;
    }

    public boolean b() {
        if (this.f49242b != 0 && this.f49243c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (this.f49244d != 0 && (valueOf.longValue() - this.f49244d) / 1000 <= this.f49242b && this.f49245e >= this.f49243c) {
                return true;
            }
            if (this.f49244d == 0) {
                this.f49244d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f49244d) / 1000 > this.f49242b) {
                this.f49244d = valueOf.longValue();
                this.f49245e = 0;
            }
            this.f49245e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f49245e;
        return i != 0 && i == this.f49243c;
    }
}
