package d.a.j0.t.d.b.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.m.e;
import d.a.i0.r.q.a2;
import d.a.i0.z0.m0;
import d.a.j0.t.d.b.b.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60443a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.t.d.b.d.b f60444b;

    /* renamed from: d  reason: collision with root package name */
    public c f60446d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60445c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f60447e = new C1556a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f60448f = new b();

    /* renamed from: d.a.j0.t.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1556a extends CustomMessageListener {
        public C1556a(int i2) {
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
        this.f60443a = null;
        this.f60443a = tbPageContext;
        this.f60444b = new d.a.j0.t.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f60447e);
    }

    public void b() {
        if (this.f60445c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f60448f);
            e.a().postDelayed(this.f60448f, 1000L);
            return;
        }
        d.a.j0.t.d.b.d.b bVar = this.f60444b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f60446d;
    }

    public View d() {
        return this.f60444b.j();
    }

    public void e(boolean z) {
        this.f60445c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f60427a == null) {
            return;
        }
        this.f60446d = cVar;
        d.a.j0.t.d.b.d.b bVar = this.f60444b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i2 = cVar.f60428b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f60427a.w1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f60444b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f60447e);
        e.a().removeCallbacks(this.f60448f);
        d.a.j0.t.d.b.d.b bVar = this.f60444b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.a.j0.t.d.b.d.b bVar;
        c cVar = this.f60446d;
        if (cVar == null || (a2Var = cVar.f60427a) == null || a2Var.q1() == null || (bVar = this.f60444b) == null) {
            return;
        }
        bVar.x(this.f60446d.f60427a.q1().hls_url);
    }

    public void j() {
        d.a.j0.t.d.b.d.b bVar = this.f60444b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f60448f);
    }
}
