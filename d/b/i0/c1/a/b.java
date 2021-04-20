package d.b.i0.c1.a;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.holder.HotRankListManualItemHolder;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.i0.c1.c.b, HotRankListManualItemHolder> {
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.c1.c.b f53407e;

        public a(b bVar, d.b.i0.c1.c.b bVar2) {
            this.f53407e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f53407e.a()), this.f53407e.f(), "5")));
            StatisticItem statisticItem = new StatisticItem("c10811");
            TiebaStatic.log(statisticItem.param("obj_name", "" + this.f53407e.f()));
        }
    }

    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, d.b.i0.c1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        l0(i, view, viewGroup, bVar, hotRankListManualItemHolder);
        return view;
    }

    public final void h0(HotRankListManualItemHolder hotRankListManualItemHolder, d.b.i0.c1.c.b bVar) {
        if (hotRankListManualItemHolder == null || bVar == null) {
            return;
        }
        String string = StringUtils.isNull(bVar.e()) ? this.f42855e.getResources().getString(R.string.hot_topic_hot_trend) : bVar.e();
        hotRankListManualItemHolder.f17249d.setText(bVar.g());
        hotRankListManualItemHolder.f17247b.setText(string);
        hotRankListManualItemHolder.f17252g.W(bVar.j(), 10, false);
        if (StringUtils.isNull(bVar.f())) {
            hotRankListManualItemHolder.f17248c.setVisibility(8);
            hotRankListManualItemHolder.f17249d.setPadding(0, 0, 0, 0);
        } else {
            hotRankListManualItemHolder.f17248c.setVisibility(0);
            hotRankListManualItemHolder.f17248c.setText(bVar.f());
        }
        hotRankListManualItemHolder.f17253h.setOnClickListener(new a(this, bVar));
    }

    public final void i0(HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (hotRankListManualItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListManualItemHolder.f17246a != skinType) {
            hotRankListManualItemHolder.f17246a = skinType;
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17247b, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17248c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17249d, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17250e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17251f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListManualItemHolder.f17253h, R.drawable.hot_topic_ranklist_bg);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public HotRankListManualItemHolder R(ViewGroup viewGroup) {
        return new HotRankListManualItemHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.c1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (bVar != null) {
            i0(hotRankListManualItemHolder);
            h0(hotRankListManualItemHolder, bVar);
        }
        return view;
    }
}
