package d.a.k0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.t.j.d.r;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.k0.t.j.d.d, CardViewHolder<d.a.k0.t.j.h.a>> {
    public TbPageContext m;

    /* renamed from: d.a.k0.t.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1648a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.t.j.d.d f61724e;

        public View$OnClickListenerC1648a(d.a.k0.t.j.d.d dVar) {
            this.f61724e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g0(this.f61724e);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.j.d.d.f61772f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.k0.t.j.d.d dVar, d.a.k0.t.j.h.a aVar) {
        d.a.k0.t.j.d.c h2 = dVar.h();
        if (h2 == null || h2.f61771h == null) {
            return;
        }
        aVar.x(8);
        aVar.y(h2.f61771h.f61783a);
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(d.a.k0.t.j.d.d dVar) {
        if (dVar == null || dVar.h() == null || dVar.h().f61771h == null) {
            return;
        }
        r rVar = dVar.h().f61771h;
        d.a.j0.l.a.t(this.m.getPageActivity(), true, rVar.f61784b, rVar.f61783a);
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.j.d.d dVar, CardViewHolder<d.a.k0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(dVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new View$OnClickListenerC1648a(dVar));
        return cardViewHolder.b().l();
    }
}
