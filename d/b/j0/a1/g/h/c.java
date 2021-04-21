package d.b.j0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class c extends d.b.j0.a1.a<d.b.j0.x.e0.e, ThreadCardViewHolder<d.b.j0.x.e0.e>> implements d.b.j0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public NEGFeedBackView.b q;
    public d.b.c.j.e.s r;
    public d.b.j0.x.b0<d.b.j0.x.e0.e> s;

    /* loaded from: classes4.dex */
    public class a extends d.b.j0.x.b0<d.b.j0.x.e0.e> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.e eVar) {
            d.b.j0.x.t.b().d(true);
            d.b.j0.m.d.c().h("page_recommend", "show_");
            if (view == null || eVar == null || eVar.n() == null || StringUtils.isNull(eVar.n().w1())) {
                return;
            }
            c.this.o0(view, eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.c.j.e.w {
        public b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c.this.l0(view, nVar);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.o = tbPageContext;
    }

    public final void l0(View view, d.b.c.j.e.n nVar) {
        if ((nVar instanceof d.b.j0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.b.j0.x.e0.e eVar = (d.b.j0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) eVar, view.getContext(), 2, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1072a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder<d.b.j0.x.e0.e> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.v(this.o);
        bVar.o(dVar);
        bVar.n(new d.b.i.b(this.o.getPageActivity()));
        bVar.h(new d.b.i.k(this.o.getPageActivity()));
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 1;
        eVar.f51512h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        bVar.l().d(d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.r);
        k.r(2);
        ThreadCardViewHolder<d.b.j0.x.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.e eVar, ThreadCardViewHolder<d.b.j0.x.e0.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        eVar.U(eVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.p(true).u(this.q);
        threadCardViewHolder.m(eVar.w(), this.m);
        threadCardViewHolder.f(eVar);
        threadCardViewHolder.b().p(this.s);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        d.b.j0.x.t.b().a(eVar.L());
        return threadCardViewHolder.a();
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.p = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(View view, d.b.j0.x.e0.e eVar) {
        int i;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(eVar.K());
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            i = 2;
            if (i == 0) {
                d.b.j0.a1.g.m.a.a(eVar.f64193e, this.n, eVar.E(), i);
                return;
            }
            return;
        } else {
            int i2 = R.id.cover_img;
        }
        i = 0;
        if (i == 0) {
        }
    }

    public void p0(NEGFeedBackView.b bVar) {
        this.q = bVar;
    }

    public void q0(d.b.c.j.e.s sVar) {
        this.r = sVar;
    }
}
