package d.j.b.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f65658a;

    /* renamed from: b  reason: collision with root package name */
    public String f65659b;

    /* renamed from: c  reason: collision with root package name */
    public String f65660c;

    /* renamed from: d  reason: collision with root package name */
    public int f65661d;

    public a(String str) {
        this.f65660c = str;
    }

    public void a(int i2) {
        this.f65661d = i2;
    }

    public void b(long j) {
        this.f65658a = j;
    }

    public void c(String str) {
        this.f65659b = str;
    }

    public boolean d() {
        return this.f65658a > System.currentTimeMillis();
    }

    public void e() {
        this.f65658a = 0L;
    }
}
