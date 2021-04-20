package d.b.i0.o0.c.o;

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
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58757a;

    /* renamed from: b  reason: collision with root package name */
    public View f58758b;

    /* renamed from: c  reason: collision with root package name */
    public View f58759c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58760d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f58761e;

    /* renamed from: f  reason: collision with root package name */
    public g f58762f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f58763g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.o0.c.o.a f58764h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58757a.finish();
        }
    }

    public b(BaseActivity baseActivity) {
        this.f58757a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f58758b = this.f58757a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f58757a.findViewById(R.id.view_navigation_bar);
        this.f58760d = navigationBar;
        navigationBar.setCenterTextTitle(this.f58757a.getString(R.string.forummember)).setOnClickListener(new a());
        this.f58760d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58757a.setNetRefreshViewTopMargin(BdListViewHelper.f13692a);
        this.f58763g = (NoNetworkView) this.f58757a.findViewById(R.id.view_no_network);
        this.f58761e = (BdTypeListView) this.f58757a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f58757a.getPageContext());
        this.f58762f = gVar;
        gVar.Z(this.f58757a.getUniqueId());
        BaseActivity baseActivity2 = this.f58757a;
        if (baseActivity2 instanceof f.g) {
            this.f58762f.b((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f58757a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f58761e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f58761e.setPullRefresh(this.f58762f);
        this.f58759c = BdListViewHelper.d(this.f58757a.getPageContext().getPageActivity(), this.f58761e, BdListViewHelper.HeadType.DEFAULT);
        d.b.i0.o0.c.o.a aVar = new d.b.i0.o0.c.o.a(this.f58757a, this.f58761e);
        this.f58764h = aVar;
        this.f58761e.a(aVar.a());
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f58759c, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f58761e.A(0L);
    }

    public void d() {
        this.f58761e.setVisibility(0);
        this.f58757a.hideLoadingView(this.f58758b);
    }

    public void e() {
        this.f58761e.setVisibility(0);
        this.f58757a.hideNetRefreshView(this.f58758b);
    }

    public void f(List<n> list) {
        if (list == null) {
            return;
        }
        this.f58761e.setData(list);
    }

    public void g() {
        this.f58764h.b();
    }

    public void h(int i) {
        this.f58760d.onChangeSkinType(this.f58757a.getPageContext(), i);
        this.f58763g.c(this.f58757a.getPageContext(), i);
        g();
        SkinManager.setBackgroundColor(this.f58758b, R.color.CAM_X0204);
    }

    public void i() {
        this.f58764h.c();
    }

    public void j(NoNetworkView.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f58763g.a(bVar);
    }

    public void k() {
        this.f58761e.setVisibility(8);
        this.f58757a.showLoadingView(this.f58758b, true);
    }

    public void l(String str) {
        this.f58761e.setVisibility(8);
        this.f58757a.showNetRefreshView(this.f58758b, str, true);
    }

    public void m() {
        this.f58761e.F();
    }
}
