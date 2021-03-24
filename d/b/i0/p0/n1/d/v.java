package d.b.i0.p0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.k0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class v extends d.b.i0.p0.k<z1, ThreadCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d, d.b.i0.m.f, d.b.i0.x.a0, d.b.b.j.e.w {
    public String w;
    public int x;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.x = 3;
        this.o = tbPageContext;
        this.i = bdUniqueId2;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.p0.j2.d
    public d.b.i0.p0.j2.b b() {
        return d.b.i0.p0.j2.d.J0;
    }

    @Override // d.b.i0.x.a0
    public void d(boolean z) {
    }

    @Override // d.b.b.j.e.w
    public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
            a2 a2Var = ((z1) nVar).w;
            a2Var.objType = 1;
            ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), this.x, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1117a(1));
            d.b.i0.p0.j2.a.b(a2Var, 1, this.i, d.b.i0.p0.j2.d.J0, i0());
        }
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.w = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.x = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: t0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        bVar.h(new d.b.i.a0(this.o.getPageActivity()));
        d.b.i.l lVar = new d.b.i.l(this.o.getPageActivity());
        lVar.t();
        bVar.h(lVar);
        d.b.i.k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.i);
        c0(this);
        threadCardViewHolder.o(false);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
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
        z1Var.w.x4();
        return threadCardViewHolder.a();
    }
}
