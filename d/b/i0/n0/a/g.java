package d.b.i0.n0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity;
import d.b.i0.n0.a.h;
import d.b.i0.n0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f56992a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f56993b;

    /* renamed from: c  reason: collision with root package name */
    public h f56994c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56995d;

    /* renamed from: e  reason: collision with root package name */
    public View f56996e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f56997f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56998g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f56999h;
    public d.b.h0.s.i.b i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.b.i0.n0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f56992a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f56992a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f56996e = inflate;
        this.f56992a.setContentView(inflate);
        this.f56999h = this.f56996e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f56996e.findViewById(R.id.view_navigation_bar);
        this.f56995d = navigationBar;
        navigationBar.setCenterTextTitle(this.f56992a.getString(R.string.bawu_manager_team));
        this.f56995d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56995d.showBottomLine();
        this.f56997f = (NoNetworkView) this.f56996e.findViewById(R.id.view_no_network);
        this.f56993b = (BdListView) this.f56996e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f56992a.getPageContext());
        this.f56994c = hVar;
        this.f56993b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f56994c.f(aVar);
    }

    public void c() {
        this.f56992a.hideNetRefreshView(this.f56996e);
        this.f56993b.setVisibility(0);
    }

    public View d() {
        return this.f56999h;
    }

    public boolean e() {
        return this.f56998g;
    }

    public void f(int i) {
        this.f56992a.getLayoutMode().k(i == 1);
        this.f56992a.getLayoutMode().j(this.f56996e);
        this.f56995d.onChangeSkinType(this.f56992a.getPageContext(), i);
        this.f56997f.c(this.f56992a.getPageContext(), i);
        this.f56994c.notifyDataSetChanged();
    }

    public void g() {
        d.b.h0.s.i.b bVar = this.i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f56997f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.i == null) {
            this.i = new d.b.h0.s.i.b(this.f56992a);
        }
        this.i.p();
        this.i.u(accountData);
        this.i.z(1);
    }

    public void j() {
        this.f56993b.setVisibility(8);
        this.f56992a.showNetRefreshView(this.f56996e, this.f56992a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f56998g = false;
        } else {
            this.f56998g = true;
        }
        if (z && this.f56998g) {
            j();
            return;
        }
        c();
        this.f56994c.d(arrayList);
        this.f56994c.e(lVar);
        this.f56994c.notifyDataSetChanged();
    }
}
