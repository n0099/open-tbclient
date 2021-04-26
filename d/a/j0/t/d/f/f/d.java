package d.a.j0.t.d.f.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.i0.r.q.a2;
import d.a.i0.z0.m0;
import d.a.j0.t.d.b.d.b;
/* loaded from: classes4.dex */
public class d extends d.a.j0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.t.d.b.d.b f60754f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60755g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.t.d.b.b.c f60756h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f60757i;
    public Runnable j;

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

        @Override // d.a.j0.t.d.b.d.b.f
        public void a(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.j0.t.d.d.a.c().f("c12909", d.this.f60747d.f60703e, 1, a2Var.o0());
        }

        @Override // d.a.j0.t.d.b.d.b.f
        public void b(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.j0.t.d.d.a.c().f("c12910", d.this.f60747d.f60703e, 1, a2Var.o0());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q();
        }
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f60755g = false;
        this.f60757i = new a(2000994);
        this.j = new c();
    }

    @Override // d.a.j0.t.d.f.f.a
    public void b(d.a.j0.t.d.f.c.a aVar) {
        super.b(aVar);
        p();
        d.a.j0.t.d.b.d.b bVar = this.f60754f;
        if (bVar != null) {
            bVar.n(this.f60756h);
        }
        d.a.j0.t.d.b.b.c cVar = this.f60756h;
        if (cVar == null || cVar.f60427a == null) {
            return;
        }
        d.a.j0.t.d.d.a.c().f("c12908", this.f60747d.f60703e, 1, this.f60756h.f60427a.o0());
    }

    @Override // d.a.j0.t.d.f.f.a
    public View c() {
        return this.f60754f.j();
    }

    @Override // d.a.j0.t.d.f.f.a
    public void d() {
        this.f60754f = new d.a.j0.t.d.b.d.b(this.f60746c, true);
        MessageManager.getInstance().registerListener(this.f60757i);
        this.f60754f.w(new b());
    }

    @Override // d.a.j0.t.d.f.f.a
    public boolean f(d.a.j0.t.d.f.c.a aVar) {
        return (aVar == null || 1 != aVar.f60702d || ListUtils.isEmpty(aVar.f60701c) || aVar.f60701c.get(0) == null || aVar.f60701c.get(0).q1() == null) ? false : true;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void g(boolean z) {
        this.f60755g = z;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void h() {
        super.h();
        d.a.j0.t.d.b.d.b bVar = this.f60754f;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void i(int i2) {
        this.f60754f.o();
    }

    @Override // d.a.j0.t.d.f.f.a
    public void j() {
        MessageManager.getInstance().unRegisterListener(this.f60757i);
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        d.a.j0.t.d.b.d.b bVar = this.f60754f;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void k() {
        n();
    }

    @Override // d.a.j0.t.d.f.f.a
    public void l() {
        m();
    }

    @Override // d.a.j0.t.d.f.f.a
    public void m() {
        if (this.f60755g) {
            return;
        }
        if (m0.a(1)) {
            d.a.c.e.m.e.a().removeCallbacks(this.j);
            d.a.c.e.m.e.a().postDelayed(this.j, 1000L);
            return;
        }
        d.a.j0.t.d.b.d.b bVar = this.f60754f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void n() {
        d.a.j0.t.d.b.d.b bVar = this.f60754f;
        if (bVar != null) {
            bVar.r();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.j);
    }

    public final void p() {
        d.a.j0.t.d.b.b.c cVar = new d.a.j0.t.d.b.b.c();
        this.f60756h = cVar;
        cVar.f60427a = this.f60747d.f60701c.get(0);
    }

    public final void q() {
        a2 a2Var;
        d.a.j0.t.d.b.d.b bVar;
        d.a.j0.t.d.b.b.c cVar = this.f60756h;
        if (cVar == null || (a2Var = cVar.f60427a) == null || a2Var.q1() == null || (bVar = this.f60754f) == null) {
            return;
        }
        bVar.x(this.f60756h.f60427a.q1().hls_url);
    }
}
