package d.j.b.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f66344a;

    /* renamed from: b  reason: collision with root package name */
    public String f66345b;

    /* renamed from: c  reason: collision with root package name */
    public String f66346c;

    /* renamed from: d  reason: collision with root package name */
    public int f66347d;

    public a(String str) {
        this.f66346c = str;
    }

    public void a(int i2) {
        this.f66347d = i2;
    }

    public void b(long j) {
        this.f66344a = j;
    }

    public void c(String str) {
        this.f66345b = str;
    }

    public boolean d() {
        return this.f66344a > System.currentTimeMillis();
    }

    public void e() {
        this.f66344a = 0L;
    }
}
