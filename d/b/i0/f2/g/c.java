package d.b.i0.f2.g;

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
import d.b.b.e.p.j;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54809b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f54810c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f54811d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f54812e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f54813f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54814g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.f2.d.c f54815h;
    public d.b.i0.t3.d i;
    public View j;
    public FrameLayout k;
    public d.b.h0.d0.h l;
    public PluginErrorTipView m;
    public InterfaceC1250c n;

    /* renamed from: a  reason: collision with root package name */
    public int f54808a = 3;
    public AbsListView.OnScrollListener o = new a();

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.f54812e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                c.this.f54812e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.f54812e == null || i != 1) {
                return;
            }
            c.this.f54812e.c();
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

    /* renamed from: d.b.i0.f2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1250c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view == null) {
            return;
        }
        this.f54809b = tbPageContext;
        this.f54810c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f54811d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f54812e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f54813f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f54813f.addFooterView(this.j);
        this.f54813f.setOnScrollListener(this.o);
        this.f54815h = new d.b.i0.f2.d.c(this.f54813f, tbPageContext, bdUniqueId);
        this.i = new d.b.i0.t3.d(1);
    }

    public void c() {
        d.b.i0.f2.d.c cVar = this.f54815h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        d.b.h0.d0.h hVar = this.l;
        if (hVar != null) {
            hVar.dettachView(this.k);
            this.l = null;
        }
    }

    public void e() {
        this.f54814g = this.f54811d.setCenterTextTitle(this.f54809b.getString(R.string.mine));
        this.i.n(this.f54809b.getPageActivity(), this.f54811d);
        this.i.k();
        this.i.o(null);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean f() {
        d.b.h0.d0.h hVar = this.l;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void g() {
        this.f54815h.b();
    }

    public void h(int i) {
        if (this.f54808a != i) {
            SkinManager.setViewTextColor(this.f54814g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f54813f, R.color.CAM_X0201);
            this.f54811d.onChangeSkinType(this.f54809b, i);
            SkinManager.setBackgroundColor(this.f54811d.getBarBgView(), R.color.CAM_X0207, i);
            this.f54815h.c();
            this.f54810c.c(this.f54809b, i);
            this.m.e(this.f54809b, i);
            this.i.m(i);
            d.b.h0.d0.h hVar = this.l;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f54812e, R.drawable.personalize_tab_shadow);
            this.f54808a = i;
        }
    }

    public void i() {
        d.b.i0.f2.d.c cVar = this.f54815h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void j(d.b.i0.f2.e.f fVar) {
        if (fVar != null) {
            this.f54815h.d(fVar.n());
        }
    }

    public void k(InterfaceC1250c interfaceC1250c) {
        this.n = interfaceC1250c;
    }

    public void l(int i, String str) {
        this.f54809b.showToast(str);
    }

    public void m() {
        d.b.i0.f2.d.c cVar = this.f54815h;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void n() {
        if (f()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.b.h0.d0.h(this.f54809b.getPageActivity(), new b());
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i, boolean z) {
        this.i.p(i, z);
    }
}
