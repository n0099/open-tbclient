package d.a.n0.r0.n1.d;

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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e extends d.a.c.k.e.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public BdTypeRecyclerView o;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.k.e.w {
        public a() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z = nVar instanceof z1;
            if (z) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.getType() == a2.C3) {
                    BdToast.i(e.this.n.getContext(), e.this.n.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                    return;
                }
                a2 a2Var = z1Var.w;
                if (a2Var != null && z1Var.r && a2Var.z0() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(z1Var.w.z0().item_id));
                    hashMap.put("source", 10);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.n0.e3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                    return;
                }
            }
            if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                a2 a2Var2 = ((z1) nVar).w;
                a2Var2.objType = 1;
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var2, view.getContext(), 2, false);
                ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0600a(1));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
        this.m = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.s sVar = new d.a.i.s(this.n.getPageActivity());
        sVar.s();
        bVar.h(sVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        a0(new a());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
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

    public void i0(BdTypeRecyclerView bdTypeRecyclerView) {
        this.o = bdTypeRecyclerView;
    }
}
