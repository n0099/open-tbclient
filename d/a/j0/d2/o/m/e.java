package d.a.j0.d2.o.m;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i.k0;
import d.a.i.s;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e extends d.a.c.j.e.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public BdTypeRecyclerView o;

    /* loaded from: classes3.dex */
    public class a implements w {
        public a(e eVar) {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            z1 z1Var;
            a2 a2Var;
            if (!(nVar instanceof z1) || (a2Var = (z1Var = (z1) nVar).w) == null || !z1Var.r || a2Var.y0() == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("itemID", String.valueOf(z1Var.w.y0().item_id));
            hashMap.put("source", 3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
        this.m = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        bVar.l().e(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36));
        s sVar = new s(this.n.getPageActivity());
        sVar.s();
        bVar.h(sVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new a(this));
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = B(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void g0(BdTypeRecyclerView bdTypeRecyclerView) {
        this.o = bdTypeRecyclerView;
    }
}
