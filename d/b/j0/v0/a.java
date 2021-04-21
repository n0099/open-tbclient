package d.b.j0.v0;

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
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbListView f63395a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f63396b;

    /* renamed from: c  reason: collision with root package name */
    public View f63397c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f63398d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f63399e;

    /* renamed from: f  reason: collision with root package name */
    public g f63400f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.v0.b.a f63401g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f63402h;

    public a(BaseActivity baseActivity) {
        this.f63396b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f63397c = this.f63396b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f63396b.findViewById(R.id.view_navigation_bar);
        this.f63398d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f63398d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63402h = (NoNetworkView) this.f63396b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f63396b.getPageContext().getPageActivity());
        this.f63395a = pbListView;
        pbListView.a();
        this.f63395a.O();
        this.f63399e = (BdTypeListView) this.f63396b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f63396b.getPageContext());
        this.f63400f = gVar;
        BaseActivity baseActivity2 = this.f63396b;
        if (baseActivity2 instanceof f.g) {
            gVar.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f63396b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f63399e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f63399e.setPullRefresh(this.f63400f);
        d.b.j0.v0.b.a aVar = new d.b.j0.v0.b.a(this.f63396b.getPageContext(), this.f63399e);
        this.f63401g = aVar;
        this.f63399e.a(aVar.a());
        this.f63399e.setNextPage(this.f63395a);
    }

    public BdTypeListView a() {
        return this.f63399e;
    }

    public void b() {
        this.f63399e.setVisibility(0);
        this.f63396b.hideLoadingView(this.f63397c);
    }

    public void c() {
        this.f63399e.setVisibility(0);
        this.f63396b.hideNetRefreshView(this.f63397c);
    }

    public void d() {
        this.f63395a.A(this.f63396b.getResources().getString(R.string.network_ungeilivable));
        this.f63395a.f();
    }

    public void e() {
        this.f63395a.A(this.f63396b.getResources().getString(R.string.list_no_more));
        this.f63395a.f();
    }

    public void f() {
        this.f63395a.O();
    }

    public void g() {
        this.f63401g.b();
    }

    public void h(int i) {
        this.f63398d.onChangeSkinType(this.f63396b.getPageContext(), i);
        this.f63395a.o(R.color.CAM_X0204);
        this.f63395a.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f63395a.d(i);
        this.f63402h.c(this.f63396b.getPageContext(), i);
    }

    public void i(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f63402h.a(bVar);
    }

    public void j() {
        this.f63399e.setVisibility(8);
        this.f63396b.showLoadingView(this.f63397c, true);
    }

    public void k(String str) {
        this.f63399e.setVisibility(8);
        this.f63396b.showNetRefreshView(this.f63397c, str, true);
    }

    public void l() {
        this.f63399e.F();
    }

    public void m(List<n> list) {
        if (list == null) {
            return;
        }
        this.f63399e.setData(list);
    }
}
