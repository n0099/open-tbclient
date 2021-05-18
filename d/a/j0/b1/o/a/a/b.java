package d.a.j0.b1.o.a.a;
/* loaded from: classes3.dex */
public class b implements d.a.j0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public int f49116a;

    /* renamed from: b  reason: collision with root package name */
    public int f49117b;

    public b(int i2, int i3) {
        this.f49116a = i2;
        this.f49117b = i3;
    }

    @Override // d.a.j0.b1.o.b.a.a
    public int a() {
        return (this.f49117b - this.f49116a) + 1;
    }

    @Override // d.a.j0.b1.o.b.a.a
    public Object getItem(int i2) {
        if (i2 >= 0 && i2 < a()) {
            return Integer.valueOf(this.f49116a + i2);
        }
        return 0;
    }
}
