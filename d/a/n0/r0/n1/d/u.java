package d.a.n0.r0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.h0;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
/* loaded from: classes4.dex */
public class u extends d.a.n0.r0.k<z1, ThreadCardViewHolder<a2>> implements d.a.n0.z.z, d.a.n0.r0.j2.d, d.a.n0.o.f, d.a.n0.z.a0, d.a.c.k.e.w {
    public String w;
    public int x;
    public int y;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.x = 3;
        this.o = tbPageContext;
        this.f42913i = bdUniqueId2;
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
    }

    @Override // d.a.c.k.e.w
    public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
        if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            a2 a2Var = ((z1) nVar).w;
            a2Var.objType = 1;
            if (a2Var == null) {
                return;
            }
            ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var, view.getContext(), this.x, false);
            threadCardViewHolder.b().o(new a.C0600a(1));
            d.a.n0.r0.j2.a.c(a2Var, 1, this.f42913i, d.a.n0.r0.j2.d.L0, g0());
        }
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.w = str;
    }

    @Override // d.a.n0.r0.j2.d
    public d.a.n0.r0.j2.b j() {
        return d.a.n0.r0.j2.d.L0;
    }

    @Override // d.a.n0.z.a0
    public void l(boolean z) {
    }

    @Override // d.a.n0.z.z
    public void r(int i2) {
        this.x = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        bVar.h(new h0(this.o.getPageActivity()));
        d.a.i.l lVar = new d.a.i.l(this.o.getPageActivity());
        lVar.t();
        lVar.v(this.y);
        bVar.h(lVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.f42913i);
        threadCardViewHolder.o(false);
        a0(this);
        return threadCardViewHolder;
    }

    @Override // d.a.n0.r0.k, d.a.n0.z.y
    public void setFrom(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: t0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.w);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        z1Var.w.C4();
        return threadCardViewHolder.a();
    }

    public void v0(int i2) {
        this.y = i2;
    }
}
