package d.a.n0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f57944a;

    /* renamed from: b  reason: collision with root package name */
    public int f57945b = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2, int i3);
    }

    public int a() {
        return this.f57945b;
    }

    public void b(a aVar) {
        this.f57944a = aVar;
    }

    public void c(int i2) {
        int i3 = this.f57945b;
        if (i3 != i2) {
            a aVar = this.f57944a;
            if (aVar != null) {
                aVar.a(i3, i2);
            }
            this.f57945b = i2;
        }
    }

    public void d(int i2) {
        this.f57945b = i2;
    }
}
