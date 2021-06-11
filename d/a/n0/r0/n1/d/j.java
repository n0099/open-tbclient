package d.a.n0.r0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import d.a.m0.r.q.z1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class j extends d.a.n0.r0.k<z1, ThreadCardViewHolder<a2>> implements d.a.n0.z.z, d.a.n0.r0.j2.d, d.a.n0.o.f, d.a.n0.z.a0 {
    public d.a.n0.z.b0<a2> A;
    public NEGFeedBackView.b B;
    public boolean w;
    public String x;
    public String y;
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
            if (j.this.u != null) {
                j.this.u.b(view, a2Var, j.this.H());
            }
            if ("c13010".equals(j.this.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.z1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.n0.r0.j2.a.c(a2Var, 5, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.n0.r0.j2.a.c(a2Var, 14, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.n0.r0.j2.a.c(a2Var, 12, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.n0.r0.j2.a.c(a2Var, 13, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                } else if (view instanceof TbImageView) {
                    if (j.this.A.f67163a instanceof Boolean) {
                        if (((Boolean) j.this.A.f67163a).booleanValue()) {
                            d.a.n0.r0.j2.a.c(a2Var, 1, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                        } else {
                            d.a.n0.r0.j2.a.c(a2Var, 3, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.n0.r0.j2.a.c(a2Var, 15, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                } else {
                    d.a.n0.r0.j2.a.c(a2Var, 1, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
                }
            } else {
                d.a.n0.r0.j2.a.c(a2Var, 2, j.this.f42913i, d.a.n0.r0.j2.d.L0, j.this.g0());
            }
            if (view.getId() == R.id.thread_card_root && a2Var.D2()) {
                j.this.K0(a2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.a.n0.r0.n2.l.a(d.a.n0.r0.j2.d.L0, a2Var.X0());
                } else if (view instanceof TbImageView) {
                    if (j.this.A.f67163a instanceof Boolean) {
                        if (((Boolean) j.this.A.f67163a).booleanValue()) {
                            d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 1);
                        } else {
                            d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (a2Var.C1() != null && a2Var.C1().K() != null && a2Var.C1().K().y() != null && a2Var.C1().K().y().size() > 0) {
                        i2 = a2Var.C1().N ? 9 : 8;
                    }
                    d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, i2);
                } else {
                    d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 1);
                }
            } else {
                d.a.n0.r0.j2.c.j().g(d.a.n0.r0.j2.d.L0, a2Var, 2);
            }
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
                if (j.this.A != null) {
                    j.this.A.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var, view.getContext(), j.this.z, false, d.a.i.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62734a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f62735b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f62736c;

        public c(j jVar, ViewGroup viewGroup, View view, int i2) {
            this.f62734a = viewGroup;
            this.f62735b = view;
            this.f62736c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((d.a.c.k.e.s) this.f62734a, this.f62735b, this.f62736c));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NEGFeedBackView.b {
        public d(j jVar) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            if (arrayList == null || v0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", v0Var.c()).param("tid", v0Var.e()).param("nid", v0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", v0Var.k).param("weight", v0Var.j).param("ab_tag", v0Var.o).param("extra", v0Var.l).param("card_type", v0Var.n).param(TiebaStatic.Params.OBJ_FLOOR, v0Var.p));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            TiebaStatic.log(new StatisticItem("c11973").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.w = false;
        this.z = 3;
        this.A = new a();
        this.B = new d(this);
        this.o = tbPageContext;
        this.f42913i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: I0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f53670b = this.w ? 10 : 2;
        eVar.f53676h = 2;
        n0Var.v(eVar);
        n0Var.w(2);
        n0Var.B("frs_page");
        n0Var.A(1);
        n0Var.x(3);
        n0Var.b(48);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.f42913i);
        threadCardViewHolder.o(true);
        threadCardViewHolder.i(4, bVar.l());
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: J0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder threadCardViewHolder) {
        super.X(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.y);
        threadCardViewHolder.b().q(i2);
        d.a.n0.r0.j.g(threadCardViewHolder.b().e(), this.n);
        if (z1Var.w.getType() == a2.C3) {
            threadCardViewHolder.b().e().b(128);
        } else {
            threadCardViewHolder.b().e().c(128);
        }
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.m4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.q(false, Align.ALIGN_RIGHT_BOTTOM, this.B);
        if (threadCardViewHolder.b().e() instanceof n0) {
            ((n0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i2));
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.A);
        z1Var.w.C4();
        return threadCardViewHolder.a();
    }

    public final void K0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", h0() ? 2 : 1).param("obj_id", a2Var.s1() == null ? -1L : a2Var.s1().live_id).param("obj_type", 1));
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.y = str;
    }

    @Override // d.a.n0.r0.j2.d
    public d.a.n0.r0.j2.b j() {
        return d.a.n0.r0.j2.d.L0;
    }

    @Override // d.a.n0.z.a0
    public void l(boolean z) {
        this.w = z;
    }

    @Override // d.a.n0.z.z
    public void r(int i2) {
        this.z = i2;
    }

    @Override // d.a.n0.r0.k, d.a.n0.z.y
    public void setFrom(String str) {
        this.x = str;
    }
}
