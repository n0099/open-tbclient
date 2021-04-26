package d.a.j0.a1.g.h;

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
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.u0.a;
/* loaded from: classes4.dex */
public class c extends d.a.j0.a1.a<d.a.j0.x.e0.e, ThreadCardViewHolder<d.a.j0.x.e0.e>> implements d.a.j0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public NEGFeedBackView.b q;
    public d.a.c.j.e.s r;
    public d.a.j0.x.b0<d.a.j0.x.e0.e> s;

    /* loaded from: classes4.dex */
    public class a extends d.a.j0.x.b0<d.a.j0.x.e0.e> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.e eVar) {
            d.a.j0.x.t.b().d(true);
            d.a.j0.m.d.c().h("page_recommend", "show_");
            if (view == null || eVar == null || eVar.m() == null || StringUtils.isNull(eVar.m().w1())) {
                return;
            }
            c.this.m0(view, eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            c.this.h0(view, nVar);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.o = tbPageContext;
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.p = str;
    }

    public final void h0(View view, d.a.c.j.e.n nVar) {
        if ((nVar instanceof d.a.j0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.j0.x.e0.e eVar = (d.a.j0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) eVar, view.getContext(), 2, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1011a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<d.a.j0.x.e0.e> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.v(this.o);
        bVar.o(dVar);
        bVar.n(new d.a.i.b(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        m0 m0Var = new m0(this.o.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 1;
        eVar.f49137h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        bVar.l().d(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.r);
        k.r(2);
        ThreadCardViewHolder<d.a.j0.x.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.n);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.e eVar, ThreadCardViewHolder<d.a.j0.x.e0.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        eVar.U(eVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.o(true).u(this.q);
        threadCardViewHolder.l(eVar.w(), this.m);
        threadCardViewHolder.f(eVar);
        threadCardViewHolder.b().p(this.s);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        d.a.j0.x.t.b().a(eVar.L());
        return threadCardViewHolder.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m0(View view, d.a.j0.x.e0.e eVar) {
        int i2;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(eVar.K());
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            i2 = 2;
            if (i2 == 0) {
                d.a.j0.a1.g.m.a.a(eVar.f62455e, this.n, eVar.E(), i2);
                return;
            }
            return;
        } else {
            int i3 = R.id.cover_img;
        }
        i2 = 0;
        if (i2 == 0) {
        }
    }

    public void n0(NEGFeedBackView.b bVar) {
        this.q = bVar;
    }

    public void p0(d.a.c.j.e.s sVar) {
        this.r = sVar;
    }
}
