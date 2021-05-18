package d.a.k0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaForbiddenListActivityConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.k0.t.j.d.e, CardViewHolder<d.a.k0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.g0();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.j.d.e.f61773f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.k0.t.j.d.e eVar, d.a.k0.t.j.h.a aVar) {
        aVar.x(8);
        aVar.y(this.f39564e.getResources().getString(R.string.ala_person_live_forbidden));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaForbiddenListActivityConfig(this.m.getPageActivity())));
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.j.d.e eVar, CardViewHolder<d.a.k0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(eVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a());
        return cardViewHolder.b().l();
    }
}
