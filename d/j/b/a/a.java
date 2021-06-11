package d.j.b.a;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f70173a;

    /* renamed from: b  reason: collision with root package name */
    public String f70174b;

    /* renamed from: c  reason: collision with root package name */
    public String f70175c;

    /* renamed from: d  reason: collision with root package name */
    public int f70176d;

    public a(String str) {
        this.f70175c = str;
    }

    public void a(int i2) {
        this.f70176d = i2;
    }

    public void b(long j) {
        this.f70173a = j;
    }

    public void c(String str) {
        this.f70174b = str;
    }

    public boolean d() {
        return this.f70173a > System.currentTimeMillis();
    }

    public void e() {
        this.f70173a = 0L;
    }
}
