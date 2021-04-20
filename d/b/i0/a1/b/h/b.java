package d.b.i0.a1.b.h;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import d.b.i0.a1.b.f.c;
/* loaded from: classes4.dex */
public class b extends d.b.i.a<c> {
    public RecommendBarLayout j;
    public int k;
    public int l;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b2) {
        super(tbPageContext.getPageActivity());
        this.k = 3;
        this.j = new RecommendBarLayout(tbPageContext, tbPageContext.getPageActivity(), bdUniqueId, b2);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: o */
    public void a(c cVar) {
        if (cVar == null || this.l == cVar.hashCode()) {
            return;
        }
        this.l = cVar.hashCode();
        this.j.setData(cVar);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.k != i) {
            this.j.onChangeSkinType(tbPageContext, i);
            m(this.j, 3);
        }
        this.k = i;
    }
}
