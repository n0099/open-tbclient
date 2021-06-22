package d.a.o0.j0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.o0.z.b0;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<d.a.o0.j0.k.c.c, CardViewHolder<d.a.o0.j0.k.d.b>> {
    public TbPageContext<?> m;
    public b0<d.a.o0.j0.k.c.c> n;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.o0.j0.k.c.c> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.j0.k.c.c cVar) {
            if (cVar == null) {
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.j0.k.c.c.f59825g);
        this.n = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.j0.k.d.b> Q(ViewGroup viewGroup) {
        d.a.o0.j0.k.d.b bVar = new d.a.o0.j0.k.d.b(this.m);
        bVar.q(this.f43016i);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.j0.k.c.c cVar, CardViewHolder<d.a.o0.j0.k.d.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(cVar);
        cardViewHolder.b().p(this.n);
        return cardViewHolder.a();
    }
}
