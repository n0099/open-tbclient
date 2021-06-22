package d.a.o0.v.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.o0.v.j.d.r;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.o0.v.j.d.d, CardViewHolder<d.a.o0.v.j.h.a>> {
    public TbPageContext m;

    /* renamed from: d.a.o0.v.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1729a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.v.j.d.d f65852e;

        public View$OnClickListenerC1729a(d.a.o0.v.j.d.d dVar) {
            this.f65852e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h0(this.f65852e);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.j.d.d.f65900f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.o0.v.j.d.d dVar, d.a.o0.v.j.h.a aVar) {
        d.a.o0.v.j.d.c c2 = dVar.c();
        if (c2 == null || c2.f65899h == null) {
            return;
        }
        aVar.y(8);
        aVar.z(c2.f65899h.f65911a);
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0(d.a.o0.v.j.d.d dVar) {
        if (dVar == null || dVar.c() == null || dVar.c().f65899h == null) {
            return;
        }
        r rVar = dVar.c().f65899h;
        d.a.n0.l.a.t(this.m.getPageActivity(), true, rVar.f65912b, rVar.f65911a);
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
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.j.d.d dVar, CardViewHolder<d.a.o0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        g0(dVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new View$OnClickListenerC1729a(dVar));
        return cardViewHolder.b().m();
    }
}
