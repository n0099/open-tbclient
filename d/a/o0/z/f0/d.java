package d.a.o0.z.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<e, CardViewHolder<f>> {
    public f m;
    public TbPageContext<?> n;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), e.f67341f);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder Q(ViewGroup viewGroup) {
        this.m = new f(this.n);
        return new CardViewHolder(this.m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, e eVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(eVar);
        return cardViewHolder.a();
    }
}
