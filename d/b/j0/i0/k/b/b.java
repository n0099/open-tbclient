package d.b.j0.i0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.x.b0;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.j0.i0.k.c.c, CardViewHolder<d.b.j0.i0.k.d.b>> {
    public TbPageContext<?> m;
    public b0<d.b.j0.i0.k.c.c> n;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.j0.i0.k.c.c> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.i0.k.c.c cVar) {
            if (cVar == null) {
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.i0.k.c.c.f57190g);
        this.n = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.i0.k.d.b> R(ViewGroup viewGroup) {
        d.b.j0.i0.k.d.b bVar = new d.b.j0.i0.k.d.b(this.m);
        bVar.r(this.i);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.i0.k.c.c cVar, CardViewHolder<d.b.j0.i0.k.d.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(cVar);
        cardViewHolder.b().q(this.n);
        return cardViewHolder.a();
    }
}
