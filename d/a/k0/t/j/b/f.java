package d.a.k0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class f extends d.a.c.j.e.a<d.a.k0.t.j.d.h, CardViewHolder<d.a.k0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.g0();
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.j.d.h.f61776f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.k0.t.j.d.h hVar, d.a.k0.t.j.h.a aVar) {
        aVar.x(8);
        aVar.y(this.f39564e.getResources().getString(R.string.ala_income_value));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0() {
        d.a.j0.l.a.t(this.m.getPageActivity(), true, d.a.j0.r.d0.b.j().p("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives"), this.f39564e.getResources().getString(R.string.ala_income_value));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.k0.t.j.h.a> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.k0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.j.d.h hVar, CardViewHolder<d.a.k0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(hVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a());
        return cardViewHolder.b().l();
    }
}
