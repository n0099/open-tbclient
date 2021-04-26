package d.a.h0.a.q1.a.f.a;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f43597a;

    /* renamed from: b  reason: collision with root package name */
    public int f43598b;

    public b(int i2, int i3) {
        this.f43597a = i2;
        this.f43598b = i3;
    }

    @Override // d.a.h0.a.q1.a.f.a.c
    public int a() {
        return (this.f43598b - this.f43597a) + 1;
    }

    @Override // d.a.h0.a.q1.a.f.a.c
    public Object getItem(int i2) {
        if (i2 >= 0 && i2 < a()) {
            return Integer.valueOf(this.f43597a + i2);
        }
        return 0;
    }
}
