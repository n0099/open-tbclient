package d.a.o0.v.d.f.f;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65613a;

    /* renamed from: b  reason: collision with root package name */
    public a f65614b;

    /* renamed from: c  reason: collision with root package name */
    public int f65615c = -1;

    public e(TbPageContext tbPageContext) {
        this.f65613a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.a(viewGroup);
        }
    }

    public void b(d.a.o0.v.d.f.c.a aVar, boolean z) {
        if (aVar == null) {
            this.f65615c = -1;
            this.f65614b = new b(this.f65613a);
        } else if (z) {
            int i2 = aVar.f65553d;
            this.f65615c = i2;
            if (i2 == 1) {
                this.f65614b = new d(this.f65613a);
            } else if (i2 == 2) {
                this.f65614b = new f(this.f65613a);
            } else if (i2 != 3) {
                this.f65614b = new b(this.f65613a);
            } else {
                this.f65614b = new c(this.f65613a);
            }
        }
        if (this.f65614b.f(aVar)) {
            if (z) {
                this.f65614b.d();
            }
            this.f65614b.b(aVar);
            return;
        }
        this.f65615c = -1;
        b bVar = new b(this.f65613a);
        this.f65614b = bVar;
        if (z) {
            bVar.d();
        }
        this.f65614b.b(aVar);
    }

    public boolean c(d.a.o0.v.d.f.c.a aVar) {
        return aVar == null || this.f65615c != aVar.f65553d;
    }

    public void d(boolean z) {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void e() {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void f(int i2) {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void g() {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void h() {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i() {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void j() {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void k() {
        a aVar = this.f65614b;
        if (aVar != null) {
            aVar.n();
        }
    }
}
