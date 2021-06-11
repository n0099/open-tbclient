package d.a.n0.r0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends d.a.n0.r0.k<a2, c> {
    public d.a.c.e.k.b<ConstrainImageLayout> w;
    public d.a.c.e.k.b<TbImageView> x;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.k.c<ConstrainImageLayout> {
        public a() {
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
            return new ConstrainImageLayout(f.this.o.getPageActivity());
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
            TbImageView tbImageView = new TbImageView(f.this.o.getPageActivity());
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
    public static class c extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.r0.n1.g.d f62721a;

        public c(d.a.n0.r0.n1.g.d dVar) {
            super(dVar.m());
            this.f62721a = dVar;
        }
    }

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.w = new d.a.c.e.k.b<>(new a(), 6, 0);
        this.x = new d.a.c.e.k.b<>(new b(), 6, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public c Q(ViewGroup viewGroup) {
        d.a.n0.r0.n1.g.d dVar = new d.a.n0.r0.n1.g.d(this.o, this.f42913i);
        dVar.F(this.o.getUniqueId());
        dVar.I(this.w);
        dVar.H(this.x);
        dVar.L(0.5625d);
        return new c(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, c cVar) {
        super.X(i2, view, viewGroup, a2Var, cVar);
        cVar.f62721a.o(this.o, this.r);
        cVar.f62721a.n(a2Var);
        if (a2Var != null) {
            a2Var.C4();
        }
        return cVar.a();
    }
}
