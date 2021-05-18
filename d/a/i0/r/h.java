package d.a.i0.r;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f48217a;

    /* renamed from: b  reason: collision with root package name */
    public final int f48218b;

    /* renamed from: c  reason: collision with root package name */
    public final int f48219c;

    /* renamed from: d  reason: collision with root package name */
    public long f48220d;

    /* renamed from: e  reason: collision with root package name */
    public int f48221e;

    public h(String str, int i2, int i3) {
        this.f48217a = str;
        this.f48218b = i2;
        this.f48219c = i3;
    }

    public String a() {
        return this.f48217a;
    }

    public boolean b() {
        if (this.f48218b != 0 && this.f48219c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f48220d;
            if (j != 0 && (currentTimeMillis - j) / 1000 <= this.f48218b && this.f48221e >= this.f48219c) {
                return true;
            }
            long j2 = this.f48220d;
            if (j2 == 0) {
                this.f48220d = currentTimeMillis;
            } else if ((currentTimeMillis - j2) / 1000 > this.f48218b) {
                this.f48220d = currentTimeMillis;
                this.f48221e = 0;
            }
            this.f48221e++;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f48221e;
        return i2 != 0 && i2 == this.f48219c;
    }
}
