package d.j.b.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f67183a;

    /* renamed from: b  reason: collision with root package name */
    public String f67184b;

    /* renamed from: c  reason: collision with root package name */
    public String f67185c;

    /* renamed from: d  reason: collision with root package name */
    public int f67186d;

    public a(String str) {
        this.f67185c = str;
    }

    public void a(int i) {
        this.f67186d = i;
    }

    public void b(long j) {
        this.f67183a = j;
    }

    public void c(String str) {
        this.f67184b = str;
    }

    public boolean d() {
        return this.f67183a > System.currentTimeMillis();
    }

    public void e() {
        this.f67183a = 0L;
    }
}
