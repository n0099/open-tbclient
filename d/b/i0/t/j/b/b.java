package d.b.i0.t.j.b;

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
public class b extends d.b.c.j.e.a<d.b.i0.t.j.d.e, CardViewHolder<d.b.i0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.j0();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.j.d.e.f62429f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.j.d.e eVar, d.b.i0.t.j.h.a aVar) {
        aVar.z(8);
        aVar.A(this.f42855e.getResources().getString(R.string.ala_person_live_forbidden));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaForbiddenListActivityConfig(this.m.getPageActivity())));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public CardViewHolder<d.b.i0.t.j.h.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.j.d.e eVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        i0(eVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a());
        return cardViewHolder.b().m();
    }
}
