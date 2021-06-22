package d.a.o0.w0;

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
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f66295a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f66296b;

    /* renamed from: c  reason: collision with root package name */
    public View f66297c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f66298d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f66299e;

    /* renamed from: f  reason: collision with root package name */
    public g f66300f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.w0.b.a f66301g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f66302h;

    public a(BaseActivity baseActivity) {
        this.f66296b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f66297c = this.f66296b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f66296b.findViewById(R.id.view_navigation_bar);
        this.f66298d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f66298d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66302h = (NoNetworkView) this.f66296b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f66296b.getPageContext().getPageActivity());
        this.f66295a = pbListView;
        pbListView.a();
        this.f66295a.O();
        this.f66299e = (BdTypeListView) this.f66296b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f66296b.getPageContext());
        this.f66300f = gVar;
        BaseActivity baseActivity2 = this.f66296b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f66296b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f66299e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f66299e.setPullRefresh(this.f66300f);
        d.a.o0.w0.b.a aVar = new d.a.o0.w0.b.a(this.f66296b.getPageContext(), this.f66299e);
        this.f66301g = aVar;
        this.f66299e.a(aVar.a());
        this.f66299e.setNextPage(this.f66295a);
    }

    public BdTypeListView a() {
        return this.f66299e;
    }

    public void b() {
        this.f66299e.setVisibility(0);
        this.f66296b.hideLoadingView(this.f66297c);
    }

    public void c() {
        this.f66299e.setVisibility(0);
        this.f66296b.hideNetRefreshView(this.f66297c);
    }

    public void d() {
        this.f66295a.A(this.f66296b.getResources().getString(R.string.network_ungeilivable));
        this.f66295a.f();
    }

    public void e() {
        this.f66295a.A(this.f66296b.getResources().getString(R.string.list_no_more));
        this.f66295a.f();
    }

    public void f() {
        this.f66295a.O();
    }

    public void g() {
        this.f66301g.b();
    }

    public void h(int i2) {
        this.f66298d.onChangeSkinType(this.f66296b.getPageContext(), i2);
        this.f66295a.o(R.color.CAM_X0204);
        this.f66295a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f66295a.d(i2);
        this.f66302h.c(this.f66296b.getPageContext(), i2);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f66302h.a(bVar);
    }

    public void j() {
        this.f66299e.setVisibility(8);
        this.f66296b.showLoadingView(this.f66297c, true);
    }

    public void k(String str) {
        this.f66299e.setVisibility(8);
        this.f66296b.showNetRefreshView(this.f66297c, str, true);
    }

    public void l() {
        this.f66299e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f66299e.setData(list);
    }
}
