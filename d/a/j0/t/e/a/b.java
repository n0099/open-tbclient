package d.a.j0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaFrsLiveListGatherRecommendTitleView;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.j0.t.e.b.b, AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder> {
    public TbPageContext<?> m;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder P(ViewGroup viewGroup) {
        return new AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder(new AlaFrsLiveListGatherRecommendTitleView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.e.b.b bVar, AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder alaFrsLiveListGatherRecommendTitleViewHolder) {
        return alaFrsLiveListGatherRecommendTitleViewHolder.a();
    }
}
