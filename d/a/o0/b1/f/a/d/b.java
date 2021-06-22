package d.a.o0.b1.f.a.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.o;
import d.a.i.v0.a;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.z.b0;
/* loaded from: classes4.dex */
public class b extends d.a.o0.b1.f.a.d.a<z1, ThreadCardViewHolder<a2>> {
    public d.a.c.e.k.b<ImageView> q;
    public d.a.c.e.k.b<GifView> r;
    public b0<a2> s;

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
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(b.this.n.getPageActivity());
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

    /* renamed from: d.a.o0.b1.f.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1258b implements d.a.c.e.k.c<GifView> {
        public C1258b() {
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
            GifView gifView = new GifView(b.this.n.getPageActivity());
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
    public class c extends b0<a2> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            b.this.e0(view, a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (b.this.s != null) {
                    b.this.s.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) a2Var, view.getContext(), 0, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, a2.X2);
        this.q = new d.a.c.e.k.b<>(new a(), 12, 0);
        this.r = new d.a.c.e.k.b<>(new C1258b(), 20, 0);
        this.s = new c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        o oVar = new o(this.n.getPageActivity());
        oVar.x("hot_topic");
        oVar.z(2);
        oVar.D(this.q, this.r);
        oVar.F(0, l.g(this.f43012e, R.dimen.tbds44), 0, 0);
        oVar.y(g0());
        oVar.w(1);
        bVar.n(oVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.f43016i);
        a0(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.b1.f.a.d.a, d.a.c.k.e.a
    /* renamed from: m0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.O1 = F(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        j0(threadCardViewHolder.a(), z1Var.w, i2, i2);
        return threadCardViewHolder.a();
    }
}
