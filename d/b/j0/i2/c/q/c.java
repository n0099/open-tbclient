package d.b.j0.i2.c.q;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.o;
import d.b.i.u0.a;
import d.b.i0.r.k;
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public class c extends d.b.c.j.e.a<d.b.j0.x.e0.f, ThreadCardViewHolder<d.b.j0.x.e0.f>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public boolean s;
    public d.b.c.e.k.b<ImageView> t;
    public d.b.c.e.k.b<GifView> u;
    public b0<d.b.j0.x.e0.f> v;

    /* loaded from: classes3.dex */
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
                if (k.c().g()) {
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
            boolean g2 = k.c().g();
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

    /* loaded from: classes3.dex */
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
            if (k.c().g()) {
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
            boolean g2 = k.c().g();
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

    /* renamed from: d.b.j0.i2.c.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1364c extends b0<d.b.j0.x.e0.f> {
        public C1364c(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.f fVar) {
            if (view == null || fVar == null || fVar.n() == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.thread_card_root) {
                StatisticItem G = fVar.G("c13543");
                G.param("obj_type", fVar.Z(fVar.f64193e));
                TiebaStatic.log(G);
                d.b.j0.i2.a.a(view, fVar, 2);
            } else if (view instanceof TbImageView) {
                d.b.j0.i2.a.a(view, fVar, 3);
            } else if (view.getId() != R.id.thread_card_title && view.getId() != R.id.thread_card_abstract) {
                if (id == R.id.forum_name_text) {
                    d.b.j0.i2.a.a(view, fVar, 7);
                }
            } else {
                d.b.j0.i2.a.a(view, fVar, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.j0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.j0.x.e0.f fVar = (d.b.j0.x.e0.f) nVar;
                fVar.k = 1;
                if (c.this.v != null) {
                    c.this.v.a(threadCardViewHolder.a(), fVar);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) fVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.q = 0;
        this.r = 0;
        this.t = new d.b.c.e.k.b<>(new a(), 12, 0);
        this.u = new d.b.c.e.k.b<>(new b(), 20, 0);
        this.v = new C1364c(this);
        this.n = tbPageContext;
        j0();
    }

    public final void j0() {
        d.b.j0.x.e0.k.k0 = "c13542";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
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
        o oVar = new o(this.n.getPageActivity());
        oVar.x("index");
        oVar.z(4);
        oVar.C(this.t, this.u);
        oVar.y(this.p);
        oVar.r(l.g(this.f43095e, R.dimen.tbds20));
        oVar.w(1);
        bVar.h(oVar);
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 3;
        eVar.f51512h = 3;
        m0Var.v(eVar);
        m0Var.w(8);
        m0Var.A(6);
        m0Var.x(4);
        bVar.m(m0Var);
        k0 i2 = bVar.i();
        i2.r(4);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i2);
        threadCardViewHolder.k(this.m);
        threadCardViewHolder.r(this.r);
        c0(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.f fVar, ThreadCardViewHolder<d.b.j0.x.e0.f> threadCardViewHolder) {
        if (fVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || fVar.f64193e == null) {
            return null;
        }
        fVar.U(fVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.s) {
            threadCardViewHolder.s();
        }
        threadCardViewHolder.f(fVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.v);
        d.b.j0.i2.a.b(fVar);
        return threadCardViewHolder.a();
    }

    public void n0(boolean z) {
        this.s = z;
    }

    @Override // d.b.j0.m.f
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
