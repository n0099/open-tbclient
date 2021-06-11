package d.a.l0.r;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f52067a;

    /* renamed from: b  reason: collision with root package name */
    public final int f52068b;

    /* renamed from: c  reason: collision with root package name */
    public final int f52069c;

    /* renamed from: d  reason: collision with root package name */
    public long f52070d;

    /* renamed from: e  reason: collision with root package name */
    public int f52071e;

    public h(String str, int i2, int i3) {
        this.f52067a = str;
        this.f52068b = i2;
        this.f52069c = i3;
    }

    public String a() {
        return this.f52067a;
    }

    public boolean b() {
        if (this.f52068b != 0 && this.f52069c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f52070d;
            if (j != 0 && (currentTimeMillis - j) / 1000 <= this.f52068b && this.f52071e >= this.f52069c) {
                return true;
            }
            long j2 = this.f52070d;
            if (j2 == 0) {
                this.f52070d = currentTimeMillis;
            } else if ((currentTimeMillis - j2) / 1000 > this.f52068b) {
                this.f52070d = currentTimeMillis;
                this.f52071e = 0;
            }
            this.f52071e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f52071e;
        return i2 != 0 && i2 == this.f52069c;
    }
}
