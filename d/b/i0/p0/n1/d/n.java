package d.b.i0.p0.n1.d;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.h0.r.q.z1;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class n extends d.b.i0.p0.k<z1, ThreadCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d, d.b.i0.m.f, d.b.i0.x.a0 {
    public d.b.i0.x.b0<a2> A;
    public NEGFeedBackView.b B;
    public boolean w;
    public String x;
    public String y;
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
            if (n.this.u != null) {
                n.this.u.b(view, a2Var, n.this.G());
            }
            if ("c13010".equals(n.this.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 5, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 14, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                } else if (view.getId() == R.id.img_agree) {
                    d.b.i0.p0.j2.a.b(a2Var, 12, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.b.i0.p0.j2.a.b(a2Var, 13, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                } else if (view instanceof TbImageView) {
                    if (n.this.A.f62184a instanceof Boolean) {
                        if (((Boolean) n.this.A.f62184a).booleanValue()) {
                            d.b.i0.p0.j2.a.b(a2Var, 1, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                        } else {
                            d.b.i0.p0.j2.a.b(a2Var, 3, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.i0.p0.j2.a.b(a2Var, 15, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                } else {
                    d.b.i0.p0.j2.a.b(a2Var, 1, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
                }
            } else {
                d.b.i0.p0.j2.a.b(a2Var, 2, n.this.i, d.b.i0.p0.j2.d.J0, n.this.i0());
            }
            if (view.getId() == R.id.thread_card_root && a2Var.y2()) {
                n.this.K0(a2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.b.i0.p0.m2.l.a(d.b.i0.p0.j2.d.J0, a2Var.V0());
                } else if (view instanceof TbImageView) {
                    if (n.this.A.f62184a instanceof Boolean) {
                        if (((Boolean) n.this.A.f62184a).booleanValue()) {
                            d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 1);
                        } else {
                            d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (a2Var.z1() != null && a2Var.z1().J() != null && a2Var.z1().J().u() != null && a2Var.z1().J().u().size() > 0) {
                        i = a2Var.z1().N ? 9 : 8;
                    }
                    d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, i);
                } else {
                    d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 1);
                }
            } else {
                d.b.i0.p0.j2.c.j().g(d.b.i0.p0.j2.d.J0, a2Var, 2);
            }
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
                if (n.this.A != null) {
                    n.this.A.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), n.this.z, false, d.b.i.e.a((d.b.b.j.e.s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f58028a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f58029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58030c;

        public c(n nVar, ViewGroup viewGroup, View view, int i) {
            this.f58028a = viewGroup;
            this.f58029b = view;
            this.f58030c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.b.i.e.a((d.b.b.j.e.s) this.f58028a, this.f58029b, this.f58030c));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NEGFeedBackView.b {
        public d(n nVar) {
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
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
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

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.w = false;
        this.z = 3;
        this.A = new a();
        this.B = new d(this);
        this.o = tbPageContext;
        this.i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: I0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50763b = this.w ? 10 : 2;
        eVar.f50769h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.B("frs_page");
        m0Var.A(1);
        m0Var.x(3);
        m0Var.b(48);
        bVar.m(m0Var);
        d.b.i.k0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.i);
        threadCardViewHolder.o(true);
        threadCardViewHolder.i(4, bVar.l());
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: J0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder threadCardViewHolder) {
        super.X(i, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.y);
        threadCardViewHolder.b().q(i);
        d.b.i0.p0.j.g(threadCardViewHolder.b().e(), this.n);
        if (z1Var.w.getType() == a2.x3) {
            threadCardViewHolder.b().e().b(128);
        } else {
            threadCardViewHolder.b().e().c(128);
        }
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.h4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.q(false, Align.ALIGN_RIGHT_BOTTOM, this.B);
        if (threadCardViewHolder.b().e() instanceof m0) {
            ((m0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i));
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.A);
        z1Var.w.x4();
        return threadCardViewHolder.a();
    }

    public final void K0(a2 a2Var) {
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
        this.w = z;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.y = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.z = i;
    }
}
