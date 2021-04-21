package d.b.j0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<d.b.j0.t.j.d.f, CardViewHolder<d.b.j0.t.j.h.b>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.t.j.d.f f62805e;

        public a(d.b.j0.t.j.d.f fVar) {
            this.f62805e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.i0(this.f62805e);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.t.j.d.f.f62851f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.j0.t.j.d.f fVar) {
        d.b.j0.t.j.d.c g2;
        if (fVar == null || (g2 = fVar.g()) == null || g2.b() == null) {
            return;
        }
        if (!g2.c()) {
            TiebaStatic.log("c11864");
        } else {
            TiebaStatic.log("c11857");
        }
        String p = d.b.i0.r.d0.b.j().p("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
        if (p == null) {
            return;
        }
        if (p.endsWith("/")) {
            p = p.substring(0, p.length() - 1);
        }
        d.b.i0.l.a.l(this.m.getPageActivity(), p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public CardViewHolder<d.b.j0.t.j.h.b> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.t.j.h.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.j.d.f fVar, CardViewHolder<d.b.j0.t.j.h.b> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(fVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().o.setOnClickListener(new a(fVar));
        return cardViewHolder.b().m();
    }
}
