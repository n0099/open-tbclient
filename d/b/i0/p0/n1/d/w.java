package d.b.i0.p0.n1.d;

import android.view.View;
import android.view.ViewGroup;
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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.k0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class w extends d.b.i0.p0.k<z1, ThreadCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d, d.b.i0.m.f {
    public d.b.i0.x.b0<a2> A;
    public String w;
    public String x;
    public boolean y;
    public int z;

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
            if (w.this.u != null) {
                w.this.u.b(view, a2Var, w.this.G());
            }
            if ("c13010".equals(w.this.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 5, w.this.i, d.b.i0.p0.j2.d.J0, w.this.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 14, w.this.i, d.b.i0.p0.j2.d.J0, w.this.i0());
                } else if (view instanceof TbImageView) {
                    if (w.this.A.f62184a instanceof Boolean) {
                        if (((Boolean) w.this.A.f62184a).booleanValue()) {
                            d.b.i0.p0.j2.a.b(a2Var, 1, w.this.i, d.b.i0.p0.j2.d.J0, w.this.i0());
                        } else {
                            d.b.i0.p0.j2.a.b(a2Var, 3, w.this.i, d.b.i0.p0.j2.d.J0, w.this.i0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.i0.p0.j2.a.b(a2Var, 15, w.this.i, d.b.i0.p0.j2.d.J0, w.this.i0());
                } else {
                    d.b.i0.p0.j2.a.b(a2Var, 1, w.this.i, d.b.i0.p0.j2.d.J0, w.this.i0());
                }
            } else {
                d.b.i0.p0.j2.a.b(a2Var, 2, w.this.i, d.b.i0.p0.j2.d.J0, w.this.i0());
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.b.i0.p0.m2.l.a(d.b.i0.p0.j2.d.J0, a2Var.V0());
                    return;
                } else if (view instanceof TbImageView) {
                    if (w.this.A.f62184a instanceof Boolean) {
                        if (((Boolean) w.this.A.f62184a).booleanValue()) {
                            d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 1);
                            return;
                        } else {
                            d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 3);
                            return;
                        }
                    }
                    return;
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    return;
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 5);
                    return;
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (a2Var.z1() != null && a2Var.z1().J() != null && a2Var.z1().J().u() != null && a2Var.z1().J().u().size() > 0) {
                        i = a2Var.z1().N ? 9 : 8;
                    }
                    d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, i);
                    return;
                } else {
                    d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 1);
                    return;
                }
            }
            d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.b.j.e.w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (w.this.A != null) {
                    w.this.A.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), 3, false);
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = true;
        this.A = new a();
        this.o = tbPageContext;
        this.i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: E0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        d.b.i.v vVar = new d.b.i.v(this.o.getPageActivity());
        vVar.r("frs");
        vVar.s(this.y);
        if (this.z == 502) {
            vVar.t(false);
        } else {
            vVar.t(true);
        }
        bVar.n(vVar);
        d.b.i.k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.i);
        threadCardViewHolder.o(false);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: F0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.w);
        threadCardViewHolder.b().q(i);
        d.b.i0.p0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.h4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.A);
        z1Var.w.x4();
        return threadCardViewHolder.a();
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.p0.j2.d
    public d.b.i0.p0.j2.b b() {
        return d.b.i0.p0.j2.d.J0;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.w = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.z = i;
    }

    @Override // d.b.i0.p0.k
    public void setFromCDN(boolean z) {
        this.y = z;
    }
}
