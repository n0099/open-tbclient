package d.a.o0.v.d.f.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.n0.r.q.a2;
import d.a.n0.z0.m0;
import d.a.o0.v.d.b.d.b;
/* loaded from: classes4.dex */
public class d extends d.a.o0.v.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.v.d.b.d.b f65606f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65607g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.v.d.b.b.c f65608h;

    /* renamed from: i  reason: collision with root package name */
    public AlaInfoData f65609i;
    public CustomMessageListener j;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.f {
        public b() {
        }

        @Override // d.a.o0.v.d.b.d.b.f
        public void a(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.o0.v.d.d.a.c().f("c12909", d.this.f65599d.f65554e, 1, a2Var.o0(), d.this.f65609i);
        }

        @Override // d.a.o0.v.d.b.d.b.f
        public void b(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.o0.v.d.d.a.c().f("c12910", d.this.f65599d.f65554e, 1, a2Var.o0(), d.this.f65609i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.r();
        }
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f65607g = false;
        this.j = new a(2000994);
        this.k = new c();
    }

    @Override // d.a.o0.v.d.f.f.a
    public void b(d.a.o0.v.d.f.c.a aVar) {
        a2 a2Var;
        super.b(aVar);
        q();
        d.a.o0.v.d.b.d.b bVar = this.f65606f;
        if (bVar != null) {
            bVar.n(this.f65608h);
        }
        d.a.o0.v.d.b.b.c cVar = this.f65608h;
        if (cVar == null || (a2Var = cVar.f65277a) == null) {
            return;
        }
        this.f65609i = a2Var.s1();
        d.a.o0.v.d.d.a.c().f("c12908", this.f65599d.f65554e, 1, this.f65608h.f65277a.o0(), this.f65609i);
    }

    @Override // d.a.o0.v.d.f.f.a
    public View c() {
        return this.f65606f.j();
    }

    @Override // d.a.o0.v.d.f.f.a
    public void d() {
        this.f65606f = new d.a.o0.v.d.b.d.b(this.f65598c, true);
        MessageManager.getInstance().registerListener(this.j);
        this.f65606f.w(new b());
    }

    @Override // d.a.o0.v.d.f.f.a
    public boolean f(d.a.o0.v.d.f.c.a aVar) {
        return (aVar == null || 1 != aVar.f65553d || ListUtils.isEmpty(aVar.f65552c) || aVar.f65552c.get(0) == null || aVar.f65552c.get(0).s1() == null) ? false : true;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void g(boolean z) {
        this.f65607g = z;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void h() {
        super.h();
        d.a.o0.v.d.b.d.b bVar = this.f65606f;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // d.a.o0.v.d.f.f.a
    public void i(int i2) {
        this.f65606f.o();
    }

    @Override // d.a.o0.v.d.f.f.a
    public void j() {
        MessageManager.getInstance().unRegisterListener(this.j);
        d.a.c.e.m.e.a().removeCallbacks(this.k);
        d.a.o0.v.d.b.d.b bVar = this.f65606f;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // d.a.o0.v.d.f.f.a
    public void k() {
        n();
    }

    @Override // d.a.o0.v.d.f.f.a
    public void l() {
        m();
    }

    @Override // d.a.o0.v.d.f.f.a
    public void m() {
        if (this.f65607g) {
            return;
        }
        if (m0.a(1)) {
            d.a.c.e.m.e.a().removeCallbacks(this.k);
            d.a.c.e.m.e.a().postDelayed(this.k, 1000L);
            return;
        }
        d.a.o0.v.d.b.d.b bVar = this.f65606f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // d.a.o0.v.d.f.f.a
    public void n() {
        d.a.o0.v.d.b.d.b bVar = this.f65606f;
        if (bVar != null) {
            bVar.r();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.k);
    }

    public final void q() {
        d.a.o0.v.d.b.b.c cVar = new d.a.o0.v.d.b.b.c();
        this.f65608h = cVar;
        cVar.f65277a = this.f65599d.f65552c.get(0);
    }

    public final void r() {
        a2 a2Var;
        d.a.o0.v.d.b.d.b bVar;
        d.a.o0.v.d.b.b.c cVar = this.f65608h;
        if (cVar == null || (a2Var = cVar.f65277a) == null || a2Var.s1() == null || (bVar = this.f65606f) == null) {
            return;
        }
        bVar.x(this.f65608h.f65277a.s1().hls_url);
    }
}
