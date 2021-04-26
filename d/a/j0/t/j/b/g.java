package d.a.j0.t.j.b;

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
public class g extends d.a.c.j.e.a<d.a.j0.t.j.d.j, CardViewHolder<d.a.j0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.j.d.j f61014e;

        public a(d.a.j0.t.j.d.j jVar) {
            this.f61014e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.g0(this.f61014e);
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.t.j.d.j.f61053f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.j0.t.j.d.j jVar, d.a.j0.t.j.h.a aVar) {
        if (jVar.h() == null) {
            return;
        }
        aVar.x(8);
        aVar.y(this.f40319e.getResources().getString(R.string.ala_person_live_my_fans_family));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(d.a.j0.t.j.d.j jVar) {
        if (jVar == null || jVar.h() == null) {
            return;
        }
        TiebaStatic.log("c13134");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaFansFamilyActivityConfig(this.f40319e, jVar.h().b().user_id, true, AlaFansFamilyActivityConfig.FROM_PERSON_CENTER)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.j0.t.j.h.a> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.j0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.j.d.j jVar, CardViewHolder<d.a.j0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        TiebaStatic.log("c13133");
        f0(jVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a(jVar));
        return cardViewHolder.b().l();
    }
}
