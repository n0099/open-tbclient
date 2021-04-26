package d.a.j0.c1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.i0.r.q.a2;
import d.a.j0.q0.k;
import d.a.j0.x.b0;
import d.a.j0.x.x;
import d.a.j0.x.y;
/* loaded from: classes4.dex */
public class a extends k<a2, CardViewHolder<x>> implements y {
    public TbPageContext w;
    public b0<a2> x;

    /* renamed from: d.a.j0.c1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1150a extends b0<a2> {
        public C1150a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void b(View view, a2 a2Var, Object obj) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = new C1150a(this);
        this.w = tbPageContext;
    }

    @Override // d.a.j0.x.y
    public String from() {
        return "FrsHottopicVideoDelegateAdapter";
    }

    @Override // d.a.j0.q0.k, d.a.j0.x.y
    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f40319e = tbPageContext.getPageActivity();
            this.w = tbPageContext;
            this.f40323i = bdUniqueId;
        }
    }

    @Override // d.a.j0.q0.k, d.a.j0.x.y
    public void setFrom(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public CardViewHolder<x> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new x(this.w, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: u0 */
    public View W(int i2, View view, ViewGroup viewGroup, a2 a2Var, CardViewHolder<x> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().o(this.x);
        cardViewHolder.b().m(a2Var);
        return cardViewHolder.a();
    }
}
