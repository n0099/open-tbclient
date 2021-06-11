package d.a.n0.v.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.v.j.d.r;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.n0.v.j.d.d, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;

    /* renamed from: d.a.n0.v.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1725a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.j.d.d f65727e;

        public View$OnClickListenerC1725a(d.a.n0.v.j.d.d dVar) {
            this.f65727e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h0(this.f65727e);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.d.f65775f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.n0.v.j.d.d dVar, d.a.n0.v.j.h.a aVar) {
        d.a.n0.v.j.d.c c2 = dVar.c();
        if (c2 == null || c2.f65774h == null) {
            return;
        }
        aVar.y(8);
        aVar.z(c2.f65774h.f65786a);
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void h0(d.a.n0.v.j.d.d dVar) {
        if (dVar == null || dVar.c() == null || dVar.c().f65774h == null) {
            return;
        }
        r rVar = dVar.c().f65774h;
        d.a.m0.l.a.t(this.m.getPageActivity(), true, rVar.f65787b, rVar.f65786a);
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
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.d dVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        g0(dVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new View$OnClickListenerC1725a(dVar));
        return cardViewHolder.b().m();
    }
}
