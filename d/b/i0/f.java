package d.b.i0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f54608a;

    /* renamed from: b  reason: collision with root package name */
    public int f54609b = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, int i2);
    }

    public int a() {
        return this.f54609b;
    }

    public void b(a aVar) {
        this.f54608a = aVar;
    }

    public void c(int i) {
        int i2 = this.f54609b;
        if (i2 != i) {
            a aVar = this.f54608a;
            if (aVar != null) {
                aVar.a(i2, i);
            }
            this.f54609b = i;
        }
    }

    public void d(int i) {
        this.f54609b = i;
    }
}
