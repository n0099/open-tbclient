package d.a.o0.b1.h.n;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.personalize.view.HomePageAlaRecommendLayout;
import d.a.o0.b1.h.j.f;
/* loaded from: classes4.dex */
public class a extends d.a.i.a<d.a.n0.r.q.a> {
    public HomePageAlaRecommendLayout j;
    public int k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.k = 3;
        this.j = new HomePageAlaRecommendLayout(tbPageContext.getPageActivity());
    }

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(d.a.n0.r.q.a aVar) {
        this.j.setData((f) aVar);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.k != i2) {
            this.j.c(i2);
            m(this.j, 3);
        }
        this.k = i2;
    }
}
