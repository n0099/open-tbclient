package d.b.j0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<d.b.j0.t.j.d.g, CardViewHolder<d.b.j0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.t.j.d.g f62813e;

        public a(d.b.j0.t.j.d.g gVar) {
            this.f62813e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.j0(this.f62813e);
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.t.j.d.g.f62852f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.j0.t.j.d.g gVar, d.b.j0.t.j.h.a aVar) {
        if (gVar.g() == null) {
            return;
        }
        aVar.z(0);
        aVar.A(this.f43095e.getResources().getString(R.string.ala_person_live_admin));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(d.b.j0.t.j.d.g gVar) {
        if (gVar == null || gVar.g() == null) {
            return;
        }
        d.b.j0.t.j.d.c g2 = gVar.g();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaAdminListActivityConfig(this.m.getPageActivity(), (g2.b() == null || !g2.c()) ? "" : g2.b().live_id)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public CardViewHolder<d.b.j0.t.j.h.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.j.d.g gVar, CardViewHolder<d.b.j0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        i0(gVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(gVar));
        return cardViewHolder.b().m();
    }
}
