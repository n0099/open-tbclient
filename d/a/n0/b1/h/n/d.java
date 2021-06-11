package d.a.n0.b1.h.n;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class d extends d.a.i.a<d.a.m0.r.q.a> {
    public d.a.n0.b1.k.b.d.a j;
    public int k;

    public d(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.k = 3;
        this.j = new d.a.n0.b1.k.b.d.a(tbPageContext);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j.t();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(d.a.m0.r.q.a aVar) {
        if (aVar instanceof d.a.n0.b1.k.b.c.a) {
            this.j.n((d.a.n0.b1.k.b.c.a) aVar);
        }
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.k != i2) {
            this.j.o(tbPageContext, i2);
            m(g(), 3);
        }
        this.k = i2;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.j.q(bdUniqueId);
    }
}
