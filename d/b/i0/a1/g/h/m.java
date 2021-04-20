package d.b.i0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class m extends d.b.c.j.e.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.c.j.e.s o;

    /* loaded from: classes4.dex */
    public class a implements d.b.c.j.e.w {
        public a(m mVar) {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) ((d.b.i0.x.e0.k) nVar), view.getContext(), 2, false);
                ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1131a(1));
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<d.b.i0.x.e0.k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        bVar.h(new d.b.i.a0(this.n.getPageActivity()));
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new a(this));
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63772e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void j0(d.b.c.j.e.s sVar) {
        this.o = sVar;
    }
}
