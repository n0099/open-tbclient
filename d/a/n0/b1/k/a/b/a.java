package d.a.n0.b1.k.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.b1.k.a.e.d;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.n0.b1.k.a.c.c, CardViewHolder<d>> {
    public TbPageContext<?> m;
    public d.a.c.e.k.b<ConstrainImageLayout> n;
    public d.a.c.e.k.b<TbImageView> o;

    /* renamed from: d.a.n0.b1.k.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1267a implements d.a.c.e.k.c<ConstrainImageLayout> {
        public C1267a() {
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
            return new ConstrainImageLayout(a.this.m.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.e.k.c<TbImageView> {
        public b() {
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
            TbImageView tbImageView = new TbImageView(a.this.m.getPageActivity());
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

    /* loaded from: classes4.dex */
    public class c implements w {
        public c(a aVar) {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d dVar;
            if (!(view.getTag() instanceof CardViewHolder) || (dVar = (d) ((CardViewHolder) view.getTag()).b()) == null) {
                return;
            }
            dVar.w();
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.b1.k.a.c.c.k);
        this.n = new d.a.c.e.k.b<>(new C1267a(), 6, 0);
        this.o = new d.a.c.e.k.b<>(new b(), 12, 0);
        this.m = tbPageContext;
        a0(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<d> Q(ViewGroup viewGroup) {
        d dVar = new d(this.m);
        dVar.G(this.n);
        dVar.F(this.o);
        dVar.q(this.f42913i);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.k.a.c.c cVar, CardViewHolder<d> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(cVar);
        return cardViewHolder.a();
    }
}
