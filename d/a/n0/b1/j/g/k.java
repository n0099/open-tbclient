package d.a.n0.b1.j.g;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout;
import d.a.c.k.e.s;
/* loaded from: classes4.dex */
public class k extends d.a.c.k.e.a<d.a.n0.b1.j.h.b, AdapterViewHolder<HotTopicRankLayout>> implements d.a.n0.b1.j.d {
    public TbPageContext m;
    public String n;

    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.b1.f.a.e.a.f55252a);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public AdapterViewHolder<HotTopicRankLayout> Q(ViewGroup viewGroup) {
        return new AdapterViewHolder<>(new HotTopicRankLayout(viewGroup.getContext()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.j.h.b bVar, AdapterViewHolder<HotTopicRankLayout> adapterViewHolder) {
        if (bVar == null || adapterViewHolder == null) {
            return null;
        }
        HotTopicRankLayout b2 = adapterViewHolder.b();
        b2.setTabCode(this.n);
        b2.a(bVar);
        b2.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        return adapterViewHolder.a();
    }

    public void h0(s sVar) {
    }

    @Override // d.a.n0.b1.j.d
    public void i(String str) {
        this.n = str;
    }
}
