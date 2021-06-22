package d.a.o0.b1.d.f;

import d.a.o0.b1.d.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f55235a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55236b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55237c = false;

    public void a(e eVar) {
        this.f55236b = true;
        int i2 = this.f55235a;
        if (i2 == -1 || !this.f55237c) {
            return;
        }
        eVar.a(i2);
    }

    public void b(int i2, e eVar) {
        this.f55235a = i2;
        if (this.f55236b && this.f55237c) {
            eVar.a(i2);
        }
    }
}
