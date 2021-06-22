package d.a.o0.v.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class f extends d.a.c.k.e.a<d.a.o0.v.j.d.h, CardViewHolder<d.a.o0.v.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.h0();
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.j.d.h.f65904f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.o0.v.j.d.h hVar, d.a.o0.v.j.h.a aVar) {
        aVar.y(8);
        aVar.z(this.f43012e.getResources().getString(R.string.ala_income_value));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0() {
        d.a.n0.l.a.t(this.m.getPageActivity(), true, d.a.n0.r.d0.b.j().p("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives"), this.f43012e.getResources().getString(R.string.ala_income_value));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.a.o0.v.j.h.a> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.v.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.j.d.h hVar, CardViewHolder<d.a.o0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        g0(hVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a());
        return cardViewHolder.b().m();
    }
}
