package d.b.i0.q0.n1.d;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
/* loaded from: classes4.dex */
public class n extends d.b.i0.q0.k<z1, CardViewHolder<d.b.i0.x.w>> implements d.b.i0.x.z, d.b.i0.q0.j2.d, d.b.i0.m.f {
    public d.b.c.e.k.b<ConstrainImageLayout> A;
    public d.b.c.e.k.b<TbImageView> B;
    public TbPageContext w;
    public String x;
    public d.b.i0.q0.j2.b y;
    public d.b.i0.x.b0 z;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0 {
        public a() {
        }

        @Override // d.b.i0.x.b0
        public void b(View view, BaseCardInfo baseCardInfo, Object obj) {
            if (baseCardInfo instanceof a2) {
                if (n.this.u != null) {
                    n.this.u.b(view, baseCardInfo, a2.o3);
                }
                a2 a2Var = (a2) baseCardInfo;
                d.b.i0.q0.j2.c.j().g(n.this.y, a2Var, 1);
                d.b.i0.q0.j2.a.b(a2Var, 1, n.this.i, n.this.y, n.this.i0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.c.e.k.c<ConstrainImageLayout> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            constrainImageLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            return new ConstrainImageLayout(n.this.w.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.c.e.k.c<TbImageView> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
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
        this.y = new d.b.i0.q0.j2.b();
        this.z = new a();
        this.A = new d.b.c.e.k.b<>(new b(), 6, 0);
        this.B = new d.b.c.e.k.b<>(new c(), 12, 0);
        this.w = tbPageContext;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.q0.j2.d
    public d.b.i0.q0.j2.b b() {
        return this.y;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.x = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: y0 */
    public CardViewHolder<d.b.i0.x.w> R(ViewGroup viewGroup) {
        d.b.i0.x.w wVar = new d.b.i0.x.w(this.w, viewGroup);
        CardViewHolder<d.b.i0.x.w> cardViewHolder = new CardViewHolder<>(wVar);
        wVar.w(this.B);
        wVar.x(this.A);
        wVar.q(this.z);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: z0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, CardViewHolder<d.b.i0.x.w> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        if (cardViewHolder.b() instanceof d.b.i0.m.e) {
            cardViewHolder.b().setPage(this.x);
        }
        super.X(i, view, viewGroup, z1Var, cardViewHolder);
        if (this.y != null) {
            FrsViewData frsViewData = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        }
        d.b.i0.q0.j2.a.i(z1Var.w, this.i, this.y, i0());
        d.b.i0.q0.j2.c.j().c(this.y, z1Var.w);
        cardViewHolder.b().q(this.z);
        cardViewHolder.b().n(z1Var.w);
        return cardViewHolder.a();
    }
}
