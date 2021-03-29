package d.b.i0.t.j.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.t.j.d.o;
/* loaded from: classes4.dex */
public class l extends d.b.b.j.e.a<o, CardViewHolder<d.b.i0.t.j.h.a>> {
    public TbPageContext m;
    public d.b.i0.t.j.e.a n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f60840e;

        public a(o oVar) {
            this.f60840e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.j0(this.f60840e);
        }
    }

    public l(TbPageContext tbPageContext, d.b.i0.t.j.e.a aVar) {
        super(tbPageContext.getPageActivity(), o.f60874f);
        this.m = tbPageContext;
        this.n = aVar;
    }

    public final void i0(o oVar, d.b.i0.t.j.h.a aVar) {
        d.b.i0.t.j.d.c g2 = oVar.g();
        if (g2 == null || g2.b() == null) {
            return;
        }
        aVar.z(0);
        aVar.A(this.f42358e.getResources().getString(R.string.ala_person_live_real_authen));
        int i = g2.b().certify_status;
        if (i == 0) {
            aVar.x(this.f42358e.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
            aVar.y(0);
        } else if (1 == i) {
            aVar.x(this.f42358e.getResources().getString(R.string.ala_person_live_real_authen_in_review));
            aVar.y(4);
        } else if (2 == i) {
            aVar.x(this.f42358e.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
            aVar.y(4);
        } else if (3 == i) {
            aVar.x(this.f42358e.getResources().getString(R.string.ala_person_live_real_authen_denied));
            aVar.y(0);
        }
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(o oVar) {
        AlaUserInfoData b2;
        int i;
        if (oVar == null || oVar.g() == null || oVar.g().b() == null || 1 == (i = (b2 = oVar.g().b()).certify_status) || 2 == i) {
            return;
        }
        Context context = this.f42358e;
        String str = b2.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b2.certify_status + "")));
        d.b.i0.t.j.e.a aVar = this.n;
        if (aVar != null) {
            aVar.a(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public CardViewHolder<d.b.i0.t.j.h.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, o oVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        i0(oVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(oVar));
        return cardViewHolder.b().m();
    }
}
