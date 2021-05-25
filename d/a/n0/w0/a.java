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
import d.a.c.j.e.n;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f62455a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f62456b;

    /* renamed from: c  reason: collision with root package name */
    public View f62457c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62458d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62459e;

    /* renamed from: f  reason: collision with root package name */
    public g f62460f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.w0.b.a f62461g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f62462h;

    public a(BaseActivity baseActivity) {
        this.f62456b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f62457c = this.f62456b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f62456b.findViewById(R.id.view_navigation_bar);
        this.f62458d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f62458d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62462h = (NoNetworkView) this.f62456b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f62456b.getPageContext().getPageActivity());
        this.f62455a = pbListView;
        pbListView.a();
        this.f62455a.O();
        this.f62459e = (BdTypeListView) this.f62456b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f62456b.getPageContext());
        this.f62460f = gVar;
        BaseActivity baseActivity2 = this.f62456b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f62456b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f62459e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f62459e.setPullRefresh(this.f62460f);
        d.a.n0.w0.b.a aVar = new d.a.n0.w0.b.a(this.f62456b.getPageContext(), this.f62459e);
        this.f62461g = aVar;
        this.f62459e.a(aVar.a());
        this.f62459e.setNextPage(this.f62455a);
    }

    public BdTypeListView a() {
        return this.f62459e;
    }

    public void b() {
        this.f62459e.setVisibility(0);
        this.f62456b.hideLoadingView(this.f62457c);
    }

    public void c() {
        this.f62459e.setVisibility(0);
        this.f62456b.hideNetRefreshView(this.f62457c);
    }

    public void d() {
        this.f62455a.A(this.f62456b.getResources().getString(R.string.network_ungeilivable));
        this.f62455a.f();
    }

    public void e() {
        this.f62455a.A(this.f62456b.getResources().getString(R.string.list_no_more));
        this.f62455a.f();
    }

    public void f() {
        this.f62455a.O();
    }

    public void g() {
        this.f62461g.b();
    }

    public void h(int i2) {
        this.f62458d.onChangeSkinType(this.f62456b.getPageContext(), i2);
        this.f62455a.o(R.color.CAM_X0204);
        this.f62455a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f62455a.d(i2);
        this.f62462h.c(this.f62456b.getPageContext(), i2);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f62462h.a(bVar);
    }

    public void j() {
        this.f62459e.setVisibility(8);
        this.f62456b.showLoadingView(this.f62457c, true);
    }

    public void k(String str) {
        this.f62459e.setVisibility(8);
        this.f62456b.showNetRefreshView(this.f62457c, str, true);
    }

    public void l() {
        this.f62459e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f62459e.setData(list);
    }
}
