package d.a.j0.t.d.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class c extends d.a.j0.x.b<d.a.j0.t.d.c.e.f> {
    public View m;
    public TabLiveStageLiveView n;
    public int o;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 0;
        s();
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.tab_live_stage_item_view;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0201);
        TabLiveStageLiveView tabLiveStageLiveView = this.n;
        if (tabLiveStageLiveView != null) {
            tabLiveStageLiveView.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void s() {
        this.m = l();
        int[] b2 = d.a.j0.t.d.c.c.b(b());
        int i2 = b2[0];
        int i3 = b2[1];
        TabLiveStageLiveView tabLiveStageLiveView = (TabLiveStageLiveView) this.m.findViewById(R.id.stage_live_view);
        this.n = tabLiveStageLiveView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tabLiveStageLiveView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i2, i3);
        } else {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        layoutParams.gravity = 1;
        this.n.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(d.a.j0.t.d.c.e.f fVar) {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        if (fVar == null || fVar.f60495e == null) {
            return;
        }
        int k = l.k(this.f62438g);
        if (k != this.o) {
            int[] b2 = d.a.j0.t.d.c.c.b(b());
            int i2 = b2[0];
            int i3 = b2[1];
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
            this.n.setLayoutParams(layoutParams);
            this.o = k;
        }
        this.n.setData(fVar.f60495e.f60496a, 101);
        StatisticItem statisticItem = new StatisticItem("c13551");
        d.a.j0.t.d.c.e.g gVar = fVar.f60495e;
        if (gVar != null && (sdkLiveInfoData = gVar.f60496a) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null) {
            int a2 = d.a.j0.t.d.c.c.a(alaLiveInfo);
            SdkLiveInfoData.YYExt yYExt = fVar.f60495e.f60496a.liveInfo.yyExt;
            if (yYExt != null) {
                TiebaStaticHelper.addYYParam(statisticItem, d.a.j0.t.d.c.c.k(yYExt));
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param("obj_param1", a2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
        TiebaStatic.log(statisticItem);
    }
}
