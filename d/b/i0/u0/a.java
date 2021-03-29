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
    public PbListView f61236a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61237b;

    /* renamed from: c  reason: collision with root package name */
    public View f61238c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61239d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61240e;

    /* renamed from: f  reason: collision with root package name */
    public g f61241f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.u0.b.a f61242g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f61243h;

    public a(BaseActivity baseActivity) {
        this.f61237b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f61238c = this.f61237b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f61237b.findViewById(R.id.view_navigation_bar);
        this.f61239d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f61239d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61243h = (NoNetworkView) this.f61237b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f61237b.getPageContext().getPageActivity());
        this.f61236a = pbListView;
        pbListView.a();
        this.f61236a.O();
        this.f61240e = (BdTypeListView) this.f61237b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f61237b.getPageContext());
        this.f61241f = gVar;
        BaseActivity baseActivity2 = this.f61237b;
        if (baseActivity2 instanceof f.g) {
            gVar.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f61237b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f61240e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f61240e.setPullRefresh(this.f61241f);
        d.b.i0.u0.b.a aVar = new d.b.i0.u0.b.a(this.f61237b.getPageContext(), this.f61240e);
        this.f61242g = aVar;
        this.f61240e.a(aVar.a());
        this.f61240e.setNextPage(this.f61236a);
    }

    public BdTypeListView a() {
        return this.f61240e;
    }

    public void b() {
        this.f61240e.setVisibility(0);
        this.f61237b.hideLoadingView(this.f61238c);
    }

    public void c() {
        this.f61240e.setVisibility(0);
        this.f61237b.hideNetRefreshView(this.f61238c);
    }

    public void d() {
        this.f61236a.A(this.f61237b.getResources().getString(R.string.network_ungeilivable));
        this.f61236a.f();
    }

    public void e() {
        this.f61236a.A(this.f61237b.getResources().getString(R.string.list_no_more));
        this.f61236a.f();
    }

    public void f() {
        this.f61236a.O();
    }

    public void g() {
        this.f61242g.b();
    }

    public void h(int i) {
        this.f61239d.onChangeSkinType(this.f61237b.getPageContext(), i);
        this.f61236a.o(R.color.CAM_X0204);
        this.f61236a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f61236a.d(i);
        this.f61243h.c(this.f61237b.getPageContext(), i);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f61243h.a(bVar);
    }

    public void j() {
        this.f61240e.setVisibility(8);
        this.f61237b.showLoadingView(this.f61238c, true);
    }

    public void k(String str) {
        this.f61240e.setVisibility(8);
        this.f61237b.showNetRefreshView(this.f61238c, str, true);
    }

    public void l() {
        this.f61240e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f61240e.setData(list);
    }
}
