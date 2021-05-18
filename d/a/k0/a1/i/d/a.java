package d.a.k0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.s;
import d.a.i.e0;
import d.a.i.l0;
import d.a.j0.r.q.n1;
import d.a.j0.r.q.o1;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<o1, ThreadCardViewHolder<o1>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public String p;
    public String q;
    public View.OnClickListener r;
    public PullLeftRefreshLayout.f s;
    public d.a.j0.m.f t;

    /* renamed from: d.a.k0.a1.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1192a implements View.OnClickListener {
        public View$OnClickListenerC1192a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g0();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            a.this.g0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.j0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                return;
            }
            d.a.k0.a1.i.b.c("c13756", n1Var, i2 + 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                a.this.g0();
                return;
            }
            String D = n1Var.D();
            if (d.a.c.e.p.k.isForumName(D)) {
                a.this.n.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.n.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                d.a.k0.a1.i.b.a("c13756", n1Var, i2 + 1);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new View$OnClickListenerC1192a();
        this.s = new b();
        this.t = new c();
        this.n = tbPageContext;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.p = str;
    }

    public final void g0() {
        this.n.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.n.getPageActivity(), this.q)));
        StatisticItem statisticItem = new StatisticItem("c13757");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        e0 e0Var = new e0(this.n, this.m);
        e0Var.s(this.s);
        e0Var.q(this.r);
        e0Var.r(this.t);
        bVar.n(e0Var);
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.j(this.m);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, o1 o1Var, ThreadCardViewHolder<o1> threadCardViewHolder) {
        if (o1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.k0.m.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        this.q = o1Var.j;
        threadCardViewHolder.f(o1Var);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void j0(String str) {
    }

    public void m0(s sVar) {
        this.o = sVar;
    }
}
