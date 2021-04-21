package d.b.j0.g2.g;

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
import d.b.c.e.p.j;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56701b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f56702c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56703d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f56704e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f56705f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56706g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.g2.d.c f56707h;
    public d.b.j0.u3.d i;
    public View j;
    public FrameLayout k;
    public d.b.i0.d0.h l;
    public PluginErrorTipView m;
    public InterfaceC1331c n;

    /* renamed from: a  reason: collision with root package name */
    public int f56700a = 3;
    public AbsListView.OnScrollListener o = new a();

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.f56704e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                c.this.f56704e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.f56704e == null || i != 1) {
                return;
            }
            c.this.f56704e.c();
        }
    }

    /* loaded from: classes3.dex */
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

    /* renamed from: d.b.j0.g2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1331c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view == null) {
            return;
        }
        this.f56701b = tbPageContext;
        this.f56702c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f56703d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f56704e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f56705f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f56705f.addFooterView(this.j);
        this.f56705f.setOnScrollListener(this.o);
        this.f56707h = new d.b.j0.g2.d.c(this.f56705f, tbPageContext, bdUniqueId);
        this.i = new d.b.j0.u3.d(1);
    }

    public void c() {
        d.b.j0.g2.d.c cVar = this.f56707h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        d.b.i0.d0.h hVar = this.l;
        if (hVar != null) {
            hVar.dettachView(this.k);
            this.l = null;
        }
    }

    public void e() {
        this.f56706g = this.f56703d.setCenterTextTitle(this.f56701b.getString(R.string.mine));
        this.i.n(this.f56701b.getPageActivity(), this.f56703d);
        this.i.k();
        this.i.o(null);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean f() {
        d.b.i0.d0.h hVar = this.l;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void g() {
        this.f56707h.b();
    }

    public void h(int i) {
        if (this.f56700a != i) {
            SkinManager.setViewTextColor(this.f56706g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f56705f, R.color.CAM_X0201);
            this.f56703d.onChangeSkinType(this.f56701b, i);
            SkinManager.setBackgroundColor(this.f56703d.getBarBgView(), R.color.CAM_X0207, i);
            this.f56707h.c();
            this.f56702c.c(this.f56701b, i);
            this.m.e(this.f56701b, i);
            this.i.m(i);
            d.b.i0.d0.h hVar = this.l;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f56704e, R.drawable.personalize_tab_shadow);
            this.f56700a = i;
        }
    }

    public void i() {
        d.b.j0.g2.d.c cVar = this.f56707h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void j(d.b.j0.g2.e.f fVar) {
        if (fVar != null) {
            this.f56707h.d(fVar.n());
        }
    }

    public void k(InterfaceC1331c interfaceC1331c) {
        this.n = interfaceC1331c;
    }

    public void l(int i, String str) {
        this.f56701b.showToast(str);
    }

    public void m() {
        d.b.j0.g2.d.c cVar = this.f56707h;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void n() {
        if (f()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.b.i0.d0.h(this.f56701b.getPageActivity(), new b());
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i, boolean z) {
        this.i.p(i, z);
    }
}
