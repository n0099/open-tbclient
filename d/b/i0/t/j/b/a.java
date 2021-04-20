package d.b.i0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.t.j.d.r;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<d.b.i0.t.j.d.d, CardViewHolder<d.b.i0.t.j.h.a>> {
    public TbPageContext m;

    /* renamed from: d.b.i0.t.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1620a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.j.d.d f62381e;

        public View$OnClickListenerC1620a(d.b.i0.t.j.d.d dVar) {
            this.f62381e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j0(this.f62381e);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.j.d.d.f62428f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.j.d.d dVar, d.b.i0.t.j.h.a aVar) {
        d.b.i0.t.j.d.c g2 = dVar.g();
        if (g2 == null || g2.f62427h == null) {
            return;
        }
        aVar.z(8);
        aVar.A(g2.f62427h.f62439a);
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(d.b.i0.t.j.d.d dVar) {
        if (dVar == null || dVar.g() == null || dVar.g().f62427h == null) {
            return;
        }
        r rVar = dVar.g().f62427h;
        d.b.h0.l.a.t(this.m.getPageActivity(), true, rVar.f62440b, rVar.f62439a);
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
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.j.d.d dVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        i0(dVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new View$OnClickListenerC1620a(dVar));
        return cardViewHolder.b().m();
    }
}
