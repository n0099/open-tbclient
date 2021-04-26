package d.a.j0.c1.a;

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
public class b extends d.a.c.j.e.a<d.a.j0.c1.c.b, HotRankListManualItemHolder> {
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.c1.c.b f51582e;

        public a(b bVar, d.a.j0.c1.c.b bVar2) {
            this.f51582e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f51582e.c()), this.f51582e.f(), "5")));
            StatisticItem statisticItem = new StatisticItem("c10811");
            TiebaStatic.log(statisticItem.param("obj_name", "" + this.f51582e.f()));
        }
    }

    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.j0.c1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        h0(i2, view, viewGroup, bVar, hotRankListManualItemHolder);
        return view;
    }

    public final void e0(HotRankListManualItemHolder hotRankListManualItemHolder, d.a.j0.c1.c.b bVar) {
        if (hotRankListManualItemHolder == null || bVar == null) {
            return;
        }
        String string = StringUtils.isNull(bVar.e()) ? this.f40319e.getResources().getString(R.string.hot_topic_hot_trend) : bVar.e();
        hotRankListManualItemHolder.f17551d.setText(bVar.h());
        hotRankListManualItemHolder.f17549b.setText(string);
        hotRankListManualItemHolder.f17554g.V(bVar.i(), 10, false);
        if (StringUtils.isNull(bVar.f())) {
            hotRankListManualItemHolder.f17550c.setVisibility(8);
            hotRankListManualItemHolder.f17551d.setPadding(0, 0, 0, 0);
        } else {
            hotRankListManualItemHolder.f17550c.setVisibility(0);
            hotRankListManualItemHolder.f17550c.setText(bVar.f());
        }
        hotRankListManualItemHolder.f17555h.setOnClickListener(new a(this, bVar));
    }

    public final void f0(HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (hotRankListManualItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListManualItemHolder.f17548a != skinType) {
            hotRankListManualItemHolder.f17548a = skinType;
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17549b, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17550c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17551d, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17552e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17553f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListManualItemHolder.f17555h, R.drawable.hot_topic_ranklist_bg);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public HotRankListManualItemHolder P(ViewGroup viewGroup) {
        return new HotRankListManualItemHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, d.a.j0.c1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (bVar != null) {
            f0(hotRankListManualItemHolder);
            e0(hotRankListManualItemHolder, bVar);
        }
        return view;
    }
}
