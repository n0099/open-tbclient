package d.b.i0.b1.a;

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
/* loaded from: classes3.dex */
public class b extends d.b.b.j.e.a<d.b.i0.b1.c.b, HotRankListManualItemHolder> {
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.b1.c.b f52006e;

        public a(b bVar, d.b.i0.b1.c.b bVar2) {
            this.f52006e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f52006e.a()), this.f52006e.f(), "5")));
            StatisticItem statisticItem = new StatisticItem("c10811");
            TiebaStatic.log(statisticItem.param("obj_name", "" + this.f52006e.f()));
        }
    }

    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, d.b.i0.b1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        l0(i, view, viewGroup, bVar, hotRankListManualItemHolder);
        return view;
    }

    public final void h0(HotRankListManualItemHolder hotRankListManualItemHolder, d.b.i0.b1.c.b bVar) {
        if (hotRankListManualItemHolder == null || bVar == null) {
            return;
        }
        String string = StringUtils.isNull(bVar.e()) ? this.f42358e.getResources().getString(R.string.hot_topic_hot_trend) : bVar.e();
        hotRankListManualItemHolder.f17572d.setText(bVar.g());
        hotRankListManualItemHolder.f17570b.setText(string);
        hotRankListManualItemHolder.f17575g.W(bVar.j(), 10, false);
        if (StringUtils.isNull(bVar.f())) {
            hotRankListManualItemHolder.f17571c.setVisibility(8);
            hotRankListManualItemHolder.f17572d.setPadding(0, 0, 0, 0);
        } else {
            hotRankListManualItemHolder.f17571c.setVisibility(0);
            hotRankListManualItemHolder.f17571c.setText(bVar.f());
        }
        hotRankListManualItemHolder.f17576h.setOnClickListener(new a(this, bVar));
    }

    public final void i0(HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (hotRankListManualItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListManualItemHolder.f17569a != skinType) {
            hotRankListManualItemHolder.f17569a = skinType;
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17570b, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17571c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17572d, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17573e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17574f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListManualItemHolder.f17576h, R.drawable.hot_topic_ranklist_bg);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public HotRankListManualItemHolder R(ViewGroup viewGroup) {
        return new HotRankListManualItemHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.b1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (bVar != null) {
            i0(hotRankListManualItemHolder);
            h0(hotRankListManualItemHolder, bVar);
        }
        return view;
    }
}
