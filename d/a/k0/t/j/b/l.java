package d.a.k0.t.j.b;

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
import d.a.k0.t.j.d.o;
/* loaded from: classes4.dex */
public class l extends d.a.c.j.e.a<o, CardViewHolder<d.a.k0.t.j.h.a>> {
    public TbPageContext m;
    public d.a.k0.t.j.e.a n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f61747e;

        public a(o oVar) {
            this.f61747e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.g0(this.f61747e);
        }
    }

    public l(TbPageContext tbPageContext, d.a.k0.t.j.e.a aVar) {
        super(tbPageContext.getPageActivity(), o.f61782f);
        this.m = tbPageContext;
        this.n = aVar;
    }

    public final void f0(o oVar, d.a.k0.t.j.h.a aVar) {
        d.a.k0.t.j.d.c h2 = oVar.h();
        if (h2 == null || h2.b() == null) {
            return;
        }
        aVar.x(0);
        aVar.y(this.f39564e.getResources().getString(R.string.ala_person_live_real_authen));
        int i2 = h2.b().certify_status;
        if (i2 == 0) {
            aVar.v(this.f39564e.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
            aVar.w(0);
        } else if (1 == i2) {
            aVar.v(this.f39564e.getResources().getString(R.string.ala_person_live_real_authen_in_review));
            aVar.w(4);
        } else if (2 == i2) {
            aVar.v(this.f39564e.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
            aVar.w(4);
        } else if (3 == i2) {
            aVar.v(this.f39564e.getResources().getString(R.string.ala_person_live_real_authen_denied));
            aVar.w(0);
        }
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(o oVar) {
        AlaUserInfoData b2;
        int i2;
        if (oVar == null || oVar.h() == null || oVar.h().b() == null || 1 == (i2 = (b2 = oVar.h().b()).certify_status) || 2 == i2) {
            return;
        }
        Context context = this.f39564e;
        String str = b2.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b2.certify_status + "")));
        d.a.k0.t.j.e.a aVar = this.n;
        if (aVar != null) {
            aVar.a(1);
        }
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
    public View W(int i2, View view, ViewGroup viewGroup, o oVar, CardViewHolder<d.a.k0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(oVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a(oVar));
        return cardViewHolder.b().l();
    }
}
