package d.a.j0.a1.c.f;

import d.a.j0.a1.c.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f50565a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50566b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50567c = false;

    public void a(e eVar) {
        this.f50566b = true;
        int i2 = this.f50565a;
        if (i2 == -1 || !this.f50567c) {
            return;
        }
        eVar.a(i2);
    }

    public void b(int i2, e eVar) {
        this.f50565a = i2;
        if (this.f50566b && this.f50567c) {
            eVar.a(i2);
        }
    }
}
