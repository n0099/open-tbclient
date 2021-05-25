package d.a.n0.v.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaFrsLiveListGatherNoDataTitleView;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.n0.v.e.b.a, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder> {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder P(ViewGroup viewGroup) {
        return new AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder(new AlaFrsLiveListGatherNoDataTitleView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.e.b.a aVar, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder alaFrsLiveListNoDataViewHolder) {
        return alaFrsLiveListNoDataViewHolder.a();
    }
}
