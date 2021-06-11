package d.a.n0.b1.c.e;

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
import d.a.i.l0;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class j extends d.a.c.k.e.a<d.a.n0.z.e0.l, ThreadCardViewHolder<d.a.n0.z.e0.l>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.a.c.k.e.s q;
    public d.a.i.i r;
    public b0<d.a.n0.z.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.z.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.l lVar) {
            BdToast.i(j.this.o.getContext(), j.this.o.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.k.e.w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            BdToast.i(j.this.o.getContext(), j.this.o.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<d.a.n0.z.e0.l> N(ViewGroup viewGroup, d.a.n0.z.e0.l lVar) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        d.a.i.i iVar = new d.a.i.i(this.o.getPageActivity());
        this.r = iVar;
        iVar.q(this.m);
        bVar.n(this.r);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        ThreadCardViewHolder<d.a.n0.z.e0.l> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        k.p(this.s);
        k.r(1);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<d.a.n0.z.e0.l> Q(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View T(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.l lVar, ThreadCardViewHolder<d.a.n0.z.e0.l> threadCardViewHolder) {
        if (lVar == null) {
            return threadCardViewHolder.a();
        }
        if (threadCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.a.n0.z.t.b().a(lVar.A("c12351"));
        threadCardViewHolder.b().q(i2);
        lVar.V = 0;
        if (threadCardViewHolder.b() instanceof d.a.n0.o.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(lVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        return threadCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.l lVar, ThreadCardViewHolder<d.a.n0.z.e0.l> threadCardViewHolder) {
        return null;
    }

    public void k0(d.a.c.k.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId v() {
        return d.a.n0.z.e0.b.P;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId w() {
        return d.a.n0.z.e0.b.N;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId x() {
        return d.a.n0.z.e0.b.O;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId y() {
        BdUniqueId bdUniqueId = this.n;
        return bdUniqueId != null ? bdUniqueId : d.a.n0.z.e0.b.G;
    }
}
