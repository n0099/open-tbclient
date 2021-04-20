package d.b.i0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaFrsLiveListGatherNoDataTitleView;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<d.b.i0.t.e.b.a, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder> {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder R(ViewGroup viewGroup) {
        return new AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder(new AlaFrsLiveListGatherNoDataTitleView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.e.b.a aVar, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder alaFrsLiveListNoDataViewHolder) {
        return alaFrsLiveListNoDataViewHolder.a();
    }
}
