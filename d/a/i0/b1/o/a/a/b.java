package d.a.i0.b1.o.a.a;
/* loaded from: classes3.dex */
public class b implements d.a.i0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public int f48288a;

    /* renamed from: b  reason: collision with root package name */
    public int f48289b;

    public b(int i2, int i3) {
        this.f48288a = i2;
        this.f48289b = i3;
    }

    @Override // d.a.i0.b1.o.b.a.a
    public int a() {
        return (this.f48289b - this.f48288a) + 1;
    }

    @Override // d.a.i0.b1.o.b.a.a
    public Object getItem(int i2) {
        if (i2 >= 0 && i2 < a()) {
            return Integer.valueOf(this.f48288a + i2);
        }
        return 0;
    }
}
