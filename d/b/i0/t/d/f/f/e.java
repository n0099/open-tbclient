package d.b.i0.t.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60594a;

    /* renamed from: b  reason: collision with root package name */
    public a f60595b;

    /* renamed from: c  reason: collision with root package name */
    public int f60596c = -1;

    public e(TbPageContext tbPageContext) {
        this.f60594a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.b.i0.t.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f60596c = -1;
            this.f60595b = new b(this.f60594a);
        } else if (z) {
            int i = aVar.f60528d;
            this.f60596c = i;
            if (i == 1) {
                this.f60595b = new d(this.f60594a);
            } else if (i == 2) {
                this.f60595b = new f(this.f60594a);
            } else if (i != 3) {
                this.f60595b = new b(this.f60594a);
            } else {
                this.f60595b = new c(this.f60594a);
            }
        }
        if (this.f60595b.f(aVar)) {
            if (z) {
                this.f60595b.d();
            }
            this.f60595b.b(aVar);
            return;
        }
        this.f60596c = -1;
        b bVar = new b(this.f60594a);
        this.f60595b = bVar;
        if (z) {
            bVar.d();
        }
        this.f60595b.b(aVar);
    }

    public boolean c(d.b.i0.t.d.f.c.a aVar) {
        return aVar == null || this.f60596c != aVar.f60528d;
    }

    public void d(boolean z) {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i) {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.i(i);
        }
    }

    public void g() {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f60595b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
