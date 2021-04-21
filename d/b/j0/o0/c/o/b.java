package d.b.j0.o0.c.o;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f59178a;

    /* renamed from: b  reason: collision with root package name */
    public View f59179b;

    /* renamed from: c  reason: collision with root package name */
    public View f59180c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59181d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f59182e;

    /* renamed from: f  reason: collision with root package name */
    public g f59183f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f59184g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.o0.c.o.a f59185h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f59178a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f59178a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f59179b = this.f59178a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f59178a.findViewById(R.id.view_navigation_bar);
        this.f59181d = navigationBar;
        navigationBar.setCenterTextTitle(this.f59178a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f59181d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59178a.setNetRefreshViewTopMargin(BdListViewHelper.f13700a);
        this.f59184g = (NoNetworkView) this.f59178a.findViewById(R.id.view_no_network);
        this.f59182e = (BdTypeListView) this.f59178a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f59178a.getPageContext());
        this.f59183f = gVar;
        gVar.Z(this.f59178a.getUniqueId());
        BaseActivity baseActivity2 = this.f59178a;
        if (baseActivity2 instanceof f.g) {
            this.f59183f.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f59178a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f59182e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f59182e.setPullRefresh(this.f59183f);
        this.f59180c = BdListViewHelper.d(this.f59178a.getPageContext().getPageActivity(), this.f59182e, BdListViewHelper.HeadType.DEFAULT);
        d.b.j0.o0.c.o.a aVar = new d.b.j0.o0.c.o.a(this.f59178a, this.f59182e);
        this.f59185h = aVar;
        this.f59182e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f59180c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f59182e.A(0L);
    }

    public void d() {
        this.f59182e.setVisibility(0);
        this.f59178a.hideLoadingView(this.f59179b);
    }

    public void e() {
        this.f59182e.setVisibility(0);
        this.f59178a.hideNetRefreshView(this.f59179b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f59182e.setData(list);
    }

    public void g() {
        this.f59185h.b();
    }

    public void h(int i) {
        this.f59181d.onChangeSkinType(this.f59178a.getPageContext(), i);
        this.f59184g.c(this.f59178a.getPageContext(), i);
        g();
        SkinManager.setBackgroundColor(this.f59179b, R.color.CAM_X0204);
    }

    public void i() {
        this.f59185h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f59184g.a(bVar);
    }

    public void k() {
        this.f59182e.setVisibility(8);
        this.f59178a.showLoadingView(this.f59179b, true);
    }

    public void l(String str) {
        this.f59182e.setVisibility(8);
        this.f59178a.showNetRefreshView(this.f59179b, str, true);
    }

    public void m() {
        this.f59182e.F();
    }
}
