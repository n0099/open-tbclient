package d.a.k0.t.d.b.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.m.e;
import d.a.j0.r.q.a2;
import d.a.j0.z0.m0;
import d.a.k0.t.d.b.b.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61167a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.t.d.b.d.b f61168b;

    /* renamed from: d  reason: collision with root package name */
    public c f61170d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61169c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f61171e = new C1621a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f61172f = new b();

    /* renamed from: d.a.k0.t.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1621a extends CustomMessageListener {
        public C1621a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.b();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i();
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f61167a = null;
        this.f61167a = tbPageContext;
        this.f61168b = new d.a.k0.t.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f61171e);
    }

    public void b() {
        if (this.f61169c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f61172f);
            e.a().postDelayed(this.f61172f, 1000L);
            return;
        }
        d.a.k0.t.d.b.d.b bVar = this.f61168b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f61170d;
    }

    public View d() {
        return this.f61168b.j();
    }

    public void e(boolean z) {
        this.f61169c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f61151a == null) {
            return;
        }
        this.f61170d = cVar;
        d.a.k0.t.d.b.d.b bVar = this.f61168b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i2 = cVar.f61152b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f61151a.x1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f61168b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f61171e);
        e.a().removeCallbacks(this.f61172f);
        d.a.k0.t.d.b.d.b bVar = this.f61168b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.a.k0.t.d.b.d.b bVar;
        c cVar = this.f61170d;
        if (cVar == null || (a2Var = cVar.f61151a) == null || a2Var.q1() == null || (bVar = this.f61168b) == null) {
            return;
        }
        bVar.x(this.f61170d.f61151a.q1().hls_url);
    }

    public void j() {
        d.a.k0.t.d.b.d.b bVar = this.f61168b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f61172f);
    }
}
