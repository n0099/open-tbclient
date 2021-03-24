package d.b.i0.z0.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout;
import d.b.b.j.e.s;
/* loaded from: classes4.dex */
public class n extends d.b.b.j.e.a<SpecialColumnListData, AdapterViewHolder<SpecialTopicLayout>> {
    public TbPageContext m;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), SpecialColumnListData.TYPE);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public AdapterViewHolder<SpecialTopicLayout> R(ViewGroup viewGroup) {
        SpecialTopicLayout specialTopicLayout = new SpecialTopicLayout(this.m);
        specialTopicLayout.setShowMore(true);
        return new AdapterViewHolder<>(specialTopicLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, SpecialColumnListData specialColumnListData, AdapterViewHolder<SpecialTopicLayout> adapterViewHolder) {
        adapterViewHolder.b().a(specialColumnListData);
        return adapterViewHolder.a();
    }

    public void j0(s sVar) {
    }
}
