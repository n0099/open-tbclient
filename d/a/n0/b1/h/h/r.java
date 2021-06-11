package d.a.n0.b1.h.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.d;
import d.a.i.i0;
import d.a.i.l0;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class r extends d.a.c.k.e.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public boolean o;
    public NEGFeedBackView.b p;
    public d.a.n0.z.b0<d.a.n0.z.e0.k> q;

    /* loaded from: classes4.dex */
    public class a implements d.b {
        public a(r rVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.m0.r.q.a aVar, View view) {
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
    public class b implements d.a.c.k.e.w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.a.n0.z.e0.k kVar;
            a2 a2Var;
            if (!(nVar instanceof d.a.n0.z.e0.k) || (kVar = (d.a.n0.z.e0.k) nVar) == null || (a2Var = kVar.f67177e) == null || a2Var.l1() == null) {
                return;
            }
            r.this.p0(kVar.f67177e, view);
            TiebaStatic.log(kVar.K());
            TiebaStatic.log(kVar.C());
            r.this.i0(kVar.f67177e, kVar.E());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.n0.z.b0<d.a.n0.z.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public boolean c(View view, d.a.n0.z.e0.k kVar, String str) {
            a2 a2Var;
            if (kVar == null || (a2Var = kVar.f67177e) == null || a2Var.l1() == null) {
                return false;
            }
            r.this.p0(kVar.f67177e, view);
            TiebaStatic.log(kVar.K());
            TiebaStatic.log(kVar.C());
            r.this.i0(kVar.f67177e, kVar.E());
            return true;
        }
    }

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.o = true;
        this.p = null;
        this.q = new c();
        this.n = tbPageContext;
        h0();
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
    }

    public final void h0() {
        d.a.n0.z.e0.k.g0 = "c13388";
        d.a.n0.z.e0.k.h0 = "c13389";
    }

    public final void i0(a2 a2Var, int i2) {
        if (a2Var == null || a2Var.l1() == null) {
            return;
        }
        d.a.n0.d3.c.g().c(this.m, d.a.n0.d3.a.j(a2Var, "a002", "common_click", 1, i2, a2Var.l1().id));
    }

    public final void j0(a2 a2Var, int i2) {
        if (a2Var == null || a2Var.l1() == null) {
            return;
        }
        String str = a2Var.l1().id;
        d.a.n0.d3.c.g().d(this.m, d.a.n0.d3.a.c(a2Var.z1(), "", str, null), d.a.n0.d3.a.k(a2Var, "a002", "common_exp", i2, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder<d.a.n0.z.e0.k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.r(false);
        dVar.w(false);
        dVar.c(1024);
        dVar.s(new a(this));
        bVar.o(dVar);
        d.a.i.x xVar = new d.a.i.x(this.n.getPageActivity());
        xVar.p("index");
        xVar.q(this.o);
        bVar.n(xVar);
        bVar.m(new i0(this.n.getPageActivity()));
        ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67177e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.p(false).u(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        d.a.n0.z.t.b().a(kVar.L());
        d.a.n0.o.d.c().i("page_recommend", "show_", kVar.L());
        j0(kVar.f67177e, kVar.E());
        return threadCardViewHolder.a();
    }

    public void m0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public final void p0(a2 a2Var, View view) {
        if (a2Var == null || a2Var.l1() == null) {
            return;
        }
        String str = a2Var.l1().id;
        String str2 = a2Var.l1().link;
        String str3 = a2Var.l1().h5_url;
        Long l = a2Var.l1().swan_app_id;
        long parseLong = Long.parseLong(a2Var.z1());
        long c0 = a2Var.c0();
        String str4 = a2Var.l1().name;
        d.a.m0.r.d0.b.j().w("smart_app_tid", parseLong);
        d.a.m0.r.d0.b.j().x("smart_app_name", str4);
        d.a.m0.r.d0.b.j().x("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!d.a.n0.u.a.b(str, str2, "1191008600000000", a2Var.l1().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            d.a.m0.l.a.l(view.getContext(), str3);
        }
        d.a.n0.z.m.a(a2Var.z1());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", c0).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", a2Var.l1().is_game.intValue()));
    }
}
