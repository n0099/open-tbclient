package d.j.b.a;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f70277a;

    /* renamed from: b  reason: collision with root package name */
    public String f70278b;

    /* renamed from: c  reason: collision with root package name */
    public String f70279c;

    /* renamed from: d  reason: collision with root package name */
    public int f70280d;

    public a(String str) {
        this.f70279c = str;
    }

    public void a(int i2) {
        this.f70280d = i2;
    }

    public void b(long j) {
        this.f70277a = j;
    }

    public void c(String str) {
        this.f70278b = str;
    }

    public boolean d() {
        return this.f70277a > System.currentTimeMillis();
    }

    public void e() {
        this.f70277a = 0L;
    }
}
