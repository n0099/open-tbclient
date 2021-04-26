package d.a.j0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.j0.t.j.d.f, CardViewHolder<d.a.j0.t.j.h.b>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.j.d.f f61003e;

        public a(d.a.j0.t.j.d.f fVar) {
            this.f61003e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f0(this.f61003e);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.t.j.d.f.f61050f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.j0.t.j.d.f fVar) {
        d.a.j0.t.j.d.c h2;
        if (fVar == null || (h2 = fVar.h()) == null || h2.b() == null) {
            return;
        }
        if (!h2.c()) {
            TiebaStatic.log("c11864");
        } else {
            TiebaStatic.log("c11857");
        }
        String p = d.a.i0.r.d0.b.j().p("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
        if (p == null) {
            return;
        }
        if (p.endsWith("/")) {
            p = p.substring(0, p.length() - 1);
        }
        d.a.i0.l.a.l(this.m.getPageActivity(), p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public CardViewHolder<d.a.j0.t.j.h.b> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.j0.t.j.h.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.j.d.f fVar, CardViewHolder<d.a.j0.t.j.h.b> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(fVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().o.setOnClickListener(new a(fVar));
        return cardViewHolder.b().l();
    }
}
