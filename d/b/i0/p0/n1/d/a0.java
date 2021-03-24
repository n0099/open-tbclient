package d.b.i0.p0.n1.d;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.k0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class a0 extends d.b.i0.p0.k<z1, ThreadCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d, d.b.i0.m.f, d.b.i0.x.a0, d.b.b.j.e.w {
    public String w;
    public String x;
    public int y;
    public d.b.i0.x.b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (a0.this.u != null) {
                a0.this.u.b(view, a2Var, a0.this.G());
            }
            if ("c13010".equals(a0.this.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            d.b.i0.p0.j2.a.b(a2Var, 1, a0.this.i, d.b.i0.p0.j2.d.J0, a0.this.i0());
            if (view.getId() == R.id.thread_card_root && a2Var.y2()) {
                a0.this.A0(a2Var);
            }
            if (!(view instanceof ThreadSmartAppLayout) && view.getId() != R.id.iv_thread_smart_app_head && view.getId() != R.id.tv_thread_smart_app_title && view.getId() != R.id.tv_thread_smart_app_abstract) {
                d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 1);
                return;
            }
            d.b.i0.x.m.a(a2Var.w1());
            if (a2Var.j1() != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", a2Var.c0()).param("obj_source", "frs_card").param("obj_id", a2Var.j1().swan_app_id.longValue()).param("obj_name", a2Var.j1().name).param("tid", a2Var.w1()).param("obj_param1", a2Var.j1().is_game.intValue()));
            }
        }
    }

    public a0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = 3;
        this.z = new a();
        this.o = tbPageContext;
        this.i = bdUniqueId2;
    }

    public final void A0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", l0() ? 2 : 1).param("obj_id", a2Var.q1() == null ? -1L : a2Var.q1().live_id).param("obj_type", 1));
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
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            a2 a2Var = ((z1) nVar).w;
            a2Var.objType = 1;
            d.b.i0.x.b0<a2> b0Var = this.z;
            if (b0Var != null) {
                b0Var.a(threadCardViewHolder.a(), a2Var);
            }
            ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), this.y, false);
            threadCardViewHolder.b().o(new a.C1117a(1));
        }
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.x = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.y = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: y0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        bVar.h(new d.b.i.i0(this.o.getPageActivity()));
        d.b.i.k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.i);
        c0(this);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: z0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.z);
        z1Var.w.x4();
        return threadCardViewHolder.a();
    }
}
