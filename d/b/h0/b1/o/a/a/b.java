package d.b.h0.b1.o.a.a;
/* loaded from: classes3.dex */
public class b implements d.b.h0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public int f49991a;

    /* renamed from: b  reason: collision with root package name */
    public int f49992b;

    public b(int i, int i2) {
        this.f49991a = i;
        this.f49992b = i2;
    }

    @Override // d.b.h0.b1.o.b.a.a
    public int a() {
        return (this.f49992b - this.f49991a) + 1;
    }

    @Override // d.b.h0.b1.o.b.a.a
    public Object getItem(int i) {
        if (i >= 0 && i < a()) {
            return Integer.valueOf(this.f49991a + i);
        }
        return 0;
    }
}
