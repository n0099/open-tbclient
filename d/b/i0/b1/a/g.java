package d.b.i0.b1.a;

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
public class g extends d.b.b.j.e.a<d.b.i0.b1.c.i, HotTopicPkItemHolder> {
    public int m;
    public HotTopicActivity n;

    public g(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.n = hotTopicActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, d.b.i0.b1.c.i iVar, HotTopicPkItemHolder hotTopicPkItemHolder) {
        l0(i, view, viewGroup, iVar, hotTopicPkItemHolder);
        return view;
    }

    public final void h0(HotTopicPkItemHolder hotTopicPkItemHolder, d.b.i0.b1.c.i iVar) {
        if (hotTopicPkItemHolder == null || iVar == null) {
            return;
        }
        hotTopicPkItemHolder.f17588b.setText(StringUtils.isNull(iVar.f52117e) ? this.n.getResources().getString(R.string.pk_topic_default) : iVar.f52117e.trim());
        hotTopicPkItemHolder.f17589c.setText(StringHelper.cutStringWithSuffix(iVar.f52118f.trim(), 32, StringHelper.STRING_MORE));
        hotTopicPkItemHolder.f17589c.setText(iVar.f52118f.trim());
        hotTopicPkItemHolder.f17590d.setData(iVar, this.n);
        hotTopicPkItemHolder.f17591e.setText(iVar.f52119g.trim());
        hotTopicPkItemHolder.f17592f.setText(iVar.i.trim());
    }

    public final void i0(HotTopicPkItemHolder hotTopicPkItemHolder, View view) {
        if (hotTopicPkItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || hotTopicPkItemHolder.f17587a == skinType) {
            return;
        }
        hotTopicPkItemHolder.f17587a = skinType;
        SkinManager.setBackgroundColor(hotTopicPkItemHolder.a(), R.color.CAM_X0201);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public HotTopicPkItemHolder R(ViewGroup viewGroup) {
        return new HotTopicPkItemHolder(LayoutInflater.from(this.f42357e).inflate(R.layout.hot_topic_pk_item, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.b1.c.i iVar, HotTopicPkItemHolder hotTopicPkItemHolder) {
        if (iVar != null && hotTopicPkItemHolder != null) {
            i0(hotTopicPkItemHolder, view);
            h0(hotTopicPkItemHolder, iVar);
        }
        return view;
    }
}
