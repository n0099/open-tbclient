package d.b.i0.b1.o.a.a;
/* loaded from: classes3.dex */
public class b implements d.b.i0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public int f50720a;

    /* renamed from: b  reason: collision with root package name */
    public int f50721b;

    public b(int i, int i2) {
        this.f50720a = i;
        this.f50721b = i2;
    }

    @Override // d.b.i0.b1.o.b.a.a
    public int a() {
        return (this.f50721b - this.f50720a) + 1;
    }

    @Override // d.b.i0.b1.o.b.a.a
    public Object getItem(int i) {
        if (i >= 0 && i < a()) {
            return Integer.valueOf(this.f50720a + i);
        }
        return 0;
    }
}
