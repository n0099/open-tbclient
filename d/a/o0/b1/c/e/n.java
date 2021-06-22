package d.a.o0.b1.c.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class n extends d.a.c.k.e.a<d.a.o0.z.e0.k, ThreadCardViewHolder<d.a.o0.z.e0.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.c.k.e.s o;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.k.e.w {
        public a(n nVar) {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.o0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                kVar.k = 1;
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 1, false);
                ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0602a(1));
            }
        }
    }

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<d.a.o0.z.e0.k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.s sVar = new d.a.i.s(this.n.getPageActivity());
        sVar.s();
        bVar.h(sVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        a0(new a(this));
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void h0(d.a.c.k.e.s sVar) {
        this.o = sVar;
    }
}
