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
    public TbPageContext f59273b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f59274c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59275d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f59276e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f59277f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59278g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.h2.d.c f59279h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.v3.d f59280i;
    public View j;
    public FrameLayout k;
    public d.a.m0.d0.h l;
    public PluginErrorTipView m;
    public InterfaceC1420c n;

    /* renamed from: a  reason: collision with root package name */
    public int f59272a = 3;
    public AbsListView.OnScrollListener o = new a();

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.f59276e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                c.this.f59276e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (c.this.f59276e == null || i2 != 1) {
                return;
            }
            c.this.f59276e.c();
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
    public interface InterfaceC1420c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view == null) {
            return;
        }
        this.f59273b = tbPageContext;
        this.f59274c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f59275d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f59276e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f59277f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f59277f.addFooterView(this.j);
        this.f59277f.setOnScrollListener(this.o);
        this.f59279h = new d.a.n0.h2.d.c(this.f59277f, tbPageContext, bdUniqueId);
        this.f59280i = new d.a.n0.v3.d(1);
    }

    public void c() {
        d.a.n0.h2.d.c cVar = this.f59279h;
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
        this.f59278g = this.f59275d.setCenterTextTitle(this.f59273b.getString(R.string.mine));
        this.f59280i.n(this.f59273b.getPageActivity(), this.f59275d);
        this.f59280i.k();
        this.f59280i.o(null);
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
        this.f59279h.b();
    }

    public void h(int i2) {
        if (this.f59272a != i2) {
            SkinManager.setViewTextColor(this.f59278g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f59277f, R.color.CAM_X0201);
            this.f59275d.onChangeSkinType(this.f59273b, i2);
            SkinManager.setBackgroundColor(this.f59275d.getBarBgView(), R.color.CAM_X0207, i2);
            this.f59279h.c();
            this.f59274c.c(this.f59273b, i2);
            this.m.e(this.f59273b, i2);
            this.f59280i.m(i2);
            d.a.m0.d0.h hVar = this.l;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f59276e, R.drawable.personalize_tab_shadow);
            this.f59272a = i2;
        }
    }

    public void i() {
        d.a.n0.h2.d.c cVar = this.f59279h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void j(d.a.n0.h2.e.f fVar) {
        if (fVar != null) {
            this.f59279h.d(fVar.n());
        }
    }

    public void k(InterfaceC1420c interfaceC1420c) {
        this.n = interfaceC1420c;
    }

    public void l(int i2, String str) {
        this.f59273b.showToast(str);
    }

    public void m() {
        d.a.n0.h2.d.c cVar = this.f59279h;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void n() {
        if (f()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.m0.d0.h(this.f59273b.getPageActivity(), new b());
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        this.f59280i.p(i2, z);
    }
}
