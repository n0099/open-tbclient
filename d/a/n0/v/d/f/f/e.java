package d.a.n0.v.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61773a;

    /* renamed from: b  reason: collision with root package name */
    public a f61774b;

    /* renamed from: c  reason: collision with root package name */
    public int f61775c = -1;

    public e(TbPageContext tbPageContext) {
        this.f61773a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.a.n0.v.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f61775c = -1;
            this.f61774b = new b(this.f61773a);
        } else if (z) {
            int i2 = aVar.f61714d;
            this.f61775c = i2;
            if (i2 == 1) {
                this.f61774b = new d(this.f61773a);
            } else if (i2 == 2) {
                this.f61774b = new f(this.f61773a);
            } else if (i2 != 3) {
                this.f61774b = new b(this.f61773a);
            } else {
                this.f61774b = new c(this.f61773a);
            }
        }
        if (this.f61774b.f(aVar)) {
            if (z) {
                this.f61774b.d();
            }
            this.f61774b.b(aVar);
            return;
        }
        this.f61775c = -1;
        b bVar = new b(this.f61773a);
        this.f61774b = bVar;
        if (z) {
            bVar.d();
        }
        this.f61774b.b(aVar);
    }

    public boolean c(d.a.n0.v.d.f.c.a aVar) {
        return aVar == null || this.f61775c != aVar.f61714d;
    }

    public void d(boolean z) {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i2) {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void g() {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f61774b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
