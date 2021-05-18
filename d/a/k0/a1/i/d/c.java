package d.a.k0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.k0.x.e0.j, CardViewHolder<d.a.k0.x.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.k0.x.k p;
    public NEGFeedBackView.b q;
    public b0<d.a.k0.x.e0.j> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.x.e0.j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.j jVar) {
            int i2 = 2;
            if (c.this.p.x == view) {
                i2 = 1;
            } else if (view == c.this.p.p.getCommentContainer()) {
                i2 = 5;
            } else if (view == c.this.p.q.getCommentContainer() || ((c.this.p.L() == null || view.getId() != c.this.p.L().getId()) && (c.this.p.M() == null || view.getId() != c.this.p.M().getId()))) {
                i2 = 0;
            }
            if (i2 != 0) {
                d.a.k0.a1.g.m.a.a(jVar.f63179e, c.this.m, jVar.E(), i2);
            }
            d.a.k0.a1.i.b.d(view, jVar, c.this.o);
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
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public CardViewHolder<d.a.k0.x.k> P(ViewGroup viewGroup) {
        d.a.k0.x.k kVar = new d.a.k0.x.k(this.n, this.m);
        this.p = kVar;
        kVar.A(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.p.V(bdUniqueId);
        }
        return new CardViewHolder<>(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.j jVar, CardViewHolder<d.a.k0.x.k> cardViewHolder) {
        jVar.U(jVar.position + 1);
        d.a.k0.x.k b2 = cardViewHolder.b();
        b2.X(i2 + 1);
        b2.m(jVar);
        b2.o(this.r);
        b2.z(this.q);
        d.a.k0.a1.g.m.a.c(jVar.f63179e, this.m, jVar.E());
        d.a.k0.a1.i.b.e(jVar, this.o);
        return cardViewHolder.a();
    }
}
