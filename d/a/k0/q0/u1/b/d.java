package d.a.k0.q0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.x.b0;
import d.a.k0.x.f;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<d.a.k0.d0.d, CardViewHolder<d.a.k0.x.f>> {
    public TbPageContext<?> m;
    public d.a.k0.x.f n;
    public b0 o;
    public String p;

    /* loaded from: classes4.dex */
    public class a implements f.a {
        public a() {
        }

        @Override // d.a.k0.x.f.a
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (d.this.o != null) {
                d.this.o.a(view, baseCardInfo);
            }
        }
    }

    public d(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.a.k0.d0.d.f52563f);
        this.m = tbPageContext;
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder<d.a.k0.x.f> P(ViewGroup viewGroup) {
        this.n = new d.a.k0.x.f(this.m, this.p);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.d0.d dVar, CardViewHolder<d.a.k0.x.f> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(dVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().v(new a());
        return cardViewHolder.b().l();
    }

    public void h0(b0 b0Var) {
        this.o = b0Var;
    }
}
