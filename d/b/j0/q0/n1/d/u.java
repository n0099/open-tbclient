package d.b.j0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.g0;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
/* loaded from: classes4.dex */
public class u extends d.b.j0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.b.j0.x.z, d.b.j0.q0.j2.d, d.b.j0.m.f, d.b.j0.x.a0, d.b.c.j.e.w {
    public String w;
    public int x;
    public int y;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.x = 3;
        this.o = tbPageContext;
        this.i = bdUniqueId2;
    }

    @Override // d.b.j0.x.z
    public void a(String str) {
    }

    @Override // d.b.j0.q0.j2.d
    public d.b.j0.q0.j2.b b() {
        return d.b.j0.q0.j2.d.J0;
    }

    @Override // d.b.j0.x.a0
    public void d(boolean z) {
    }

    @Override // d.b.c.j.e.w
    public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            a2 a2Var = ((z1) nVar).w;
            a2Var.objType = 1;
            if (a2Var == null) {
                return;
            }
            ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) a2Var, view.getContext(), this.x, false);
            threadCardViewHolder.b().o(new a.C1072a(1));
            d.b.j0.q0.j2.a.b(a2Var, 1, this.i, d.b.j0.q0.j2.d.J0, i0());
        }
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.w = str;
    }

    @Override // d.b.j0.x.z
    public void p(int i) {
        this.x = i;
    }

    @Override // d.b.j0.q0.k, d.b.j0.x.y
    public void setFrom(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        bVar.h(new g0(this.o.getPageActivity()));
        d.b.i.l lVar = new d.b.i.l(this.o.getPageActivity());
        lVar.t();
        lVar.v(this.y);
        bVar.h(lVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.i);
        threadCardViewHolder.o(false);
        c0(this);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    /* renamed from: u0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.w);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        z1Var.w.y4();
        return threadCardViewHolder.a();
    }

    public void v0(int i) {
        this.y = i;
    }
}
