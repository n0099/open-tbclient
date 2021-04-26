package d.a.j0.t.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60761a;

    /* renamed from: b  reason: collision with root package name */
    public a f60762b;

    /* renamed from: c  reason: collision with root package name */
    public int f60763c = -1;

    public e(TbPageContext tbPageContext) {
        this.f60761a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.a.j0.t.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f60763c = -1;
            this.f60762b = new b(this.f60761a);
        } else if (z) {
            int i2 = aVar.f60702d;
            this.f60763c = i2;
            if (i2 == 1) {
                this.f60762b = new d(this.f60761a);
            } else if (i2 == 2) {
                this.f60762b = new f(this.f60761a);
            } else if (i2 != 3) {
                this.f60762b = new b(this.f60761a);
            } else {
                this.f60762b = new c(this.f60761a);
            }
        }
        if (this.f60762b.f(aVar)) {
            if (z) {
                this.f60762b.d();
            }
            this.f60762b.b(aVar);
            return;
        }
        this.f60763c = -1;
        b bVar = new b(this.f60761a);
        this.f60762b = bVar;
        if (z) {
            bVar.d();
        }
        this.f60762b.b(aVar);
    }

    public boolean c(d.a.j0.t.d.f.c.a aVar) {
        return aVar == null || this.f60763c != aVar.f60702d;
    }

    public void d(boolean z) {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i2) {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void g() {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f60762b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
