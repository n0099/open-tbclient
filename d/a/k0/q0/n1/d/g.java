package d.a.k0.q0.n1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i.a;
import d.a.i.d;
import d.a.i.g0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.j0.r.q.z1;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class g extends d.a.k0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.a.k0.x.z, d.a.k0.q0.j2.d, d.a.k0.m.f {
    public boolean A;
    public int B;
    public d.a.k0.q0.j2.b C;
    public d.a.k0.x.b0<a2> D;
    public d.a.c.e.k.b<ImageView> E;
    public d.a.c.e.k.b<GifView> F;
    public NEGFeedBackView.b G;
    public TbPageContext<?> w;
    public HashSet<String> x;
    public String y;
    public String z;

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
            if ("c13010".equals(g.this.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", a2Var.c0()).param("tid", a2Var.x1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof ThreadGodReplyLayout) {
                    d.a.k0.q0.j2.a.c(a2Var, 15, g.this.f39568i, g.this.C, g.this.f0());
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 5, g.this.f39568i, g.this.C, g.this.f0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 14, g.this.f39568i, g.this.C, g.this.f0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.k0.q0.j2.a.c(a2Var, 12, g.this.f39568i, g.this.C, g.this.f0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.k0.q0.j2.a.c(a2Var, 13, g.this.f39568i, g.this.C, g.this.f0());
                } else {
                    d.a.k0.q0.j2.a.c(a2Var, 1, g.this.f39568i, g.this.C, g.this.f0());
                }
            } else {
                d.a.k0.q0.j2.a.c(a2Var, 2, g.this.f39568i, g.this.C, g.this.f0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.k0.q0.j2.c.j().g(g.this.C, a2Var, 2);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                d.a.k0.q0.j2.c.j().g(g.this.C, a2Var, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", a2Var.x1());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", a2Var.x1());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.e.k.c<ImageView> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.a.j0.r.k.c().g()) {
                    tbImageView.setAdjustViewBounds(false);
                    tbImageView.setInterceptOnClick(false);
                } else {
                    tbImageView.setDefaultResource(R.drawable.icon_click);
                    tbImageView.setAdjustViewBounds(true);
                    tbImageView.setInterceptOnClick(true);
                }
            }
            return imageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(g.this.w.getPageActivity());
            boolean g2 = d.a.j0.r.k.c().g();
            foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                foreDrawableImageView.setAdjustViewBounds(false);
                foreDrawableImageView.setInterceptOnClick(false);
            } else {
                foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                foreDrawableImageView.setAdjustViewBounds(true);
                foreDrawableImageView.setInterceptOnClick(true);
            }
            return foreDrawableImageView;
        }

        public ImageView h(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                foreDrawableImageView.Q();
            }
            return imageView;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.e.k.c<GifView> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            gifView.setTag(null);
            if (d.a.j0.r.k.c().g()) {
                gifView.setAdjustViewBounds(false);
                gifView.setInterceptOnClick(false);
            } else {
                gifView.setDefaultResource(R.drawable.icon_click);
                gifView.setAdjustViewBounds(true);
                gifView.setInterceptOnClick(true);
            }
            return gifView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.setBackgroundDrawable(null);
            gifView.setImageDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            gifView.n0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(g.this.w.getPageActivity());
            boolean g2 = d.a.j0.r.k.c().g();
            gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                gifView.setAdjustViewBounds(false);
                gifView.setInterceptOnClick(false);
            } else {
                gifView.setDefaultResource(R.drawable.icon_click);
                gifView.setAdjustViewBounds(true);
                gifView.setInterceptOnClick(true);
            }
            return gifView;
        }

        public GifView h(GifView gifView) {
            gifView.s0();
            gifView.n0();
            gifView.setImageDrawable(null);
            gifView.t0();
            gifView.setBackgroundDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            return gifView;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NEGFeedBackView.b {
        public d(g gVar) {
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
    public class e implements d.b {
        public e(g gVar) {
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
    public class f implements a.InterfaceC0547a {
        public f() {
        }

        @Override // d.a.i.a.InterfaceC0547a
        public void a(d.a.j0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().r1, g.this.f39564e, 3, (Rect) null, aVar.m().i0());
        }
    }

    /* renamed from: d.a.k0.q0.n1.d.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1505g implements d.a.c.j.e.w {
        public C1505g() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (g.this.D != null) {
                    g.this.D.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), g.this.B, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.A = true;
        this.B = 3;
        this.C = new d.a.k0.q0.j2.b();
        this.D = new a();
        this.E = new d.a.c.e.k.b<>(new b(), 8, 0);
        this.F = new d.a.c.e.k.b<>(new c(), 20, 0);
        this.G = new d(this);
        this.w = tbPageContext;
        this.f39568i = bdUniqueId2;
    }

    public final void F0(a2 a2Var) {
        if (this.x == null) {
            this.x = new HashSet<>();
        }
        d.a.k0.q0.j2.c.j().d(a2Var, this.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: G0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.w.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.w.getPageActivity());
        dVar.b(4280);
        dVar.t(this.f39568i);
        dVar.s(new e(this));
        bVar.o(dVar);
        g0 g0Var = new g0(this.w);
        g0Var.n(Boolean.FALSE);
        g0Var.v("frs");
        if (this.B == 502) {
            g0Var.x(false);
        } else {
            g0Var.x(true);
        }
        bVar.l().d(d.a.c.e.p.l.g(this.f39564e, R.dimen.tbds33));
        bVar.n(g0Var);
        d.a.i.o oVar = new d.a.i.o(this.w.getPageActivity());
        oVar.x("frs");
        oVar.z(3);
        if (this.B == 502) {
            oVar.B(false);
        } else {
            oVar.B(true);
        }
        oVar.D(this.E, this.F);
        oVar.y(this.A);
        oVar.n(Boolean.TRUE);
        oVar.v(R.color.CAM_X0204);
        oVar.F(d.a.j0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.a.j0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        oVar.A(new f());
        bVar.h(oVar);
        bVar.h(new p0(this.w.getPageActivity()));
        d.a.i.n nVar = new d.a.i.n(this.w.getPageActivity());
        nVar.x(this.A);
        nVar.w("frs");
        bVar.h(nVar);
        n0 n0Var = new n0(this.w.getPageActivity());
        d.a.j0.r.q.e eVar = new d.a.j0.r.q.e();
        eVar.f49950b = 2;
        eVar.f49956h = 2;
        n0Var.v(eVar);
        n0Var.w(2);
        n0Var.A(3);
        n0Var.x(2);
        n0Var.b(16);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.f39568i);
        Z(new C1505g());
        threadCardViewHolder.m();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: H0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        if (threadCardViewHolder.b() instanceof d.a.k0.m.e) {
            threadCardViewHolder.b().setPage(this.y);
        }
        threadCardViewHolder.b().q(i2);
        super.W(i2, view, viewGroup, z1Var, threadCardViewHolder);
        d.a.k0.q0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.k4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        boolean z = (z1Var.w.T() == null || z1Var.w.T().getUserId() == null || !z1Var.w.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (z1Var.w.v2() && z1Var.w.b0() != null && !z) {
            threadCardViewHolder.o(true).u(this.G);
        }
        threadCardViewHolder.r();
        if (threadCardViewHolder.b().e() != null) {
            threadCardViewHolder.b().e().b(32);
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.D);
        if (this.C != null) {
            FrsViewData frsViewData2 = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.a.k0.q0.j2.c.j().c(this.C, z1Var.w);
        F0(z1Var.w);
        z1Var.w.A4();
        d.a.k0.q0.j2.a.j(z1Var.w, this.f39568i, this.C, f0());
        a2 a2Var = z1Var.w;
        if (a2Var != null) {
            a2Var.A4();
        }
        return threadCardViewHolder.a();
    }

    public void I0(boolean z) {
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

    @Override // d.a.k0.x.z
    public void q(int i2) {
        this.B = i2;
    }

    @Override // d.a.k0.q0.k, d.a.k0.x.y
    public void setFrom(String str) {
        this.z = str;
    }

    @Override // d.a.k0.q0.k
    public void setFromCDN(boolean z) {
        this.A = z;
    }
}
