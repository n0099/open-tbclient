package d.a.n0.v.d.b.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.m.e;
import d.a.m0.r.q.a2;
import d.a.m0.z0.m0;
import d.a.n0.v.d.b.b.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61455a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.v.d.b.d.b f61456b;

    /* renamed from: d  reason: collision with root package name */
    public c f61458d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61457c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f61459e = new C1641a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f61460f = new b();

    /* renamed from: d.a.n0.v.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1641a extends CustomMessageListener {
        public C1641a(int i2) {
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
        this.f61455a = null;
        this.f61455a = tbPageContext;
        this.f61456b = new d.a.n0.v.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f61459e);
    }

    public void b() {
        if (this.f61457c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f61460f);
            e.a().postDelayed(this.f61460f, 1000L);
            return;
        }
        d.a.n0.v.d.b.d.b bVar = this.f61456b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f61458d;
    }

    public View d() {
        return this.f61456b.j();
    }

    public void e(boolean z) {
        this.f61457c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f61439a == null) {
            return;
        }
        this.f61458d = cVar;
        d.a.n0.v.d.b.d.b bVar = this.f61456b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i2 = cVar.f61440b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f61439a.y1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f61456b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f61459e);
        e.a().removeCallbacks(this.f61460f);
        d.a.n0.v.d.b.d.b bVar = this.f61456b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.a.n0.v.d.b.d.b bVar;
        c cVar = this.f61458d;
        if (cVar == null || (a2Var = cVar.f61439a) == null || a2Var.r1() == null || (bVar = this.f61456b) == null) {
            return;
        }
        bVar.x(this.f61458d.f61439a.r1().hls_url);
    }

    public void j() {
        d.a.n0.v.d.b.d.b bVar = this.f61456b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f61460f);
    }
}
