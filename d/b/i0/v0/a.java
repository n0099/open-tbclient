package d.b.i0.v0;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f62974a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f62975b;

    /* renamed from: c  reason: collision with root package name */
    public View f62976c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62977d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62978e;

    /* renamed from: f  reason: collision with root package name */
    public g f62979f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.v0.b.a f62980g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f62981h;

    public a(BaseActivity baseActivity) {
        this.f62975b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f62976c = this.f62975b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f62975b.findViewById(R.id.view_navigation_bar);
        this.f62977d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f62977d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62981h = (NoNetworkView) this.f62975b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f62975b.getPageContext().getPageActivity());
        this.f62974a = pbListView;
        pbListView.a();
        this.f62974a.O();
        this.f62978e = (BdTypeListView) this.f62975b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f62975b.getPageContext());
        this.f62979f = gVar;
        BaseActivity baseActivity2 = this.f62975b;
        if (baseActivity2 instanceof f.g) {
            gVar.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f62975b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f62978e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f62978e.setPullRefresh(this.f62979f);
        d.b.i0.v0.b.a aVar = new d.b.i0.v0.b.a(this.f62975b.getPageContext(), this.f62978e);
        this.f62980g = aVar;
        this.f62978e.a(aVar.a());
        this.f62978e.setNextPage(this.f62974a);
    }

    public BdTypeListView a() {
        return this.f62978e;
    }

    public void b() {
        this.f62978e.setVisibility(0);
        this.f62975b.hideLoadingView(this.f62976c);
    }

    public void c() {
        this.f62978e.setVisibility(0);
        this.f62975b.hideNetRefreshView(this.f62976c);
    }

    public void d() {
        this.f62974a.A(this.f62975b.getResources().getString(R.string.network_ungeilivable));
        this.f62974a.f();
    }

    public void e() {
        this.f62974a.A(this.f62975b.getResources().getString(R.string.list_no_more));
        this.f62974a.f();
    }

    public void f() {
        this.f62974a.O();
    }

    public void g() {
        this.f62980g.b();
    }

    public void h(int i) {
        this.f62977d.onChangeSkinType(this.f62975b.getPageContext(), i);
        this.f62974a.o(R.color.CAM_X0204);
        this.f62974a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f62974a.d(i);
        this.f62981h.c(this.f62975b.getPageContext(), i);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f62981h.a(bVar);
    }

    public void j() {
        this.f62978e.setVisibility(8);
        this.f62975b.showLoadingView(this.f62976c, true);
    }

    public void k(String str) {
        this.f62978e.setVisibility(8);
        this.f62975b.showNetRefreshView(this.f62976c, str, true);
    }

    public void l() {
        this.f62978e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f62978e.setData(list);
    }
}
