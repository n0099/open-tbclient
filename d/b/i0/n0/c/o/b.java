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
    public BaseActivity f57058a;

    /* renamed from: b  reason: collision with root package name */
    public View f57059b;

    /* renamed from: c  reason: collision with root package name */
    public View f57060c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57061d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f57062e;

    /* renamed from: f  reason: collision with root package name */
    public g f57063f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f57064g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.n0.c.o.a f57065h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57058a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f57058a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f57059b = this.f57058a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f57058a.findViewById(R.id.view_navigation_bar);
        this.f57061d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57058a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f57061d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57058a.setNetRefreshViewTopMargin(BdListViewHelper.f14031a);
        this.f57064g = (NoNetworkView) this.f57058a.findViewById(R.id.view_no_network);
        this.f57062e = (BdTypeListView) this.f57058a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f57058a.getPageContext());
        this.f57063f = gVar;
        gVar.Z(this.f57058a.getUniqueId());
        BaseActivity baseActivity2 = this.f57058a;
        if (baseActivity2 instanceof f.g) {
            this.f57063f.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f57058a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f57062e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f57062e.setPullRefresh(this.f57063f);
        this.f57060c = BdListViewHelper.d(this.f57058a.getPageContext().getPageActivity(), this.f57062e, BdListViewHelper.HeadType.DEFAULT);
        d.b.i0.n0.c.o.a aVar = new d.b.i0.n0.c.o.a(this.f57058a, this.f57062e);
        this.f57065h = aVar;
        this.f57062e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f57060c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f57062e.A(0L);
    }

    public void d() {
        this.f57062e.setVisibility(0);
        this.f57058a.hideLoadingView(this.f57059b);
    }

    public void e() {
        this.f57062e.setVisibility(0);
        this.f57058a.hideNetRefreshView(this.f57059b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f57062e.setData(list);
    }

    public void g() {
        this.f57065h.b();
    }

    public void h(int i) {
        this.f57061d.onChangeSkinType(this.f57058a.getPageContext(), i);
        this.f57064g.c(this.f57058a.getPageContext(), i);
        g();
        SkinManager.setBackgroundColor(this.f57059b, R.color.CAM_X0204);
    }

    public void i() {
        this.f57065h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f57064g.a(bVar);
    }

    public void k() {
        this.f57062e.setVisibility(8);
        this.f57058a.showLoadingView(this.f57059b, true);
    }

    public void l(String str) {
        this.f57062e.setVisibility(8);
        this.f57058a.showNetRefreshView(this.f57059b, str, true);
    }

    public void m() {
        this.f57062e.F();
    }
}
