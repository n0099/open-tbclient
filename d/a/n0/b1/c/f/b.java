package d.a.n0.b1.c.f;

import d.a.n0.b1.c.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f51427a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51428b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51429c = false;

    public void a(e eVar) {
        this.f51428b = true;
        int i2 = this.f51427a;
        if (i2 == -1 || !this.f51429c) {
            return;
        }
        eVar.a(i2);
    }

    public void b(int i2, e eVar) {
        this.f51427a = i2;
        if (this.f51428b && this.f51429c) {
            eVar.a(i2);
        }
    }
}
