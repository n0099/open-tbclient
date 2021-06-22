package d.a.o0.b1.c.h;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import d.a.o0.b1.c.f.c;
/* loaded from: classes4.dex */
public class b extends d.a.i.a<c> {
    public RecommendBarLayout j;
    public int k;
    public int l;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b2) {
        super(tbPageContext.getPageActivity());
        this.k = 3;
        this.j = new RecommendBarLayout(tbPageContext, tbPageContext.getPageActivity(), bdUniqueId, b2);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(c cVar) {
        if (cVar == null || this.l == cVar.hashCode()) {
            return;
        }
        this.l = cVar.hashCode();
        this.j.setData(cVar);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.k != i2) {
            this.j.onChangeSkinType(tbPageContext, i2);
            m(this.j, 3);
        }
        this.k = i2;
    }
}
