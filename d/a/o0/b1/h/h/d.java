package d.a.o0.b1.h.h;

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
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<d.a.o0.z.e0.k, ThreadCardViewHolder<d.a.o0.z.e0.k>> implements d.a.o0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.o0.b1.h.k.e o;
    public String p;
    public boolean q;
    public d.a.c.k.e.s r;
    public d.a.c.e.k.b<ImageView> s;
    public d.a.c.e.k.b<GifView> t;
    public d.a.o0.z.b0<d.a.o0.z.e0.k> u;

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
                if (d.a.n0.r.k.c().g()) {
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
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(d.this.n.getPageActivity());
            boolean g2 = d.a.n0.r.k.c().g();
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
            if (d.a.n0.r.k.c().g()) {
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
            gifView.l0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(d.this.n.getPageActivity());
            boolean g2 = d.a.n0.r.k.c().g();
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
            gifView.q0();
            gifView.l0();
            gifView.setImageDrawable(null);
            gifView.s0();
            gifView.setBackgroundDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            return gifView;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.o0.z.b0<d.a.o0.z.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.k kVar) {
            d.a.o0.z.t.b().d(true);
            d.a.o0.o.d.c().h("page_recommend", "show_");
            if (view == null || d.this.o == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.o0.b1.h.f.b(d.a.c.e.m.b.f(kVar.i().z1(), 0L))) {
                d.a.o0.b1.h.f.a(d.a.c.e.m.b.f(kVar.i().z1(), 0L));
                d.this.o.e(d.a.c.e.m.b.f(kVar.i().z1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.i().V());
            }
            d.this.m0(view, kVar);
        }
    }

    /* renamed from: d.a.o0.b1.h.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1265d implements d.a.c.k.e.w {
        public C1265d() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.o0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                kVar.k = 1;
                if (d.this.u != null) {
                    d.this.u.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = true;
        this.s = new d.a.c.e.k.b<>(new a(), 12, 0);
        this.t = new d.a.c.e.k.b<>(new b(), 20, 0);
        this.u = new c();
        this.n = tbPageContext;
        j0();
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.p = str;
    }

    public final void j0() {
        d.a.o0.z.e0.k.V = "c10705";
        d.a.o0.z.e0.k.W = "c10730";
        d.a.o0.z.e0.k.X = "c10731";
        d.a.o0.z.e0.k.Y = "c10704";
        d.a.o0.z.e0.k.Z = "c10755";
        d.a.o0.z.e0.k.a0 = "c10710";
        d.a.o0.z.e0.k.b0 = "c10736";
        d.a.o0.z.e0.k.c0 = "c10737";
        d.a.o0.z.e0.k.i0 = "c10711";
        d.a.o0.z.e0.k.j0 = "c10758";
        d.a.o0.z.e0.k.k0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.o oVar = new d.a.i.o(this.n.getPageActivity());
        oVar.x("index");
        oVar.z(2);
        oVar.D(this.s, this.t);
        oVar.F(0, d.a.c.e.p.l.g(this.f43012e, R.dimen.tbds44), 0, 0);
        oVar.y(this.q);
        oVar.w(1);
        bVar.n(oVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.r);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        a0(new C1265d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.u);
        d.a.o0.z.t.b().a(kVar.L());
        d.a.o0.o.d.c().a(kVar.L());
        d.a.o0.b1.h.m.a.c(kVar.f67302e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void m0(View view, d.a.o0.z.e0.k kVar) {
        int id = view.getId();
        int i2 = 3;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(kVar.e0());
                d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.user_name) {
                TiebaStatic.log(kVar.e0());
                d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.C());
                d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.C());
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
                        d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.b0());
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
            d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.K());
            i2 = 1;
        }
        if (i2 != 0) {
            d.a.o0.b1.h.m.a.a(kVar.f67302e, this.m, kVar.E(), i2);
        }
    }

    public void p0(d.a.o0.b1.h.k.e eVar) {
        this.o = eVar;
    }

    public void q0(d.a.c.k.e.s sVar) {
        this.r = sVar;
    }

    public void setFromCDN(boolean z) {
        this.q = z;
    }
}
