package d.b.g0.n;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f49240a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49241b;

    /* renamed from: c  reason: collision with root package name */
    public final int f49242c;

    /* renamed from: d  reason: collision with root package name */
    public long f49243d;

    /* renamed from: e  reason: collision with root package name */
    public int f49244e;

    public h(String str, int i, int i2) {
        this.f49240a = str;
        this.f49241b = i;
        this.f49242c = i2;
    }

    public String a() {
        return this.f49240a;
    }

    public boolean b() {
        if (this.f49241b != 0 && this.f49242c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (this.f49243d != 0 && (valueOf.longValue() - this.f49243d) / 1000 <= this.f49241b && this.f49244e >= this.f49242c) {
                return true;
            }
            if (this.f49243d == 0) {
                this.f49243d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f49243d) / 1000 > this.f49241b) {
                this.f49243d = valueOf.longValue();
                this.f49244e = 0;
            }
            this.f49244e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f49244e;
        return i != 0 && i == this.f49242c;
    }
}
