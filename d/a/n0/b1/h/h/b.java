package d.a.n0.b1.h.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<d.a.n0.b1.h.j.f, ThreadCardViewHolder<d.a.n0.b1.h.j.f>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.c.k.e.s o;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<d.a.n0.b1.h.j.f> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        bVar.n(new d.a.n0.b1.h.n.a(this.n, this.m));
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder<d.a.n0.b1.h.j.f> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.k(this.m);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.h.j.f fVar, ThreadCardViewHolder<d.a.n0.b1.h.j.f> threadCardViewHolder) {
        if (fVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.f(fVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        d.a.n0.z.t.b().a(fVar.A());
        d.a.n0.o.d.c().a(fVar.A());
        return threadCardViewHolder.a();
    }

    public void h0(BdUniqueId bdUniqueId) {
        this.m = bdUniqueId;
    }
}
