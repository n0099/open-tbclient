package d.b.j0.c1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.r.q.a2;
import d.b.j0.q0.k;
import d.b.j0.x.b0;
import d.b.j0.x.t;
import d.b.j0.x.w;
import d.b.j0.x.y;
/* loaded from: classes4.dex */
public class c extends k<a2, CardViewHolder<w>> implements y {
    public d.b.c.e.k.b<TbImageView> A;
    public TbPageContext w;
    public String x;
    public b0<a2> y;
    public d.b.c.e.k.b<ConstrainImageLayout> z;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void b(View view, a2 a2Var, Object obj) {
            if (view == null || a2Var == null || a2Var.T() == null) {
                return;
            }
            if ("c13010".equals(c.this.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 4).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() == R.id.card_root_layout) {
                TiebaStatic.log(new StatisticItem("c13020").param("fid", a2Var.c0()).param("obj_name", a2Var.T().getName_show()).param("tid", a2Var.w1()));
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
            return new ConstrainImageLayout(c.this.w.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* renamed from: d.b.j0.c1.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1212c implements d.b.c.e.k.c<TbImageView> {
        public C1212c() {
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
            TbImageView tbImageView = new TbImageView(c.this.w.getPageActivity());
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

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.y = new a();
        this.z = new d.b.c.e.k.b<>(new b(), 6, 0);
        this.A = new d.b.c.e.k.b<>(new C1212c(), 12, 0);
        this.w = tbPageContext;
    }

    @Override // d.b.j0.x.y
    public String from() {
        return "FrsHottopicDelegateAdapter";
    }

    @Override // d.b.j0.q0.k, d.b.j0.x.y
    public void i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f43095e = tbPageContext.getPageActivity();
            this.w = tbPageContext;
            this.i = bdUniqueId;
        }
    }

    @Override // d.b.j0.q0.k, d.b.j0.x.y
    public void setFrom(String str) {
        this.x = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: v0 */
    public CardViewHolder<w> R(ViewGroup viewGroup) {
        w wVar = new w(this.w, viewGroup);
        wVar.w(this.A);
        wVar.x(this.z);
        return new CardViewHolder<>(wVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    /* renamed from: w0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, CardViewHolder<w> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().q(this.y);
        cardViewHolder.b().n(a2Var);
        if (a2Var != null && a2Var.T() != null) {
            StatisticItem statisticItem = new StatisticItem("c13019");
            statisticItem.param("tid", a2Var.w1()).param("fid", a2Var.c0()).param("obj_name", a2Var.T().getName_show());
            t.b().a(statisticItem);
        }
        return cardViewHolder.a();
    }
}
