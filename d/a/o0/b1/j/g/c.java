package d.a.o0.b1.j.g;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.o0.z.b0;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<d.a.o0.z.e0.j, CardViewHolder<d.a.o0.z.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.o0.z.k p;
    public NEGFeedBackView.b q;
    public b0<d.a.o0.z.e0.j> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.o0.z.e0.j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.j jVar) {
            int i2 = 2;
            if (c.this.p.x == view) {
                i2 = 1;
            } else if (view == c.this.p.p.getCommentContainer()) {
                i2 = 5;
            } else if (view == c.this.p.q.getCommentContainer() || ((c.this.p.M() == null || view.getId() != c.this.p.M().getId()) && (c.this.p.N() == null || view.getId() != c.this.p.N().getId()))) {
                i2 = 0;
            }
            if (i2 != 0) {
                d.a.o0.b1.h.m.a.a(jVar.f67302e, c.this.m, jVar.E(), i2);
            }
            d.a.o0.b1.j.c.d(view, jVar, c.this.o);
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
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.o0.z.k> Q(ViewGroup viewGroup) {
        d.a.o0.z.k kVar = new d.a.o0.z.k(this.n, this.m);
        this.p = kVar;
        kVar.B(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.p.V(bdUniqueId);
        }
        return new CardViewHolder<>(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.j jVar, CardViewHolder<d.a.o0.z.k> cardViewHolder) {
        jVar.U(jVar.position + 1);
        d.a.o0.z.k b2 = cardViewHolder.b();
        b2.Y(i2 + 1);
        b2.n(jVar);
        b2.p(this.r);
        b2.A(this.q);
        d.a.o0.b1.h.m.a.c(jVar.f67302e, this.m, jVar.E());
        d.a.o0.b1.j.c.e(jVar, this.o);
        return cardViewHolder.a();
    }
}
