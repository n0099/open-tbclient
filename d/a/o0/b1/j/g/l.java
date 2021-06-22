package d.a.o0.b1.j.g;

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
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class l extends d.a.c.k.e.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;

    /* loaded from: classes4.dex */
    public class a implements w {
        public a(l lVar) {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            z1 z1Var;
            a2 a2Var;
            boolean z = nVar instanceof z1;
            if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                if (z && (z1Var = (z1) nVar) != null && z1Var.r && (a2Var = z1Var.w) != null && a2Var.z0() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(z1Var.w.z0().item_id));
                    hashMap.put("source", 1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.o0.e3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                    return;
                }
                a2 a2Var2 = ((z1) nVar).w;
                a2Var2.objType = 1;
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) a2Var2, view.getContext(), 2, false);
                ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0602a(1));
            }
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
        this.m = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.s sVar = new d.a.i.s(this.n.getPageActivity());
        sVar.s();
        bVar.h(sVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        a0(new a(this));
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.O1 = F(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void h0(s sVar) {
        this.o = sVar;
    }
}
