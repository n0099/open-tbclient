package d.b.i0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f54609a;

    /* renamed from: b  reason: collision with root package name */
    public int f54610b = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, int i2);
    }

    public int a() {
        return this.f54610b;
    }

    public void b(a aVar) {
        this.f54609a = aVar;
    }

    public void c(int i) {
        int i2 = this.f54610b;
        if (i2 != i) {
            a aVar = this.f54609a;
            if (aVar != null) {
                aVar.a(i2, i);
            }
            this.f54610b = i;
        }
    }

    public void d(int i) {
        this.f54610b = i;
    }
}
