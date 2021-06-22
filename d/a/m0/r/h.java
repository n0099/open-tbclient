package d.a.m0.r;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f52175a;

    /* renamed from: b  reason: collision with root package name */
    public final int f52176b;

    /* renamed from: c  reason: collision with root package name */
    public final int f52177c;

    /* renamed from: d  reason: collision with root package name */
    public long f52178d;

    /* renamed from: e  reason: collision with root package name */
    public int f52179e;

    public h(String str, int i2, int i3) {
        this.f52175a = str;
        this.f52176b = i2;
        this.f52177c = i3;
    }

    public String a() {
        return this.f52175a;
    }

    public boolean b() {
        if (this.f52176b != 0 && this.f52177c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f52178d;
            if (j != 0 && (currentTimeMillis - j) / 1000 <= this.f52176b && this.f52179e >= this.f52177c) {
                return true;
            }
            long j2 = this.f52178d;
            if (j2 == 0) {
                this.f52178d = currentTimeMillis;
            } else if ((currentTimeMillis - j2) / 1000 > this.f52176b) {
                this.f52178d = currentTimeMillis;
                this.f52179e = 0;
            }
            this.f52179e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f52179e;
        return i2 != 0 && i2 == this.f52177c;
    }
}
