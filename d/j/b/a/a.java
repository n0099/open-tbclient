package d.j.b.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f66387a;

    /* renamed from: b  reason: collision with root package name */
    public String f66388b;

    /* renamed from: c  reason: collision with root package name */
    public String f66389c;

    /* renamed from: d  reason: collision with root package name */
    public int f66390d;

    public a(String str) {
        this.f66389c = str;
    }

    public void a(int i2) {
        this.f66390d = i2;
    }

    public void b(long j) {
        this.f66387a = j;
    }

    public void c(String str) {
        this.f66388b = str;
    }

    public boolean d() {
        return this.f66387a > System.currentTimeMillis();
    }

    public void e() {
        this.f66387a = 0L;
    }
}
