package d.b.i0.n0.c.o;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import d.b.b.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f57057a;

    /* renamed from: b  reason: collision with root package name */
    public View f57058b;

    /* renamed from: c  reason: collision with root package name */
    public View f57059c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57060d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f57061e;

    /* renamed from: f  reason: collision with root package name */
    public g f57062f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f57063g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.n0.c.o.a f57064h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57057a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f57057a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f57058b = this.f57057a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f57057a.findViewById(R.id.view_navigation_bar);
        this.f57060d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57057a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f57060d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57057a.setNetRefreshViewTopMargin(BdListViewHelper.f14030a);
        this.f57063g = (NoNetworkView) this.f57057a.findViewById(R.id.view_no_network);
        this.f57061e = (BdTypeListView) this.f57057a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f57057a.getPageContext());
        this.f57062f = gVar;
        gVar.Z(this.f57057a.getUniqueId());
        BaseActivity baseActivity2 = this.f57057a;
        if (baseActivity2 instanceof f.g) {
            this.f57062f.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f57057a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f57061e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f57061e.setPullRefresh(this.f57062f);
        this.f57059c = BdListViewHelper.d(this.f57057a.getPageContext().getPageActivity(), this.f57061e, BdListViewHelper.HeadType.DEFAULT);
        d.b.i0.n0.c.o.a aVar = new d.b.i0.n0.c.o.a(this.f57057a, this.f57061e);
        this.f57064h = aVar;
        this.f57061e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f57059c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f57061e.A(0L);
    }

    public void d() {
        this.f57061e.setVisibility(0);
        this.f57057a.hideLoadingView(this.f57058b);
    }

    public void e() {
        this.f57061e.setVisibility(0);
        this.f57057a.hideNetRefreshView(this.f57058b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f57061e.setData(list);
    }

    public void g() {
        this.f57064h.b();
    }

    public void h(int i) {
        this.f57060d.onChangeSkinType(this.f57057a.getPageContext(), i);
        this.f57063g.c(this.f57057a.getPageContext(), i);
        g();
        SkinManager.setBackgroundColor(this.f57058b, R.color.CAM_X0204);
    }

    public void i() {
        this.f57064h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f57063g.a(bVar);
    }

    public void k() {
        this.f57061e.setVisibility(8);
        this.f57057a.showLoadingView(this.f57058b, true);
    }

    public void l(String str) {
        this.f57061e.setVisibility(8);
        this.f57057a.showNetRefreshView(this.f57058b, str, true);
    }

    public void m() {
        this.f57061e.F();
    }
}
