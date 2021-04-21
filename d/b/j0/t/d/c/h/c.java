package d.b.j0.t.d.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class c extends d.b.j0.x.b<d.b.j0.t.d.c.e.f> {
    public View m;
    public TabLiveStageLiveView n;
    public int o;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = 0;
        u();
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.tab_live_stage_item_view;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0201);
        TabLiveStageLiveView tabLiveStageLiveView = this.n;
        if (tabLiveStageLiveView != null) {
            tabLiveStageLiveView.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void u() {
        this.m = m();
        int[] a2 = d.b.j0.t.d.c.c.a(b());
        int i = a2[0];
        int i2 = a2[1];
        TabLiveStageLiveView tabLiveStageLiveView = (TabLiveStageLiveView) this.m.findViewById(R.id.stage_live_view);
        this.n = tabLiveStageLiveView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tabLiveStageLiveView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.gravity = 1;
        this.n.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: v */
    public void n(d.b.j0.t.d.c.e.f fVar) {
        if (fVar == null || fVar.f62317e == null) {
            return;
        }
        int k = l.k(this.f64178g);
        if (k != this.o) {
            int[] a2 = d.b.j0.t.d.c.c.a(b());
            int i = a2[0];
            int i2 = a2[1];
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.n.setLayoutParams(layoutParams);
            this.o = k;
        }
        this.n.setData(fVar.f62317e.f62318a, 101);
        StatisticItem statisticItem = new StatisticItem("c13551");
        statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
        TiebaStatic.log(statisticItem);
    }
}
