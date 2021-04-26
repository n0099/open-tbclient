package d.a.j0.a1.b.e;

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
import d.a.i.k0;
import d.a.i.u0.a;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class g extends d.a.c.j.e.a<d.a.j0.x.e0.k, ThreadCardViewHolder<d.a.j0.x.e0.k>> implements d.a.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public d.a.c.j.e.s q;
    public b0<d.a.j0.x.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.j0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.k kVar) {
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().w1())) {
                return;
            }
            g.this.i0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.j0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.j0.x.e0.k kVar = (d.a.j0.x.e0.k) nVar;
                kVar.k = 1;
                if (g.this.r != null) {
                    g.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.a.i.v vVar = new d.a.i.v(this.n.getPageActivity());
        vVar.r(ImageViewerConfig.FROM_CONCERN);
        vVar.s(this.p);
        bVar.n(vVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.k kVar, ThreadCardViewHolder<d.a.j0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.a.j0.x.t.b().a(kVar.A("c12351"));
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.j0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        return threadCardViewHolder.a();
    }

    public final void i0(View view, d.a.j0.x.e0.k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            d.a.j0.a1.b.c.b(view, kVar, 2);
        } else if (view instanceof TbImageView) {
            d.a.j0.a1.b.c.b(view, kVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            d.a.j0.a1.b.c.b(view, kVar, 2);
        }
    }

    public void j0(d.a.c.j.e.s sVar) {
        this.q = sVar;
    }
}
