package d.b.i0.w1.d.c;

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
import d.b.b.j.e.s;
import d.b.h0.r.q.n1;
import d.b.h0.r.q.o1;
import d.b.i.e0;
import d.b.i.k0;
/* loaded from: classes4.dex */
public class m extends d.b.i0.w1.d.c.a<o1, ThreadCardViewHolder<o1>> implements d.b.i0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public String q;
    public String r;
    public View.OnClickListener s;
    public PullLeftRefreshLayout.f t;
    public d.b.h0.m.f u;

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
    public class c implements d.b.h0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i, long j) {
            if (n1Var == null) {
                m.this.o.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(m.this.o.getPageActivity(), m.this.r)));
                return;
            }
            String D = n1Var.D();
            if (d.b.b.e.p.k.isForumName(D)) {
                m.this.o.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.o.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                d.b.i0.w1.c.a("c13739", n1Var, i + 1);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
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
    @Override // d.b.b.j.e.a
    /* renamed from: n0 */
    public View X(int i, View view, ViewGroup viewGroup, o1 o1Var, ThreadCardViewHolder<o1> threadCardViewHolder) {
        if (o1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().q(i);
        if (threadCardViewHolder.b() instanceof d.b.i0.m.e) {
            threadCardViewHolder.b().setPage(this.q);
        }
        threadCardViewHolder.f(o1Var);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.q = str;
    }

    public void o0(s sVar) {
        this.p = sVar;
    }
}
