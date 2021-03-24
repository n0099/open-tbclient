package d.j.b.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f66189a;

    /* renamed from: b  reason: collision with root package name */
    public String f66190b;

    /* renamed from: c  reason: collision with root package name */
    public String f66191c;

    /* renamed from: d  reason: collision with root package name */
    public int f66192d;

    public a(String str) {
        this.f66191c = str;
    }

    public void a(int i) {
        this.f66192d = i;
    }

    public void b(long j) {
        this.f66189a = j;
    }

    public void c(String str) {
        this.f66190b = str;
    }

    public boolean d() {
        return this.f66189a > System.currentTimeMillis();
    }

    public void e() {
        this.f66189a = 0L;
    }
}
