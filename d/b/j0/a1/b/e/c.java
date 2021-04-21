package d.b.j0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.a0;
import d.b.i.d;
import d.b.i.g0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.j0.x.b0;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<d.b.j0.x.e0.b, ThreadCardViewHolder<d.b.j0.x.e0.b>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.b.c.j.e.s p;
    public boolean q;
    public d.b.c.e.k.b<ImageView> r;
    public d.b.c.e.k.b<GifView> s;
    public b0<d.b.j0.x.e0.b> t;

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
                if (d.b.i0.r.k.c().g()) {
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
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.n.getPageActivity());
            boolean g2 = d.b.i0.r.k.c().g();
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
            if (d.b.i0.r.k.c().g()) {
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
            GifView gifView = new GifView(c.this.n.getPageActivity());
            boolean g2 = d.b.i0.r.k.c().g();
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

    /* renamed from: d.b.j0.a1.b.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1159c extends b0<d.b.j0.x.e0.b> {
        public C1159c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.b bVar) {
            c.this.w0(view, bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b {
        public d(c cVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.i0.r.q.a aVar, View view) {
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
    public class e implements d.b.c.j.e.w {
        public e() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.c.j.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.b.c.j.e.g gVar = (d.b.c.j.e.g) nVar;
                if (gVar.g() instanceof d.b.j0.x.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.b.j0.x.e0.b bVar = (d.b.j0.x.e0.b) gVar.g();
                    bVar.k = 1;
                    if (c.this.t != null) {
                        c.this.t.a(threadCardViewHolder.a(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) bVar, view.getContext(), 1, false, d.b.i.e.a((d.b.c.j.e.s) viewGroup, view, i));
                    threadCardViewHolder.b().o(new a.C1072a(1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.c.j.e.w {
        public f() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.c.j.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.b.c.j.e.g gVar = (d.b.c.j.e.g) nVar;
                if (gVar.g() instanceof d.b.j0.x.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.b.j0.x.e0.b bVar = (d.b.j0.x.e0.b) gVar.g();
                    bVar.k = 1;
                    if (c.this.t != null) {
                        c.this.t.a(threadCardViewHolder.a(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) bVar, view.getContext(), 1, false);
                    threadCardViewHolder.b().o(new a.C1072a(1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.b.c.j.e.w {
        public g() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            d.b.j0.x.e0.b bVar;
            a2 a2Var;
            boolean z = nVar instanceof d.b.c.j.e.g;
            if (z) {
                d.b.c.j.e.g gVar = (d.b.c.j.e.g) nVar;
                if ((gVar.g() instanceof d.b.j0.x.e0.b) && nVar != null && gVar.g() != null && (bVar = (d.b.j0.x.e0.b) gVar.g()) != null && (a2Var = bVar.f64193e) != null && bVar.y && a2Var.y0() != null) {
                    if (bVar.f64193e.getType() == a2.x3) {
                        BdToast.i(c.this.n.getContext(), c.this.n.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(bVar.f64193e.y0().item_id));
                    hashMap.put("source", 2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.j0.d3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                    return;
                }
            }
            if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.b.c.j.e.g gVar2 = (d.b.c.j.e.g) nVar;
                if (gVar2.g() instanceof d.b.j0.x.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.b.j0.x.e0.b bVar2 = (d.b.j0.x.e0.b) gVar2.g();
                    bVar2.k = 1;
                    if (c.this.t != null) {
                        c.this.t.a(threadCardViewHolder.a(), bVar2);
                    }
                    ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) bVar2, view.getContext(), 1, false, d.b.i.e.a((d.b.c.j.e.s) viewGroup, view, i));
                    threadCardViewHolder.b().o(new a.C1072a(1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.b.c.j.e.w {
        public h() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.c.j.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.b.c.j.e.g gVar = (d.b.c.j.e.g) nVar;
                if (gVar.g() instanceof d.b.j0.x.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.b.j0.x.e0.b bVar = (d.b.j0.x.e0.b) gVar.g();
                    bVar.k = 1;
                    if (c.this.t != null) {
                        c.this.t.a(threadCardViewHolder.a(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) bVar, view.getContext(), 1, false, d.b.i.e.a((d.b.c.j.e.s) viewGroup, view, i));
                    threadCardViewHolder.b().o(new a.C1072a(1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f52766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f52767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f52768c;

        public i(c cVar, ViewGroup viewGroup, View view, int i) {
            this.f52766a = viewGroup;
            this.f52767b = view;
            this.f52768c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.b.i.e.a((d.b.c.j.e.s) this.f52766a, this.f52767b, this.f52768c));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = true;
        this.r = new d.b.c.e.k.b<>(new a(), 12, 0);
        this.s = new d.b.c.e.k.b<>(new b(), 20, 0);
        this.t = new C1159c();
        this.n = tbPageContext;
        l0();
    }

    public final void l0() {
        d.b.j0.x.e0.k.U = "c10705";
        d.b.j0.x.e0.k.V = "c10730";
        d.b.j0.x.e0.k.W = "c10731";
        d.b.j0.x.e0.k.X = "c10704";
        d.b.j0.x.e0.k.Y = "c10755";
        d.b.j0.x.e0.k.Z = "c10710";
        d.b.j0.x.e0.k.a0 = "c10736";
        d.b.j0.x.e0.k.b0 = "c10737";
        d.b.j0.x.e0.k.c0 = "c10711";
        d.b.j0.x.e0.k.d0 = "c10758";
        d.b.j0.x.e0.k.e0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder<d.b.j0.x.e0.b> M(ViewGroup viewGroup, d.b.j0.x.e0.b bVar) {
        k0.b bVar2 = new k0.b(this.n.getPageActivity(), false);
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 9;
        eVar.f51512h = 9;
        m0Var.v(eVar);
        m0Var.w(4);
        m0Var.B("personalize_page");
        m0Var.A(4);
        m0Var.x(1);
        m0Var.b(32);
        bVar2.m(m0Var);
        k0 k = bVar2.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new h());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public ThreadCardViewHolder<d.b.j0.x.e0.b> O(ViewGroup viewGroup, d.b.j0.x.e0.b bVar) {
        k0.b bVar2 = new k0.b(this.n.getPageActivity(), false);
        if (bVar.t) {
            d.b.i.o oVar = new d.b.i.o(this.n.getPageActivity());
            oVar.C(this.r, this.s);
            oVar.x(ImageViewerConfig.FROM_CONCERN);
            oVar.z(1);
            oVar.y(this.q);
            oVar.w(1);
            bVar2.n(oVar);
        } else if (bVar.u) {
            d.b.i.y yVar = new d.b.i.y(this.n.getPageActivity());
            yVar.q(ImageViewerConfig.FROM_CONCERN);
            yVar.r(this.q);
            bVar2.n(yVar);
        } else if (bVar.v) {
            d.b.i.v vVar = new d.b.i.v(this.n.getPageActivity());
            vVar.r(ImageViewerConfig.FROM_CONCERN);
            vVar.s(this.q);
            bVar2.n(vVar);
        } else if (bVar.w) {
            d.b.i.z zVar = new d.b.i.z(this.n.getPageActivity());
            zVar.r(ImageViewerConfig.FROM_CONCERN);
            zVar.s(this.q);
            bVar2.n(zVar);
        } else {
            boolean z = bVar.x;
        }
        k0 k = bVar2.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new f());
        return threadCardViewHolder;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: o0 */
    public ThreadCardViewHolder<d.b.j0.x.e0.b> P(ViewGroup viewGroup, d.b.j0.x.e0.b bVar) {
        k0.b bVar2 = new k0.b(this.n.getPageActivity(), false);
        d.b.i.s sVar = new d.b.i.s(this.n.getPageActivity());
        sVar.s();
        bVar2.h(sVar);
        bVar2.h(new g0(this.n.getPageActivity()));
        bVar2.h(new a0(this.n.getPageActivity()));
        d.b.i.k kVar = new d.b.i.k(this.n.getPageActivity());
        kVar.t();
        bVar2.h(kVar);
        d.b.i.n nVar = new d.b.i.n(this.n.getPageActivity());
        nVar.x(this.q);
        nVar.w(ImageViewerConfig.FROM_CONCERN);
        bVar2.h(nVar);
        k0 k = bVar2.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new g());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: p0 */
    public ThreadCardViewHolder<d.b.j0.x.e0.b> Q(ViewGroup viewGroup, d.b.j0.x.e0.b bVar) {
        if (bVar == null) {
            return null;
        }
        k0.b bVar2 = new k0.b(this.n.getPageActivity());
        if (bVar.r) {
            d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
            dVar.t(this.m);
            dVar.b(128);
            dVar.c(1024);
            dVar.s(new d(this));
            bVar2.o(dVar);
        } else if (bVar.s) {
            bVar2.o(new d.b.i.m(this.n.getPageActivity()));
        }
        k0 k = bVar2.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: q0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: r0 */
    public View T(int i2, View view, ViewGroup viewGroup, d.b.j0.x.e0.b bVar, ThreadCardViewHolder threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f64193e == null) {
            return null;
        }
        bVar.U(bVar.position + 1);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b().e() instanceof m0) {
            ((m0) threadCardViewHolder.b().e()).z(new i(this, viewGroup, view, i2));
        }
        if (threadCardViewHolder.b() instanceof d.b.j0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.u(false, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.f(bVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.t);
        return threadCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: s0 */
    public View U(int i2, View view, ViewGroup viewGroup, d.b.j0.x.e0.b bVar, ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f64193e == null) {
            return null;
        }
        bVar.U(bVar.position + 1);
        d.b.j0.x.t.b().a(bVar.A("c12351"));
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.b.j0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        if (bVar.u) {
            d.b.i.y yVar = (d.b.i.y) threadCardViewHolder.b().f();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.j.f4516h.getLayoutParams();
            layoutParams.width = bVar.o;
            layoutParams.height = bVar.p;
            if (yVar.j.f4516h.getVisibility() != 8) {
                yVar.j.f4516h.setLayoutParams(layoutParams);
            }
        }
        threadCardViewHolder.f(bVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.t);
        return threadCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public View V(int i2, View view, ViewGroup viewGroup, d.b.j0.x.e0.b bVar, ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f64193e == null) {
            return null;
        }
        bVar.U(bVar.position + 1);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.b.j0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        if (bVar.C) {
            d.b.j0.x.t.b().a(new StatisticItem("c13424"));
        }
        threadCardViewHolder.f(bVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.t);
        return threadCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: u0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.b.j0.x.e0.b bVar, ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f64193e == null) {
            return null;
        }
        bVar.U(bVar.position + 1);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.b.j0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        if (bVar.r) {
            threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
        } else if (bVar.s) {
            d.b.j0.x.t.b().a(bVar.L());
            d.b.j0.m.d.c().a(bVar.L());
            d.b.j0.a1.g.m.a.c(bVar.f64193e, this.m, bVar.E());
        }
        threadCardViewHolder.f(bVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.t);
        return threadCardViewHolder.a();
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId v() {
        return d.b.j0.x.e0.b.O;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: v0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.b.j0.x.e0.b bVar, ThreadCardViewHolder<d.b.j0.x.e0.b> threadCardViewHolder) {
        return null;
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId w() {
        return d.b.j0.x.e0.b.K;
    }

    public final void w0(View view, d.b.j0.x.e0.b bVar) {
        StatisticItem K;
        if (view == null || bVar == null || bVar.n() == null || StringUtils.isNull(bVar.n().w1())) {
            return;
        }
        int id = view.getId();
        int i2 = 1;
        if (bVar.r) {
            if (id == R.id.thread_card_root) {
                d.b.j0.a1.b.c.b(view, bVar, 2);
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                d.b.j0.a1.b.c.b(view, bVar, 1);
            }
        } else if (bVar.s) {
            d.b.j0.x.t.b().d(true);
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                if (bVar.Q()) {
                    K = bVar.N();
                } else {
                    K = bVar.K();
                }
                TiebaStatic.log(K);
                d.b.j0.m.d.c().i("page_concern", "clk_", K);
            } else {
                TiebaStatic.log(bVar.C());
                d.b.j0.m.d.c().i("page_concern", "clk_", bVar.C());
                i2 = 9;
            }
            d.b.j0.a1.g.m.a.a(bVar.f64193e, this.m, bVar.E(), i2);
        } else if (!bVar.t && !bVar.u && !bVar.v && !bVar.w) {
            if (!bVar.y) {
                if (bVar.z) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) bVar.n(), view.getContext(), 1, false);
                        threadCardViewHolder.b().o(new a.C1072a(1));
                    }
                } else if (!bVar.A) {
                    if (bVar.B) {
                        if (view.getId() == R.id.thread_card_root) {
                            d.b.j0.a1.b.c.b(view, bVar, 2);
                        } else if (id == R.id.forum_name_text) {
                            d.b.j0.a1.b.c.b(view, bVar, 7);
                        }
                    } else if (bVar.C) {
                        if (view.getId() == R.id.thread_card_root) {
                            d.b.j0.a1.b.c.b(view, bVar, 2);
                        } else if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            statisticItem.param("tid", bVar.l);
                            a2 a2Var = bVar.f64193e;
                            if (a2Var != null && a2Var.z1() != null) {
                                statisticItem.param("pid", bVar.f64193e.z1().E());
                            }
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param("tid", bVar.l);
                            a2 a2Var2 = bVar.f64193e;
                            if (a2Var2 != null && a2Var2.z1() != null) {
                                statisticItem2.param("pid", bVar.f64193e.z1().E());
                            }
                            TiebaStatic.log(statisticItem2);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (id == R.id.god_reply_agree_view) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                statisticItem3.param("tid", bVar.l);
                                a2 a2Var3 = bVar.f64193e;
                                if (a2Var3 != null && a2Var3.z1() != null) {
                                    statisticItem3.param("pid", bVar.f64193e.z1().E());
                                }
                                TiebaStatic.log(statisticItem3);
                            } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                statisticItem4.param("tid", bVar.l);
                                a2 a2Var4 = bVar.f64193e;
                                if (a2Var4 != null && a2Var4.z1() != null) {
                                    statisticItem4.param("pid", bVar.f64193e.z1().E());
                                }
                                TiebaStatic.log(statisticItem4);
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            statisticItem5.param("tid", bVar.l);
                            a2 a2Var5 = bVar.f64193e;
                            if (a2Var5 != null && a2Var5.z1() != null) {
                                statisticItem5.param("pid", bVar.f64193e.z1().E());
                            }
                            TiebaStatic.log(statisticItem5);
                        }
                    } else if (bVar.D && (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container)) {
                        d.b.j0.a1.b.c.b(view, bVar, 2);
                    }
                }
            }
        } else if (view.getId() == R.id.thread_card_root) {
            d.b.j0.a1.b.c.b(view, bVar, 2);
        } else if (view instanceof TbImageView) {
            d.b.j0.a1.b.c.b(view, bVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            d.b.j0.a1.b.c.b(view, bVar, 2);
        }
        if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
            d.b.j0.a1.b.c.b(view, bVar, 8);
        }
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId x() {
        return d.b.j0.x.e0.b.N;
    }

    public void x0(d.b.c.j.e.s sVar) {
        this.p = sVar;
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId y() {
        return d.b.j0.x.e0.b.F;
    }
}
