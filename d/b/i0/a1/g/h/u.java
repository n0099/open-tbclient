package d.b.i0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.a;
import d.b.i.d;
import d.b.i.f0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.o0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class u extends d.b.i0.a1.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public d.b.i0.a1.g.k.e p;
    public String q;
    public boolean r;
    public NEGFeedBackView.b s;
    public d.b.c.j.e.s t;
    public d.b.c.e.k.b<ImageView> u;
    public d.b.c.e.k.b<GifView> v;
    public d.b.i0.x.b0<d.b.i0.x.e0.k> w;

    /* loaded from: classes4.dex */
    public class a implements d.b.c.e.k.c<ImageView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.b.h0.r.k.c().g()) {
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
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.c0();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(u.this.o.getPageActivity());
            boolean g2 = d.b.h0.r.k.c().g();
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
                foreDrawableImageView.c0();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                foreDrawableImageView.S();
            }
            return imageView;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.c.e.k.c<GifView> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            gifView.setTag(null);
            if (d.b.h0.r.k.c().g()) {
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
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.setBackgroundDrawable(null);
            gifView.setImageDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            gifView.p0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(u.this.o.getPageActivity());
            boolean g2 = d.b.h0.r.k.c().g();
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
            gifView.p0();
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
    public class c extends d.b.i0.x.b0<d.b.i0.x.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (view == null || u.this.p == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.b.i0.a1.g.f.b(d.b.c.e.m.b.f(kVar.n().w1(), 0L))) {
                d.b.i0.a1.g.f.a(d.b.c.e.m.b.f(kVar.n().w1(), 0L));
                u.this.p.e(d.b.c.e.m.b.f(kVar.n().w1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.b.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.n().V());
            }
            u.this.r0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b {
        public d(u uVar) {
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
    public class e implements a.InterfaceC1129a {
        public e() {
        }

        @Override // d.b.i.a.InterfaceC1129a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, u.this.f42855e, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.c.j.e.w {
        public f() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (u.this.w != null) {
                    u.this.w.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = true;
        this.s = null;
        this.u = new d.b.c.e.k.b<>(new a(), 8, 0);
        this.v = new d.b.c.e.k.b<>(new b(), 20, 0);
        this.w = new c();
        this.o = tbPageContext;
        o0();
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.q = str;
    }

    public final void o0() {
        d.b.i0.x.e0.k.U = "c10705";
        d.b.i0.x.e0.k.V = "c10730";
        d.b.i0.x.e0.k.W = "c10731";
        d.b.i0.x.e0.k.X = "c10704";
        d.b.i0.x.e0.k.Y = "c10755";
        d.b.i0.x.e0.k.Z = "c10710";
        d.b.i0.x.e0.k.a0 = "c10736";
        d.b.i0.x.e0.k.b0 = "c10737";
        d.b.i0.x.e0.k.c0 = "c10711";
        d.b.i0.x.e0.k.d0 = "c10758";
        d.b.i0.x.e0.k.e0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: p0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new d(this));
        bVar.o(dVar);
        f0 f0Var = new f0(this.o);
        f0Var.n(Boolean.FALSE);
        f0Var.v("index");
        bVar.n(f0Var);
        d.b.i.o oVar = new d.b.i.o(this.o.getPageActivity());
        oVar.x("index");
        oVar.z(2);
        oVar.C(this.u, this.v);
        oVar.y(this.r);
        oVar.n(Boolean.TRUE);
        oVar.v(R.color.CAM_X0204);
        oVar.F(d.b.h0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.b.h0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        oVar.A(new e());
        bVar.h(oVar);
        bVar.h(new o0(this.o.getPageActivity()));
        bVar.h(new d.b.i.k(this.o.getPageActivity()));
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f51170b = 1;
        eVar.f51176h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.t);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.n);
        c0(new f());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: q0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63772e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.b().setPage(this.q);
        threadCardViewHolder.p(true).u(this.s);
        threadCardViewHolder.m(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.w);
        d.b.i0.x.t.b().a(kVar.L());
        d.b.i0.m.d.c().a(kVar.L());
        d.b.i0.a1.g.m.a.c(kVar.f63772e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void r0(View view, d.b.i0.x.e0.k kVar) {
        int id = view.getId();
        int i = 3;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(kVar.e0());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.user_name) {
                TiebaStatic.log(kVar.e0());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.C());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.C());
                i = 9;
            } else {
                if (id == R.id.god_reply_content) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem);
                } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                    if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 3);
                            TiebaStatic.log(statisticItem2);
                        }
                        TiebaStatic.log(kVar.b0());
                        d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.b0());
                    } else {
                        i = 0;
                    }
                } else {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                }
                i = 5;
            }
            i = 2;
        } else {
            TiebaStatic.log(kVar.K());
            d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.K());
            i = 1;
        }
        if (i != 0) {
            d.b.i0.a1.g.m.a.a(kVar.f63772e, this.n, kVar.E(), i);
        }
    }

    public void s0(NEGFeedBackView.b bVar) {
        this.s = bVar;
    }

    public void t0(d.b.c.j.e.s sVar) {
        this.t = sVar;
    }
}
