package d.b.i0.t.d.b.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.b.e.m.e;
import d.b.h0.r.q.a2;
import d.b.h0.z0.m0;
import d.b.i0.t.d.b.b.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60276a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.t.d.b.d.b f60277b;

    /* renamed from: d  reason: collision with root package name */
    public c f60279d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60278c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f60280e = new C1539a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f60281f = new b();

    /* renamed from: d.b.i0.t.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1539a extends CustomMessageListener {
        public C1539a(int i) {
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
        this.f60276a = null;
        this.f60276a = tbPageContext;
        this.f60277b = new d.b.i0.t.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f60280e);
    }

    public void b() {
        if (this.f60278c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f60281f);
            e.a().postDelayed(this.f60281f, 1000L);
            return;
        }
        d.b.i0.t.d.b.d.b bVar = this.f60277b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f60279d;
    }

    public View d() {
        return this.f60277b.j();
    }

    public void e(boolean z) {
        this.f60278c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f60261a == null) {
            return;
        }
        this.f60279d = cVar;
        d.b.i0.t.d.b.d.b bVar = this.f60277b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i = cVar.f60262b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f60261a.w1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f60277b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f60280e);
        e.a().removeCallbacks(this.f60281f);
        d.b.i0.t.d.b.d.b bVar = this.f60277b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.b.i0.t.d.b.d.b bVar;
        c cVar = this.f60279d;
        if (cVar == null || (a2Var = cVar.f60261a) == null || a2Var.q1() == null || (bVar = this.f60277b) == null) {
            return;
        }
        bVar.x(this.f60279d.f60261a.q1().hls_url);
    }

    public void j() {
        d.b.i0.t.d.b.d.b bVar = this.f60277b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f60281f);
    }
}
