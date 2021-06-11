package d.a.n0.b1.j.g;

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
import d.a.c.k.e.s;
import d.a.i.e0;
import d.a.i.l0;
import d.a.m0.r.q.n1;
import d.a.m0.r.q.o1;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<o1, ThreadCardViewHolder<o1>> implements d.a.n0.o.f, d.a.n0.b1.j.d {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public String p;
    public String q;
    public String r;
    public View.OnClickListener s;
    public PullLeftRefreshLayout.f t;
    public d.a.m0.m.f u;

    /* renamed from: d.a.n0.b1.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1265a implements View.OnClickListener {
        public View$OnClickListenerC1265a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.i0();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            a.this.i0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.m0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                return;
            }
            d.a.n0.b1.j.c.b("c13756", n1Var, i2 + 1, a.this.q);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                a.this.i0();
                return;
            }
            String D = n1Var.D();
            if (d.a.c.e.p.k.isForumName(D)) {
                a.this.n.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.n.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                d.a.n0.b1.j.c.a("c13756", n1Var, i2 + 1, a.this.q);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new View$OnClickListenerC1265a();
        this.t = new b();
        this.u = new c();
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    @Override // d.a.n0.b1.j.d
    public void i(String str) {
        this.q = str;
    }

    public final void i0() {
        this.n.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.n.getPageActivity(), this.r)));
        StatisticItem statisticItem = new StatisticItem("c13757");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        e0 e0Var = new e0(this.n, this.m);
        e0Var.s(this.t);
        e0Var.q(this.s);
        e0Var.r(this.u);
        bVar.n(e0Var);
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.k(this.m);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, o1 o1Var, ThreadCardViewHolder<o1> threadCardViewHolder) {
        if (o1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.n0.o.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        this.r = o1Var.j;
        threadCardViewHolder.f(o1Var);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void l0(s sVar) {
        this.o = sVar;
    }
}
