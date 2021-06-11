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
    public TbPageContext<?> f65168a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.v.d.b.d.b f65169b;

    /* renamed from: d  reason: collision with root package name */
    public c f65171d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65170c = false;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f65172e = new C1698a(2000994);

    /* renamed from: f  reason: collision with root package name */
    public Runnable f65173f = new b();

    /* renamed from: d.a.n0.v.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1698a extends CustomMessageListener {
        public C1698a(int i2) {
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
        this.f65168a = null;
        this.f65168a = tbPageContext;
        this.f65169b = new d.a.n0.v.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f65172e);
    }

    public void b() {
        if (this.f65170c) {
            return;
        }
        if (m0.a(1)) {
            e.a().removeCallbacks(this.f65173f);
            e.a().postDelayed(this.f65173f, 1000L);
            return;
        }
        d.a.n0.v.d.b.d.b bVar = this.f65169b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        return this.f65171d;
    }

    public View d() {
        return this.f65169b.j();
    }

    public void e(boolean z) {
        this.f65170c = z;
    }

    public void f(c cVar) {
        if (cVar == null || cVar.f65152a == null) {
            return;
        }
        this.f65171d = cVar;
        d.a.n0.v.d.b.d.b bVar = this.f65169b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i2 = cVar.f65153b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f65152a.z1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        this.f65169b.o();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.f65172e);
        e.a().removeCallbacks(this.f65173f);
        d.a.n0.v.d.b.d.b bVar = this.f65169b;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void i() {
        a2 a2Var;
        d.a.n0.v.d.b.d.b bVar;
        c cVar = this.f65171d;
        if (cVar == null || (a2Var = cVar.f65152a) == null || a2Var.s1() == null || (bVar = this.f65169b) == null) {
            return;
        }
        bVar.x(this.f65171d.f65152a.s1().hls_url);
    }

    public void j() {
        d.a.n0.v.d.b.d.b bVar = this.f65169b;
        if (bVar != null) {
            bVar.r();
        }
        e.a().removeCallbacks(this.f65173f);
    }
}
