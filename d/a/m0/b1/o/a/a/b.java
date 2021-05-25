package d.a.m0.b1.o.a.a;
/* loaded from: classes3.dex */
public class b implements d.a.m0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public int f49141a;

    /* renamed from: b  reason: collision with root package name */
    public int f49142b;

    public b(int i2, int i3) {
        this.f49141a = i2;
        this.f49142b = i3;
    }

    @Override // d.a.m0.b1.o.b.a.a
    public int a() {
        return (this.f49142b - this.f49141a) + 1;
    }

    @Override // d.a.m0.b1.o.b.a.a
    public Object getItem(int i2) {
        if (i2 >= 0 && i2 < a()) {
            return Integer.valueOf(this.f49141a + i2);
        }
        return 0;
    }
}
