package d.a.k0.x.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<e, CardViewHolder<f>> {
    public f m;
    public TbPageContext<?> n;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), e.f63218f);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder P(ViewGroup viewGroup) {
        this.m = new f(this.n);
        return new CardViewHolder(this.m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, e eVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(eVar);
        return cardViewHolder.a();
    }
}
