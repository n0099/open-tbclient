package d.a.o0.d1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.r.q.a2;
import d.a.o0.r0.k;
import d.a.o0.z.b0;
import d.a.o0.z.x;
import d.a.o0.z.y;
/* loaded from: classes4.dex */
public class a extends k<a2, CardViewHolder<x>> implements y {
    public TbPageContext w;
    public b0<a2> x;

    /* renamed from: d.a.o0.d1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1299a extends b0<a2> {
        public C1299a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void b(View view, a2 a2Var, Object obj) {
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = new C1299a(this);
        this.w = tbPageContext;
    }

    @Override // d.a.o0.z.y
    public String from() {
        return "FrsHottopicVideoDelegateAdapter";
    }

    @Override // d.a.o0.r0.k, d.a.o0.z.y
    public void o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f43012e = tbPageContext.getPageActivity();
            this.w = tbPageContext;
            this.f43016i = bdUniqueId;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public CardViewHolder<x> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new x(this.w, viewGroup));
    }

    @Override // d.a.o0.r0.k, d.a.o0.z.y
    public void setFrom(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: t0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, CardViewHolder<x> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().p(this.x);
        cardViewHolder.b().n(a2Var);
        return cardViewHolder.a();
    }
}
