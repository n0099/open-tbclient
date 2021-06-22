package d.a.o0.v.j.b;

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
public class g extends d.a.c.k.e.a<d.a.o0.v.j.d.j, CardViewHolder<d.a.o0.v.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.v.j.d.j f65866e;

        public a(d.a.o0.v.j.d.j jVar) {
            this.f65866e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.h0(this.f65866e);
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.j.d.j.f65905f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.o0.v.j.d.j jVar, d.a.o0.v.j.h.a aVar) {
        if (jVar.c() == null) {
            return;
        }
        aVar.y(8);
        aVar.z(this.f43012e.getResources().getString(R.string.ala_person_live_my_fans_family));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0(d.a.o0.v.j.d.j jVar) {
        if (jVar == null || jVar.c() == null) {
            return;
        }
        TiebaStatic.log("c13134");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaFansFamilyActivityConfig(this.f43012e, jVar.c().b().user_id, true, AlaFansFamilyActivityConfig.FROM_PERSON_CENTER)));
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
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.j.d.j jVar, CardViewHolder<d.a.o0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        TiebaStatic.log("c13133");
        g0(jVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(jVar));
        return cardViewHolder.b().m();
    }
}
