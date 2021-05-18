package d.a.k0.t.d.f.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.r.q.a2;
import d.a.j0.z0.m0;
import d.a.k0.t.d.b.d.b;
/* loaded from: classes4.dex */
public class d extends d.a.k0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.t.d.b.d.b f61478f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61479g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.t.d.b.b.c f61480h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f61481i;
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

        @Override // d.a.k0.t.d.b.d.b.f
        public void a(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.k0.t.d.d.a.c().f("c12909", d.this.f61471d.f61427e, 1, a2Var.o0());
        }

        @Override // d.a.k0.t.d.b.d.b.f
        public void b(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.k0.t.d.d.a.c().f("c12910", d.this.f61471d.f61427e, 1, a2Var.o0());
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
        this.f61479g = false;
        this.f61481i = new a(2000994);
        this.j = new c();
    }

    @Override // d.a.k0.t.d.f.f.a
    public void b(d.a.k0.t.d.f.c.a aVar) {
        super.b(aVar);
        p();
        d.a.k0.t.d.b.d.b bVar = this.f61478f;
        if (bVar != null) {
            bVar.n(this.f61480h);
        }
        d.a.k0.t.d.b.b.c cVar = this.f61480h;
        if (cVar == null || cVar.f61151a == null) {
            return;
        }
        d.a.k0.t.d.d.a.c().f("c12908", this.f61471d.f61427e, 1, this.f61480h.f61151a.o0());
    }

    @Override // d.a.k0.t.d.f.f.a
    public View c() {
        return this.f61478f.j();
    }

    @Override // d.a.k0.t.d.f.f.a
    public void d() {
        this.f61478f = new d.a.k0.t.d.b.d.b(this.f61470c, true);
        MessageManager.getInstance().registerListener(this.f61481i);
        this.f61478f.w(new b());
    }

    @Override // d.a.k0.t.d.f.f.a
    public boolean f(d.a.k0.t.d.f.c.a aVar) {
        return (aVar == null || 1 != aVar.f61426d || ListUtils.isEmpty(aVar.f61425c) || aVar.f61425c.get(0) == null || aVar.f61425c.get(0).q1() == null) ? false : true;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void g(boolean z) {
        this.f61479g = z;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void h() {
        super.h();
        d.a.k0.t.d.b.d.b bVar = this.f61478f;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void i(int i2) {
        this.f61478f.o();
    }

    @Override // d.a.k0.t.d.f.f.a
    public void j() {
        MessageManager.getInstance().unRegisterListener(this.f61481i);
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        d.a.k0.t.d.b.d.b bVar = this.f61478f;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void k() {
        n();
    }

    @Override // d.a.k0.t.d.f.f.a
    public void l() {
        m();
    }

    @Override // d.a.k0.t.d.f.f.a
    public void m() {
        if (this.f61479g) {
            return;
        }
        if (m0.a(1)) {
            d.a.c.e.m.e.a().removeCallbacks(this.j);
            d.a.c.e.m.e.a().postDelayed(this.j, 1000L);
            return;
        }
        d.a.k0.t.d.b.d.b bVar = this.f61478f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void n() {
        d.a.k0.t.d.b.d.b bVar = this.f61478f;
        if (bVar != null) {
            bVar.r();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.j);
    }

    public final void p() {
        d.a.k0.t.d.b.b.c cVar = new d.a.k0.t.d.b.b.c();
        this.f61480h = cVar;
        cVar.f61151a = this.f61471d.f61425c.get(0);
    }

    public final void q() {
        a2 a2Var;
        d.a.k0.t.d.b.d.b bVar;
        d.a.k0.t.d.b.b.c cVar = this.f61480h;
        if (cVar == null || (a2Var = cVar.f61151a) == null || a2Var.q1() == null || (bVar = this.f61478f) == null) {
            return;
        }
        bVar.x(this.f61480h.f61151a.q1().hls_url);
    }
}
