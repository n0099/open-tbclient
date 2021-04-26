package d.a.j0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.k0;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class j extends d.a.c.j.e.a<d.a.j0.x.e0.l, ThreadCardViewHolder<d.a.j0.x.e0.l>> implements d.a.j0.m.f {
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.a.c.j.e.s q;
    public d.a.i.i r;
    public b0<d.a.j0.x.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.j0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.l lVar) {
            BdToast.i(j.this.o.getContext(), j.this.o.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            BdToast.i(j.this.o.getContext(), j.this.o.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<d.a.j0.x.e0.l> M(ViewGroup viewGroup, d.a.j0.x.e0.l lVar) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        d.a.i.i iVar = new d.a.i.i(this.o.getPageActivity());
        this.r = iVar;
        iVar.q(this.m);
        bVar.n(this.r);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        ThreadCardViewHolder<d.a.j0.x.e0.l> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        k.p(this.s);
        k.r(1);
        Z(new b());
        return threadCardViewHolder;
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<d.a.j0.x.e0.l> P(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View S(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.l lVar, ThreadCardViewHolder<d.a.j0.x.e0.l> threadCardViewHolder) {
        if (lVar == null) {
            return threadCardViewHolder.a();
        }
        if (threadCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.a.j0.x.t.b().a(lVar.A("c12351"));
        threadCardViewHolder.b().q(i2);
        lVar.U = 0;
        if (threadCardViewHolder.b() instanceof d.a.j0.m.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(lVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        return threadCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.l lVar, ThreadCardViewHolder<d.a.j0.x.e0.l> threadCardViewHolder) {
        return null;
    }

    public void j0(d.a.c.j.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId u() {
        return d.a.j0.x.e0.b.O;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId v() {
        return d.a.j0.x.e0.b.M;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId w() {
        return d.a.j0.x.e0.b.N;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId x() {
        BdUniqueId bdUniqueId = this.n;
        return bdUniqueId != null ? bdUniqueId : d.a.j0.x.e0.b.F;
    }
}
