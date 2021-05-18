package d.a.k0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
/* loaded from: classes4.dex */
public class r extends d.a.k0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.a.k0.x.z, d.a.k0.q0.j2.d, d.a.k0.m.f, d.a.k0.x.a0, d.a.c.j.e.w {
    public String w;
    public int x;
    public int y;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.x = 3;
        this.o = tbPageContext;
        this.f39568i = bdUniqueId2;
    }

    @Override // d.a.k0.x.z
    public void a(String str) {
    }

    @Override // d.a.c.j.e.w
    public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
        if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
            a2 a2Var = ((z1) nVar).w;
            a2Var.objType = 1;
            ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), this.x, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0549a(1));
            d.a.k0.q0.j2.a.c(a2Var, 1, this.f39568i, d.a.k0.q0.j2.d.J0, f0());
        }
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.w = str;
    }

    @Override // d.a.k0.q0.j2.d
    public d.a.k0.q0.j2.b i() {
        return d.a.k0.q0.j2.d.J0;
    }

    @Override // d.a.k0.x.a0
    public void k(boolean z) {
    }

    @Override // d.a.k0.x.z
    public void q(int i2) {
        this.x = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        bVar.h(new d.a.i.a0(this.o.getPageActivity()));
        d.a.i.l lVar = new d.a.i.l(this.o.getPageActivity());
        lVar.t();
        lVar.v(this.y);
        bVar.h(lVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.f39568i);
        Z(this);
        threadCardViewHolder.n(false);
        return threadCardViewHolder;
    }

    @Override // d.a.k0.q0.k, d.a.k0.x.y
    public void setFrom(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: t0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.W(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.w);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        z1Var.w.A4();
        return threadCardViewHolder.a();
    }

    public void u0(int i2) {
        this.y = i2;
    }
}
