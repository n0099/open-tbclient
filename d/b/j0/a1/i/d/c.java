package d.b.j0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<d.b.j0.x.e0.j, CardViewHolder<d.b.j0.x.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.b.j0.x.k p;
    public NEGFeedBackView.b q;
    public b0<d.b.j0.x.e0.j> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.j0.x.e0.j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.j jVar) {
            int i = 2;
            if (c.this.p.x == view) {
                i = 1;
            } else if (view == c.this.p.p.getCommentContainer()) {
                i = 5;
            } else if (view == c.this.p.q.getCommentContainer() || ((c.this.p.O() == null || view.getId() != c.this.p.O().getId()) && (c.this.p.P() == null || view.getId() != c.this.p.P().getId()))) {
                i = 0;
            }
            if (i != 0) {
                d.b.j0.a1.g.m.a.a(jVar.f64193e, c.this.m, jVar.E(), i);
            }
            d.b.j0.a1.i.b.d(view, jVar, c.this.o);
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = null;
        this.r = new a();
        this.n = tbPageContext;
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public CardViewHolder<d.b.j0.x.k> R(ViewGroup viewGroup) {
        d.b.j0.x.k kVar = new d.b.j0.x.k(this.n, this.m);
        this.p = kVar;
        kVar.E(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.p.W(bdUniqueId);
        }
        return new CardViewHolder<>(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.j jVar, CardViewHolder<d.b.j0.x.k> cardViewHolder) {
        jVar.U(jVar.position + 1);
        d.b.j0.x.k b2 = cardViewHolder.b();
        b2.Y(i + 1);
        b2.n(jVar);
        b2.q(this.r);
        b2.B(this.q);
        d.b.j0.a1.g.m.a.c(jVar.f64193e, this.m, jVar.E());
        d.b.j0.a1.i.b.e(jVar, this.o);
        return cardViewHolder.a();
    }
}
