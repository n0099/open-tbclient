package d.b.i0.t.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62159a;

    /* renamed from: b  reason: collision with root package name */
    public a f62160b;

    /* renamed from: c  reason: collision with root package name */
    public int f62161c = -1;

    public e(TbPageContext tbPageContext) {
        this.f62159a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.b.i0.t.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f62161c = -1;
            this.f62160b = new b(this.f62159a);
        } else if (z) {
            int i = aVar.f62093d;
            this.f62161c = i;
            if (i == 1) {
                this.f62160b = new d(this.f62159a);
            } else if (i == 2) {
                this.f62160b = new f(this.f62159a);
            } else if (i != 3) {
                this.f62160b = new b(this.f62159a);
            } else {
                this.f62160b = new c(this.f62159a);
            }
        }
        if (this.f62160b.f(aVar)) {
            if (z) {
                this.f62160b.d();
            }
            this.f62160b.b(aVar);
            return;
        }
        this.f62161c = -1;
        b bVar = new b(this.f62159a);
        this.f62160b = bVar;
        if (z) {
            bVar.d();
        }
        this.f62160b.b(aVar);
    }

    public boolean c(d.b.i0.t.d.f.c.a aVar) {
        return aVar == null || this.f62161c != aVar.f62093d;
    }

    public void d(boolean z) {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i) {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.i(i);
        }
    }

    public void g() {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f62160b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
