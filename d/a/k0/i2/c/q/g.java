package d.a.k0.i2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i.a0;
import d.a.i.h0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.s;
import d.a.i.u0;
import d.a.i.v0.a;
import d.a.i.w;
import d.a.k0.x.b0;
import d.a.k0.x.e0.k;
/* loaded from: classes5.dex */
public class g extends d.a.c.j.e.a<k, ThreadCardViewHolder<k>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public boolean s;
    public d.a.c.e.k.b<ConstrainImageLayout> t;
    public d.a.c.e.k.b<TbImageView> u;
    public b0<k> v;

    /* loaded from: classes5.dex */
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
            return new ConstrainImageLayout(g.this.n.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes5.dex */
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
            TbImageView tbImageView = new TbImageView(g.this.n.getPageActivity());
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
            return tbImageView;
        }

        public TbImageView h(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
            return tbImageView;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends b0<k> {
        public c(g gVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.m() == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.thread_card_root) {
                StatisticItem G = kVar.G("c13543");
                G.param("obj_type", kVar.Z(kVar.f63179e));
                TiebaStatic.log(G);
                d.a.k0.i2.a.a(view, kVar, 2);
            } else if (id == R.id.forum_name_text) {
                d.a.k0.i2.a.a(view, kVar, 7);
            } else if (view instanceof TbImageView) {
                d.a.k0.i2.a.a(view, kVar, 3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.c.j.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f56123a;

        public d(w wVar) {
            this.f56123a = wVar;
        }

        @Override // d.a.c.j.c.b
        public void a(int i2, int i3, int i4) {
            g.this.d0(i2, i3, i4);
            if (g.this.I(1) && g.this.I(2)) {
                this.f56123a.w(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d.a.c.j.e.w {
        public e() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (g.this.v != null) {
                    g.this.v.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.q = 0;
        this.r = 0;
        this.t = new d.a.c.e.k.b<>(new a(), 6, 0);
        this.u = new d.a.c.e.k.b<>(new b(), 12, 0);
        this.v = new c(this);
        this.n = tbPageContext;
        g0();
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.o = str;
    }

    public final void g0() {
        k.l0 = "c13542";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.c(32768);
        int i2 = this.q;
        if (i2 > 0) {
            dVar.b(i2);
        }
        dVar.r(false);
        dVar.w(false);
        bVar.o(dVar);
        w wVar = new w(this.n.getPageActivity());
        wVar.t("index");
        wVar.s(this.t);
        wVar.r(this.u);
        wVar.u(this.p);
        bVar.n(wVar);
        bVar.l().d(l.g(this.f39564e, R.dimen.tbds25));
        if (!I(1) || !I(2)) {
            wVar.w(new d(wVar));
        }
        bVar.h(new s(this.n.getPageActivity()));
        u0 u0Var = new u0(this.n.getPageActivity());
        u0Var.x(this.n);
        u0Var.w(4);
        bVar.h(u0Var);
        bVar.h(new h0(this.n.getPageActivity()));
        bVar.h(new a0(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.j0.r.q.e eVar = new d.a.j0.r.q.e();
        eVar.f49950b = 3;
        eVar.f49956h = 3;
        n0Var.v(eVar);
        n0Var.w(8);
        n0Var.A(6);
        n0Var.x(4);
        bVar.m(n0Var);
        l0 i3 = bVar.i();
        i3.r(4);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i3);
        threadCardViewHolder.j(this.m);
        threadCardViewHolder.q(this.r);
        Z(new e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63179e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.s) {
            threadCardViewHolder.r();
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.v);
        d.a.k0.i2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void j0(boolean z) {
        this.s = z;
    }

    public void m0(int i2) {
        this.r = i2;
    }

    public void n0(int i2) {
    }

    public void p0(int i2) {
        this.q = i2;
    }
}
