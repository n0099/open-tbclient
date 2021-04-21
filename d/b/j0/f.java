package d.b.j0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f56128a;

    /* renamed from: b  reason: collision with root package name */
    public int f56129b = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, int i2);
    }

    public int a() {
        return this.f56129b;
    }

    public void b(a aVar) {
        this.f56128a = aVar;
    }

    public void c(int i) {
        int i2 = this.f56129b;
        if (i2 != i) {
            a aVar = this.f56128a;
            if (aVar != null) {
                aVar.a(i2, i);
            }
            this.f56129b = i;
        }
    }

    public void d(int i) {
        this.f56129b = i;
    }
}
