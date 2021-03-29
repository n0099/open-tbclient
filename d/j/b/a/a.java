package d.j.b.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f66190a;

    /* renamed from: b  reason: collision with root package name */
    public String f66191b;

    /* renamed from: c  reason: collision with root package name */
    public String f66192c;

    /* renamed from: d  reason: collision with root package name */
    public int f66193d;

    public a(String str) {
        this.f66192c = str;
    }

    public void a(int i) {
        this.f66193d = i;
    }

    public void b(long j) {
        this.f66190a = j;
    }

    public void c(String str) {
        this.f66191b = str;
    }

    public boolean d() {
        return this.f66190a > System.currentTimeMillis();
    }

    public void e() {
        this.f66190a = 0L;
    }
}
