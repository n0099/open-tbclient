package d.a.k0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class k extends d.a.c.j.e.a<d.a.k0.x.e0.k, ThreadCardViewHolder<d.a.k0.x.e0.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.c.j.e.s o;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.j.e.w {
        public a(k kVar) {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.a.k0.x.e0.k kVar;
            a2 a2Var;
            boolean z = nVar instanceof d.a.k0.x.e0.k;
            if (z && (kVar = (d.a.k0.x.e0.k) nVar) != null && kVar.y && (a2Var = kVar.f63179e) != null && a2Var.y0() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("itemID", String.valueOf(kVar.f63179e.y0().item_id));
                hashMap.put("source", 1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.k0.d3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
            } else if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.k0.x.e0.k kVar2 = (d.a.k0.x.e0.k) nVar;
                kVar2.k = 1;
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) kVar2, view.getContext(), 4, false);
                ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0549a(1));
            }
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<d.a.k0.x.e0.k> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.s sVar = new d.a.i.s(this.n.getPageActivity());
        sVar.s();
        bVar.h(sVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new a(this));
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.k kVar, ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63179e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void g0(d.a.c.j.e.s sVar) {
        this.o = sVar;
    }
}
