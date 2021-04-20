package d.b.g0.a.q1.a.f.a;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f45919a;

    /* renamed from: b  reason: collision with root package name */
    public int f45920b;

    public b(int i, int i2) {
        this.f45919a = i;
        this.f45920b = i2;
    }

    @Override // d.b.g0.a.q1.a.f.a.c
    public int a() {
        return (this.f45920b - this.f45919a) + 1;
    }

    @Override // d.b.g0.a.q1.a.f.a.c
    public Object getItem(int i) {
        if (i >= 0 && i < a()) {
            return Integer.valueOf(this.f45919a + i);
        }
        return 0;
    }
}
