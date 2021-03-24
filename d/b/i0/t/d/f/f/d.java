package d.b.i0.t.d.f.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.r.q.a2;
import d.b.h0.z0.m0;
import d.b.i0.t.d.b.d.b;
/* loaded from: classes4.dex */
public class d extends d.b.i0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.b.d.b f60588f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60589g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.b.b.c f60590h;
    public CustomMessageListener i;
    public Runnable j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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

        @Override // d.b.i0.t.d.b.d.b.f
        public void a(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.b.i0.t.d.d.a.c().f("c12909", d.this.f60581d.f60529e, 1, a2Var.o0());
        }

        @Override // d.b.i0.t.d.b.d.b.f
        public void b(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.b.i0.t.d.d.a.c().f("c12910", d.this.f60581d.f60529e, 1, a2Var.o0());
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
        this.f60589g = false;
        this.i = new a(2000994);
        this.j = new c();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void b(d.b.i0.t.d.f.c.a aVar) {
        super.b(aVar);
        p();
        d.b.i0.t.d.b.d.b bVar = this.f60588f;
        if (bVar != null) {
            bVar.n(this.f60590h);
        }
        d.b.i0.t.d.b.b.c cVar = this.f60590h;
        if (cVar == null || cVar.f60261a == null) {
            return;
        }
        d.b.i0.t.d.d.a.c().f("c12908", this.f60581d.f60529e, 1, this.f60590h.f60261a.o0());
    }

    @Override // d.b.i0.t.d.f.f.a
    public View c() {
        return this.f60588f.j();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void d() {
        this.f60588f = new d.b.i0.t.d.b.d.b(this.f60580c, true);
        MessageManager.getInstance().registerListener(this.i);
        this.f60588f.w(new b());
    }

    @Override // d.b.i0.t.d.f.f.a
    public boolean f(d.b.i0.t.d.f.c.a aVar) {
        return (aVar == null || 1 != aVar.f60528d || ListUtils.isEmpty(aVar.f60527c) || aVar.f60527c.get(0) == null || aVar.f60527c.get(0).q1() == null) ? false : true;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void g(boolean z) {
        this.f60589g = z;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void h() {
        super.h();
        d.b.i0.t.d.b.d.b bVar = this.f60588f;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void i(int i) {
        this.f60588f.o();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void j() {
        MessageManager.getInstance().unRegisterListener(this.i);
        d.b.b.e.m.e.a().removeCallbacks(this.j);
        d.b.i0.t.d.b.d.b bVar = this.f60588f;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void k() {
        n();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void l() {
        m();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void m() {
        if (this.f60589g) {
            return;
        }
        if (m0.a(1)) {
            d.b.b.e.m.e.a().removeCallbacks(this.j);
            d.b.b.e.m.e.a().postDelayed(this.j, 1000L);
            return;
        }
        d.b.i0.t.d.b.d.b bVar = this.f60588f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void n() {
        d.b.i0.t.d.b.d.b bVar = this.f60588f;
        if (bVar != null) {
            bVar.r();
        }
        d.b.b.e.m.e.a().removeCallbacks(this.j);
    }

    public final void p() {
        d.b.i0.t.d.b.b.c cVar = new d.b.i0.t.d.b.b.c();
        this.f60590h = cVar;
        cVar.f60261a = this.f60581d.f60527c.get(0);
    }

    public final void q() {
        a2 a2Var;
        d.b.i0.t.d.b.d.b bVar;
        d.b.i0.t.d.b.b.c cVar = this.f60590h;
        if (cVar == null || (a2Var = cVar.f60261a) == null || a2Var.q1() == null || (bVar = this.f60588f) == null) {
            return;
        }
        bVar.x(this.f60590h.f60261a.q1().hls_url);
    }
}
