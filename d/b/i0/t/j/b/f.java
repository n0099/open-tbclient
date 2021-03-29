package d.b.i0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class f extends d.b.b.j.e.a<d.b.i0.t.j.d.h, CardViewHolder<d.b.i0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.j0();
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.j.d.h.f60868f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.j.d.h hVar, d.b.i0.t.j.h.a aVar) {
        aVar.z(8);
        aVar.A(this.f42358e.getResources().getString(R.string.ala_income_value));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0() {
        d.b.h0.l.a.t(this.m.getPageActivity(), true, d.b.h0.r.d0.b.i().o("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives"), this.f42358e.getResources().getString(R.string.ala_income_value));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public CardViewHolder<d.b.i0.t.j.h.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.j.d.h hVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        i0(hVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a());
        return cardViewHolder.b().m();
    }
}
