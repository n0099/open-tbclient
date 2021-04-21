package d.b.j0.c1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.HotTopicIntervalItemHolder;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<d.b.j0.c1.c.g, HotTopicIntervalItemHolder> {
    public int m;

    public e(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, d.b.j0.c1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        l0(i, view, viewGroup, gVar, hotTopicIntervalItemHolder);
        return view;
    }

    public final void h0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, d.b.j0.c1.c.g gVar) {
        if (hotTopicIntervalItemHolder != null && gVar != null && !StringUtils.isNull(gVar.f53938e)) {
            hotTopicIntervalItemHolder.f17272c.setVisibility(0);
            hotTopicIntervalItemHolder.f17272c.setText(gVar.f53938e);
        } else if (hotTopicIntervalItemHolder != null) {
            hotTopicIntervalItemHolder.f17272c.setVisibility(8);
        }
    }

    public final void i0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, View view) {
        if (hotTopicIntervalItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotTopicIntervalItemHolder.f17270a != skinType) {
            hotTopicIntervalItemHolder.f17270a = skinType;
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.f17271b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(hotTopicIntervalItemHolder.f17272c, R.color.CAM_X0108, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public HotTopicIntervalItemHolder R(ViewGroup viewGroup) {
        return new HotTopicIntervalItemHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.hot_topic_interval, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.j0.c1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        if (gVar != null && hotTopicIntervalItemHolder != null) {
            i0(hotTopicIntervalItemHolder, view);
            h0(hotTopicIntervalItemHolder, gVar);
        }
        return view;
    }
}
