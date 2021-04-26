package d.a.j0.a1.b.h;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout;
import d.a.i0.m.f;
import d.a.i0.r.q.s1;
/* loaded from: classes4.dex */
public class a extends d.a.i.a<s1> {
    public ConcernRecommendLayout j;
    public int k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.k = 3;
        ConcernRecommendLayout concernRecommendLayout = new ConcernRecommendLayout(tbPageContext.getPageActivity());
        this.j = concernRecommendLayout;
        concernRecommendLayout.setPageContext(tbPageContext);
        this.j.setPageUniqueId(bdUniqueId);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(s1 s1Var) {
        this.j.setData(s1Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.k != i2) {
            this.j.onChangeSkinType(tbPageContext, i2);
            m(this.j, 3);
        }
        this.k = i2;
    }

    public void p(boolean z) {
        this.j.setHasBorder(z);
    }

    public void q(f<MetaData> fVar) {
        this.j.setOnItemCoverListener(fVar);
    }
}
