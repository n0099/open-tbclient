package d.b.i0.z0.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
/* loaded from: classes4.dex */
public class b extends d.b.b.j.e.a<d.b.i0.z0.g.j.f, ThreadCardViewHolder<d.b.i0.z0.g.j.f>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.b.j.e.s o;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<d.b.i0.z0.g.j.f> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        bVar.n(new d.b.i0.z0.g.n.a(this.n, this.m));
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder<d.b.i0.z0.g.j.f> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.k(this.m);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.z0.g.j.f fVar, ThreadCardViewHolder<d.b.i0.z0.g.j.f> threadCardViewHolder) {
        if (fVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.f(fVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        d.b.i0.x.t.b().a(fVar.A());
        d.b.i0.m.d.c().a(fVar.A());
        return threadCardViewHolder.a();
    }

    public void j0(BdUniqueId bdUniqueId) {
        this.m = bdUniqueId;
    }
}
