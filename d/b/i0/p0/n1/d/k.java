package d.b.i0.p0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.t0;
import d.b.i.u0.a;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class k extends d.b.i0.p0.k<a2, ThreadCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d, d.b.i0.m.f, d.b.i0.x.a0 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public d.b.i0.p0.j2.b E;
    public int F;
    public int G;
    public d.b.i0.x.b0<a2> H;
    public NEGFeedBackView.b I;
    public d.b.b.e.k.b<ConstrainImageLayout> J;
    public d.b.b.e.k.b<TbImageView> K;
    public TbPageContext<?> w;
    public HashSet<String> x;
    public String y;
    public String z;

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
            if (k.this.u != null) {
                k.this.u.b(view, a2Var, k.this.G());
            }
            if ("c13010".equals(k.this.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof TbImageView) {
                    if (k.this.H.f62184a instanceof Boolean) {
                        if (((Boolean) k.this.H.f62184a).booleanValue()) {
                            d.b.i0.p0.j2.a.b(a2Var, 1, k.this.i, k.this.E, k.this.i0());
                        } else {
                            d.b.i0.p0.j2.a.b(a2Var, 3, k.this.i, k.this.E, k.this.i0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.i0.p0.j2.a.b(a2Var, 15, k.this.i, k.this.E, k.this.i0());
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 5, k.this.i, k.this.E, k.this.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 14, k.this.i, k.this.E, k.this.i0());
                } else if (view.getId() == R.id.img_agree) {
                    d.b.i0.p0.j2.a.b(a2Var, 12, k.this.i, k.this.E, k.this.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.b.i0.p0.j2.a.b(a2Var, 13, k.this.i, k.this.E, k.this.i0());
                } else {
                    d.b.i0.p0.j2.a.b(a2Var, 1, k.this.i, k.this.E, k.this.i0());
                }
            } else {
                d.b.i0.p0.j2.a.b(a2Var, 2, k.this.i, k.this.E, k.this.i0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.b.i0.p0.j2.c.j().g(k.this.E, a2Var, 2);
            } else if (view.getId() == R.id.card_divider_tv) {
                d.b.i0.p0.m2.l.a(k.this.E, a2Var.V0());
            } else if (view instanceof TbImageView) {
                if (k.this.H.f62184a instanceof Boolean) {
                    if (((Boolean) k.this.H.f62184a).booleanValue()) {
                        d.b.i0.p0.j2.c.j().g(k.this.E, a2Var, 1);
                    } else {
                        d.b.i0.p0.j2.c.j().g(k.this.E, a2Var, 3);
                    }
                }
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.thread_card_voice) {
                d.b.i0.p0.j2.c.j().g(k.this.E, a2Var, 5);
            } else if (!(view instanceof ThreadGodReplyLayout)) {
                d.b.i0.p0.j2.c.j().g(k.this.E, a2Var, 1);
            } else {
                int i = 6;
                if (a2Var.z1() != null && a2Var.z1().J() != null && a2Var.z1().J().u() != null && a2Var.z1().J().u().size() > 0) {
                    i = a2Var.z1().N ? 9 : 8;
                }
                d.b.i0.p0.j2.c.j().g(k.this.E, a2Var, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b(k kVar) {
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
    public class c implements d.b.b.e.k.c<ConstrainImageLayout> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            constrainImageLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            return new ConstrainImageLayout(k.this.w.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.b.e.k.c<TbImageView> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(k.this.w.getPageActivity());
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
            return tbImageView;
        }

        public TbImageView h(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
            return tbImageView;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b {
        public e(k kVar) {
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
    public class f implements d.b.b.j.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i.w f58013a;

        public f(d.b.i.w wVar) {
            this.f58013a = wVar;
        }

        @Override // d.b.b.j.c.b
        public void a(int i, int i2, int i3) {
            k.this.g0(i, i2, i3);
            if (k.this.J(1) && k.this.J(2)) {
                this.f58013a.w(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.b.b.j.e.w {
        public g() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = (a2) nVar;
                a2Var.objType = 1;
                if (k.this.H != null) {
                    k.this.H.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), 3, false);
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.A = false;
        this.B = true;
        this.C = false;
        this.E = new d.b.i0.p0.j2.b();
        this.H = new a();
        this.I = new b(this);
        this.J = new d.b.b.e.k.b<>(new c(), 6, 0);
        this.K = new d.b.b.e.k.b<>(new d(), 12, 0);
        this.w = tbPageContext;
        this.i = bdUniqueId2;
    }

    public final void I0(a2 a2Var) {
        if (this.x == null) {
            this.x = new HashSet<>();
        }
        d.b.i0.p0.j2.c.j().d(a2Var, this.x);
    }

    public int J0() {
        return this.G;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: K0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.w.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.w.getPageActivity());
        dVar.b(4280);
        dVar.t(this.i);
        dVar.s(new e(this));
        bVar.o(dVar);
        d.b.i.w wVar = new d.b.i.w(this.w.getPageActivity());
        wVar.t("frs");
        wVar.s(this.J);
        wVar.r(this.K);
        wVar.u(this.B);
        if (this.F == 502) {
            wVar.v(false);
        } else {
            wVar.v(true);
        }
        bVar.n(wVar);
        if (this.D) {
            bVar.h(new d.b.i.s(this.w.getPageActivity()));
        }
        t0 t0Var = new t0(this.w.getPageActivity());
        t0Var.x(this.w);
        t0Var.w(3);
        bVar.h(t0Var);
        bVar.h(new d.b.i.g0(this.w.getPageActivity()));
        bVar.h(new d.b.i.a0(this.w.getPageActivity()));
        d.b.i.l lVar = new d.b.i.l(this.w.getPageActivity());
        lVar.v(J0());
        bVar.h(lVar);
        bVar.h(new d.b.i.i0(this.w.getPageActivity()));
        d.b.i.n nVar = new d.b.i.n(this.w.getPageActivity());
        bVar.h(nVar);
        nVar.x(this.B);
        nVar.w("frs");
        if (!J(1) || !J(2)) {
            wVar.w(new f(wVar));
        }
        m0 m0Var = new m0(this.w.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50763b = this.A ? 10 : 2;
        eVar.f50769h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(1);
        m0Var.x(3);
        m0Var.b(48);
        if (this.C) {
            m0Var.c(4);
        }
        bVar.m(m0Var);
        bVar.l().d(d.b.b.e.p.l.g(this.f42358e, R.dimen.tbds28));
        d.b.i.k0 i = bVar.i();
        i.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(i);
        threadCardViewHolder.k(this.i);
        c0(new g());
        threadCardViewHolder.n();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: L0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i, view, viewGroup, a2Var, threadCardViewHolder);
        if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.y);
        d.b.i0.p0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            a2Var.h4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (a2Var.s2() && a2Var.b0() != null && !z) {
            threadCardViewHolder.p(true).u(this.I);
        }
        threadCardViewHolder.s();
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.H);
        if (this.E != null) {
            FrsViewData frsViewData2 = this.n;
            a2Var.M1 = (i + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.b.i0.p0.j2.c.j().c(this.E, a2Var);
        I0(a2Var);
        a2Var.x4();
        d.b.i0.p0.j2.a.i(a2Var, this.i, this.E, i0());
        a2Var.x4();
        return threadCardViewHolder.a();
    }

    public void M0(int i) {
        this.G = i;
    }

    public void N0(boolean z) {
        this.C = z;
    }

    public void O0(boolean z) {
        this.D = z;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.p0.j2.d
    public d.b.i0.p0.j2.b b() {
        return this.E;
    }

    @Override // d.b.i0.x.a0
    public void d(boolean z) {
        this.A = z;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.y = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.F = i;
    }

    public void setFrom(String str) {
        this.z = str;
    }

    @Override // d.b.i0.p0.k
    public void setFromCDN(boolean z) {
        this.B = z;
    }
}
