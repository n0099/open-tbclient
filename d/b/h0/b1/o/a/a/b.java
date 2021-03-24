package d.b.h0.b1.o.a.a;
/* loaded from: classes3.dex */
public class b implements d.b.h0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public int f49990a;

    /* renamed from: b  reason: collision with root package name */
    public int f49991b;

    public b(int i, int i2) {
        this.f49990a = i;
        this.f49991b = i2;
    }

    @Override // d.b.h0.b1.o.b.a.a
    public int a() {
        return (this.f49991b - this.f49990a) + 1;
    }

    @Override // d.b.h0.b1.o.b.a.a
    public Object getItem(int i) {
        if (i >= 0 && i < a()) {
            return Integer.valueOf(this.f49990a + i);
        }
        return 0;
    }
}
