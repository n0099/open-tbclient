package d.b.i0.z0.c.f;

import d.b.i0.z0.c.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f62827a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62828b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62829c = false;

    public void a(e eVar) {
        this.f62828b = true;
        int i = this.f62827a;
        if (i == -1 || !this.f62829c) {
            return;
        }
        eVar.a(i);
    }

    public void b(int i, e eVar) {
        this.f62827a = i;
        if (this.f62828b && this.f62829c) {
            eVar.a(i);
        }
    }
}
