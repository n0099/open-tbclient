package d.b.i0.t.j.b;

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
public class h extends d.b.c.j.e.a<d.b.i0.t.j.d.k, CardViewHolder<d.b.i0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.j.d.k f62397e;

        public a(d.b.i0.t.j.d.k kVar) {
            this.f62397e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.j0(this.f62397e);
        }
    }

    public h(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.j.d.k.f62434f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.j.d.k kVar, d.b.i0.t.j.h.a aVar) {
        if (kVar.g() == null) {
            return;
        }
        aVar.z(8);
        aVar.A(this.f42855e.getResources().getString(R.string.ala_person_live_my_love_family));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(d.b.i0.t.j.d.k kVar) {
        if (kVar == null || kVar.g() == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLoveFamilyActivityConfig(this.f42855e, kVar.g().b().user_id)));
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
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.j.d.k kVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        i0(kVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(kVar));
        return cardViewHolder.b().m();
    }
}
