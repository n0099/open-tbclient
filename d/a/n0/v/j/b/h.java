package d.a.n0.v.j.b;

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
public class h extends d.a.c.k.e.a<d.a.n0.v.j.d.k, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.j.d.k f65743e;

        public a(d.a.n0.v.j.d.k kVar) {
            this.f65743e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.h0(this.f65743e);
        }
    }

    public h(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.k.f65781f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.n0.v.j.d.k kVar, d.a.n0.v.j.h.a aVar) {
        if (kVar.c() == null) {
            return;
        }
        aVar.y(8);
        aVar.z(this.f42909e.getResources().getString(R.string.ala_person_live_my_love_family));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0(d.a.n0.v.j.d.k kVar) {
        if (kVar == null || kVar.c() == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLoveFamilyActivityConfig(this.f42909e, kVar.c().b().user_id)));
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
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.k kVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        g0(kVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(kVar));
        return cardViewHolder.b().m();
    }
}
