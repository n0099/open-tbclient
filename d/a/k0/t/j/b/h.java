package d.a.k0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaLoveFamilyActivityConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class h extends d.a.c.j.e.a<d.a.k0.t.j.d.k, CardViewHolder<d.a.k0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.t.j.d.k f61740e;

        public a(d.a.k0.t.j.d.k kVar) {
            this.f61740e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.g0(this.f61740e);
        }
    }

    public h(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.j.d.k.f61778f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.k0.t.j.d.k kVar, d.a.k0.t.j.h.a aVar) {
        if (kVar.h() == null) {
            return;
        }
        aVar.x(8);
        aVar.y(this.f39564e.getResources().getString(R.string.ala_person_live_my_love_family));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(d.a.k0.t.j.d.k kVar) {
        if (kVar == null || kVar.h() == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLoveFamilyActivityConfig(this.f39564e, kVar.h().b().user_id)));
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.j.d.k kVar, CardViewHolder<d.a.k0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(kVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a(kVar));
        return cardViewHolder.b().l();
    }
}
