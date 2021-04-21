package d.b.j0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
/* loaded from: classes4.dex */
public class z extends d.b.c.j.e.a<d.b.j0.a1.b.f.c, ThreadCardViewHolder<d.b.j0.a1.b.f.c>> implements d.b.j0.m.f {
    public TbPageContext<?> m;
    public BdUniqueId n;
    public d.b.c.j.e.s o;
    public String p;
    public byte q;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
        this.q = b2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<d.b.j0.a1.b.f.c> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.m.getPageActivity(), false);
        bVar.n(new d.b.j0.a1.b.h.b(this.m, this.n, this.q));
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder<d.b.j0.a1.b.f.c> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.k(this.n);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.a1.b.f.c cVar, ThreadCardViewHolder<d.b.j0.a1.b.f.c> threadCardViewHolder) {
        threadCardViewHolder.f(cVar);
        if (threadCardViewHolder.b() != null) {
            threadCardViewHolder.b().q(i);
            threadCardViewHolder.b().setPage(this.p);
            threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
        return threadCardViewHolder.a();
    }

    public void j0(d.b.c.j.e.s sVar) {
        this.o = sVar;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.p = str;
    }
}
