package d.a.n0.v.j.b;

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
public class b extends d.a.c.k.e.a<d.a.n0.v.j.d.e, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.h0();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.e.f65776f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.n0.v.j.d.e eVar, d.a.n0.v.j.h.a aVar) {
        aVar.y(8);
        aVar.z(this.f42909e.getResources().getString(R.string.ala_person_live_forbidden));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaForbiddenListActivityConfig(this.m.getPageActivity())));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.a.n0.v.j.h.a> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.v.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.e eVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        g0(eVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a());
        return cardViewHolder.b().m();
    }
}
