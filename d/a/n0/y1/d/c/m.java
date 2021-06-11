package d.a.n0.y1.d.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.s;
import d.a.i.e0;
import d.a.i.l0;
import d.a.m0.r.q.n1;
import d.a.m0.r.q.o1;
/* loaded from: classes4.dex */
public class m extends d.a.n0.y1.d.c.a<o1, ThreadCardViewHolder<o1>> implements d.a.n0.o.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public String q;
    public String r;
    public View.OnClickListener s;
    public PullLeftRefreshLayout.f t;
    public d.a.m0.m.f u;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m.this.o.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(m.this.o.getPageActivity(), m.this.r)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            m.this.o.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(m.this.o.getPageActivity(), m.this.r)));
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                m.this.o.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(m.this.o.getPageActivity(), m.this.r)));
                return;
            }
            String D = n1Var.D();
            if (d.a.c.e.p.k.isForumName(D)) {
                m.this.o.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.o.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                d.a.n0.y1.c.a("c13739", n1Var, i2 + 1);
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.t = new b();
        this.u = new c();
        this.o = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.q = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        e0 e0Var = new e0(this.o, this.n);
        e0Var.u(false);
        e0Var.p(false);
        e0Var.t(false);
        e0Var.s(this.t);
        e0Var.q(this.s);
        e0Var.r(this.u);
        bVar.n(e0Var);
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p));
        threadCardViewHolder.k(this.n);
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
            threadCardViewHolder.b().setPage(this.q);
        }
        threadCardViewHolder.f(o1Var);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void l0(s sVar) {
        this.p = sVar;
    }
}
