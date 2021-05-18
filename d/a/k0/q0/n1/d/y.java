package d.a.k0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i.d;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
/* loaded from: classes4.dex */
public class y extends d.a.k0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.a.k0.x.z, d.a.k0.q0.j2.d, d.a.k0.m.f, d.a.k0.x.a0 {
    public String w;
    public String x;
    public int y;
    public d.a.k0.x.b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends d.a.k0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (y.this.u != null) {
                y.this.u.b(view, a2Var, y.this.G());
            }
            if ("c13010".equals(y.this.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.x1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof TbImageView) {
                    if (y.this.z.f63165a instanceof Boolean) {
                        if (((Boolean) y.this.z.f63165a).booleanValue()) {
                            d.a.k0.q0.j2.a.c(a2Var, 1, y.this.f39568i, d.a.k0.q0.j2.d.J0, y.this.f0());
                        } else {
                            d.a.k0.q0.j2.a.c(a2Var, 3, y.this.f39568i, d.a.k0.q0.j2.d.J0, y.this.f0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.k0.q0.j2.a.c(a2Var, 15, y.this.f39568i, d.a.k0.q0.j2.d.J0, y.this.f0());
                } else {
                    d.a.k0.q0.j2.a.c(a2Var, 1, y.this.f39568i, d.a.k0.q0.j2.d.J0, y.this.f0());
                }
            } else {
                d.a.k0.q0.j2.a.c(a2Var, 2, y.this.f39568i, d.a.k0.q0.j2.d.J0, y.this.f0());
            }
            if (view.getId() == R.id.thread_card_root && a2Var.B2()) {
                y.this.F0(a2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.a.k0.q0.n2.l.a(d.a.k0.q0.j2.d.J0, a2Var.V0());
                } else if (view instanceof TbImageView) {
                    if (y.this.z.f63165a instanceof Boolean) {
                        if (((Boolean) y.this.z.f63165a).booleanValue()) {
                            d.a.k0.q0.j2.c.j().g(d.a.k0.q0.j2.d.J0, a2Var, 1);
                        } else {
                            d.a.k0.q0.j2.c.j().g(d.a.k0.q0.j2.d.J0, a2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.a.k0.q0.j2.c.j().g(d.a.k0.q0.j2.d.J0, a2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (a2Var.A1() != null && a2Var.A1().K() != null && a2Var.A1().K().u() != null && a2Var.A1().K().u().size() > 0) {
                        i2 = a2Var.A1().N ? 9 : 8;
                    }
                    d.a.k0.q0.j2.c.j().g(d.a.k0.q0.j2.d.J0, a2Var, i2);
                } else {
                    d.a.k0.q0.j2.c.j().g(d.a.k0.q0.j2.d.J0, a2Var, 1);
                }
            } else {
                d.a.k0.q0.j2.c.j().g(d.a.k0.q0.j2.d.J0, a2Var, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(y yVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.j0.r.q.a aVar, View view) {
            if (aVar != null) {
                if (view.getId() == R.id.user_name) {
                    aVar.objType = 3;
                } else if (view.getId() == R.id.user_avatar) {
                    aVar.objType = 4;
                } else {
                    aVar.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.j.e.w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (y.this.z != null) {
                    y.this.z.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), y.this.y, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = 3;
        this.z = new a();
        this.o = tbPageContext;
        this.f39568i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: D0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), true);
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.b(4280);
        dVar.t(this.f39568i);
        dVar.s(new b(this));
        bVar.o(dVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.f39568i);
        threadCardViewHolder.n(false);
        Z(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: E0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.W(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i2);
        d.a.k0.q0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.k4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.l(z1Var.w.w(), null);
        threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, null);
        if (!z1Var.w.T1() && !z1Var.w.F2()) {
            threadCardViewHolder.r();
        } else {
            threadCardViewHolder.g();
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.z);
        z1Var.w.A4();
        if (d.a.k0.q0.j2.d.J0 != null) {
            FrsViewData frsViewData2 = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.a.k0.q0.j2.c.j().c(d.a.k0.q0.j2.d.J0, z1Var.w);
        z1Var.w.A4();
        d.a.k0.q0.j2.a.j(z1Var.w, this.f39568i, d.a.k0.q0.j2.d.J0, f0());
        if (z1Var != null) {
            z1Var.w.A4();
        }
        return threadCardViewHolder.a();
    }

    public final void F0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", g0() ? 2 : 1).param("obj_id", a2Var.q1() == null ? -1L : a2Var.q1().live_id).param("obj_type", 1));
    }

    @Override // d.a.k0.x.z
    public void a(String str) {
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.x = str;
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
        this.y = i2;
    }

    @Override // d.a.k0.q0.k, d.a.k0.x.y
    public void setFrom(String str) {
        this.w = str;
    }
}
