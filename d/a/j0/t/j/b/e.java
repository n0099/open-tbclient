package d.a.j0.t.j.b;

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
public class e extends d.a.c.j.e.a<d.a.j0.t.j.d.g, CardViewHolder<d.a.j0.t.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.j.d.g f61011e;

        public a(d.a.j0.t.j.d.g gVar) {
            this.f61011e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.g0(this.f61011e);
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.t.j.d.g.f61051f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.j0.t.j.d.g gVar, d.a.j0.t.j.h.a aVar) {
        if (gVar.h() == null) {
            return;
        }
        aVar.x(0);
        aVar.y(this.f40319e.getResources().getString(R.string.ala_person_live_admin));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(d.a.j0.t.j.d.g gVar) {
        if (gVar == null || gVar.h() == null) {
            return;
        }
        d.a.j0.t.j.d.c h2 = gVar.h();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaAdminListActivityConfig(this.m.getPageActivity(), (h2.b() == null || !h2.c()) ? "" : h2.b().live_id)));
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.j.d.g gVar, CardViewHolder<d.a.j0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(gVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a(gVar));
        return cardViewHolder.b().l();
    }
}
