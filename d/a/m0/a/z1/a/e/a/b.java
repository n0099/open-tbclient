package d.a.m0.a.z1.a.e.a;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f49810a;

    /* renamed from: b  reason: collision with root package name */
    public int f49811b;

    public b(int i2, int i3) {
        this.f49810a = i2;
        this.f49811b = i3;
    }

    @Override // d.a.m0.a.z1.a.e.a.c
    public int a() {
        return (this.f49811b - this.f49810a) + 1;
    }

    @Override // d.a.m0.a.z1.a.e.a.c
    public Object getItem(int i2) {
        if (i2 >= 0 && i2 < a()) {
            return Integer.valueOf(this.f49810a + i2);
        }
        return 0;
    }
}
