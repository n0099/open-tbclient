package d.a.o0.v.j.b;

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
import d.a.o0.v.j.d.o;
/* loaded from: classes4.dex */
public class l extends d.a.c.k.e.a<o, CardViewHolder<d.a.o0.v.j.h.a>> {
    public TbPageContext m;
    public d.a.o0.v.j.e.a n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f65875e;

        public a(o oVar) {
            this.f65875e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.h0(this.f65875e);
        }
    }

    public l(TbPageContext tbPageContext, d.a.o0.v.j.e.a aVar) {
        super(tbPageContext.getPageActivity(), o.f65910f);
        this.m = tbPageContext;
        this.n = aVar;
    }

    public final void g0(o oVar, d.a.o0.v.j.h.a aVar) {
        d.a.o0.v.j.d.c c2 = oVar.c();
        if (c2 == null || c2.b() == null) {
            return;
        }
        aVar.y(0);
        aVar.z(this.f43012e.getResources().getString(R.string.ala_person_live_real_authen));
        int i2 = c2.b().certify_status;
        if (i2 == 0) {
            aVar.w(this.f43012e.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
            aVar.x(0);
        } else if (1 == i2) {
            aVar.w(this.f43012e.getResources().getString(R.string.ala_person_live_real_authen_in_review));
            aVar.x(4);
        } else if (2 == i2) {
            aVar.w(this.f43012e.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
            aVar.x(4);
        } else if (3 == i2) {
            aVar.w(this.f43012e.getResources().getString(R.string.ala_person_live_real_authen_denied));
            aVar.x(0);
        }
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0(o oVar) {
        AlaUserInfoData b2;
        int i2;
        if (oVar == null || oVar.c() == null || oVar.c().b() == null || 1 == (i2 = (b2 = oVar.c().b()).certify_status) || 2 == i2) {
            return;
        }
        Context context = this.f43012e;
        String str = b2.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b2.certify_status + "")));
        d.a.o0.v.j.e.a aVar = this.n;
        if (aVar != null) {
            aVar.a(1);
        }
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
    public View X(int i2, View view, ViewGroup viewGroup, o oVar, CardViewHolder<d.a.o0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        g0(oVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(oVar));
        return cardViewHolder.b().m();
    }
}
