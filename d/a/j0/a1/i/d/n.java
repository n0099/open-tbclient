package d.a.j0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout;
import d.a.c.j.e.s;
/* loaded from: classes4.dex */
public class n extends d.a.c.j.e.a<SpecialColumnListData, AdapterViewHolder<SpecialTopicLayout>> {
    public TbPageContext m;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), SpecialColumnListData.TYPE);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AdapterViewHolder<SpecialTopicLayout> P(ViewGroup viewGroup) {
        SpecialTopicLayout specialTopicLayout = new SpecialTopicLayout(this.m);
        specialTopicLayout.setShowMore(true);
        return new AdapterViewHolder<>(specialTopicLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, SpecialColumnListData specialColumnListData, AdapterViewHolder<SpecialTopicLayout> adapterViewHolder) {
        adapterViewHolder.b().a(specialColumnListData);
        return adapterViewHolder.a();
    }

    public void g0(s sVar) {
    }
}
