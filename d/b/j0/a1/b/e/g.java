package d.b.j0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.j0.x.b0;
/* loaded from: classes4.dex */
public class g extends d.b.c.j.e.a<d.b.j0.x.e0.k, ThreadCardViewHolder<d.b.j0.x.e0.k>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public d.b.c.j.e.s q;
    public b0<d.b.j0.x.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.j0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.k kVar) {
            if (view == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            g.this.m0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.c.j.e.w {
        public b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.j0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.j0.x.e0.k kVar = (d.b.j0.x.e0.k) nVar;
                kVar.k = 1;
                if (g.this.r != null) {
                    g.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i.v vVar = new d.b.i.v(this.n.getPageActivity());
        vVar.r(ImageViewerConfig.FROM_CONCERN);
        vVar.s(this.p);
        bVar.n(vVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.k kVar, ThreadCardViewHolder<d.b.j0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f64193e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.b.j0.x.t.b().a(kVar.A("c12351"));
        threadCardViewHolder.b().q(i);
        if (threadCardViewHolder.b() instanceof d.b.j0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        return threadCardViewHolder.a();
    }

    public final void m0(View view, d.b.j0.x.e0.k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            d.b.j0.a1.b.c.b(view, kVar, 2);
        } else if (view instanceof TbImageView) {
            d.b.j0.a1.b.c.b(view, kVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            d.b.j0.a1.b.c.b(view, kVar, 2);
        }
    }

    public void n0(d.b.c.j.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.o = str;
    }
}
