package d.a.n0.r0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.u0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
/* loaded from: classes4.dex */
public class a0 extends d.a.n0.r0.k<z1, ThreadCardViewHolder<a2>> implements d.a.n0.z.z, d.a.n0.r0.j2.d, d.a.n0.o.f, d.a.n0.z.a0, d.a.c.k.e.w {
    public String w;
    public String x;
    public int y;
    public d.a.n0.z.b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends d.a.n0.z.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (a0.this.u != null) {
                a0.this.u.b(view, a2Var, a0.this.H());
            }
            if ("c13010".equals(a0.this.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.z1()));
            }
            d.a.n0.r0.j2.a.c(a2Var, 1, a0.this.f42913i, d.a.n0.r0.j2.d.L0, a0.this.g0());
            if (view.getId() == R.id.thread_card_root && a2Var.D2()) {
                a0.this.A0(a2Var);
            }
            if (view instanceof VoteView) {
                d.a.n0.z.m.a(a2Var.z1());
            } else {
                d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 1);
            }
        }
    }

    public a0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = 3;
        this.z = new a();
        this.o = tbPageContext;
        this.f42913i = bdUniqueId2;
    }

    public final void A0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", h0() ? 2 : 1).param("obj_id", a2Var.s1() == null ? -1L : a2Var.s1().live_id).param("obj_type", 1));
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
            d.a.n0.z.b0<a2> b0Var = this.z;
            if (b0Var != null) {
                b0Var.a(threadCardViewHolder.a(), a2Var);
            }
            ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var, view.getContext(), this.y, false);
            threadCardViewHolder.b().o(new a.C0600a(1));
        }
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.x = str;
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
        this.y = i2;
    }

    @Override // d.a.n0.r0.k, d.a.n0.z.y
    public void setFrom(String str) {
        this.w = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: y0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        u0 u0Var = new u0(this.o.getPageActivity());
        u0Var.x(this.o);
        u0Var.w(3);
        bVar.h(u0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.f42913i);
        threadCardViewHolder.o(false);
        a0(this);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: z0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.z);
        z1Var.w.C4();
        return threadCardViewHolder.a();
    }
}
