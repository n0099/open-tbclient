package d.a.n0.r0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.z.b0;
import d.a.n0.z.f;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<d.a.n0.e0.d, CardViewHolder<d.a.n0.z.f>> {
    public TbPageContext<?> m;
    public d.a.n0.z.f n;
    public b0 o;
    public String p;

    /* loaded from: classes4.dex */
    public class a implements f.a {
        public a() {
        }

        @Override // d.a.n0.z.f.a
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (d.this.o != null) {
                d.this.o.a(view, baseCardInfo);
            }
        }
    }

    public d(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.a.n0.e0.d.f56457f);
        this.m = tbPageContext;
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<d.a.n0.z.f> Q(ViewGroup viewGroup) {
        this.n = new d.a.n0.z.f(this.m, this.p);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.e0.d dVar, CardViewHolder<d.a.n0.z.f> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(dVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().w(new a());
        return cardViewHolder.b().m();
    }

    public void i0(b0 b0Var) {
        this.o = b0Var;
    }
}
