package d.b.j0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaFrsLiveListGatherRecommendTitleView;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.j0.t.e.b.b, AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder> {
    public TbPageContext<?> m;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder R(ViewGroup viewGroup) {
        return new AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder(new AlaFrsLiveListGatherRecommendTitleView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.e.b.b bVar, AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder alaFrsLiveListGatherRecommendTitleViewHolder) {
        return alaFrsLiveListGatherRecommendTitleViewHolder.a();
    }
}
