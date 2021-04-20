package d.b.i0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout;
import d.b.c.j.e.s;
/* loaded from: classes4.dex */
public class j extends d.b.c.j.e.a<d.b.i0.a1.i.e.b, AdapterViewHolder<HotTopicRankLayout>> {
    public TbPageContext m;

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.a1.e.a.e.a.f52583a);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public AdapterViewHolder<HotTopicRankLayout> R(ViewGroup viewGroup) {
        return new AdapterViewHolder<>(new HotTopicRankLayout(viewGroup.getContext()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.a1.i.e.b bVar, AdapterViewHolder<HotTopicRankLayout> adapterViewHolder) {
        if (bVar == null || adapterViewHolder == null) {
            return null;
        }
        HotTopicRankLayout b2 = adapterViewHolder.b();
        b2.a(bVar);
        b2.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        return adapterViewHolder.a();
    }

    public void j0(s sVar) {
    }
}
