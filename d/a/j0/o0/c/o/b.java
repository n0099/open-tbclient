package d.a.j0.o0.c.o;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f57206a;

    /* renamed from: b  reason: collision with root package name */
    public View f57207b;

    /* renamed from: c  reason: collision with root package name */
    public View f57208c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57209d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f57210e;

    /* renamed from: f  reason: collision with root package name */
    public g f57211f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f57212g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.o0.c.o.a f57213h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57206a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f57206a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f57207b = this.f57206a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f57206a.findViewById(R.id.view_navigation_bar);
        this.f57209d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57206a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f57209d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57206a.setNetRefreshViewTopMargin(BdListViewHelper.f13704a);
        this.f57212g = (NoNetworkView) this.f57206a.findViewById(R.id.view_no_network);
        this.f57210e = (BdTypeListView) this.f57206a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f57206a.getPageContext());
        this.f57211f = gVar;
        gVar.Z(this.f57206a.getUniqueId());
        BaseActivity baseActivity2 = this.f57206a;
        if (baseActivity2 instanceof f.g) {
            this.f57211f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f57206a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f57210e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f57210e.setPullRefresh(this.f57211f);
        this.f57208c = BdListViewHelper.d(this.f57206a.getPageContext().getPageActivity(), this.f57210e, BdListViewHelper.HeadType.DEFAULT);
        d.a.j0.o0.c.o.a aVar = new d.a.j0.o0.c.o.a(this.f57206a, this.f57210e);
        this.f57213h = aVar;
        this.f57210e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f57208c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f57210e.A(0L);
    }

    public void d() {
        this.f57210e.setVisibility(0);
        this.f57206a.hideLoadingView(this.f57207b);
    }

    public void e() {
        this.f57210e.setVisibility(0);
        this.f57206a.hideNetRefreshView(this.f57207b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f57210e.setData(list);
    }

    public void g() {
        this.f57213h.b();
    }

    public void h(int i2) {
        this.f57209d.onChangeSkinType(this.f57206a.getPageContext(), i2);
        this.f57212g.c(this.f57206a.getPageContext(), i2);
        g();
        SkinManager.setBackgroundColor(this.f57207b, R.color.CAM_X0204);
    }

    public void i() {
        this.f57213h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f57212g.a(bVar);
    }

    public void k() {
        this.f57210e.setVisibility(8);
        this.f57206a.showLoadingView(this.f57207b, true);
    }

    public void l(String str) {
        this.f57210e.setVisibility(8);
        this.f57206a.showNetRefreshView(this.f57207b, str, true);
    }

    public void m() {
        this.f57210e.F();
    }
}
