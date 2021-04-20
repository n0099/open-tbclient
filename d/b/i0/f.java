package d.b.i0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f55707a;

    /* renamed from: b  reason: collision with root package name */
    public int f55708b = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, int i2);
    }

    public int a() {
        return this.f55708b;
    }

    public void b(a aVar) {
        this.f55707a = aVar;
    }

    public void c(int i) {
        int i2 = this.f55708b;
        if (i2 != i) {
            a aVar = this.f55707a;
            if (aVar != null) {
                aVar.a(i2, i);
            }
            this.f55708b = i;
        }
    }

    public void d(int i) {
        this.f55708b = i;
    }
}
