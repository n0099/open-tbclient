package d.a.j0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.g0;
import d.a.i.k0;
import d.a.i.u0.a;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class t extends d.a.c.j.e.a<d.a.j0.x.e0.k, ThreadCardViewHolder<d.a.j0.x.e0.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.c.j.e.s o;
    public b0<d.a.j0.x.e0.k> p;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.j0.x.e0.k> {
        public a(t tVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.k kVar) {
            ThreadCardViewHolder threadCardViewHolder;
            super.a(view, kVar);
            if (kVar == null || kVar.m() == null || (threadCardViewHolder = (ThreadCardViewHolder) view.getTag()) == null) {
                return;
            }
            ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar.m(), view.getContext(), 1, false);
            threadCardViewHolder.b().o(new a.C1011a(1));
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
                if (t.this.p != null) {
                    t.this.p.a(threadCardViewHolder.a(), kVar);
                }
            }
        }
    }

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<d.a.j0.x.e0.k> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        bVar.h(new g0(this.n.getPageActivity()));
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(1);
        ThreadCardViewHolder<d.a.j0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.k kVar, ThreadCardViewHolder<d.a.j0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void h0(d.a.c.j.e.s sVar) {
        this.o = sVar;
    }
}
