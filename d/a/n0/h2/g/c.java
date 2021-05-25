package d.a.n0.h2.g;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f55584b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f55585c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f55586d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f55587e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f55588f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55589g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.h2.d.c f55590h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.v3.d f55591i;
    public View j;
    public FrameLayout k;
    public d.a.m0.d0.h l;
    public PluginErrorTipView m;
    public InterfaceC1364c n;

    /* renamed from: a  reason: collision with root package name */
    public int f55583a = 3;
    public AbsListView.OnScrollListener o = new a();

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.f55587e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                c.this.f55587e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (c.this.f55587e == null || i2 != 1) {
                return;
            }
            c.this.f55587e.c();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                c.this.d();
                if (c.this.n != null) {
                    c.this.n.a(view);
                }
            }
        }
    }

    /* renamed from: d.a.n0.h2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1364c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view == null) {
            return;
        }
        this.f55584b = tbPageContext;
        this.f55585c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f55586d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f55587e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f55588f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f55588f.addFooterView(this.j);
        this.f55588f.setOnScrollListener(this.o);
        this.f55590h = new d.a.n0.h2.d.c(this.f55588f, tbPageContext, bdUniqueId);
        this.f55591i = new d.a.n0.v3.d(1);
    }

    public void c() {
        d.a.n0.h2.d.c cVar = this.f55590h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        d.a.m0.d0.h hVar = this.l;
        if (hVar != null) {
            hVar.dettachView(this.k);
            this.l = null;
        }
    }

    public void e() {
        this.f55589g = this.f55586d.setCenterTextTitle(this.f55584b.getString(R.string.mine));
        this.f55591i.n(this.f55584b.getPageActivity(), this.f55586d);
        this.f55591i.k();
        this.f55591i.o(null);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean f() {
        d.a.m0.d0.h hVar = this.l;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void g() {
        this.f55590h.b();
    }

    public void h(int i2) {
        if (this.f55583a != i2) {
            SkinManager.setViewTextColor(this.f55589g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f55588f, R.color.CAM_X0201);
            this.f55586d.onChangeSkinType(this.f55584b, i2);
            SkinManager.setBackgroundColor(this.f55586d.getBarBgView(), R.color.CAM_X0207, i2);
            this.f55590h.c();
            this.f55585c.c(this.f55584b, i2);
            this.m.e(this.f55584b, i2);
            this.f55591i.m(i2);
            d.a.m0.d0.h hVar = this.l;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f55587e, R.drawable.personalize_tab_shadow);
            this.f55583a = i2;
        }
    }

    public void i() {
        d.a.n0.h2.d.c cVar = this.f55590h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void j(d.a.n0.h2.e.f fVar) {
        if (fVar != null) {
            this.f55590h.d(fVar.n());
        }
    }

    public void k(InterfaceC1364c interfaceC1364c) {
        this.n = interfaceC1364c;
    }

    public void l(int i2, String str) {
        this.f55584b.showToast(str);
    }

    public void m() {
        d.a.n0.h2.d.c cVar = this.f55590h;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void n() {
        if (f()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.m0.d0.h(this.f55584b.getPageActivity(), new b());
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        this.f55591i.p(i2, z);
    }
}
