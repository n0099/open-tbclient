package d.b.j0.t.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62580a;

    /* renamed from: b  reason: collision with root package name */
    public a f62581b;

    /* renamed from: c  reason: collision with root package name */
    public int f62582c = -1;

    public e(TbPageContext tbPageContext) {
        this.f62580a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.b.j0.t.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f62582c = -1;
            this.f62581b = new b(this.f62580a);
        } else if (z) {
            int i = aVar.f62514d;
            this.f62582c = i;
            if (i == 1) {
                this.f62581b = new d(this.f62580a);
            } else if (i == 2) {
                this.f62581b = new f(this.f62580a);
            } else if (i != 3) {
                this.f62581b = new b(this.f62580a);
            } else {
                this.f62581b = new c(this.f62580a);
            }
        }
        if (this.f62581b.f(aVar)) {
            if (z) {
                this.f62581b.d();
            }
            this.f62581b.b(aVar);
            return;
        }
        this.f62582c = -1;
        b bVar = new b(this.f62580a);
        this.f62581b = bVar;
        if (z) {
            bVar.d();
        }
        this.f62581b.b(aVar);
    }

    public boolean c(d.b.j0.t.d.f.c.a aVar) {
        return aVar == null || this.f62582c != aVar.f62514d;
    }

    public void d(boolean z) {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i) {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.i(i);
        }
    }

    public void g() {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f62581b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
