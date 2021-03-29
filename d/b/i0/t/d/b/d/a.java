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
    public TbPageContext<?> f60277a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.t.d.b.d.b f60278b;

    /* renamed from: d  reason: collision with root package name */
    public c f60280d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60279c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f60281e = new C1540a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f60282f = new b();

    /* renamed from: d.b.i0.t.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1540a extends CustomMessageListener {
        public C1540a(int i) {
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
        this.f60277a = null;
        this.f60277a = tbPageContext;
        this.f60278b = new d.b.i0.t.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f60281e);
    }

    public void b() {
        if (this.f60279c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f60282f);
            e.a().postDelayed(this.f60282f, 1000L);
            return;
        }
        d.b.i0.t.d.b.d.b bVar = this.f60278b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f60280d;
    }

    public View d() {
        return this.f60278b.j();
    }

    public void e(boolean z) {
        this.f60279c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f60262a == null) {
            return;
        }
        this.f60280d = cVar;
        d.b.i0.t.d.b.d.b bVar = this.f60278b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i = cVar.f60263b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f60262a.w1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f60278b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f60281e);
        e.a().removeCallbacks(this.f60282f);
        d.b.i0.t.d.b.d.b bVar = this.f60278b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.b.i0.t.d.b.d.b bVar;
        c cVar = this.f60280d;
        if (cVar == null || (a2Var = cVar.f60262a) == null || a2Var.q1() == null || (bVar = this.f60278b) == null) {
            return;
        }
        bVar.x(this.f60280d.f60262a.q1().hls_url);
    }

    public void j() {
        d.b.i0.t.d.b.d.b bVar = this.f60278b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f60282f);
    }
}
