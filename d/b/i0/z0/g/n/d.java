package d.b.i0.z0.g.n;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class d extends d.b.i.a<d.b.h0.r.q.a> {
    public d.b.i0.z0.j.b.d.a j;
    public int k;

    public d(Context context, TbPageContext<?> tbPageContext) {
        super(context);
        this.k = 3;
        this.j = new d.b.i0.z0.j.b.d.a(tbPageContext);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j.u();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: o */
    public void a(d.b.h0.r.q.a aVar) {
        if (aVar instanceof d.b.i0.z0.j.b.c.a) {
            this.j.n((d.b.i0.z0.j.b.c.a) aVar);
        }
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.k != i) {
            this.j.o(tbPageContext, i);
            m(g(), 3);
        }
        this.k = i;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.j.r(bdUniqueId);
    }
}
