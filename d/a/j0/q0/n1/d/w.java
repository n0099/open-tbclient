package d.a.j0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.i0;
import d.a.i.k0;
import d.a.i.u0.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
/* loaded from: classes4.dex */
public class w extends d.a.j0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.a.j0.x.z, d.a.j0.q0.j2.d, d.a.j0.m.f, d.a.j0.x.a0, d.a.c.j.e.w {
    public String w;
    public String x;
    public int y;
    public d.a.j0.x.b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends d.a.j0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (w.this.u != null) {
                w.this.u.b(view, a2Var, w.this.G());
            }
            if ("c13010".equals(w.this.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            d.a.j0.q0.j2.a.c(a2Var, 1, w.this.f40323i, d.a.j0.q0.j2.d.J0, w.this.f0());
            if (view.getId() == R.id.thread_card_root && a2Var.z2()) {
                w.this.A0(a2Var);
            }
            if (!(view instanceof ThreadSmartAppLayout) && view.getId() != R.id.iv_thread_smart_app_head && view.getId() != R.id.tv_thread_smart_app_title && view.getId() != R.id.tv_thread_smart_app_abstract) {
                d.a.j0.q0.j2.c.j().g(d.a.j0.q0.j2.d.J0, a2Var, 1);
                return;
            }
            d.a.j0.x.m.a(a2Var.w1());
            if (a2Var.j1() != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", a2Var.c0()).param("obj_source", "frs_card").param("obj_id", a2Var.j1().swan_app_id.longValue()).param("obj_name", a2Var.j1().name).param("tid", a2Var.w1()).param("obj_param1", a2Var.j1().is_game.intValue()));
            }
        }
    }

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = 3;
        this.z = new a();
        this.o = tbPageContext;
        this.f40323i = bdUniqueId2;
    }

    public final void A0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", h0() ? 2 : 1).param("obj_id", a2Var.q1() == null ? -1L : a2Var.q1().live_id).param("obj_type", 1));
    }

    @Override // d.a.j0.x.z
    public void a(String str) {
    }

    @Override // d.a.c.j.e.w
    public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
        if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            a2 a2Var = ((z1) nVar).w;
            a2Var.objType = 1;
            d.a.j0.x.b0<a2> b0Var = this.z;
            if (b0Var != null) {
                b0Var.a(threadCardViewHolder.a(), a2Var);
            }
            ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) a2Var, view.getContext(), this.y, false);
            threadCardViewHolder.b().o(new a.C1011a(1));
        }
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.x = str;
    }

    @Override // d.a.j0.q0.j2.d
    public d.a.j0.q0.j2.b i() {
        return d.a.j0.q0.j2.d.J0;
    }

    @Override // d.a.j0.x.a0
    public void k(boolean z) {
    }

    @Override // d.a.j0.x.z
    public void q(int i2) {
        this.y = i2;
    }

    @Override // d.a.j0.q0.k, d.a.j0.x.y
    public void setFrom(String str) {
        this.w = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: y0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        bVar.h(new i0(this.o.getPageActivity()));
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.f40323i);
        Z(this);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: z0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.W(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.z);
        z1Var.w.y4();
        return threadCardViewHolder.a();
    }
}
