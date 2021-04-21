package d.b.h0.a.q1.a.f.a;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f46248a;

    /* renamed from: b  reason: collision with root package name */
    public int f46249b;

    public b(int i, int i2) {
        this.f46248a = i;
        this.f46249b = i2;
    }

    @Override // d.b.h0.a.q1.a.f.a.c
    public int a() {
        return (this.f46249b - this.f46248a) + 1;
    }

    @Override // d.b.h0.a.q1.a.f.a.c
    public Object getItem(int i) {
        if (i >= 0 && i < a()) {
            return Integer.valueOf(this.f46248a + i);
        }
        return 0;
    }
}
