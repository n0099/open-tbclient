package d.k.b.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f67330a;

    /* renamed from: b  reason: collision with root package name */
    public String f67331b;

    /* renamed from: c  reason: collision with root package name */
    public String f67332c;

    /* renamed from: d  reason: collision with root package name */
    public int f67333d;

    public a(String str) {
        this.f67332c = str;
    }

    public void a(int i) {
        this.f67333d = i;
    }

    public void b(long j) {
        this.f67330a = j;
    }

    public void c(String str) {
        this.f67331b = str;
    }

    public boolean d() {
        return this.f67330a > System.currentTimeMillis();
    }

    public void e() {
        this.f67330a = 0L;
    }
}
