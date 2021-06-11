package d.a.n0.w0;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f66170a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f66171b;

    /* renamed from: c  reason: collision with root package name */
    public View f66172c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f66173d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f66174e;

    /* renamed from: f  reason: collision with root package name */
    public g f66175f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.w0.b.a f66176g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f66177h;

    public a(BaseActivity baseActivity) {
        this.f66171b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f66172c = this.f66171b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f66171b.findViewById(R.id.view_navigation_bar);
        this.f66173d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f66173d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66177h = (NoNetworkView) this.f66171b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f66171b.getPageContext().getPageActivity());
        this.f66170a = pbListView;
        pbListView.a();
        this.f66170a.O();
        this.f66174e = (BdTypeListView) this.f66171b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f66171b.getPageContext());
        this.f66175f = gVar;
        BaseActivity baseActivity2 = this.f66171b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f66171b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f66174e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f66174e.setPullRefresh(this.f66175f);
        d.a.n0.w0.b.a aVar = new d.a.n0.w0.b.a(this.f66171b.getPageContext(), this.f66174e);
        this.f66176g = aVar;
        this.f66174e.a(aVar.a());
        this.f66174e.setNextPage(this.f66170a);
    }

    public BdTypeListView a() {
        return this.f66174e;
    }

    public void b() {
        this.f66174e.setVisibility(0);
        this.f66171b.hideLoadingView(this.f66172c);
    }

    public void c() {
        this.f66174e.setVisibility(0);
        this.f66171b.hideNetRefreshView(this.f66172c);
    }

    public void d() {
        this.f66170a.A(this.f66171b.getResources().getString(R.string.network_ungeilivable));
        this.f66170a.f();
    }

    public void e() {
        this.f66170a.A(this.f66171b.getResources().getString(R.string.list_no_more));
        this.f66170a.f();
    }

    public void f() {
        this.f66170a.O();
    }

    public void g() {
        this.f66176g.b();
    }

    public void h(int i2) {
        this.f66173d.onChangeSkinType(this.f66171b.getPageContext(), i2);
        this.f66170a.o(R.color.CAM_X0204);
        this.f66170a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f66170a.d(i2);
        this.f66177h.c(this.f66171b.getPageContext(), i2);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f66177h.a(bVar);
    }

    public void j() {
        this.f66174e.setVisibility(8);
        this.f66171b.showLoadingView(this.f66172c, true);
    }

    public void k(String str) {
        this.f66174e.setVisibility(8);
        this.f66171b.showNetRefreshView(this.f66172c, str, true);
    }

    public void l() {
        this.f66174e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f66174e.setData(list);
    }
}
