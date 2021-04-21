package d.b.j0.t.d.b.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.m.e;
import d.b.i0.r.q.a2;
import d.b.i0.z0.m0;
import d.b.j0.t.d.b.b.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f62262a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.t.d.b.d.b f62263b;

    /* renamed from: d  reason: collision with root package name */
    public c f62265d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62264c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62266e = new C1616a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f62267f = new b();

    /* renamed from: d.b.j0.t.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1616a extends CustomMessageListener {
        public C1616a(int i) {
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
        this.f62262a = null;
        this.f62262a = tbPageContext;
        this.f62263b = new d.b.j0.t.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f62266e);
    }

    public void b() {
        if (this.f62264c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f62267f);
            e.a().postDelayed(this.f62267f, 1000L);
            return;
        }
        d.b.j0.t.d.b.d.b bVar = this.f62263b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f62265d;
    }

    public View d() {
        return this.f62263b.j();
    }

    public void e(boolean z) {
        this.f62264c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f62247a == null) {
            return;
        }
        this.f62265d = cVar;
        d.b.j0.t.d.b.d.b bVar = this.f62263b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i = cVar.f62248b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f62247a.w1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f62263b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f62266e);
        e.a().removeCallbacks(this.f62267f);
        d.b.j0.t.d.b.d.b bVar = this.f62263b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.b.j0.t.d.b.d.b bVar;
        c cVar = this.f62265d;
        if (cVar == null || (a2Var = cVar.f62247a) == null || a2Var.q1() == null || (bVar = this.f62263b) == null) {
            return;
        }
        bVar.x(this.f62265d.f62247a.q1().hls_url);
    }

    public void j() {
        d.b.j0.t.d.b.d.b bVar = this.f62263b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f62267f);
    }
}
