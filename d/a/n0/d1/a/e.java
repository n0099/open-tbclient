package d.a.n0.d1.a;

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
public class e extends d.a.c.k.e.a<d.a.n0.d1.c.g, HotTopicIntervalItemHolder> {
    public int m;

    public e(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.n0.d1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        i0(i2, view, viewGroup, gVar, hotTopicIntervalItemHolder);
        return view;
    }

    public final void e0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, d.a.n0.d1.c.g gVar) {
        if (hotTopicIntervalItemHolder != null && gVar != null && !StringUtils.isNull(gVar.f56268e)) {
            hotTopicIntervalItemHolder.f16868c.setVisibility(0);
            hotTopicIntervalItemHolder.f16868c.setText(gVar.f56268e);
        } else if (hotTopicIntervalItemHolder != null) {
            hotTopicIntervalItemHolder.f16868c.setVisibility(8);
        }
    }

    public final void g0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, View view) {
        if (hotTopicIntervalItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotTopicIntervalItemHolder.f16866a != skinType) {
            hotTopicIntervalItemHolder.f16866a = skinType;
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.f16867b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(hotTopicIntervalItemHolder.f16868c, R.color.CAM_X0108, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public HotTopicIntervalItemHolder Q(ViewGroup viewGroup) {
        return new HotTopicIntervalItemHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.hot_topic_interval, viewGroup, false));
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.n0.d1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        if (gVar != null && hotTopicIntervalItemHolder != null) {
            g0(hotTopicIntervalItemHolder, view);
            e0(hotTopicIntervalItemHolder, gVar);
        }
        return view;
    }
}
