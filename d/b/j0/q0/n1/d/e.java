package d.b.j0.q0.n1.d;

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
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public BdTypeRecyclerView o;

    /* loaded from: classes4.dex */
    public class a implements d.b.c.j.e.w {
        public a() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z = nVar instanceof z1;
            if (z) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.getType() == a2.x3) {
                    BdToast.i(e.this.n.getContext(), e.this.n.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                    return;
                }
                a2 a2Var = z1Var.w;
                if (a2Var != null && z1Var.r && a2Var.y0() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(z1Var.w.y0().item_id));
                    hashMap.put("source", 10);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.j0.d3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                    return;
                }
            }
            if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                a2 a2Var2 = ((z1) nVar).w;
                a2Var2.objType = 1;
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) a2Var2, view.getContext(), 2, false);
                ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1072a(1));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
        this.m = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i.s sVar = new d.b.i.s(this.n.getPageActivity());
        sVar.s();
        bVar.h(sVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new a());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = E(i) + 1;
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void l0(BdTypeRecyclerView bdTypeRecyclerView) {
        this.o = bdTypeRecyclerView;
    }
}
