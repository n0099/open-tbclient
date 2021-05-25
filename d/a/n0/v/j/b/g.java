package d.a.n0.v.j.b;

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
public class g extends d.a.c.j.e.a<d.a.n0.v.j.d.j, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.j.d.j f62026e;

        public a(d.a.n0.v.j.d.j jVar) {
            this.f62026e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.g0(this.f62026e);
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.j.f62065f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.n0.v.j.d.j jVar, d.a.n0.v.j.h.a aVar) {
        if (jVar.h() == null) {
            return;
        }
        aVar.x(8);
        aVar.y(this.f39228e.getResources().getString(R.string.ala_person_live_my_fans_family));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(d.a.n0.v.j.d.j jVar) {
        if (jVar == null || jVar.h() == null) {
            return;
        }
        TiebaStatic.log("c13134");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaFansFamilyActivityConfig(this.f39228e, jVar.h().b().user_id, true, AlaFansFamilyActivityConfig.FROM_PERSON_CENTER)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.n0.v.j.h.a> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.v.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.j jVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        TiebaStatic.log("c13133");
        f0(jVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a(jVar));
        return cardViewHolder.b().l();
    }
}
