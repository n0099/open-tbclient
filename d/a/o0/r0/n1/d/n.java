package d.a.o0.r0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
/* loaded from: classes4.dex */
public class n extends d.a.o0.r0.k<z1, CardViewHolder<d.a.o0.z.w>> implements d.a.o0.z.z, d.a.o0.r0.j2.d, d.a.o0.o.f {
    public d.a.c.e.k.b<ConstrainImageLayout> A;
    public d.a.c.e.k.b<TbImageView> B;
    public TbPageContext w;
    public String x;
    public d.a.o0.r0.j2.b y;
    public d.a.o0.z.b0 z;

    /* loaded from: classes4.dex */
    public class a extends d.a.o0.z.b0 {
        public a() {
        }

        @Override // d.a.o0.z.b0
        public void b(View view, BaseCardInfo baseCardInfo, Object obj) {
            if (baseCardInfo instanceof a2) {
                if (n.this.u != null) {
                    n.this.u.b(view, baseCardInfo, a2.t3);
                }
                a2 a2Var = (a2) baseCardInfo;
                d.a.o0.r0.j2.c.j().g(n.this.y, a2Var, 1);
                d.a.o0.r0.j2.a.c(a2Var, 1, n.this.f43016i, n.this.y, n.this.g0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.e.k.c<ConstrainImageLayout> {
        public b() {
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
            return new ConstrainImageLayout(n.this.w.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.e.k.c<TbImageView> {
        public c() {
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
            TbImageView tbImageView = new TbImageView(n.this.w.getPageActivity());
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

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = new d.a.o0.r0.j2.b();
        this.z = new a();
        this.A = new d.a.c.e.k.b<>(new b(), 6, 0);
        this.B = new d.a.c.e.k.b<>(new c(), 12, 0);
        this.w = tbPageContext;
    }

    @Override // d.a.o0.z.z
    public void a(String str) {
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.x = str;
    }

    @Override // d.a.o0.r0.j2.d
    public d.a.o0.r0.j2.b j() {
        return this.y;
    }

    @Override // d.a.o0.z.z
    public void r(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: y0 */
    public CardViewHolder<d.a.o0.z.w> Q(ViewGroup viewGroup) {
        d.a.o0.z.w wVar = new d.a.o0.z.w(this.w, viewGroup);
        CardViewHolder<d.a.o0.z.w> cardViewHolder = new CardViewHolder<>(wVar);
        wVar.v(this.B);
        wVar.w(this.A);
        wVar.p(this.z);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: z0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, CardViewHolder<d.a.o0.z.w> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        if (cardViewHolder.b() instanceof d.a.o0.o.e) {
            cardViewHolder.b().setPage(this.x);
        }
        super.X(i2, view, viewGroup, z1Var, cardViewHolder);
        if (this.y != null) {
            FrsViewData frsViewData = this.n;
            z1Var.w.O1 = (z1Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        }
        d.a.o0.r0.j2.a.j(z1Var.w, this.f43016i, this.y, g0());
        d.a.o0.r0.j2.c.j().c(this.y, z1Var.w);
        cardViewHolder.b().p(this.z);
        cardViewHolder.b().n(z1Var.w);
        return cardViewHolder.a();
    }
}
