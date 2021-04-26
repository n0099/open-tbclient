package d.a.j0.c1.a;

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
public class e extends d.a.c.j.e.a<d.a.j0.c1.c.g, HotTopicIntervalItemHolder> {
    public int m;

    public e(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.j0.c1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        h0(i2, view, viewGroup, gVar, hotTopicIntervalItemHolder);
        return view;
    }

    public final void e0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, d.a.j0.c1.c.g gVar) {
        if (hotTopicIntervalItemHolder != null && gVar != null && !StringUtils.isNull(gVar.f51700e)) {
            hotTopicIntervalItemHolder.f17567c.setVisibility(0);
            hotTopicIntervalItemHolder.f17567c.setText(gVar.f51700e);
        } else if (hotTopicIntervalItemHolder != null) {
            hotTopicIntervalItemHolder.f17567c.setVisibility(8);
        }
    }

    public final void f0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, View view) {
        if (hotTopicIntervalItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotTopicIntervalItemHolder.f17565a != skinType) {
            hotTopicIntervalItemHolder.f17565a = skinType;
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.f17566b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(hotTopicIntervalItemHolder.f17567c, R.color.CAM_X0108, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public HotTopicIntervalItemHolder P(ViewGroup viewGroup) {
        return new HotTopicIntervalItemHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.hot_topic_interval, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, d.a.j0.c1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        if (gVar != null && hotTopicIntervalItemHolder != null) {
            f0(hotTopicIntervalItemHolder, view);
            e0(hotTopicIntervalItemHolder, gVar);
        }
        return view;
    }
}
