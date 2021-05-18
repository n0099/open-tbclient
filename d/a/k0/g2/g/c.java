package d.a.k0.g2.g;

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
    public TbPageContext f55310b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f55311c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f55312d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f55313e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f55314f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55315g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.g2.d.c f55316h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.u3.d f55317i;
    public View j;
    public FrameLayout k;
    public d.a.j0.d0.h l;
    public PluginErrorTipView m;
    public InterfaceC1342c n;

    /* renamed from: a  reason: collision with root package name */
    public int f55309a = 3;
    public AbsListView.OnScrollListener o = new a();

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.f55313e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                c.this.f55313e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (c.this.f55313e == null || i2 != 1) {
                return;
            }
            c.this.f55313e.c();
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

    /* renamed from: d.a.k0.g2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1342c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view == null) {
            return;
        }
        this.f55310b = tbPageContext;
        this.f55311c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f55312d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f55313e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f55314f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f55314f.addFooterView(this.j);
        this.f55314f.setOnScrollListener(this.o);
        this.f55316h = new d.a.k0.g2.d.c(this.f55314f, tbPageContext, bdUniqueId);
        this.f55317i = new d.a.k0.u3.d(1);
    }

    public void c() {
        d.a.k0.g2.d.c cVar = this.f55316h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        d.a.j0.d0.h hVar = this.l;
        if (hVar != null) {
            hVar.dettachView(this.k);
            this.l = null;
        }
    }

    public void e() {
        this.f55315g = this.f55312d.setCenterTextTitle(this.f55310b.getString(R.string.mine));
        this.f55317i.n(this.f55310b.getPageActivity(), this.f55312d);
        this.f55317i.k();
        this.f55317i.o(null);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean f() {
        d.a.j0.d0.h hVar = this.l;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void g() {
        this.f55316h.b();
    }

    public void h(int i2) {
        if (this.f55309a != i2) {
            SkinManager.setViewTextColor(this.f55315g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f55314f, R.color.CAM_X0201);
            this.f55312d.onChangeSkinType(this.f55310b, i2);
            SkinManager.setBackgroundColor(this.f55312d.getBarBgView(), R.color.CAM_X0207, i2);
            this.f55316h.c();
            this.f55311c.c(this.f55310b, i2);
            this.m.e(this.f55310b, i2);
            this.f55317i.m(i2);
            d.a.j0.d0.h hVar = this.l;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f55313e, R.drawable.personalize_tab_shadow);
            this.f55309a = i2;
        }
    }

    public void i() {
        d.a.k0.g2.d.c cVar = this.f55316h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void j(d.a.k0.g2.e.f fVar) {
        if (fVar != null) {
            this.f55316h.d(fVar.n());
        }
    }

    public void k(InterfaceC1342c interfaceC1342c) {
        this.n = interfaceC1342c;
    }

    public void l(int i2, String str) {
        this.f55310b.showToast(str);
    }

    public void m() {
        d.a.k0.g2.d.c cVar = this.f55316h;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void n() {
        if (f()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.j0.d0.h(this.f55310b.getPageActivity(), new b());
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        this.f55317i.p(i2, z);
    }
}
