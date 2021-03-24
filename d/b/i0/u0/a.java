package d.b.i0.u0;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.b.b.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f61235a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61236b;

    /* renamed from: c  reason: collision with root package name */
    public View f61237c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61238d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61239e;

    /* renamed from: f  reason: collision with root package name */
    public g f61240f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.u0.b.a f61241g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f61242h;

    public a(BaseActivity baseActivity) {
        this.f61236b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f61237c = this.f61236b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f61236b.findViewById(R.id.view_navigation_bar);
        this.f61238d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f61238d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61242h = (NoNetworkView) this.f61236b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f61236b.getPageContext().getPageActivity());
        this.f61235a = pbListView;
        pbListView.a();
        this.f61235a.O();
        this.f61239e = (BdTypeListView) this.f61236b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f61236b.getPageContext());
        this.f61240f = gVar;
        BaseActivity baseActivity2 = this.f61236b;
        if (baseActivity2 instanceof f.g) {
            gVar.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f61236b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f61239e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f61239e.setPullRefresh(this.f61240f);
        d.b.i0.u0.b.a aVar = new d.b.i0.u0.b.a(this.f61236b.getPageContext(), this.f61239e);
        this.f61241g = aVar;
        this.f61239e.a(aVar.a());
        this.f61239e.setNextPage(this.f61235a);
    }

    public BdTypeListView a() {
        return this.f61239e;
    }

    public void b() {
        this.f61239e.setVisibility(0);
        this.f61236b.hideLoadingView(this.f61237c);
    }

    public void c() {
        this.f61239e.setVisibility(0);
        this.f61236b.hideNetRefreshView(this.f61237c);
    }

    public void d() {
        this.f61235a.A(this.f61236b.getResources().getString(R.string.network_ungeilivable));
        this.f61235a.f();
    }

    public void e() {
        this.f61235a.A(this.f61236b.getResources().getString(R.string.list_no_more));
        this.f61235a.f();
    }

    public void f() {
        this.f61235a.O();
    }

    public void g() {
        this.f61241g.b();
    }

    public void h(int i) {
        this.f61238d.onChangeSkinType(this.f61236b.getPageContext(), i);
        this.f61235a.o(R.color.CAM_X0204);
        this.f61235a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f61235a.d(i);
        this.f61242h.c(this.f61236b.getPageContext(), i);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f61242h.a(bVar);
    }

    public void j() {
        this.f61239e.setVisibility(8);
        this.f61236b.showLoadingView(this.f61237c, true);
    }

    public void k(String str) {
        this.f61239e.setVisibility(8);
        this.f61236b.showNetRefreshView(this.f61237c, str, true);
    }

    public void l() {
        this.f61239e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f61239e.setData(list);
    }
}
