package d.a.n0.p0.c.o;

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
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58022a;

    /* renamed from: b  reason: collision with root package name */
    public View f58023b;

    /* renamed from: c  reason: collision with root package name */
    public View f58024c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58025d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f58026e;

    /* renamed from: f  reason: collision with root package name */
    public g f58027f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f58028g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.p0.c.o.a f58029h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58022a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f58022a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f58023b = this.f58022a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f58022a.findViewById(R.id.view_navigation_bar);
        this.f58025d = navigationBar;
        navigationBar.setCenterTextTitle(this.f58022a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f58025d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58022a.setNetRefreshViewTopMargin(BdListViewHelper.f12948a);
        this.f58028g = (NoNetworkView) this.f58022a.findViewById(R.id.view_no_network);
        this.f58026e = (BdTypeListView) this.f58022a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f58022a.getPageContext());
        this.f58027f = gVar;
        gVar.Z(this.f58022a.getUniqueId());
        BaseActivity baseActivity2 = this.f58022a;
        if (baseActivity2 instanceof f.g) {
            this.f58027f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f58022a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f58026e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f58026e.setPullRefresh(this.f58027f);
        this.f58024c = BdListViewHelper.d(this.f58022a.getPageContext().getPageActivity(), this.f58026e, BdListViewHelper.HeadType.DEFAULT);
        d.a.n0.p0.c.o.a aVar = new d.a.n0.p0.c.o.a(this.f58022a, this.f58026e);
        this.f58029h = aVar;
        this.f58026e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f58024c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f58026e.A(0L);
    }

    public void d() {
        this.f58026e.setVisibility(0);
        this.f58022a.hideLoadingView(this.f58023b);
    }

    public void e() {
        this.f58026e.setVisibility(0);
        this.f58022a.hideNetRefreshView(this.f58023b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f58026e.setData(list);
    }

    public void g() {
        this.f58029h.b();
    }

    public void h(int i2) {
        this.f58025d.onChangeSkinType(this.f58022a.getPageContext(), i2);
        this.f58028g.c(this.f58022a.getPageContext(), i2);
        g();
        SkinManager.setBackgroundColor(this.f58023b, R.color.CAM_X0204);
    }

    public void i() {
        this.f58029h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f58028g.a(bVar);
    }

    public void k() {
        this.f58026e.setVisibility(8);
        this.f58022a.showLoadingView(this.f58023b, true);
    }

    public void l(String str) {
        this.f58026e.setVisibility(8);
        this.f58022a.showNetRefreshView(this.f58023b, str, true);
    }

    public void m() {
        this.f58026e.F();
    }
}
