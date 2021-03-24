package d.b.i0.z0.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.b.i.d;
import d.b.i.g0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class n extends d.b.i0.z0.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public d.b.i0.z0.g.k.e q;
    public String r;
    public boolean s;
    public d.b.b.e.k.b<ConstrainImageLayout> t;
    public d.b.b.e.k.b<TbImageView> u;
    public d.b.i0.x.b0<d.b.i0.x.e0.k> v;

    /* loaded from: classes4.dex */
    public class a implements d.b.b.e.k.c<ConstrainImageLayout> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            constrainImageLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            return new ConstrainImageLayout(n.this.o.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.b.e.k.c<TbImageView> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(n.this.o.getPageActivity());
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

    /* loaded from: classes4.dex */
    public class c extends d.b.i0.x.b0<d.b.i0.x.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (view == null || n.this.q == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.b.i0.z0.g.f.b(d.b.b.e.m.b.f(kVar.n().w1(), 0L))) {
                d.b.i0.z0.g.f.a(d.b.b.e.m.b.f(kVar.n().w1(), 0L));
                n.this.q.e(d.b.b.e.m.b.f(kVar.n().w1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.b.b.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.n().V());
            }
            n.this.q0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b {
        public d(n nVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
            if (aVar != null) {
                if (view.getId() == R.id.user_name) {
                    aVar.objType = 3;
                } else if (view.getId() == R.id.user_avatar) {
                    aVar.objType = 4;
                } else {
                    aVar.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.b.j.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i.w f63143a;

        public e(d.b.i.w wVar) {
            this.f63143a = wVar;
        }

        @Override // d.b.b.j.c.b
        public void a(int i, int i2, int i3) {
            n.this.g0(i, i2, i3);
            if (n.this.J(1) && n.this.J(2)) {
                this.f63143a.w(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.b.j.e.w {
        public f() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (n.this.v != null) {
                    n.this.v.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.s = true;
        this.t = new d.b.b.e.k.b<>(new a(), 6, 0);
        this.u = new d.b.b.e.k.b<>(new b(), 12, 0);
        this.v = new c();
        this.o = tbPageContext;
        n0();
    }

    public final void n0() {
        d.b.i0.x.e0.k.U = "c10705";
        d.b.i0.x.e0.k.V = "c10730";
        d.b.i0.x.e0.k.W = "c10731";
        d.b.i0.x.e0.k.X = "c10704";
        d.b.i0.x.e0.k.Y = "c10755";
        d.b.i0.x.e0.k.Z = "c10710";
        d.b.i0.x.e0.k.a0 = "c10736";
        d.b.i0.x.e0.k.b0 = "c10737";
        d.b.i0.x.e0.k.c0 = "c10711";
        d.b.i0.x.e0.k.d0 = "c10758";
        d.b.i0.x.e0.k.e0 = "c10757";
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.r = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new d(this));
        bVar.o(dVar);
        d.b.i.w wVar = new d.b.i.w(this.o.getPageActivity());
        wVar.t("index");
        wVar.s(this.t);
        wVar.r(this.u);
        wVar.u(this.s);
        bVar.n(wVar);
        bVar.h(new d.b.i.s(this.o.getPageActivity()));
        bVar.h(new g0(this.o.getPageActivity()));
        bVar.h(new d.b.i.a0(this.o.getPageActivity()));
        bVar.h(new d.b.i.k(this.o.getPageActivity()));
        d.b.i.n nVar = new d.b.i.n(this.o.getPageActivity());
        nVar.x(this.s);
        nVar.w("index");
        bVar.h(nVar);
        if (!J(1) || !J(2)) {
            wVar.w(new e(wVar));
        }
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50762b = 1;
        eVar.f50768h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        k0 i = bVar.i();
        i.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
        threadCardViewHolder.k(this.n);
        c0(new f());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: p0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62196e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.r);
        threadCardViewHolder.p(true).u(this.p);
        threadCardViewHolder.m(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.v);
        d.b.i0.x.t.b().a(kVar.L());
        d.b.i0.m.d.c().i("page_recommend", "show_", kVar.L());
        d.b.i0.z0.g.m.a.c(kVar.f62196e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void q0(View view, d.b.i0.x.e0.k kVar) {
        int id = view.getId();
        int i = 3;
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.K());
            d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.K());
            i = 1;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.K());
            d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.K());
            i = 5;
        } else {
            if (id == R.id.thread_card_voice) {
                TiebaStatic.log(kVar.f0());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.f0());
            } else {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(kVar.e0());
                    d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(kVar.e0());
                    d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(kVar.C());
                    d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.C());
                } else if (id == R.id.god_reply_voice_btn) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.god_reply_content) {
                    StatisticItem statisticItem2 = new StatisticItem("c10760");
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                    if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 3);
                            TiebaStatic.log(statisticItem3);
                        }
                        TiebaStatic.log(kVar.b0());
                        d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.b0());
                    }
                } else {
                    StatisticItem statisticItem4 = new StatisticItem("c10760");
                    statisticItem4.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem4);
                }
                i = 2;
            }
            i = 0;
        }
        if (i != 0) {
            d.b.i0.z0.g.m.a.a(kVar.f62196e, this.n, kVar.E(), i);
        }
    }

    public void r0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void s0(d.b.i0.z0.g.k.e eVar) {
        this.q = eVar;
    }

    public void setFromCDN(boolean z) {
        this.s = z;
    }
}
