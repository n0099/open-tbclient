package d.b.i0.t.d.b.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.m.e;
import d.b.h0.r.q.a2;
import d.b.h0.z0.m0;
import d.b.i0.t.d.b.b.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61841a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.t.d.b.d.b f61842b;

    /* renamed from: d  reason: collision with root package name */
    public c f61844d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61843c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f61845e = new C1593a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f61846f = new b();

    /* renamed from: d.b.i0.t.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1593a extends CustomMessageListener {
        public C1593a(int i) {
            super(i);
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
        this.f61841a = null;
        this.f61841a = tbPageContext;
        this.f61842b = new d.b.i0.t.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f61845e);
    }

    public void b() {
        if (this.f61843c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f61846f);
            e.a().postDelayed(this.f61846f, 1000L);
            return;
        }
        d.b.i0.t.d.b.d.b bVar = this.f61842b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f61844d;
    }

    public View d() {
        return this.f61842b.j();
    }

    public void e(boolean z) {
        this.f61843c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f61826a == null) {
            return;
        }
        this.f61844d = cVar;
        d.b.i0.t.d.b.d.b bVar = this.f61842b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i = cVar.f61827b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f61826a.w1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f61842b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f61845e);
        e.a().removeCallbacks(this.f61846f);
        d.b.i0.t.d.b.d.b bVar = this.f61842b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.b.i0.t.d.b.d.b bVar;
        c cVar = this.f61844d;
        if (cVar == null || (a2Var = cVar.f61826a) == null || a2Var.q1() == null || (bVar = this.f61842b) == null) {
            return;
        }
        bVar.x(this.f61844d.f61826a.q1().hls_url);
    }

    public void j() {
        d.b.i0.t.d.b.d.b bVar = this.f61842b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f61846f);
    }
}
