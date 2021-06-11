package d.a.n0.r0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
/* loaded from: classes4.dex */
public class v extends d.a.n0.r0.k<z1, ThreadCardViewHolder<a2>> implements d.a.n0.z.z, d.a.n0.r0.j2.d, d.a.n0.o.f {
    public d.a.n0.z.b0<a2> A;
    public String w;
    public String x;
    public boolean y;
    public int z;

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
            if (v.this.u != null) {
                v.this.u.b(view, a2Var, v.this.H());
            }
            if ("c13010".equals(v.this.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.z1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.n0.r0.j2.a.c(a2Var, 5, v.this.f42913i, d.a.n0.r0.j2.d.L0, v.this.g0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.n0.r0.j2.a.c(a2Var, 14, v.this.f42913i, d.a.n0.r0.j2.d.L0, v.this.g0());
                } else if (view instanceof TbImageView) {
                    if (v.this.A.f67163a instanceof Boolean) {
                        if (((Boolean) v.this.A.f67163a).booleanValue()) {
                            d.a.n0.r0.j2.a.c(a2Var, 1, v.this.f42913i, d.a.n0.r0.j2.d.L0, v.this.g0());
                        } else {
                            d.a.n0.r0.j2.a.c(a2Var, 3, v.this.f42913i, d.a.n0.r0.j2.d.L0, v.this.g0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.n0.r0.j2.a.c(a2Var, 15, v.this.f42913i, d.a.n0.r0.j2.d.L0, v.this.g0());
                } else {
                    d.a.n0.r0.j2.a.c(a2Var, 1, v.this.f42913i, d.a.n0.r0.j2.d.L0, v.this.g0());
                }
            } else {
                d.a.n0.r0.j2.a.c(a2Var, 2, v.this.f42913i, d.a.n0.r0.j2.d.L0, v.this.g0());
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.a.n0.r0.n2.l.a(d.a.n0.r0.j2.d.L0, a2Var.X0());
                    return;
                } else if (view instanceof TbImageView) {
                    if (v.this.A.f67163a instanceof Boolean) {
                        if (((Boolean) v.this.A.f67163a).booleanValue()) {
                            d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 1);
                            return;
                        } else {
                            d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 3);
                            return;
                        }
                    }
                    return;
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    return;
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 5);
                    return;
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (a2Var.C1() != null && a2Var.C1().K() != null && a2Var.C1().K().y() != null && a2Var.C1().K().y().size() > 0) {
                        i2 = a2Var.C1().N ? 9 : 8;
                    }
                    d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, i2);
                    return;
                } else {
                    d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 1);
                    return;
                }
            }
            d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.k.e.w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (v.this.A != null) {
                    v.this.A.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var, view.getContext(), 3, false);
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = true;
        this.A = new a();
        this.o = tbPageContext;
        this.f42913i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: E0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        d.a.i.y yVar = new d.a.i.y(this.o.getPageActivity());
        yVar.q("frs");
        yVar.r(this.y);
        if (this.z == 502) {
            yVar.s(false);
        } else {
            yVar.s(true);
        }
        bVar.n(yVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.f42913i);
        threadCardViewHolder.o(false);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: F0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i2);
        d.a.n0.r0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.m4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.A);
        z1Var.w.C4();
        d.a.i.y yVar = (d.a.i.y) threadCardViewHolder.b().f();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.j.f4483h.getLayoutParams();
        layoutParams.width = z1Var.x;
        layoutParams.height = z1Var.y;
        if (yVar.j.f4483h.getVisibility() != 8) {
            yVar.j.f4483h.setLayoutParams(layoutParams);
        }
        return threadCardViewHolder.a();
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.x = str;
    }

    @Override // d.a.n0.r0.j2.d
    public d.a.n0.r0.j2.b j() {
        return d.a.n0.r0.j2.d.L0;
    }

    @Override // d.a.n0.z.z
    public void r(int i2) {
        this.z = i2;
    }

    @Override // d.a.n0.r0.k, d.a.n0.z.y
    public void setFrom(String str) {
        this.w = str;
    }

    @Override // d.a.n0.r0.k
    public void setFromCDN(boolean z) {
        this.y = z;
    }
}
