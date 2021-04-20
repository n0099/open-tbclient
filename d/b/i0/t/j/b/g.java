package d.b.i0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaFansFamilyActivityConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class g extends d.b.c.j.e.a<d.b.i0.t.j.d.j, CardViewHolder<d.b.i0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.j.d.j f62395e;

        public a(d.b.i0.t.j.d.j jVar) {
            this.f62395e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.j0(this.f62395e);
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.j.d.j.f62433f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.j.d.j jVar, d.b.i0.t.j.h.a aVar) {
        if (jVar.g() == null) {
            return;
        }
        aVar.z(8);
        aVar.A(this.f42855e.getResources().getString(R.string.ala_person_live_my_fans_family));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(d.b.i0.t.j.d.j jVar) {
        if (jVar == null || jVar.g() == null) {
            return;
        }
        TiebaStatic.log("c13134");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaFansFamilyActivityConfig(this.f42855e, jVar.g().b().user_id, true, AlaFansFamilyActivityConfig.FROM_PERSON_CENTER)));
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
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.j.d.j jVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        TiebaStatic.log("c13133");
        i0(jVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(jVar));
        return cardViewHolder.b().m();
    }
}
