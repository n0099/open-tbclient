package d.b.i;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import d.b.i0.r.q.n1;
import d.b.i0.r.q.o1;
/* loaded from: classes.dex */
public class e0 extends a<o1> {
    public RecommendForumLayout j;
    public int k;

    public e0(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.k = 3;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.j = recommendForumLayout;
        recommendForumLayout.setPageUniqueId(bdUniqueId);
        this.j.setShowMore(true);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: o */
    public void a(o1 o1Var) {
        this.j.setData(o1Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.k != i) {
            this.j.onChangeSkinType(tbPageContext, i);
        }
        this.k = i;
    }

    public void p(boolean z) {
        this.j.setEnableShowInto(z);
    }

    public void q(View.OnClickListener onClickListener) {
        this.j.setOnClickRightArrowListener(onClickListener);
    }

    public void r(d.b.i0.m.f<n1> fVar) {
        this.j.setOnItemCoverListener(fVar);
    }

    public void s(PullLeftRefreshLayout.f fVar) {
        this.j.setOnRullOkCallbackr(fVar);
    }

    public void t(boolean z) {
        this.j.setShowMore(z);
    }

    public void u(boolean z) {
        this.j.setShowSquareEntrance(z);
    }
}
