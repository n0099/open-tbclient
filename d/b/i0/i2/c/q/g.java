package d.b.i0.i2.c.q;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i.a0;
import d.b.i.g0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.s;
import d.b.i.t0;
import d.b.i.u0.a;
import d.b.i.w;
import d.b.i0.x.b0;
import d.b.i0.x.e0.k;
/* loaded from: classes3.dex */
public class g extends d.b.c.j.e.a<k, ThreadCardViewHolder<k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public boolean s;
    public d.b.c.e.k.b<ConstrainImageLayout> t;
    public d.b.c.e.k.b<TbImageView> u;
    public b0<k> v;

    /* loaded from: classes3.dex */
    public class a implements d.b.c.e.k.c<ConstrainImageLayout> {
        public a() {
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
            return new ConstrainImageLayout(g.this.n.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.c.e.k.c<TbImageView> {
        public b() {
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

    /* loaded from: classes3.dex */
    public class c extends b0<k> {
        public c(g gVar) {
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
                StatisticItem G = kVar.G("c13543");
                G.param("obj_type", kVar.Z(kVar.f63772e));
                TiebaStatic.log(G);
                d.b.i0.i2.a.a(view, kVar, 2);
            } else if (id == R.id.forum_name_text) {
                d.b.i0.i2.a.a(view, kVar, 7);
            } else if (view instanceof TbImageView) {
                d.b.i0.i2.a.a(view, kVar, 3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.c.j.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f57054a;

        public d(w wVar) {
            this.f57054a = wVar;
        }

        @Override // d.b.c.j.c.b
        public void a(int i, int i2, int i3) {
            g.this.g0(i, i2, i3);
            if (g.this.J(1) && g.this.J(2)) {
                this.f57054a.w(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.c.j.e.w {
        public e() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (g.this.v != null) {
                    g.this.v.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.q = 0;
        this.r = 0;
        this.t = new d.b.c.e.k.b<>(new a(), 6, 0);
        this.u = new d.b.c.e.k.b<>(new b(), 12, 0);
        this.v = new c(this);
        this.n = tbPageContext;
        j0();
    }

    public final void j0() {
        k.k0 = "c13542";
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
        w wVar = new w(this.n.getPageActivity());
        wVar.t("index");
        wVar.s(this.t);
        wVar.r(this.u);
        wVar.u(this.p);
        bVar.n(wVar);
        bVar.l().d(l.g(this.f42855e, R.dimen.tbds25));
        if (!J(1) || !J(2)) {
            wVar.w(new d(wVar));
        }
        bVar.h(new s(this.n.getPageActivity()));
        t0 t0Var = new t0(this.n.getPageActivity());
        t0Var.x(this.n);
        t0Var.w(4);
        bVar.h(t0Var);
        bVar.h(new g0(this.n.getPageActivity()));
        bVar.h(new a0(this.n.getPageActivity()));
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f51170b = 3;
        eVar.f51176h = 3;
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
        c0(new e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63772e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.s) {
            threadCardViewHolder.s();
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.v);
        d.b.i0.i2.a.b(kVar);
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
