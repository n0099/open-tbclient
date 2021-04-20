package d.b.i0.q0.n1.d;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class y extends d.b.i0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.q0.j2.d, d.b.i0.m.f, d.b.i0.x.a0 {
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
            if (y.this.u != null) {
                y.this.u.b(view, a2Var, y.this.G());
            }
            if ("c13010".equals(y.this.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof TbImageView) {
                    if (y.this.z.f63759a instanceof Boolean) {
                        if (((Boolean) y.this.z.f63759a).booleanValue()) {
                            d.b.i0.q0.j2.a.b(a2Var, 1, y.this.i, d.b.i0.q0.j2.d.J0, y.this.i0());
                        } else {
                            d.b.i0.q0.j2.a.b(a2Var, 3, y.this.i, d.b.i0.q0.j2.d.J0, y.this.i0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.i0.q0.j2.a.b(a2Var, 15, y.this.i, d.b.i0.q0.j2.d.J0, y.this.i0());
                } else {
                    d.b.i0.q0.j2.a.b(a2Var, 1, y.this.i, d.b.i0.q0.j2.d.J0, y.this.i0());
                }
            } else {
                d.b.i0.q0.j2.a.b(a2Var, 2, y.this.i, d.b.i0.q0.j2.d.J0, y.this.i0());
            }
            if (view.getId() == R.id.thread_card_root && a2Var.z2()) {
                y.this.G0(a2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.b.i0.q0.n2.l.a(d.b.i0.q0.j2.d.J0, a2Var.V0());
                } else if (view instanceof TbImageView) {
                    if (y.this.z.f63759a instanceof Boolean) {
                        if (((Boolean) y.this.z.f63759a).booleanValue()) {
                            d.b.i0.q0.j2.c.j().g(d.b.i0.q0.j2.d.J0, a2Var, 1);
                        } else {
                            d.b.i0.q0.j2.c.j().g(d.b.i0.q0.j2.d.J0, a2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.b.i0.q0.j2.c.j().g(d.b.i0.q0.j2.d.J0, a2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (a2Var.z1() != null && a2Var.z1().K() != null && a2Var.z1().K().u() != null && a2Var.z1().K().u().size() > 0) {
                        i = a2Var.z1().N ? 9 : 8;
                    }
                    d.b.i0.q0.j2.c.j().g(d.b.i0.q0.j2.d.J0, a2Var, i);
                } else {
                    d.b.i0.q0.j2.c.j().g(d.b.i0.q0.j2.d.J0, a2Var, 1);
                }
            } else {
                d.b.i0.q0.j2.c.j().g(d.b.i0.q0.j2.d.J0, a2Var, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(y yVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
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
    public class c implements d.b.c.j.e.w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (y.this.z != null) {
                    y.this.z.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), y.this.y, false, d.b.i.e.a((d.b.c.j.e.s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = 3;
        this.z = new a();
        this.o = tbPageContext;
        this.i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: E0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), true);
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.b(4280);
        dVar.t(this.i);
        dVar.s(new b(this));
        bVar.o(dVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.i);
        threadCardViewHolder.o(false);
        c0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: F0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i);
        d.b.i0.q0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.i4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, null);
        if (!z1Var.w.S1() && !z1Var.w.D2()) {
            threadCardViewHolder.s();
        } else {
            threadCardViewHolder.h();
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.z);
        z1Var.w.y4();
        if (d.b.i0.q0.j2.d.J0 != null) {
            FrsViewData frsViewData2 = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.b.i0.q0.j2.c.j().c(d.b.i0.q0.j2.d.J0, z1Var.w);
        z1Var.w.y4();
        d.b.i0.q0.j2.a.i(z1Var.w, this.i, d.b.i0.q0.j2.d.J0, i0());
        if (z1Var != null) {
            z1Var.w.y4();
        }
        return threadCardViewHolder.a();
    }

    public final void G0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", l0() ? 2 : 1).param("obj_id", a2Var.q1() == null ? -1L : a2Var.q1().live_id).param("obj_type", 1));
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.q0.j2.d
    public d.b.i0.q0.j2.b b() {
        return d.b.i0.q0.j2.d.J0;
    }

    @Override // d.b.i0.x.a0
    public void d(boolean z) {
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.x = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.y = i;
    }

    @Override // d.b.i0.q0.k, d.b.i0.x.y
    public void setFrom(String str) {
        this.w = str;
    }
}
