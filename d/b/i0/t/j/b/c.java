package d.b.i0.t.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class c extends d.b.b.j.e.a<d.b.i0.t.j.d.f, CardViewHolder<d.b.i0.t.j.h.b>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.j.d.f f60819e;

        public a(d.b.i0.t.j.d.f fVar) {
            this.f60819e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.i0(this.f60819e);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.j.d.f.f60865f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.j.d.f fVar) {
        d.b.i0.t.j.d.c g2;
        if (fVar == null || (g2 = fVar.g()) == null || g2.b() == null) {
            return;
        }
        if (!g2.c()) {
            TiebaStatic.log("c11864");
        } else {
            TiebaStatic.log("c11857");
        }
        String o = d.b.h0.r.d0.b.i().o("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
        if (o == null) {
            return;
        }
        if (o.endsWith("/")) {
            o = o.substring(0, o.length() - 1);
        }
        d.b.h0.l.a.l(this.m.getPageActivity(), o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public CardViewHolder<d.b.i0.t.j.h.b> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.t.j.h.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.j.d.f fVar, CardViewHolder<d.b.i0.t.j.h.b> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(fVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().o.setOnClickListener(new a(fVar));
        return cardViewHolder.b().m();
    }
}
