package d.b.i0.z0.b.h;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout;
import d.b.h0.m.f;
import d.b.h0.r.q.s1;
/* loaded from: classes4.dex */
public class a extends d.b.i.a<s1> {
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

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: o */
    public void a(s1 s1Var) {
        this.j.setData(s1Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.k != i) {
            this.j.onChangeSkinType(tbPageContext, i);
            m(this.j, 3);
        }
        this.k = i;
    }

    public void p(boolean z) {
        this.j.setHasBorder(z);
    }

    public void q(f<MetaData> fVar) {
        this.j.setOnItemCoverListener(fVar);
    }
}
