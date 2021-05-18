package d.a.k0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
/* loaded from: classes4.dex */
public class m extends d.a.k0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.a.k0.x.z, d.a.k0.q0.j2.d, d.a.k0.m.f, d.a.k0.x.a0 {
    public d.a.k0.x.b0<a2> A;
    public String w;
    public String x;
    public boolean y;
    public int z;

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
            if (m.this.u != null) {
                m.this.u.b(view, a2Var, m.this.G());
            }
            if ("c13010".equals(m.this.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.x1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 5, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 14, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.k0.q0.j2.a.c(a2Var, 12, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.k0.q0.j2.a.c(a2Var, 13, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                } else if (view instanceof TbImageView) {
                    if (m.this.A.f63165a instanceof Boolean) {
                        if (((Boolean) m.this.A.f63165a).booleanValue()) {
                            d.a.k0.q0.j2.a.c(a2Var, 1, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                        } else {
                            d.a.k0.q0.j2.a.c(a2Var, 3, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.k0.q0.j2.a.c(a2Var, 15, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                } else {
                    d.a.k0.q0.j2.a.c(a2Var, 1, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
                }
            } else {
                d.a.k0.q0.j2.a.c(a2Var, 2, m.this.f39568i, d.a.k0.q0.j2.d.J0, m.this.f0());
            }
            if (view.getId() == R.id.thread_card_root && a2Var.B2()) {
                m.this.J0(a2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.a.k0.q0.n2.l.a(d.a.k0.q0.j2.d.J0, a2Var.V0());
                } else if (view instanceof TbImageView) {
                    if (m.this.A.f63165a instanceof Boolean) {
                        if (((Boolean) m.this.A.f63165a).booleanValue()) {
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
    public class b implements d.a.c.j.e.w {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i.n f58909e;

        public b(d.a.i.n nVar) {
            this.f58909e = nVar;
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                if ((d.a.k0.q0.b.e().g() || d.a.k0.q0.a.h().j()) && !this.f58909e.u()) {
                    a2 a2Var = ((z1) nVar).w;
                    if (a2Var == null) {
                        return;
                    }
                    if (!a2Var.k2() && d.a.k0.q0.b.e().g()) {
                        if (d.a.k0.q0.b.e().a(a2Var)) {
                            a2Var.V3(true);
                        }
                    } else if (!a2Var.l2() && d.a.k0.q0.a.h().j()) {
                        if (d.a.k0.q0.a.h().a(a2Var)) {
                            a2Var.W3(true);
                        }
                    } else {
                        d.a.k0.q0.b.e().j(a2Var);
                        a2Var.V3(false);
                        d.a.k0.q0.a.h().l(a2Var);
                        a2Var.W3(false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, a2Var));
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var2 = ((z1) nVar).w;
                a2Var2.objType = 1;
                if (m.this.A != null) {
                    m.this.A.a(threadCardViewHolder.a(), a2Var2);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var2, view.getContext(), m.this.z, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = true;
        this.z = 3;
        this.A = new a();
        this.o = tbPageContext;
        this.f39568i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: H0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        d.a.i.n nVar = new d.a.i.n(this.o.getPageActivity());
        bVar.h(nVar);
        nVar.x(this.y);
        nVar.w("frs");
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.f39568i);
        Z(new b(nVar));
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: I0 */
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
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.A);
        z1Var.w.A4();
        return threadCardViewHolder.a();
    }

    public final void J0(a2 a2Var) {
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
        this.z = i2;
    }

    @Override // d.a.k0.q0.k, d.a.k0.x.y
    public void setFrom(String str) {
        this.w = str;
    }

    @Override // d.a.k0.q0.k
    public void setFromCDN(boolean z) {
        this.y = z;
    }
}
