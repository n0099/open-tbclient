package d.b.j0.a1.g.n;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.personalize.view.HomePageAlaRecommendLayout;
import d.b.j0.a1.g.j.f;
/* loaded from: classes4.dex */
public class a extends d.b.i.a<d.b.i0.r.q.a> {
    public HomePageAlaRecommendLayout j;
    public int k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.k = 3;
        this.j = new HomePageAlaRecommendLayout(tbPageContext.getPageActivity());
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: o */
    public void a(d.b.i0.r.q.a aVar) {
        this.j.setData((f) aVar);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.k != i) {
            this.j.c(i);
            m(this.j, 3);
        }
        this.k = i;
    }
}
