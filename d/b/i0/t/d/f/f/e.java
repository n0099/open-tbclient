package d.b.i0.t.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60595a;

    /* renamed from: b  reason: collision with root package name */
    public a f60596b;

    /* renamed from: c  reason: collision with root package name */
    public int f60597c = -1;

    public e(TbPageContext tbPageContext) {
        this.f60595a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.b.i0.t.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f60597c = -1;
            this.f60596b = new b(this.f60595a);
        } else if (z) {
            int i = aVar.f60529d;
            this.f60597c = i;
            if (i == 1) {
                this.f60596b = new d(this.f60595a);
            } else if (i == 2) {
                this.f60596b = new f(this.f60595a);
            } else if (i != 3) {
                this.f60596b = new b(this.f60595a);
            } else {
                this.f60596b = new c(this.f60595a);
            }
        }
        if (this.f60596b.f(aVar)) {
            if (z) {
                this.f60596b.d();
            }
            this.f60596b.b(aVar);
            return;
        }
        this.f60597c = -1;
        b bVar = new b(this.f60595a);
        this.f60596b = bVar;
        if (z) {
            bVar.d();
        }
        this.f60596b.b(aVar);
    }

    public boolean c(d.b.i0.t.d.f.c.a aVar) {
        return aVar == null || this.f60597c != aVar.f60529d;
    }

    public void d(boolean z) {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i) {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.i(i);
        }
    }

    public void g() {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f60596b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
