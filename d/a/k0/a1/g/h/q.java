package d.a.k0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.d;
import d.a.i.i0;
import d.a.i.l0;
import d.a.j0.r.q.a2;
/* loaded from: classes4.dex */
public class q extends d.a.c.j.e.a<d.a.k0.x.e0.k, ThreadCardViewHolder<d.a.k0.x.e0.k>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public boolean o;
    public NEGFeedBackView.b p;
    public d.a.c.e.k.b<ConstrainImageLayout> q;
    public d.a.c.e.k.b<TbImageView> r;
    public d.a.k0.x.b0<d.a.k0.x.e0.k> s;

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
            return new ConstrainImageLayout(q.this.n.getPageActivity());
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
            TbImageView tbImageView = new TbImageView(q.this.n.getPageActivity());
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
    public class c implements d.b {
        public c(q qVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.j0.r.q.a aVar, View view) {
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
    public class d implements d.a.c.j.e.w {
        public d() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            a2 a2Var;
            d.a.k0.x.e0.k kVar = (d.a.k0.x.e0.k) nVar;
            if (kVar == null || (a2Var = kVar.f63179e) == null || a2Var.j1() == null) {
                return;
            }
            q.this.q0(kVar.f63179e, view);
            TiebaStatic.log(kVar.K());
            TiebaStatic.log(kVar.C());
            q.this.i0(kVar.f63179e, kVar.E());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.k0.x.b0<d.a.k0.x.e0.k> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public boolean c(View view, d.a.k0.x.e0.k kVar, String str) {
            a2 a2Var;
            if (kVar == null || (a2Var = kVar.f63179e) == null || a2Var.j1() == null) {
                return false;
            }
            q.this.q0(kVar.f63179e, view);
            TiebaStatic.log(kVar.K());
            TiebaStatic.log(kVar.C());
            q.this.i0(kVar.f63179e, kVar.E());
            return true;
        }
    }

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.o = true;
        this.p = null;
        this.q = new d.a.c.e.k.b<>(new a(), 6, 0);
        this.r = new d.a.c.e.k.b<>(new b(), 12, 0);
        this.s = new e();
        this.n = tbPageContext;
        h0();
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
    }

    public final void h0() {
        d.a.k0.x.e0.k.g0 = "c13388";
        d.a.k0.x.e0.k.h0 = "c13389";
    }

    public final void i0(a2 a2Var, int i2) {
        if (a2Var == null || a2Var.j1() == null) {
            return;
        }
        d.a.k0.c3.c.g().c(this.m, d.a.k0.c3.a.j(a2Var, "a002", "common_click", 1, i2, a2Var.j1().id));
    }

    public final void j0(a2 a2Var, int i2) {
        if (a2Var == null || a2Var.j1() == null) {
            return;
        }
        String str = a2Var.j1().id;
        d.a.k0.c3.c.g().d(this.m, d.a.k0.c3.a.c(a2Var.x1(), "", str, null), d.a.k0.c3.a.k(a2Var, "a002", "common_exp", i2, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder<d.a.k0.x.e0.k> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.r(false);
        dVar.w(false);
        dVar.c(1024);
        dVar.s(new c(this));
        bVar.o(dVar);
        d.a.i.w wVar = new d.a.i.w(this.n.getPageActivity());
        wVar.t("index");
        wVar.s(this.q);
        wVar.r(this.r);
        wVar.u(this.o);
        bVar.n(wVar);
        bVar.m(new i0(this.n.getPageActivity()));
        ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
        threadCardViewHolder.j(this.m);
        Z(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.k kVar, ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63179e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.o(false).u(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.a.k0.x.t.b().a(kVar.L());
        d.a.k0.m.d.c().i("page_recommend", "show_", kVar.L());
        j0(kVar.f63179e, kVar.E());
        return threadCardViewHolder.a();
    }

    public void p0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public final void q0(a2 a2Var, View view) {
        if (a2Var == null || a2Var.j1() == null) {
            return;
        }
        String str = a2Var.j1().id;
        String str2 = a2Var.j1().link;
        String str3 = a2Var.j1().h5_url;
        Long l = a2Var.j1().swan_app_id;
        long parseLong = Long.parseLong(a2Var.x1());
        String str4 = a2Var.j1().name;
        long c0 = a2Var.c0();
        d.a.j0.r.d0.b.j().w("smart_app_tid", parseLong);
        d.a.j0.r.d0.b.j().x("smart_app_name", str4);
        d.a.j0.r.d0.b.j().x("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!d.a.k0.s.a.b(str, str2, "1191008600000000", a2Var.j1().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            d.a.j0.l.a.l(view.getContext(), str3);
        }
        d.a.k0.x.m.a(a2Var.x1());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", c0).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", a2Var.j1().is_game.intValue()));
    }
}
