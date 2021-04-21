package d.b.j0.q0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.x.b0;
import d.b.j0.x.f;
/* loaded from: classes4.dex */
public class d extends d.b.c.j.e.a<d.b.j0.d0.d, CardViewHolder<d.b.j0.x.f>> {
    public TbPageContext<?> m;
    public d.b.j0.x.f n;
    public b0 o;
    public String p;

    /* loaded from: classes4.dex */
    public class a implements f.a {
        public a() {
        }

        @Override // d.b.j0.x.f.a
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (d.this.o != null) {
                d.this.o.a(view, baseCardInfo);
            }
        }
    }

    public d(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.b.j0.d0.d.f54090f);
        this.m = tbPageContext;
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.b.j0.x.f> R(ViewGroup viewGroup) {
        this.n = new d.b.j0.x.f(this.m, this.p);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.d0.d dVar, CardViewHolder<d.b.j0.x.f> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(dVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().x(new a());
        return cardViewHolder.b().m();
    }

    public void l0(b0 b0Var) {
        this.o = b0Var;
    }
}
