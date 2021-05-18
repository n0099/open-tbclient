package d.a.k0.o0.c.o;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f57913a;

    /* renamed from: b  reason: collision with root package name */
    public View f57914b;

    /* renamed from: c  reason: collision with root package name */
    public View f57915c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57916d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f57917e;

    /* renamed from: f  reason: collision with root package name */
    public g f57918f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f57919g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.o0.c.o.a f57920h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57913a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f57913a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f57914b = this.f57913a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f57913a.findViewById(R.id.view_navigation_bar);
        this.f57916d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57913a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f57916d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57913a.setNetRefreshViewTopMargin(BdListViewHelper.f13040a);
        this.f57919g = (NoNetworkView) this.f57913a.findViewById(R.id.view_no_network);
        this.f57917e = (BdTypeListView) this.f57913a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f57913a.getPageContext());
        this.f57918f = gVar;
        gVar.Z(this.f57913a.getUniqueId());
        BaseActivity baseActivity2 = this.f57913a;
        if (baseActivity2 instanceof f.g) {
            this.f57918f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f57913a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f57917e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f57917e.setPullRefresh(this.f57918f);
        this.f57915c = BdListViewHelper.d(this.f57913a.getPageContext().getPageActivity(), this.f57917e, BdListViewHelper.HeadType.DEFAULT);
        d.a.k0.o0.c.o.a aVar = new d.a.k0.o0.c.o.a(this.f57913a, this.f57917e);
        this.f57920h = aVar;
        this.f57917e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f57915c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f57917e.A(0L);
    }

    public void d() {
        this.f57917e.setVisibility(0);
        this.f57913a.hideLoadingView(this.f57914b);
    }

    public void e() {
        this.f57917e.setVisibility(0);
        this.f57913a.hideNetRefreshView(this.f57914b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f57917e.setData(list);
    }

    public void g() {
        this.f57920h.b();
    }

    public void h(int i2) {
        this.f57916d.onChangeSkinType(this.f57913a.getPageContext(), i2);
        this.f57919g.c(this.f57913a.getPageContext(), i2);
        g();
        SkinManager.setBackgroundColor(this.f57914b, R.color.CAM_X0204);
    }

    public void i() {
        this.f57920h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f57919g.a(bVar);
    }

    public void k() {
        this.f57917e.setVisibility(8);
        this.f57913a.showLoadingView(this.f57914b, true);
    }

    public void l(String str) {
        this.f57917e.setVisibility(8);
        this.f57913a.showNetRefreshView(this.f57914b, str, true);
    }

    public void m() {
        this.f57917e.F();
    }
}
