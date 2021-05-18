package d.a.k0.q0.n1.d;

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
import d.a.i.d;
import d.a.i.j0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.u0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.j0.r.q.z1;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class t extends d.a.k0.q0.k<z1, ThreadCardViewHolder<z1>> implements d.a.k0.x.z, d.a.k0.q0.j2.d, d.a.k0.m.f, d.a.k0.x.a0 {
    public boolean A;
    public boolean B;
    public d.a.k0.q0.j2.b C;
    public int D;
    public d.a.k0.x.b0<z1> E;
    public NEGFeedBackView.b F;
    public d.a.c.e.k.b<ConstrainImageLayout> G;
    public d.a.c.e.k.b<TbImageView> H;
    public TbPageContext<?> w;
    public HashSet<String> x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends d.a.k0.x.b0<z1> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, z1 z1Var) {
            if (view == null || z1Var == null) {
                return;
            }
            if (t.this.u != null) {
                t.this.u.b(view, z1Var, t.this.G());
            }
            if ("c13010".equals(t.this.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", z1Var.w.c0()).param("tid", z1Var.w.x1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.k0.q0.j2.a.c(z1Var.w, 5, t.this.f39568i, t.this.C, t.this.f0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.k0.q0.j2.a.c(z1Var.w, 14, t.this.f39568i, t.this.C, t.this.f0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.k0.q0.j2.a.c(z1Var.w, 12, t.this.f39568i, t.this.C, t.this.f0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.k0.q0.j2.a.c(z1Var.w, 13, t.this.f39568i, t.this.C, t.this.f0());
                } else if (view instanceof TbImageView) {
                    if (t.this.E.f63165a instanceof Boolean) {
                        if (((Boolean) t.this.E.f63165a).booleanValue()) {
                            d.a.k0.q0.j2.a.c(z1Var.w, 1, t.this.f39568i, t.this.C, t.this.f0());
                        } else {
                            d.a.k0.q0.j2.a.c(z1Var.w, 3, t.this.f39568i, t.this.C, t.this.f0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.k0.q0.j2.a.c(z1Var.w, 15, t.this.f39568i, t.this.C, t.this.f0());
                } else {
                    d.a.k0.q0.j2.a.c(z1Var.w, 1, t.this.f39568i, t.this.C, t.this.f0());
                }
            } else {
                d.a.k0.q0.j2.a.c(z1Var.w, 2, t.this.f39568i, t.this.C, t.this.f0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.k0.q0.j2.c.j().g(t.this.C, z1Var.w, 2);
            } else if (view.getId() == R.id.card_divider_tv) {
                d.a.k0.q0.n2.l.a(t.this.C, z1Var.z());
            } else if (view instanceof TbImageView) {
                if (t.this.E.f63165a instanceof Boolean) {
                    if (((Boolean) t.this.E.f63165a).booleanValue()) {
                        d.a.k0.q0.j2.c.j().g(t.this.C, z1Var.w, 1);
                    } else {
                        d.a.k0.q0.j2.c.j().g(t.this.C, z1Var.w, 3);
                    }
                }
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.thread_card_voice) {
                d.a.k0.q0.j2.c.j().g(t.this.C, z1Var.w, 5);
            } else if (!(view instanceof ThreadGodReplyLayout)) {
                d.a.k0.q0.j2.c.j().g(t.this.C, z1Var.w, 1);
            } else {
                int i2 = 6;
                if (z1Var.w.A1() != null && z1Var.w.A1().K() != null && z1Var.w.A1().K().u() != null && z1Var.w.A1().K().u().size() > 0) {
                    i2 = z1Var.w.A1().N ? 9 : 8;
                }
                d.a.k0.q0.j2.c.j().g(t.this.C, z1Var.w, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b(t tVar) {
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

    /* loaded from: classes4.dex */
    public class c implements d.a.c.e.k.c<ConstrainImageLayout> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            constrainImageLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            return new ConstrainImageLayout(t.this.w.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.c.e.k.c<TbImageView> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(t.this.w.getPageActivity());
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
        public e(t tVar) {
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
    public class f implements d.a.c.j.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i.w f58931a;

        public f(d.a.i.w wVar) {
            this.f58931a = wVar;
        }

        @Override // d.a.c.j.c.b
        public void a(int i2, int i3, int i4) {
            t.this.d0(i2, i3, i4);
            if (t.this.I(1) && t.this.I(2)) {
                this.f58931a.w(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.c.j.e.w {
        public g() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                z1 z1Var = (z1) nVar;
                a2 a2Var = z1Var.w;
                a2Var.objType = 1;
                if (t.this.E != null) {
                    t.this.E.a(threadCardViewHolder.a(), z1Var);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), 3, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.A = false;
        this.B = true;
        this.C = new d.a.k0.q0.j2.b();
        this.E = new a();
        this.F = new b(this);
        this.G = new d.a.c.e.k.b<>(new c(), 6, 0);
        this.H = new d.a.c.e.k.b<>(new d(), 12, 0);
        this.w = tbPageContext;
        this.f39568i = bdUniqueId2;
    }

    public final void H0(a2 a2Var) {
        if (this.x == null) {
            this.x = new HashSet<>();
        }
        d.a.k0.q0.j2.c.j().d(a2Var, this.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: I0 */
    public ThreadCardViewHolder<z1> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.w.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.w.getPageActivity());
        dVar.b(4280);
        dVar.t(this.f39568i);
        dVar.s(new e(this));
        bVar.o(dVar);
        d.a.i.w wVar = new d.a.i.w(this.w.getPageActivity());
        wVar.t("frs");
        if (this.D == 502) {
            wVar.v(false);
        } else {
            wVar.v(true);
        }
        wVar.s(this.G);
        wVar.r(this.H);
        wVar.u(this.B);
        bVar.n(wVar);
        u0 u0Var = new u0(this.w.getPageActivity());
        u0Var.x(this.w);
        u0Var.w(3);
        bVar.h(u0Var);
        bVar.h(new j0(this.w.getPageActivity()));
        d.a.i.n nVar = new d.a.i.n(this.w.getPageActivity());
        bVar.h(nVar);
        nVar.x(this.B);
        nVar.w("frs");
        if (!I(1) || !I(2)) {
            wVar.w(new f(wVar));
        }
        n0 n0Var = new n0(this.w.getPageActivity());
        d.a.j0.r.q.e eVar = new d.a.j0.r.q.e();
        eVar.f49950b = this.A ? 10 : 2;
        eVar.f49956h = 2;
        n0Var.v(eVar);
        n0Var.w(2);
        n0Var.A(1);
        n0Var.x(3);
        n0Var.b(16);
        bVar.m(n0Var);
        bVar.l().d(d.a.c.e.p.l.g(this.f39564e, R.dimen.tbds28));
        l0 i2 = bVar.i();
        i2.r(3);
        ThreadCardViewHolder<z1> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
        threadCardViewHolder.j(this.f39568i);
        Z(new g());
        threadCardViewHolder.m();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: J0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<z1> threadCardViewHolder) {
        super.W(i2, view, viewGroup, z1Var, threadCardViewHolder);
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().setPage(this.y);
        d.a.k0.q0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.k4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        boolean z = (z1Var.w.T() == null || z1Var.w.T().getUserId() == null || !z1Var.w.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (z1Var.w.v2() && z1Var.w.b0() != null && !z) {
            threadCardViewHolder.o(true).u(this.F);
        }
        threadCardViewHolder.r();
        if (threadCardViewHolder.b().e() != null) {
            threadCardViewHolder.b().e().b(32);
        }
        threadCardViewHolder.f(z1Var);
        threadCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.E);
        if (this.C != null) {
            FrsViewData frsViewData2 = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.a.k0.q0.j2.c.j().c(this.C, z1Var.w);
        H0(z1Var.w);
        z1Var.w.A4();
        d.a.k0.q0.j2.a.j(z1Var.w, this.f39568i, this.C, f0());
        if (z1Var != null) {
            z1Var.w.A4();
        }
        return threadCardViewHolder.a();
    }

    @Override // d.a.k0.x.z
    public void a(String str) {
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.y = str;
    }

    @Override // d.a.k0.q0.j2.d
    public d.a.k0.q0.j2.b i() {
        return this.C;
    }

    @Override // d.a.k0.x.a0
    public void k(boolean z) {
        this.A = z;
    }

    @Override // d.a.k0.x.z
    public void q(int i2) {
        this.D = i2;
    }

    @Override // d.a.k0.q0.k, d.a.k0.x.y
    public void setFrom(String str) {
        this.z = str;
    }

    @Override // d.a.k0.q0.k
    public void setFromCDN(boolean z) {
        this.B = z;
    }
}
