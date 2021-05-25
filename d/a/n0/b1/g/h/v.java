package d.a.n0.b1.g.h;

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
import d.a.i.a;
import d.a.i.d;
import d.a.i.g0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class v extends d.a.n0.b1.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public d.a.n0.b1.g.k.e p;
    public String q;
    public boolean r;
    public NEGFeedBackView.b s;
    public d.a.c.j.e.s t;
    public d.a.c.e.k.b<ImageView> u;
    public d.a.c.e.k.b<GifView> v;
    public d.a.n0.z.b0<d.a.n0.z.e0.k> w;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.k.c<ImageView> {
        public a() {
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
                if (d.a.m0.r.k.c().g()) {
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
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(v.this.o.getPageActivity());
            boolean g2 = d.a.m0.r.k.c().g();
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
    public class b implements d.a.c.e.k.c<GifView> {
        public b() {
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
            if (d.a.m0.r.k.c().g()) {
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
            GifView gifView = new GifView(v.this.o.getPageActivity());
            boolean g2 = d.a.m0.r.k.c().g();
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
    public class c extends d.a.n0.z.b0<d.a.n0.z.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.k kVar) {
            d.a.n0.z.t.b().d(true);
            d.a.n0.o.d.c().h("page_recommend", "show_");
            if (view == null || v.this.p == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().y1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.n0.b1.g.f.b(d.a.c.e.m.b.f(kVar.m().y1(), 0L))) {
                d.a.n0.b1.g.f.a(d.a.c.e.m.b.f(kVar.m().y1(), 0L));
                v.this.p.e(d.a.c.e.m.b.f(kVar.m().y1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.m().V());
            }
            v.this.q0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b {
        public d(v vVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.m0.r.q.a aVar, View view) {
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
    public class e implements a.InterfaceC0542a {
        public e() {
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().s1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().s1, v.this.f39228e, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.c.j.e.w {
        public f() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.n0.z.e0.k kVar = (d.a.n0.z.e0.k) nVar;
                kVar.k = 1;
                if (v.this.w != null) {
                    v.this.w.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = true;
        this.s = null;
        this.u = new d.a.c.e.k.b<>(new a(), 8, 0);
        this.v = new d.a.c.e.k.b<>(new b(), 20, 0);
        this.w = new c();
        this.o = tbPageContext;
        m0();
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.q = str;
    }

    public final void m0() {
        d.a.n0.z.e0.k.V = "c10705";
        d.a.n0.z.e0.k.W = "c10730";
        d.a.n0.z.e0.k.X = "c10731";
        d.a.n0.z.e0.k.Y = "c10704";
        d.a.n0.z.e0.k.Z = "c10755";
        d.a.n0.z.e0.k.a0 = "c10710";
        d.a.n0.z.e0.k.b0 = "c10736";
        d.a.n0.z.e0.k.c0 = "c10737";
        d.a.n0.z.e0.k.d0 = "c10711";
        d.a.n0.z.e0.k.e0 = "c10758";
        d.a.n0.z.e0.k.f0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new d(this));
        bVar.o(dVar);
        g0 g0Var = new g0(this.o);
        g0Var.n(Boolean.FALSE);
        g0Var.v("index");
        bVar.n(g0Var);
        d.a.i.o oVar = new d.a.i.o(this.o.getPageActivity());
        oVar.x("index");
        oVar.z(2);
        oVar.D(this.u, this.v);
        oVar.y(this.r);
        oVar.n(Boolean.TRUE);
        oVar.v(R.color.CAM_X0204);
        oVar.F(d.a.m0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.a.m0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        oVar.A(new e());
        bVar.h(oVar);
        bVar.h(new p0(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f49994b = 1;
        eVar.f50000h = 1;
        n0Var.v(eVar);
        n0Var.w(1);
        n0Var.A(3);
        n0Var.x(2);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.t);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.n);
        Z(new f());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63459e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.q);
        threadCardViewHolder.o(true).u(this.s);
        threadCardViewHolder.l(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.w);
        d.a.n0.z.t.b().a(kVar.L());
        d.a.n0.o.d.c().a(kVar.L());
        d.a.n0.b1.g.m.a.c(kVar.f63459e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void q0(View view, d.a.n0.z.e0.k kVar) {
        int id = view.getId();
        int i2 = 3;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(kVar.e0());
                d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.user_name) {
                TiebaStatic.log(kVar.e0());
                d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.C());
                d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.C());
                i2 = 9;
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
                        d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.b0());
                    } else {
                        i2 = 0;
                    }
                } else {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                }
                i2 = 5;
            }
            i2 = 2;
        } else {
            TiebaStatic.log(kVar.K());
            d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.K());
            i2 = 1;
        }
        if (i2 != 0) {
            d.a.n0.b1.g.m.a.a(kVar.f63459e, this.n, kVar.E(), i2);
        }
    }

    public void s0(NEGFeedBackView.b bVar) {
        this.s = bVar;
    }

    public void t0(d.a.c.j.e.s sVar) {
        this.t = sVar;
    }
}
