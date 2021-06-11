package d.a.n0.b1.d.f;

import d.a.n0.b1.d.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f55110a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55111b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55112c = false;

    public void a(e eVar) {
        this.f55111b = true;
        int i2 = this.f55110a;
        if (i2 == -1 || !this.f55112c) {
            return;
        }
        eVar.a(i2);
    }

    public void b(int i2, e eVar) {
        this.f55110a = i2;
        if (this.f55111b && this.f55112c) {
            eVar.a(i2);
        }
    }
}
