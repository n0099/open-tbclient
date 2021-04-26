package d.a.j0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.j0.t.j.d.r;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.j0.t.j.d.d, CardViewHolder<d.a.j0.t.j.h.a>> {
    public TbPageContext m;

    /* renamed from: d.a.j0.t.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1583a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.j.d.d f61000e;

        public View$OnClickListenerC1583a(d.a.j0.t.j.d.d dVar) {
            this.f61000e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g0(this.f61000e);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.t.j.d.d.f61048f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.j0.t.j.d.d dVar, d.a.j0.t.j.h.a aVar) {
        d.a.j0.t.j.d.c h2 = dVar.h();
        if (h2 == null || h2.f61047h == null) {
            return;
        }
        aVar.x(8);
        aVar.y(h2.f61047h.f61059a);
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(d.a.j0.t.j.d.d dVar) {
        if (dVar == null || dVar.h() == null || dVar.h().f61047h == null) {
            return;
        }
        r rVar = dVar.h().f61047h;
        d.a.i0.l.a.t(this.m.getPageActivity(), true, rVar.f61060b, rVar.f61059a);
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.j.d.d dVar, CardViewHolder<d.a.j0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(dVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new View$OnClickListenerC1583a(dVar));
        return cardViewHolder.b().l();
    }
}
