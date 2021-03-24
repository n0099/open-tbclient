package d.b.i0.h2.c.q;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.i.a;
import d.b.i.f0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.o;
import d.b.i.o0;
import d.b.i.t0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
import d.b.i0.x.e0.k;
/* loaded from: classes5.dex */
public class e extends d.b.b.j.e.a<k, ThreadCardViewHolder<k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public boolean s;
    public b0<k> t;
    public d.b.b.e.k.b<ImageView> u;
    public d.b.b.e.k.b<GifView> v;

    /* loaded from: classes5.dex */
    public class a extends b0<k> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.n() == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.thread_card_root) {
                d.b.i0.h2.a.a(view, kVar, 2);
            } else if (view instanceof TbImageView) {
                d.b.i0.h2.a.a(view, kVar, 6);
            } else if (id != R.id.thread_card_title && view.getId() != R.id.thread_card_abstract) {
                if (id == R.id.forum_name_text) {
                    d.b.i0.h2.a.a(view, kVar, 7);
                }
            } else {
                d.b.i0.h2.a.a(view, kVar, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b.b.e.k.c<ImageView> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
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
        @Override // d.b.b.e.k.c
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
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(e.this.n.getPageActivity());
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

    /* loaded from: classes5.dex */
    public class c implements d.b.b.e.k.c<GifView> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
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
        @Override // d.b.b.e.k.c
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
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(e.this.n.getPageActivity());
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

    /* loaded from: classes5.dex */
    public class d implements a.InterfaceC1115a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f55185a;

        public d(o oVar) {
            this.f55185a = oVar;
        }

        @Override // d.b.i.a.InterfaceC1115a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, e.this.f42357e, 4);
            d.b.i0.h2.a.a(this.f55185a.g(), aVar, 6);
        }
    }

    /* renamed from: d.b.i0.h2.c.q.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1266e implements w {
        public C1266e() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (e.this.t != null) {
                    e.this.t.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.q = 0;
        this.r = 0;
        this.t = new a(this);
        this.u = new d.b.b.e.k.b<>(new b(), 8, 0);
        this.v = new d.b.b.e.k.b<>(new c(), 20, 0);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.c(32768);
        int i = this.q;
        if (i > 0) {
            dVar.b(i);
        }
        dVar.r(false);
        dVar.w(false);
        bVar.o(dVar);
        f0 f0Var = new f0(this.n);
        f0Var.n(Boolean.FALSE);
        f0Var.v(ImageViewerConfig.FROM_CONCERN);
        f0Var.r(l.g(this.f42357e, R.dimen.tbds25));
        bVar.h(f0Var);
        o oVar = new o(this.n.getPageActivity());
        oVar.x(ImageViewerConfig.FROM_CONCERN);
        oVar.z(4);
        oVar.C(this.u, this.v);
        oVar.y(this.p);
        oVar.n(Boolean.TRUE);
        oVar.v(R.color.CAM_X0204);
        oVar.F(d.b.h0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.b.h0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        oVar.A(new d(oVar));
        bVar.h(oVar);
        bVar.h(new o0(this.n.getPageActivity()));
        t0 t0Var = new t0(this.n.getPageActivity());
        t0Var.x(this.n);
        t0Var.w(4);
        bVar.h(t0Var);
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50762b = 3;
        eVar.f50768h = 3;
        m0Var.v(eVar);
        m0Var.w(8);
        m0Var.A(6);
        m0Var.x(4);
        bVar.m(m0Var);
        k0 i2 = bVar.i();
        i2.r(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
        threadCardViewHolder.k(this.m);
        threadCardViewHolder.r(this.r);
        c0(new C1266e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62196e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.s) {
            threadCardViewHolder.s();
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.t);
        d.b.i0.h2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void n0(boolean z) {
        this.s = z;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }

    public void o0(int i) {
        this.r = i;
    }

    public void p0(int i) {
    }

    public void q0(int i) {
        this.q = i;
    }
}
