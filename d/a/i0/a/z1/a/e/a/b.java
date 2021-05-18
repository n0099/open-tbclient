package d.a.i0.a.z1.a.e.a;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f45852a;

    /* renamed from: b  reason: collision with root package name */
    public int f45853b;

    public b(int i2, int i3) {
        this.f45852a = i2;
        this.f45853b = i3;
    }

    @Override // d.a.i0.a.z1.a.e.a.c
    public int a() {
        return (this.f45853b - this.f45852a) + 1;
    }

    @Override // d.a.i0.a.z1.a.e.a.c
    public Object getItem(int i2) {
        if (i2 >= 0 && i2 < a()) {
            return Integer.valueOf(this.f45852a + i2);
        }
        return 0;
    }
}
