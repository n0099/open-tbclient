package d.a.k0.a1.c.f;

import d.a.k0.a1.c.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f51262a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51263b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51264c = false;

    public void a(e eVar) {
        this.f51263b = true;
        int i2 = this.f51262a;
        if (i2 == -1 || !this.f51264c) {
            return;
        }
        eVar.a(i2);
    }

    public void b(int i2, e eVar) {
        this.f51262a = i2;
        if (this.f51263b && this.f51264c) {
            eVar.a(i2);
        }
    }
}
