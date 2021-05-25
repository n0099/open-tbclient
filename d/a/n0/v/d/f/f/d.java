package d.a.n0.v.d.f.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.r.q.a2;
import d.a.m0.z0.m0;
import d.a.n0.v.d.b.d.b;
/* loaded from: classes4.dex */
public class d extends d.a.n0.v.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v.d.b.d.b f61766f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61767g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.v.d.b.b.c f61768h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f61769i;
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

        @Override // d.a.n0.v.d.b.d.b.f
        public void a(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.n0.v.d.d.a.c().f("c12909", d.this.f61759d.f61715e, 1, a2Var.o0());
        }

        @Override // d.a.n0.v.d.b.d.b.f
        public void b(a2 a2Var) {
            if (a2Var == null) {
                return;
            }
            d.a.n0.v.d.d.a.c().f("c12910", d.this.f61759d.f61715e, 1, a2Var.o0());
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
        this.f61767g = false;
        this.f61769i = new a(2000994);
        this.j = new c();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void b(d.a.n0.v.d.f.c.a aVar) {
        super.b(aVar);
        p();
        d.a.n0.v.d.b.d.b bVar = this.f61766f;
        if (bVar != null) {
            bVar.n(this.f61768h);
        }
        d.a.n0.v.d.b.b.c cVar = this.f61768h;
        if (cVar == null || cVar.f61439a == null) {
            return;
        }
        d.a.n0.v.d.d.a.c().f("c12908", this.f61759d.f61715e, 1, this.f61768h.f61439a.o0());
    }

    @Override // d.a.n0.v.d.f.f.a
    public View c() {
        return this.f61766f.j();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void d() {
        this.f61766f = new d.a.n0.v.d.b.d.b(this.f61758c, true);
        MessageManager.getInstance().registerListener(this.f61769i);
        this.f61766f.w(new b());
    }

    @Override // d.a.n0.v.d.f.f.a
    public boolean f(d.a.n0.v.d.f.c.a aVar) {
        return (aVar == null || 1 != aVar.f61714d || ListUtils.isEmpty(aVar.f61713c) || aVar.f61713c.get(0) == null || aVar.f61713c.get(0).r1() == null) ? false : true;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void g(boolean z) {
        this.f61767g = z;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void h() {
        super.h();
        d.a.n0.v.d.b.d.b bVar = this.f61766f;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void i(int i2) {
        this.f61766f.o();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void j() {
        MessageManager.getInstance().unRegisterListener(this.f61769i);
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        d.a.n0.v.d.b.d.b bVar = this.f61766f;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void k() {
        n();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void l() {
        m();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void m() {
        if (this.f61767g) {
            return;
        }
        if (m0.a(1)) {
            d.a.c.e.m.e.a().removeCallbacks(this.j);
            d.a.c.e.m.e.a().postDelayed(this.j, 1000L);
            return;
        }
        d.a.n0.v.d.b.d.b bVar = this.f61766f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void n() {
        d.a.n0.v.d.b.d.b bVar = this.f61766f;
        if (bVar != null) {
            bVar.r();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.j);
    }

    public final void p() {
        d.a.n0.v.d.b.b.c cVar = new d.a.n0.v.d.b.b.c();
        this.f61768h = cVar;
        cVar.f61439a = this.f61759d.f61713c.get(0);
    }

    public final void q() {
        a2 a2Var;
        d.a.n0.v.d.b.d.b bVar;
        d.a.n0.v.d.b.b.c cVar = this.f61768h;
        if (cVar == null || (a2Var = cVar.f61439a) == null || a2Var.r1() == null || (bVar = this.f61766f) == null) {
            return;
        }
        bVar.x(this.f61768h.f61439a.r1().hls_url);
    }
}
