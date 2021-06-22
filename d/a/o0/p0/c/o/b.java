package d.a.o0.p0.c.o;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f61838a;

    /* renamed from: b  reason: collision with root package name */
    public View f61839b;

    /* renamed from: c  reason: collision with root package name */
    public View f61840c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61841d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61842e;

    /* renamed from: f  reason: collision with root package name */
    public g f61843f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f61844g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.p0.c.o.a f61845h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f61838a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f61838a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f61839b = this.f61838a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f61838a.findViewById(R.id.view_navigation_bar);
        this.f61841d = navigationBar;
        navigationBar.setCenterTextTitle(this.f61838a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f61841d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61838a.setNetRefreshViewTopMargin(BdListViewHelper.f13095a);
        this.f61844g = (NoNetworkView) this.f61838a.findViewById(R.id.view_no_network);
        this.f61842e = (BdTypeListView) this.f61838a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f61838a.getPageContext());
        this.f61843f = gVar;
        gVar.Z(this.f61838a.getUniqueId());
        BaseActivity baseActivity2 = this.f61838a;
        if (baseActivity2 instanceof f.g) {
            this.f61843f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f61838a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f61842e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f61842e.setPullRefresh(this.f61843f);
        this.f61840c = BdListViewHelper.d(this.f61838a.getPageContext().getPageActivity(), this.f61842e, BdListViewHelper.HeadType.DEFAULT);
        d.a.o0.p0.c.o.a aVar = new d.a.o0.p0.c.o.a(this.f61838a, this.f61842e);
        this.f61845h = aVar;
        this.f61842e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f61840c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f61842e.A(0L);
    }

    public void d() {
        this.f61842e.setVisibility(0);
        this.f61838a.hideLoadingView(this.f61839b);
    }

    public void e() {
        this.f61842e.setVisibility(0);
        this.f61838a.hideNetRefreshView(this.f61839b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f61842e.setData(list);
    }

    public void g() {
        this.f61845h.b();
    }

    public void h(int i2) {
        this.f61841d.onChangeSkinType(this.f61838a.getPageContext(), i2);
        this.f61844g.c(this.f61838a.getPageContext(), i2);
        g();
        SkinManager.setBackgroundColor(this.f61839b, R.color.CAM_X0204);
    }

    public void i() {
        this.f61845h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f61844g.a(bVar);
    }

    public void k() {
        this.f61842e.setVisibility(8);
        this.f61838a.showLoadingView(this.f61839b, true);
    }

    public void l(String str) {
        this.f61842e.setVisibility(8);
        this.f61838a.showNetRefreshView(this.f61839b, str, true);
    }

    public void m() {
        this.f61842e.F();
    }
}
