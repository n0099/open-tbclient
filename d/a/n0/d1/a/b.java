package d.a.n0.d1.a;

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
public class b extends d.a.c.k.e.a<d.a.n0.d1.c.b, HotRankListManualItemHolder> {
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.b f56150e;

        public a(b bVar, d.a.n0.d1.c.b bVar2) {
            this.f56150e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f56150e.b()), this.f56150e.e(), "5")));
            StatisticItem statisticItem = new StatisticItem("c10811");
            TiebaStatic.log(statisticItem.param("obj_name", "" + this.f56150e.e()));
        }
    }

    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.n0.d1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        i0(i2, view, viewGroup, bVar, hotRankListManualItemHolder);
        return view;
    }

    public final void e0(HotRankListManualItemHolder hotRankListManualItemHolder, d.a.n0.d1.c.b bVar) {
        if (hotRankListManualItemHolder == null || bVar == null) {
            return;
        }
        String string = StringUtils.isNull(bVar.c()) ? this.f42909e.getResources().getString(R.string.hot_topic_hot_trend) : bVar.c();
        hotRankListManualItemHolder.f16852d.setText(bVar.g());
        hotRankListManualItemHolder.f16850b.setText(string);
        hotRankListManualItemHolder.f16855g.U(bVar.h(), 10, false);
        if (StringUtils.isNull(bVar.e())) {
            hotRankListManualItemHolder.f16851c.setVisibility(8);
            hotRankListManualItemHolder.f16852d.setPadding(0, 0, 0, 0);
        } else {
            hotRankListManualItemHolder.f16851c.setVisibility(0);
            hotRankListManualItemHolder.f16851c.setText(bVar.e());
        }
        hotRankListManualItemHolder.f16856h.setOnClickListener(new a(this, bVar));
    }

    public final void g0(HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (hotRankListManualItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListManualItemHolder.f16849a != skinType) {
            hotRankListManualItemHolder.f16849a = skinType;
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f16850b, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f16851c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f16852d, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f16853e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f16854f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListManualItemHolder.f16856h, R.drawable.hot_topic_ranklist_bg);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public HotRankListManualItemHolder Q(ViewGroup viewGroup) {
        return new HotRankListManualItemHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false));
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.n0.d1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (bVar != null) {
            g0(hotRankListManualItemHolder);
            e0(hotRankListManualItemHolder, bVar);
        }
        return view;
    }
}
