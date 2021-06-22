package d.a.o0.b1.g.i;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.lowFlows.LowFlowsActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.m.f;
import d.a.n0.r.q.z1;
import d.a.o0.b1.g.b;
import d.a.o0.b1.g.c;
import d.a.o0.b1.g.d.d;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements c, View.OnClickListener, f {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f55435e;

    /* renamed from: f  reason: collision with root package name */
    public LowFlowsActivity f55436f;

    /* renamed from: h  reason: collision with root package name */
    public d f55438h;

    /* renamed from: i  reason: collision with root package name */
    public String f55439i;
    public String j;
    public View m;
    public ImageView n;
    public ImageView o;
    public NavigationBar p;
    public BdTypeRecyclerView q;
    public View r;
    public ImageView s;
    public TextView t;
    public CollapsingToolbarLayout u;
    public View v;
    public View w;
    public AppBarLayout x;
    public TextView y;
    public RelativeLayout z;
    public String k = "";
    public int l = 3;
    public AppBarLayout.OnOffsetChangedListener A = new C1261a();

    /* renamed from: g  reason: collision with root package name */
    public b f55437g = new d.a.o0.b1.g.g.a(this);

    /* renamed from: d.a.o0.b1.g.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1261a implements AppBarLayout.OnOffsetChangedListener {
        public C1261a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            int totalScrollRange = appBarLayout.getTotalScrollRange() - a.this.i();
            if (totalScrollRange <= 0) {
                return;
            }
            float abs = Math.abs(i2 * 1.0f) / totalScrollRange;
            if (Float.compare(abs, 1.0f) > 0) {
                abs = 1.0f;
            }
            if (a.this.p == null || abs != 1.0f) {
                WebPManager.setPureDrawable(a.this.s, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (a.this.t != null) {
                    a.this.t.setAlpha(0.0f);
                }
                if (a.this.p.getBarBgView() != null) {
                    a.this.p.getBarBgView().setAlpha(0.0f);
                    return;
                }
                return;
            }
            if (a.this.p.getBarBgView() != null) {
                a.this.p.getBarBgView().setAlpha(1.0f);
            }
            if (a.this.t != null) {
                a.this.t.setAlpha(1.0f);
            }
            WebPManager.setPureDrawable(a.this.s, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f55435e = tbPageContext;
        this.f55436f = (LowFlowsActivity) tbPageContext.getPageActivity();
        m();
        k();
    }

    @Override // d.a.n0.m.f
    public void a(View view, Object obj, int i2, long j) {
        d.a.o0.b1.g.h.a.a("c14084", StringUtils.isNull(this.k) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), this.f55439i);
    }

    @Override // d.a.o0.b1.g.c
    public void b(int i2) {
        View view;
        LowFlowsActivity lowFlowsActivity;
        View view2 = this.v;
        if (view2 != null && view2.getParent() != null && (lowFlowsActivity = this.f55436f) != null) {
            lowFlowsActivity.hideLoadingView(this.v);
            this.v.setVisibility(8);
        }
        if (this.f55436f == null || (view = this.w) == null) {
            return;
        }
        view.setVisibility(0);
        this.f55436f.showNetRefreshView(this.w, "");
    }

    @Override // d.a.n0.m.f
    public void c(View view, Object obj, int i2, long j) {
    }

    public final BdUniqueId h() {
        TbPageContext tbPageContext = this.f55435e;
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public final int i() {
        NavigationBar navigationBar = this.p;
        if (navigationBar == null) {
            return 0;
        }
        return navigationBar.getHeight();
    }

    public View j() {
        TbPageContext tbPageContext;
        if (this.m == null && (tbPageContext = this.f55435e) != null) {
            this.m = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.activity_low_flows, (ViewGroup) null);
        }
        return this.m;
    }

    public final void k() {
        TbPageContext tbPageContext = this.f55435e;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f55435e.getPageActivity().setContentView(j());
        this.n = (ImageView) j().findViewById(R.id.header_img);
        this.o = (ImageView) j().findViewById(R.id.header_shadow);
        this.p = (NavigationBar) j().findViewById(R.id.lf_navigation_bar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) j().findViewById(R.id.more_treasure_trove_content);
        this.q = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55435e.getPageActivity()));
        this.q.setFadingEdgeLength(0);
        n(this.f55439i);
        AppBarLayout appBarLayout = (AppBarLayout) j().findViewById(R.id.lf_app_bar_layout);
        this.x = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.A);
        this.u = (CollapsingToolbarLayout) j().findViewById(R.id.lf_collapse_layout);
        this.v = j().findViewById(R.id.net_loading_view);
        this.w = j().findViewById(R.id.net_refresh_view);
        l();
        d dVar = new d(this.f55435e, this.q);
        this.f55438h = dVar;
        dVar.e(h());
        this.f55438h.d(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void l() {
        TbPageContext tbPageContext = this.f55435e;
        if (tbPageContext != null) {
            int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X008);
            this.z = new RelativeLayout(this.f55435e.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.z.setPadding(0, g2, 0, g2);
            this.z.setLayoutParams(layoutParams);
            this.y = new TextView(this.f55435e.getPageActivity());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.y.setLayoutParams(layoutParams2);
            this.y.setText(R.string.lf_footer_no_more);
            this.y.setBackgroundColor(0);
            this.z.addView(this.y);
        }
    }

    @Override // d.a.o0.b1.g.c
    public void loadData() {
        LowFlowsActivity lowFlowsActivity;
        View view = this.w;
        if (view != null && view.getParent() != null && (lowFlowsActivity = this.f55436f) != null) {
            lowFlowsActivity.hideNetRefreshView(this.w);
            this.w.setVisibility(8);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.q;
        if (bdTypeRecyclerView != null && bdTypeRecyclerView.getParent() != null) {
            this.q.setVisibility(8);
        }
        View view2 = this.v;
        if (view2 != null && this.f55436f != null) {
            view2.setVisibility(0);
            this.f55436f.showLoadingView(this.v);
        }
        ImageView imageView = this.o;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.o.setVisibility(8);
        }
        b bVar = this.f55437g;
        if (bVar != null) {
            bVar.a(h(), this.f55439i, this.j, this.k);
        }
    }

    public final void m() {
        Intent intent;
        TbPageContext tbPageContext = this.f55435e;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f55435e.getPageActivity().getIntent()) == null) {
            return;
        }
        this.f55439i = intent.getStringExtra(LowFlowsActivityConfig.TAB_CODE);
        this.j = intent.getStringExtra(LowFlowsActivityConfig.LF_USER);
        this.k = intent.getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID);
    }

    public void n(String str) {
        Drawable[] a2 = d.a.o0.b1.g.h.b.a(str);
        if (a2 != null) {
            this.n.setImageDrawable(a2[0]);
            this.o.setImageDrawable(a2[1]);
        }
        o(d.a.o0.b1.g.h.b.b(str));
    }

    public void o(String str) {
        View addSystemImageButton = this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.r = addSystemImageButton;
        this.s = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.t = this.p.getCenterText();
        this.p.setCenterTextTitle(str);
    }

    @Override // d.a.o0.b1.g.c
    public void onChangeSkinType(int i2) {
        if (this.l != i2) {
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.t);
            d2.x(R.string.F_X02);
            d2.w(R.dimen.T_X05);
            d2.s(R.color.CAM_X0105);
            this.p.getBarBgView().setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
            Drawable[] a2 = d.a.o0.b1.g.h.b.a(this.f55439i);
            if (a2 != null) {
                this.n.setImageDrawable(a2[0]);
                this.o.setImageDrawable(a2[1]);
            }
            this.z.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
            d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(this.y);
            d3.w(R.dimen.T_X08);
            d3.s(R.color.CAM_X0109);
            d dVar = this.f55438h;
            if (dVar != null) {
                dVar.b();
            }
        }
        this.l = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f55435e == null || view.getId() != R.id.navigationBarGoBack || this.f55435e.getPageActivity() == null) {
            return;
        }
        this.f55435e.getPageActivity().finish();
    }

    @Override // d.a.o0.b1.g.c
    public void setData(List<n> list) {
        View view = this.v;
        if (view != null && this.f55436f != null && view.getParent() != null) {
            this.f55436f.hideLoadingView(this.v);
            this.v.setVisibility(8);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.q;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        ImageView imageView = this.o;
        if (imageView != null && imageView.getVisibility() == 8) {
            this.o.setVisibility(0);
        }
        for (n nVar : list) {
            if (nVar instanceof z1) {
                ((z1) nVar).i().d2 = this.f55439i;
            }
        }
        d dVar = this.f55438h;
        if (dVar != null) {
            dVar.c(list);
        }
        this.q.setFooterView(this.z);
    }
}
