package d.a.l0.r;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f48393a;

    /* renamed from: b  reason: collision with root package name */
    public final int f48394b;

    /* renamed from: c  reason: collision with root package name */
    public final int f48395c;

    /* renamed from: d  reason: collision with root package name */
    public long f48396d;

    /* renamed from: e  reason: collision with root package name */
    public int f48397e;

    public h(String str, int i2, int i3) {
        this.f48393a = str;
        this.f48394b = i2;
        this.f48395c = i3;
    }

    public String a() {
        return this.f48393a;
    }

    public boolean b() {
        if (this.f48394b != 0 && this.f48395c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f48396d;
            if (j != 0 && (currentTimeMillis - j) / 1000 <= this.f48394b && this.f48397e >= this.f48395c) {
                return true;
            }
            long j2 = this.f48396d;
            if (j2 == 0) {
                this.f48396d = currentTimeMillis;
            } else if ((currentTimeMillis - j2) / 1000 > this.f48394b) {
                this.f48396d = currentTimeMillis;
                this.f48397e = 0;
            }
            this.f48397e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f48397e;
        return i2 != 0 && i2 == this.f48395c;
    }
}
