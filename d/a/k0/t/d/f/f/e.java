package d.a.k0.t.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61485a;

    /* renamed from: b  reason: collision with root package name */
    public a f61486b;

    /* renamed from: c  reason: collision with root package name */
    public int f61487c = -1;

    public e(TbPageContext tbPageContext) {
        this.f61485a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.a.k0.t.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f61487c = -1;
            this.f61486b = new b(this.f61485a);
        } else if (z) {
            int i2 = aVar.f61426d;
            this.f61487c = i2;
            if (i2 == 1) {
                this.f61486b = new d(this.f61485a);
            } else if (i2 == 2) {
                this.f61486b = new f(this.f61485a);
            } else if (i2 != 3) {
                this.f61486b = new b(this.f61485a);
            } else {
                this.f61486b = new c(this.f61485a);
            }
        }
        if (this.f61486b.f(aVar)) {
            if (z) {
                this.f61486b.d();
            }
            this.f61486b.b(aVar);
            return;
        }
        this.f61487c = -1;
        b bVar = new b(this.f61485a);
        this.f61486b = bVar;
        if (z) {
            bVar.d();
        }
        this.f61486b.b(aVar);
    }

    public boolean c(d.a.k0.t.d.f.c.a aVar) {
        return aVar == null || this.f61487c != aVar.f61426d;
    }

    public void d(boolean z) {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i2) {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void g() {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f61486b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
