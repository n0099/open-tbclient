package d.a.n0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f54255a;

    /* renamed from: b  reason: collision with root package name */
    public int f54256b = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2, int i3);
    }

    public int a() {
        return this.f54256b;
    }

    public void b(a aVar) {
        this.f54255a = aVar;
    }

    public void c(int i2) {
        int i3 = this.f54256b;
        if (i3 != i2) {
            a aVar = this.f54255a;
            if (aVar != null) {
                aVar.a(i3, i2);
            }
            this.f54256b = i2;
        }
    }

    public void d(int i2) {
        this.f54256b = i2;
    }
}
