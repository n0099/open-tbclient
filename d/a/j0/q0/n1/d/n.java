package d.a.j0.q0.n1.d;

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
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
/* loaded from: classes4.dex */
public class n extends d.a.j0.q0.k<z1, CardViewHolder<d.a.j0.x.w>> implements d.a.j0.x.z, d.a.j0.q0.j2.d, d.a.j0.m.f {
    public d.a.c.e.k.b<ConstrainImageLayout> A;
    public d.a.c.e.k.b<TbImageView> B;
    public TbPageContext w;
    public String x;
    public d.a.j0.q0.j2.b y;
    public d.a.j0.x.b0 z;

    /* loaded from: classes4.dex */
    public class a extends d.a.j0.x.b0 {
        public a() {
        }

        @Override // d.a.j0.x.b0
        public void b(View view, BaseCardInfo baseCardInfo, Object obj) {
            if (baseCardInfo instanceof a2) {
                if (n.this.u != null) {
                    n.this.u.b(view, baseCardInfo, a2.o3);
                }
                a2 a2Var = (a2) baseCardInfo;
                d.a.j0.q0.j2.c.j().g(n.this.y, a2Var, 1);
                d.a.j0.q0.j2.a.c(a2Var, 1, n.this.f40323i, n.this.y, n.this.f0());
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
        this.y = new d.a.j0.q0.j2.b();
        this.z = new a();
        this.A = new d.a.c.e.k.b<>(new b(), 6, 0);
        this.B = new d.a.c.e.k.b<>(new c(), 12, 0);
        this.w = tbPageContext;
    }

    @Override // d.a.j0.x.z
    public void a(String str) {
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.x = str;
    }

    @Override // d.a.j0.q0.j2.d
    public d.a.j0.q0.j2.b i() {
        return this.y;
    }

    @Override // d.a.j0.x.z
    public void q(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: y0 */
    public CardViewHolder<d.a.j0.x.w> P(ViewGroup viewGroup) {
        d.a.j0.x.w wVar = new d.a.j0.x.w(this.w, viewGroup);
        CardViewHolder<d.a.j0.x.w> cardViewHolder = new CardViewHolder<>(wVar);
        wVar.u(this.B);
        wVar.v(this.A);
        wVar.o(this.z);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: z0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, CardViewHolder<d.a.j0.x.w> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        if (cardViewHolder.b() instanceof d.a.j0.m.e) {
            cardViewHolder.b().setPage(this.x);
        }
        super.W(i2, view, viewGroup, z1Var, cardViewHolder);
        if (this.y != null) {
            FrsViewData frsViewData = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        }
        d.a.j0.q0.j2.a.j(z1Var.w, this.f40323i, this.y, f0());
        d.a.j0.q0.j2.c.j().c(this.y, z1Var.w);
        cardViewHolder.b().o(this.z);
        cardViewHolder.b().m(z1Var.w);
        return cardViewHolder.a();
    }
}
