package d.a.n0.v.j.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<d.a.n0.v.j.d.f, CardViewHolder<d.a.n0.v.j.h.b>> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.j.d.f f65730e;

        public a(d.a.n0.v.j.d.f fVar) {
            this.f65730e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.g0(this.f65730e);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.f.f65777f);
        this.m = tbPageContext;
    }

    public final void g0(d.a.n0.v.j.d.f fVar) {
        d.a.n0.v.j.d.c c2;
        if (fVar == null || (c2 = fVar.c()) == null || c2.b() == null) {
            return;
        }
        if (!c2.c()) {
            TiebaStatic.log("c11864");
        } else {
            TiebaStatic.log("c11857");
        }
        String p = d.a.m0.r.d0.b.j().p("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
        if (p == null) {
            return;
        }
        if (p.endsWith("/")) {
            p = p.substring(0, p.length() - 1);
        }
        d.a.m0.l.a.l(this.m.getPageActivity(), p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.n0.v.j.h.b> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.v.j.h.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.f fVar, CardViewHolder<d.a.n0.v.j.h.b> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(fVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().o.setOnClickListener(new a(fVar));
        return cardViewHolder.b().m();
    }
}
