package d.b.g0.a.q1.a.f.a;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f45526a;

    /* renamed from: b  reason: collision with root package name */
    public int f45527b;

    public b(int i, int i2) {
        this.f45526a = i;
        this.f45527b = i2;
    }

    @Override // d.b.g0.a.q1.a.f.a.c
    public int a() {
        return (this.f45527b - this.f45526a) + 1;
    }

    @Override // d.b.g0.a.q1.a.f.a.c
    public Object getItem(int i) {
        if (i >= 0 && i < a()) {
            return Integer.valueOf(this.f45526a + i);
        }
        return 0;
    }
}
