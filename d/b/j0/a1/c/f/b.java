package d.b.j0.a1.c.f;

import d.b.j0.a1.c.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f52868a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52869b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52870c = false;

    public void a(e eVar) {
        this.f52869b = true;
        int i = this.f52868a;
        if (i == -1 || !this.f52870c) {
            return;
        }
        eVar.a(i);
    }

    public void b(int i, e eVar) {
        this.f52868a = i;
        if (this.f52869b && this.f52870c) {
            eVar.a(i);
        }
    }
}
