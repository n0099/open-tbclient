package d.b.i0.x.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class d extends d.b.c.j.e.a<e, CardViewHolder<f>> {
    public f m;
    public TbPageContext<?> n;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), e.f63807f);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder R(ViewGroup viewGroup) {
        this.m = new f(this.n);
        return new CardViewHolder(this.m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, e eVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(eVar);
        return cardViewHolder.a();
    }
}
