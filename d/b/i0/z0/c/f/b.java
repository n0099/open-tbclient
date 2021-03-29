package d.b.i0.z0.c.f;

import d.b.i0.z0.c.e;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f62828a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62829b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62830c = false;

    public void a(e eVar) {
        this.f62829b = true;
        int i = this.f62828a;
        if (i == -1 || !this.f62830c) {
            return;
        }
        eVar.a(i);
    }

    public void b(int i, e eVar) {
        this.f62828a = i;
        if (this.f62829b && this.f62830c) {
            eVar.a(i);
        }
    }
}
