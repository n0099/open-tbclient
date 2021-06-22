package d.a.o0.b1.h.h;

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
import d.a.i.d;
import d.a.i.h0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class n extends d.a.o0.b1.a<d.a.o0.z.e0.k, ThreadCardViewHolder<d.a.o0.z.e0.k>> implements d.a.o0.o.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public d.a.o0.b1.h.k.e q;
    public String r;
    public boolean s;
    public d.a.c.e.k.b<ConstrainImageLayout> t;
    public d.a.c.e.k.b<TbImageView> u;
    public d.a.o0.z.b0<d.a.o0.z.e0.k> v;

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
            return new ConstrainImageLayout(n.this.o.getPageActivity());
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
    public class c extends d.a.o0.z.b0<d.a.o0.z.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.k kVar) {
            d.a.o0.z.t.b().d(true);
            d.a.o0.o.d.c().h("page_recommend", "show_");
            if (view == null || n.this.q == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.o0.b1.h.f.b(d.a.c.e.m.b.f(kVar.i().z1(), 0L))) {
                d.a.o0.b1.h.f.a(d.a.c.e.m.b.f(kVar.i().z1(), 0L));
                n.this.q.e(d.a.c.e.m.b.f(kVar.i().z1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.i().V());
            }
            n.this.p0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b {
        public d(n nVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.n0.r.q.a aVar, View view) {
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
    public class e implements d.a.c.k.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i.w f55571a;

        public e(d.a.i.w wVar) {
            this.f55571a = wVar;
        }

        @Override // d.a.c.k.c.b
        public void a(int i2, int i3, int i4) {
            n.this.d0(i2, i3, i4);
            if (n.this.J(1) && n.this.J(2)) {
                this.f55571a.w(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.c.k.e.w {
        public f() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.o0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                kVar.k = 1;
                if (n.this.v != null) {
                    n.this.v.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.s = true;
        this.t = new d.a.c.e.k.b<>(new a(), 6, 0);
        this.u = new d.a.c.e.k.b<>(new b(), 12, 0);
        this.v = new c();
        this.o = tbPageContext;
        k0();
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.r = str;
    }

    public final void k0() {
        d.a.o0.z.e0.k.V = "c10705";
        d.a.o0.z.e0.k.W = "c10730";
        d.a.o0.z.e0.k.X = "c10731";
        d.a.o0.z.e0.k.Y = "c10704";
        d.a.o0.z.e0.k.Z = "c10755";
        d.a.o0.z.e0.k.a0 = "c10710";
        d.a.o0.z.e0.k.b0 = "c10736";
        d.a.o0.z.e0.k.c0 = "c10737";
        d.a.o0.z.e0.k.i0 = "c10711";
        d.a.o0.z.e0.k.j0 = "c10758";
        d.a.o0.z.e0.k.k0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new d(this));
        bVar.o(dVar);
        d.a.i.w wVar = new d.a.i.w(this.o.getPageActivity());
        wVar.t("index");
        wVar.s(this.t);
        wVar.r(this.u);
        wVar.u(this.s);
        bVar.n(wVar);
        bVar.h(new d.a.i.s(this.o.getPageActivity()));
        bVar.h(new h0(this.o.getPageActivity()));
        bVar.h(new d.a.i.a0(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        d.a.i.n nVar = new d.a.i.n(this.o.getPageActivity());
        nVar.x(this.s);
        nVar.w("index");
        bVar.h(nVar);
        if (!J(1) || !J(2)) {
            wVar.w(new e(wVar));
        }
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 1;
        eVar.f53783h = 1;
        n0Var.v(eVar);
        n0Var.w(1);
        n0Var.A(3);
        n0Var.x(2);
        bVar.m(n0Var);
        l0 i2 = bVar.i();
        i2.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i2);
        threadCardViewHolder.k(this.n);
        a0(new f());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: m0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.r);
        threadCardViewHolder.p(true).u(this.p);
        threadCardViewHolder.m(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.v);
        d.a.o0.z.t.b().a(kVar.L());
        d.a.o0.o.d.c().i("page_recommend", "show_", kVar.L());
        d.a.o0.b1.h.m.a.c(kVar.f67302e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void p0(View view, d.a.o0.z.e0.k kVar) {
        int id = view.getId();
        int i2 = 3;
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.K());
            d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.K());
            i2 = 1;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.K());
            d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.K());
            i2 = 5;
        } else {
            if (id == R.id.thread_card_voice) {
                TiebaStatic.log(kVar.f0());
                d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.f0());
            } else {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(kVar.e0());
                    d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.e0());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(kVar.e0());
                    d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.e0());
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(kVar.C());
                    d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.C());
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
                        d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.b0());
                    }
                } else {
                    StatisticItem statisticItem4 = new StatisticItem("c10760");
                    statisticItem4.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem4);
                }
                i2 = 2;
            }
            i2 = 0;
        }
        if (i2 != 0) {
            d.a.o0.b1.h.m.a.a(kVar.f67302e, this.n, kVar.E(), i2);
        }
    }

    public void q0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void s0(d.a.o0.b1.h.k.e eVar) {
        this.q = eVar;
    }

    public void setFromCDN(boolean z) {
        this.s = z;
    }
}
