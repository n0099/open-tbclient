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
import d.a.c.k.e.n;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f61713a;

    /* renamed from: b  reason: collision with root package name */
    public View f61714b;

    /* renamed from: c  reason: collision with root package name */
    public View f61715c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61716d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61717e;

    /* renamed from: f  reason: collision with root package name */
    public g f61718f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f61719g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.p0.c.o.a f61720h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f61713a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f61713a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f61714b = this.f61713a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f61713a.findViewById(R.id.view_navigation_bar);
        this.f61716d = navigationBar;
        navigationBar.setCenterTextTitle(this.f61713a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f61716d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61713a.setNetRefreshViewTopMargin(BdListViewHelper.f13013a);
        this.f61719g = (NoNetworkView) this.f61713a.findViewById(R.id.view_no_network);
        this.f61717e = (BdTypeListView) this.f61713a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f61713a.getPageContext());
        this.f61718f = gVar;
        gVar.Z(this.f61713a.getUniqueId());
        BaseActivity baseActivity2 = this.f61713a;
        if (baseActivity2 instanceof f.g) {
            this.f61718f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f61713a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f61717e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f61717e.setPullRefresh(this.f61718f);
        this.f61715c = BdListViewHelper.d(this.f61713a.getPageContext().getPageActivity(), this.f61717e, BdListViewHelper.HeadType.DEFAULT);
        d.a.n0.p0.c.o.a aVar = new d.a.n0.p0.c.o.a(this.f61713a, this.f61717e);
        this.f61720h = aVar;
        this.f61717e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f61715c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f61717e.A(0L);
    }

    public void d() {
        this.f61717e.setVisibility(0);
        this.f61713a.hideLoadingView(this.f61714b);
    }

    public void e() {
        this.f61717e.setVisibility(0);
        this.f61713a.hideNetRefreshView(this.f61714b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f61717e.setData(list);
    }

    public void g() {
        this.f61720h.b();
    }

    public void h(int i2) {
        this.f61716d.onChangeSkinType(this.f61713a.getPageContext(), i2);
        this.f61719g.c(this.f61713a.getPageContext(), i2);
        g();
        SkinManager.setBackgroundColor(this.f61714b, R.color.CAM_X0204);
    }

    public void i() {
        this.f61720h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f61719g.a(bVar);
    }

    public void k() {
        this.f61717e.setVisibility(8);
        this.f61713a.showLoadingView(this.f61714b, true);
    }

    public void l(String str) {
        this.f61717e.setVisibility(8);
        this.f61713a.showNetRefreshView(this.f61714b, str, true);
    }

    public void m() {
        this.f61717e.F();
    }
}
