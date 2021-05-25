package d.a.n0.v.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.v.j.d.r;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.n0.v.j.d.d, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;

    /* renamed from: d.a.n0.v.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1668a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.j.d.d f62012e;

        public View$OnClickListenerC1668a(d.a.n0.v.j.d.d dVar) {
            this.f62012e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g0(this.f62012e);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.d.f62060f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.n0.v.j.d.d dVar, d.a.n0.v.j.h.a aVar) {
        d.a.n0.v.j.d.c h2 = dVar.h();
        if (h2 == null || h2.f62059h == null) {
            return;
        }
        aVar.x(8);
        aVar.y(h2.f62059h.f62071a);
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0(d.a.n0.v.j.d.d dVar) {
        if (dVar == null || dVar.h() == null || dVar.h().f62059h == null) {
            return;
        }
        r rVar = dVar.h().f62059h;
        d.a.m0.l.a.t(this.m.getPageActivity(), true, rVar.f62072b, rVar.f62071a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.n0.v.j.h.a> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.v.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.d dVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(dVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new View$OnClickListenerC1668a(dVar));
        return cardViewHolder.b().l();
    }
}
