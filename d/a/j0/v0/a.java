package d.a.j0.v0;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f61625a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61626b;

    /* renamed from: c  reason: collision with root package name */
    public View f61627c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61628d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61629e;

    /* renamed from: f  reason: collision with root package name */
    public g f61630f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.v0.b.a f61631g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f61632h;

    public a(BaseActivity baseActivity) {
        this.f61626b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f61627c = this.f61626b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f61626b.findViewById(R.id.view_navigation_bar);
        this.f61628d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f61628d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61632h = (NoNetworkView) this.f61626b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f61626b.getPageContext().getPageActivity());
        this.f61625a = pbListView;
        pbListView.a();
        this.f61625a.O();
        this.f61629e = (BdTypeListView) this.f61626b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f61626b.getPageContext());
        this.f61630f = gVar;
        BaseActivity baseActivity2 = this.f61626b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f61626b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f61629e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f61629e.setPullRefresh(this.f61630f);
        d.a.j0.v0.b.a aVar = new d.a.j0.v0.b.a(this.f61626b.getPageContext(), this.f61629e);
        this.f61631g = aVar;
        this.f61629e.a(aVar.a());
        this.f61629e.setNextPage(this.f61625a);
    }

    public BdTypeListView a() {
        return this.f61629e;
    }

    public void b() {
        this.f61629e.setVisibility(0);
        this.f61626b.hideLoadingView(this.f61627c);
    }

    public void c() {
        this.f61629e.setVisibility(0);
        this.f61626b.hideNetRefreshView(this.f61627c);
    }

    public void d() {
        this.f61625a.A(this.f61626b.getResources().getString(R.string.network_ungeilivable));
        this.f61625a.f();
    }

    public void e() {
        this.f61625a.A(this.f61626b.getResources().getString(R.string.list_no_more));
        this.f61625a.f();
    }

    public void f() {
        this.f61625a.O();
    }

    public void g() {
        this.f61631g.b();
    }

    public void h(int i2) {
        this.f61628d.onChangeSkinType(this.f61626b.getPageContext(), i2);
        this.f61625a.o(R.color.CAM_X0204);
        this.f61625a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f61625a.d(i2);
        this.f61632h.c(this.f61626b.getPageContext(), i2);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f61632h.a(bVar);
    }

    public void j() {
        this.f61629e.setVisibility(8);
        this.f61626b.showLoadingView(this.f61627c, true);
    }

    public void k(String str) {
        this.f61629e.setVisibility(8);
        this.f61626b.showNetRefreshView(this.f61627c, str, true);
    }

    public void l() {
        this.f61629e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f61629e.setData(list);
    }
}
