package d.b.i0.a1.c.f;

import d.b.i0.a1.c.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f52447a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52448b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52449c = false;

    public void a(e eVar) {
        this.f52448b = true;
        int i = this.f52447a;
        if (i == -1 || !this.f52449c) {
            return;
        }
        eVar.a(i);
    }

    public void b(int i, e eVar) {
        this.f52447a = i;
        if (this.f52448b && this.f52449c) {
            eVar.a(i);
        }
    }
}
