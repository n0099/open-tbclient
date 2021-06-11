package d.a.n0.v.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65488a;

    /* renamed from: b  reason: collision with root package name */
    public a f65489b;

    /* renamed from: c  reason: collision with root package name */
    public int f65490c = -1;

    public e(TbPageContext tbPageContext) {
        this.f65488a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.a.n0.v.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f65490c = -1;
            this.f65489b = new b(this.f65488a);
        } else if (z) {
            int i2 = aVar.f65428d;
            this.f65490c = i2;
            if (i2 == 1) {
                this.f65489b = new d(this.f65488a);
            } else if (i2 == 2) {
                this.f65489b = new f(this.f65488a);
            } else if (i2 != 3) {
                this.f65489b = new b(this.f65488a);
            } else {
                this.f65489b = new c(this.f65488a);
            }
        }
        if (this.f65489b.f(aVar)) {
            if (z) {
                this.f65489b.d();
            }
            this.f65489b.b(aVar);
            return;
        }
        this.f65490c = -1;
        b bVar = new b(this.f65488a);
        this.f65489b = bVar;
        if (z) {
            bVar.d();
        }
        this.f65489b.b(aVar);
    }

    public boolean c(d.a.n0.v.d.f.c.a aVar) {
        return aVar == null || this.f65490c != aVar.f65428d;
    }

    public void d(boolean z) {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i2) {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void g() {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f65489b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
