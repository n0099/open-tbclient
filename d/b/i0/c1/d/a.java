package d.b.i0.c1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.h0.r.q.a2;
import d.b.i0.q0.k;
import d.b.i0.x.b0;
import d.b.i0.x.x;
import d.b.i0.x.y;
/* loaded from: classes4.dex */
public class a extends k<a2, CardViewHolder<x>> implements y {
    public TbPageContext w;
    public b0<a2> x;

    /* renamed from: d.b.i0.c1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1188a extends b0<a2> {
        public C1188a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void b(View view, a2 a2Var, Object obj) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = new C1188a(this);
        this.w = tbPageContext;
    }

    @Override // d.b.i0.x.y
    public String from() {
        return "FrsHottopicVideoDelegateAdapter";
    }

    @Override // d.b.i0.q0.k, d.b.i0.x.y
    public void i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f42855e = tbPageContext.getPageActivity();
            this.w = tbPageContext;
            this.i = bdUniqueId;
        }
    }

    @Override // d.b.i0.q0.k, d.b.i0.x.y
    public void setFrom(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public CardViewHolder<x> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new x(this.w, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: u0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, CardViewHolder<x> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().q(this.x);
        cardViewHolder.b().n(a2Var);
        return cardViewHolder.a();
    }
}
