package d.b.g0.n;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f49633a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49634b;

    /* renamed from: c  reason: collision with root package name */
    public final int f49635c;

    /* renamed from: d  reason: collision with root package name */
    public long f49636d;

    /* renamed from: e  reason: collision with root package name */
    public int f49637e;

    public h(String str, int i, int i2) {
        this.f49633a = str;
        this.f49634b = i;
        this.f49635c = i2;
    }

    public String a() {
        return this.f49633a;
    }

    public boolean b() {
        if (this.f49634b != 0 && this.f49635c != 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (this.f49636d != 0 && (valueOf.longValue() - this.f49636d) / 1000 <= this.f49634b && this.f49637e >= this.f49635c) {
                return true;
            }
            if (this.f49636d == 0) {
                this.f49636d = valueOf.longValue();
            } else if ((valueOf.longValue() - this.f49636d) / 1000 > this.f49634b) {
                this.f49636d = valueOf.longValue();
                this.f49637e = 0;
            }
            this.f49637e++;
        }
        return false;
    }

    public boolean c() {
        int i = this.f49637e;
        return i != 0 && i == this.f49635c;
    }
}
