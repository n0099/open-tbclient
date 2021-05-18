package d.a.k0.v0;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f62349a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f62350b;

    /* renamed from: c  reason: collision with root package name */
    public View f62351c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62352d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62353e;

    /* renamed from: f  reason: collision with root package name */
    public g f62354f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.v0.b.a f62355g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f62356h;

    public a(BaseActivity baseActivity) {
        this.f62350b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f62351c = this.f62350b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f62350b.findViewById(R.id.view_navigation_bar);
        this.f62352d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f62352d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62356h = (NoNetworkView) this.f62350b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f62350b.getPageContext().getPageActivity());
        this.f62349a = pbListView;
        pbListView.a();
        this.f62349a.O();
        this.f62353e = (BdTypeListView) this.f62350b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f62350b.getPageContext());
        this.f62354f = gVar;
        BaseActivity baseActivity2 = this.f62350b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f62350b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f62353e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f62353e.setPullRefresh(this.f62354f);
        d.a.k0.v0.b.a aVar = new d.a.k0.v0.b.a(this.f62350b.getPageContext(), this.f62353e);
        this.f62355g = aVar;
        this.f62353e.a(aVar.a());
        this.f62353e.setNextPage(this.f62349a);
    }

    public BdTypeListView a() {
        return this.f62353e;
    }

    public void b() {
        this.f62353e.setVisibility(0);
        this.f62350b.hideLoadingView(this.f62351c);
    }

    public void c() {
        this.f62353e.setVisibility(0);
        this.f62350b.hideNetRefreshView(this.f62351c);
    }

    public void d() {
        this.f62349a.A(this.f62350b.getResources().getString(R.string.network_ungeilivable));
        this.f62349a.f();
    }

    public void e() {
        this.f62349a.A(this.f62350b.getResources().getString(R.string.list_no_more));
        this.f62349a.f();
    }

    public void f() {
        this.f62349a.O();
    }

    public void g() {
        this.f62355g.b();
    }

    public void h(int i2) {
        this.f62352d.onChangeSkinType(this.f62350b.getPageContext(), i2);
        this.f62349a.o(R.color.CAM_X0204);
        this.f62349a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f62349a.d(i2);
        this.f62356h.c(this.f62350b.getPageContext(), i2);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f62356h.a(bVar);
    }

    public void j() {
        this.f62353e.setVisibility(8);
        this.f62350b.showLoadingView(this.f62351c, true);
    }

    public void k(String str) {
        this.f62353e.setVisibility(8);
        this.f62350b.showNetRefreshView(this.f62351c, str, true);
    }

    public void l() {
        this.f62353e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f62353e.setData(list);
    }
}
