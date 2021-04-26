package d.a.j0.c1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.HotTopicPkItemHolder;
/* loaded from: classes4.dex */
public class g extends d.a.c.j.e.a<d.a.j0.c1.c.i, HotTopicPkItemHolder> {
    public int m;
    public HotTopicActivity n;

    public g(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.n = hotTopicActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.j0.c1.c.i iVar, HotTopicPkItemHolder hotTopicPkItemHolder) {
        h0(i2, view, viewGroup, iVar, hotTopicPkItemHolder);
        return view;
    }

    public final void e0(HotTopicPkItemHolder hotTopicPkItemHolder, d.a.j0.c1.c.i iVar) {
        if (hotTopicPkItemHolder == null || iVar == null) {
            return;
        }
        hotTopicPkItemHolder.f17569b.setText(StringUtils.isNull(iVar.f51702e) ? this.n.getResources().getString(R.string.pk_topic_default) : iVar.f51702e.trim());
        hotTopicPkItemHolder.f17570c.setText(StringHelper.cutStringWithSuffix(iVar.f51703f.trim(), 32, StringHelper.STRING_MORE));
        hotTopicPkItemHolder.f17570c.setText(iVar.f51703f.trim());
        hotTopicPkItemHolder.f17571d.setData(iVar, this.n);
        hotTopicPkItemHolder.f17572e.setText(iVar.f51704g.trim());
        hotTopicPkItemHolder.f17573f.setText(iVar.f51706i.trim());
    }

    public final void f0(HotTopicPkItemHolder hotTopicPkItemHolder, View view) {
        if (hotTopicPkItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || hotTopicPkItemHolder.f17568a == skinType) {
            return;
        }
        hotTopicPkItemHolder.f17568a = skinType;
        SkinManager.setBackgroundColor(hotTopicPkItemHolder.a(), R.color.CAM_X0201);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public HotTopicPkItemHolder P(ViewGroup viewGroup) {
        return new HotTopicPkItemHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.hot_topic_pk_item, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, d.a.j0.c1.c.i iVar, HotTopicPkItemHolder hotTopicPkItemHolder) {
        if (iVar != null && hotTopicPkItemHolder != null) {
            f0(hotTopicPkItemHolder, view);
            e0(hotTopicPkItemHolder, iVar);
        }
        return view;
    }
}
