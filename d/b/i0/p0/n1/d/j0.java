package d.b.i0.p0.n1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i.a;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.s0;
import d.b.i.u0.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class j0 extends d.b.i0.p0.k<a2, AutoVideoCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d, d.b.i0.m.f, d.b.i0.x.a0 {
    public boolean A;
    public int B;
    public boolean C;
    public d.b.i0.p0.j2.b D;
    public d.b.i0.x.b0<a2> E;
    public NEGFeedBackView.b F;
    public TbPageContext<?> w;
    public String x;
    public String y;
    public boolean z;

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
            if (j0.this.u != null) {
                j0.this.u.b(view, a2Var, a2.e3);
            }
            if ("c13010".equals(j0.this.y)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() == R.id.video_play) {
                d.b.i0.p0.j2.a.b(a2Var, 4, j0.this.i, j0.this.D, j0.this.i0());
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.operable_video_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 4, j0.this.i, j0.this.D, j0.this.i0());
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 5, j0.this.i, j0.this.D, j0.this.i0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.i0.p0.j2.a.b(a2Var, 15, j0.this.i, j0.this.D, j0.this.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 14, j0.this.i, j0.this.D, j0.this.i0());
                } else if (view.getId() == R.id.img_agree) {
                    d.b.i0.p0.j2.a.b(a2Var, 12, j0.this.i, j0.this.D, j0.this.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.b.i0.p0.j2.a.b(a2Var, 13, j0.this.i, j0.this.D, j0.this.i0());
                } else {
                    d.b.i0.p0.j2.a.b(a2Var, 1, j0.this.i, j0.this.D, j0.this.i0());
                }
            } else {
                d.b.i0.p0.j2.a.b(a2Var, 2, j0.this.i, j0.this.D, j0.this.i0());
            }
            if (view.getId() == R.id.thread_card_root) {
                d.b.i0.p0.j2.c.j().g(j0.this.D, a2Var, 1);
                j0.this.Q0(a2Var);
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.b.i0.p0.j2.c.j().g(j0.this.D, a2Var, 2);
            } else if (view.getId() == R.id.header_divider) {
                d.b.i0.p0.m2.l.a(j0.this.D, a2Var.V0());
            } else if (view.getId() == R.id.operable_video_container) {
                d.b.i0.p0.j2.c.j().g(j0.this.D, a2Var, 4);
                j0.this.Q0(a2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                j0.this.Q0(a2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b(j0 j0Var) {
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

    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC1115a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f58003a;

        public c(s0 s0Var) {
            this.f58003a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1115a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f58003a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, j0.this.f42357e, j0.this.B, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, j0.this.f42357e, j0.this.B, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.b.j.e.w {
        public d() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = (a2) nVar;
                a2Var.objType = 1;
                if (j0.this.E != null) {
                    j0.this.E.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), j0.this.B, false, d.b.i.e.a((d.b.b.j.e.s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f58006a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f58007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58008c;

        public e(j0 j0Var, ViewGroup viewGroup, View view, int i) {
            this.f58006a = viewGroup;
            this.f58007b = view;
            this.f58008c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.b.i.e.a((d.b.b.j.e.s) this.f58006a, this.f58007b, this.f58008c));
            }
        }
    }

    public j0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.z = false;
        this.A = false;
        this.B = 3;
        this.D = new d.b.i0.p0.j2.b();
        this.E = new a();
        this.F = new b(this);
        this.w = tbPageContext;
    }

    public final d.b.i0.i2.o L0(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        d.b.i0.i2.o oVar = new d.b.i0.i2.o();
        oVar.f56163a = a2Var.X1() ? "3" : "2";
        if (this.D.f57702d == 501) {
            oVar.f56163a = "frs_tab";
        }
        oVar.f56166d = this.D.f57701c;
        oVar.f56165c = a2Var.w1();
        oVar.f56168f = a2Var.R0;
        oVar.f56169g = a2Var.V0;
        oVar.f56170h = a2Var.S0;
        oVar.l = a2Var.T0;
        if (a2Var.u1() != null) {
            oVar.m = a2Var.u1().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: M0 */
    public AutoVideoCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.w.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.w.getPageActivity());
        dVar.b(4272);
        dVar.t(this.i);
        bVar.o(dVar);
        d.b.i.g gVar = new d.b.i.g(this.w.getPageActivity());
        gVar.u("frs");
        gVar.y("2003");
        if (this.B == 502) {
            gVar.w(false);
        } else {
            gVar.w(true);
        }
        gVar.v(new c(gVar));
        bVar.n(gVar);
        if (this.C) {
            bVar.h(new d.b.i.s(this.w.getPageActivity()));
        }
        bVar.h(new d.b.i.g0(this.w.getPageActivity()));
        bVar.h(new d.b.i.a0(this.w.getPageActivity()));
        bVar.h(new d.b.i.l(this.w.getPageActivity()));
        d.b.i.n nVar = new d.b.i.n(this.w.getPageActivity());
        nVar.x(this.z);
        nVar.w("frs");
        bVar.h(nVar);
        m0 m0Var = new m0(this.w.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50762b = 2;
        eVar.f50763c = 2;
        eVar.f50768h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(1);
        m0Var.x(this.B);
        m0Var.b(48);
        if (this.A) {
            m0Var.c(4);
        }
        bVar.m(m0Var);
        bVar.l().d(d.b.b.e.p.l.g(this.f42357e, R.dimen.tbds28));
        d.b.i.k0 i = bVar.i();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
        autoVideoCardViewHolder.k(this.i);
        i.p(this.E);
        i.r(this.B);
        c0(new d());
        autoVideoCardViewHolder.n();
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: N0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (a2Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder.b().e() instanceof m0) {
            ((m0) autoVideoCardViewHolder.b().e()).z(new e(this, viewGroup, view, i));
        }
        if (autoVideoCardViewHolder.b() instanceof d.b.i0.m.e) {
            autoVideoCardViewHolder.b().setPage(this.x);
        }
        super.X(i, view, viewGroup, a2Var, autoVideoCardViewHolder);
        d.b.i0.p0.j.g(autoVideoCardViewHolder.b().e(), this.n);
        autoVideoCardViewHolder.w(L0(a2Var));
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            a2Var.h4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (a2Var.s2() && a2Var.b0() != null && !z) {
            autoVideoCardViewHolder.p(true).u(this.F);
        }
        if (!a2Var.S1()) {
            autoVideoCardViewHolder.s();
        }
        autoVideoCardViewHolder.f(a2Var);
        autoVideoCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.E);
        if (this.D != null) {
            FrsViewData frsViewData2 = this.n;
            a2Var.M1 = (i + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.b.i0.p0.j2.c.j().c(this.D, a2Var);
        d.b.i0.p0.j2.c.j().b(a2Var);
        d.b.i0.p0.j2.c.j().e(a2Var, l0());
        d.b.i0.p0.j2.a.i(a2Var, this.i, this.D, i0());
        a2Var.x4();
        return autoVideoCardViewHolder.a();
    }

    public void O0(boolean z) {
        this.A = z;
    }

    public void P0(boolean z) {
        this.C = z;
    }

    public final void Q0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", l0() ? 2 : 1).param("obj_id", a2Var.q1() == null ? -1L : a2Var.q1().live_id).param("obj_type", 1));
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.p0.j2.d
    public d.b.i0.p0.j2.b b() {
        return this.D;
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
        this.B = i;
    }

    public void setFrom(String str) {
        this.y = str;
    }

    @Override // d.b.i0.p0.k
    public void setFromCDN(boolean z) {
        this.z = z;
    }
}
