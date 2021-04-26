package d.a.j0.i0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.j0.i0.k.c.c, CardViewHolder<d.a.j0.i0.k.d.b>> {
    public TbPageContext<?> m;
    public b0<d.a.j0.i0.k.c.c> n;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.j0.i0.k.c.c> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.i0.k.c.c cVar) {
            if (cVar == null) {
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.i0.k.c.c.f55120g);
        this.n = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.i0.k.d.b> P(ViewGroup viewGroup) {
        d.a.j0.i0.k.d.b bVar = new d.a.j0.i0.k.d.b(this.m);
        bVar.p(this.f40323i);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.i0.k.c.c cVar, CardViewHolder<d.a.j0.i0.k.d.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(cVar);
        cardViewHolder.b().o(this.n);
        return cardViewHolder.a();
    }
}
