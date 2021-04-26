package d.a.j0.a1.g.n;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class d extends d.a.i.a<d.a.i0.r.q.a> {
    public d.a.j0.a1.j.b.d.a j;
    public int k;

    public d(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.k = 3;
        this.j = new d.a.j0.a1.j.b.d.a(tbPageContext);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j.s();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(d.a.i0.r.q.a aVar) {
        if (aVar instanceof d.a.j0.a1.j.b.c.a) {
            this.j.m((d.a.j0.a1.j.b.c.a) aVar);
        }
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.k != i2) {
            this.j.n(tbPageContext, i2);
            m(g(), 3);
        }
        this.k = i2;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.j.p(bdUniqueId);
    }
}
