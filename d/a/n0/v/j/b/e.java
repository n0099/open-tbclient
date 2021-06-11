package d.a.n0.v.j.b;

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
public class e extends d.a.c.k.e.a<d.a.n0.v.j.d.g, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.j.d.g f65738e;

        public a(d.a.n0.v.j.d.g gVar) {
            this.f65738e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.h0(this.f65738e);
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.g.f65778f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.n0.v.j.d.g gVar, d.a.n0.v.j.h.a aVar) {
        if (gVar.c() == null) {
            return;
        }
        aVar.y(0);
        aVar.z(this.f42909e.getResources().getString(R.string.ala_person_live_admin));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0(d.a.n0.v.j.d.g gVar) {
        if (gVar == null || gVar.c() == null) {
            return;
        }
        d.a.n0.v.j.d.c c2 = gVar.c();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaAdminListActivityConfig(this.m.getPageActivity(), (c2.b() == null || !c2.c()) ? "" : c2.b().live_id)));
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
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.g gVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        g0(gVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a(gVar));
        return cardViewHolder.b().m();
    }
}
