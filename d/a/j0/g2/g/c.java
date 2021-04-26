package d.a.j0.g2.g;

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
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54603b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f54604c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f54605d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f54606e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f54607f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54608g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.g2.d.c f54609h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.u3.d f54610i;
    public View j;
    public FrameLayout k;
    public d.a.i0.d0.h l;
    public PluginErrorTipView m;
    public InterfaceC1270c n;

    /* renamed from: a  reason: collision with root package name */
    public int f54602a = 3;
    public AbsListView.OnScrollListener o = new a();

    /* loaded from: classes4.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.f54606e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                c.this.f54606e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (c.this.f54606e == null || i2 != 1) {
                return;
            }
            c.this.f54606e.c();
        }
    }

    /* loaded from: classes4.dex */
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

    /* renamed from: d.a.j0.g2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1270c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view == null) {
            return;
        }
        this.f54603b = tbPageContext;
        this.f54604c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f54605d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f54606e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f54607f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f54607f.addFooterView(this.j);
        this.f54607f.setOnScrollListener(this.o);
        this.f54609h = new d.a.j0.g2.d.c(this.f54607f, tbPageContext, bdUniqueId);
        this.f54610i = new d.a.j0.u3.d(1);
    }

    public void c() {
        d.a.j0.g2.d.c cVar = this.f54609h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        d.a.i0.d0.h hVar = this.l;
        if (hVar != null) {
            hVar.dettachView(this.k);
            this.l = null;
        }
    }

    public void e() {
        this.f54608g = this.f54605d.setCenterTextTitle(this.f54603b.getString(R.string.mine));
        this.f54610i.n(this.f54603b.getPageActivity(), this.f54605d);
        this.f54610i.k();
        this.f54610i.o(null);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean f() {
        d.a.i0.d0.h hVar = this.l;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void g() {
        this.f54609h.b();
    }

    public void h(int i2) {
        if (this.f54602a != i2) {
            SkinManager.setViewTextColor(this.f54608g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f54607f, R.color.CAM_X0201);
            this.f54605d.onChangeSkinType(this.f54603b, i2);
            SkinManager.setBackgroundColor(this.f54605d.getBarBgView(), R.color.CAM_X0207, i2);
            this.f54609h.c();
            this.f54604c.c(this.f54603b, i2);
            this.m.e(this.f54603b, i2);
            this.f54610i.m(i2);
            d.a.i0.d0.h hVar = this.l;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f54606e, R.drawable.personalize_tab_shadow);
            this.f54602a = i2;
        }
    }

    public void i() {
        d.a.j0.g2.d.c cVar = this.f54609h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void j(d.a.j0.g2.e.f fVar) {
        if (fVar != null) {
            this.f54609h.d(fVar.n());
        }
    }

    public void k(InterfaceC1270c interfaceC1270c) {
        this.n = interfaceC1270c;
    }

    public void l(int i2, String str) {
        this.f54603b.showToast(str);
    }

    public void m() {
        d.a.j0.g2.d.c cVar = this.f54609h;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void n() {
        if (f()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.i0.d0.h(this.f54603b.getPageActivity(), new b());
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        this.f54610i.p(i2, z);
    }
}
