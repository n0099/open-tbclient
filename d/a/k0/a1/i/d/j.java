package d.a.k0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout;
import d.a.c.j.e.s;
/* loaded from: classes4.dex */
public class j extends d.a.c.j.e.a<d.a.k0.a1.i.e.b, AdapterViewHolder<HotTopicRankLayout>> {
    public TbPageContext m;

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.a1.e.a.e.a.f51404a);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AdapterViewHolder<HotTopicRankLayout> P(ViewGroup viewGroup) {
        return new AdapterViewHolder<>(new HotTopicRankLayout(viewGroup.getContext()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.a1.i.e.b bVar, AdapterViewHolder<HotTopicRankLayout> adapterViewHolder) {
        if (bVar == null || adapterViewHolder == null) {
            return null;
        }
        HotTopicRankLayout b2 = adapterViewHolder.b();
        b2.a(bVar);
        b2.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        return adapterViewHolder.a();
    }

    public void g0(s sVar) {
    }
}
