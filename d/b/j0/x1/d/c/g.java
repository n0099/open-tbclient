package d.b.j0.x1.d.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.j0.x.b0;
import d.b.j0.x.t;
/* loaded from: classes3.dex */
public class g extends d.b.j0.x1.d.c.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public b0<a2> q;

    /* loaded from: classes3.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            g.this.o0(view, a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (g.this.q != null) {
                    g.this.q.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) a2Var, view.getContext(), 17, false);
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        bVar.h(new d.b.i.k(this.o.getPageActivity()));
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.p);
        k.r(17);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.n);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = E(i) + 1;
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        d.b.j0.x1.c.c(this, z1Var);
        return threadCardViewHolder.a();
    }

    public final void o0(View view, a2 a2Var) {
        d.b.j0.x1.c.b(this, a2Var);
    }

    public void p0(s sVar) {
        this.p = sVar;
    }
}
