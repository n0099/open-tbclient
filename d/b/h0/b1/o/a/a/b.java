package d.b.h0.b1.o.a.a;
/* loaded from: classes3.dex */
public class b implements d.b.h0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public int f50384a;

    /* renamed from: b  reason: collision with root package name */
    public int f50385b;

    public b(int i, int i2) {
        this.f50384a = i;
        this.f50385b = i2;
    }

    @Override // d.b.h0.b1.o.b.a.a
    public int a() {
        return (this.f50385b - this.f50384a) + 1;
    }

    @Override // d.b.h0.b1.o.b.a.a
    public Object getItem(int i) {
        if (i >= 0 && i < a()) {
            return Integer.valueOf(this.f50384a + i);
        }
        return 0;
    }
}
