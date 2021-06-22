package d.a.o0.b1.j.g;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout;
import d.a.c.k.e.s;
/* loaded from: classes4.dex */
public class o extends d.a.c.k.e.a<SpecialColumnListData, AdapterViewHolder<SpecialTopicLayout>> implements d.a.o0.b1.j.d {
    public TbPageContext m;
    public String n;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), SpecialColumnListData.TYPE);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public AdapterViewHolder<SpecialTopicLayout> Q(ViewGroup viewGroup) {
        SpecialTopicLayout specialTopicLayout = new SpecialTopicLayout(this.m);
        specialTopicLayout.setShowMore(true);
        return new AdapterViewHolder<>(specialTopicLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, SpecialColumnListData specialColumnListData, AdapterViewHolder<SpecialTopicLayout> adapterViewHolder) {
        SpecialTopicLayout b2 = adapterViewHolder.b();
        b2.setTabCode(this.n);
        b2.a(specialColumnListData);
        return adapterViewHolder.a();
    }

    public void h0(s sVar) {
    }

    @Override // d.a.o0.b1.j.d
    public void i(String str) {
        this.n = str;
    }
}
