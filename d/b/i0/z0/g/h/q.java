package d.b.i0.z0.g.h;

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
import d.b.h0.r.q.a2;
import d.b.i.d;
import d.b.i.h0;
import d.b.i.k0;
/* loaded from: classes3.dex */
public class q extends d.b.b.j.e.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public boolean o;
    public NEGFeedBackView.b p;
    public d.b.i0.x.b0<d.b.i0.x.e0.k> q;

    /* loaded from: classes3.dex */
    public class a implements d.b {
        public a(q qVar) {
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

    /* loaded from: classes3.dex */
    public class b implements d.b.b.j.e.w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            d.b.i0.x.e0.k kVar;
            a2 a2Var;
            if (!(nVar instanceof d.b.i0.x.e0.k) || (kVar = (d.b.i0.x.e0.k) nVar) == null || (a2Var = kVar.f62197e) == null || a2Var.j1() == null) {
                return;
            }
            q.this.q0(kVar.f62197e, view);
            TiebaStatic.log(kVar.K());
            TiebaStatic.log(kVar.C());
            q.this.l0(kVar.f62197e, kVar.E());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.i0.x.b0<d.b.i0.x.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public boolean c(View view, d.b.i0.x.e0.k kVar, String str) {
            a2 a2Var;
            if (kVar == null || (a2Var = kVar.f62197e) == null || a2Var.j1() == null) {
                return false;
            }
            q.this.q0(kVar.f62197e, view);
            TiebaStatic.log(kVar.K());
            TiebaStatic.log(kVar.C());
            q.this.l0(kVar.f62197e, kVar.E());
            return true;
        }
    }

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.o = true;
        this.p = null;
        this.q = new c();
        this.n = tbPageContext;
        j0();
    }

    public final void j0() {
        d.b.i0.x.e0.k.f0 = "c13388";
        d.b.i0.x.e0.k.g0 = "c13389";
    }

    public final void l0(a2 a2Var, int i) {
        if (a2Var == null || a2Var.j1() == null) {
            return;
        }
        d.b.i0.b3.c.g().c(this.m, d.b.i0.b3.a.j(a2Var, "a002", "common_click", 1, i, a2Var.j1().id));
    }

    public final void m0(a2 a2Var, int i) {
        if (a2Var == null || a2Var.j1() == null) {
            return;
        }
        String str = a2Var.j1().id;
        d.b.i0.b3.c.g().d(this.m, d.b.i0.b3.a.c(a2Var.w1(), "", str, null), d.b.i0.b3.a.k(a2Var, "a002", "common_exp", i, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: n0 */
    public ThreadCardViewHolder<d.b.i0.x.e0.k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.r(false);
        dVar.w(false);
        dVar.c(1024);
        dVar.s(new a(this));
        bVar.o(dVar);
        d.b.i.x xVar = new d.b.i.x(this.n.getPageActivity());
        xVar.p("index");
        xVar.q(this.o);
        bVar.n(xVar);
        bVar.m(new h0(this.n.getPageActivity()));
        ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62197e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.p(false).u(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        d.b.i0.x.t.b().a(kVar.L());
        d.b.i0.m.d.c().i("page_recommend", "show_", kVar.L());
        m0(kVar.f62197e, kVar.E());
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
        long parseLong = Long.parseLong(a2Var.w1());
        long c0 = a2Var.c0();
        String str4 = a2Var.j1().name;
        d.b.h0.r.d0.b.i().v("smart_app_tid", parseLong);
        d.b.h0.r.d0.b.i().w("smart_app_name", str4);
        d.b.h0.r.d0.b.i().w("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!d.b.i0.s.a.b(str, str2, "1191008600000000", a2Var.j1().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            d.b.h0.l.a.l(view.getContext(), str3);
        }
        d.b.i0.x.m.a(a2Var.w1());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", c0).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", a2Var.j1().is_game.intValue()));
    }
}
