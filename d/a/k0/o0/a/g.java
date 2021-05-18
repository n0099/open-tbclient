package d.a.k0.o0.a;

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
import d.a.k0.o0.a.h;
import d.a.k0.o0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f57842a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f57843b;

    /* renamed from: c  reason: collision with root package name */
    public h f57844c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57845d;

    /* renamed from: e  reason: collision with root package name */
    public View f57846e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f57847f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57848g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f57849h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.s.i.b f57850i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.a.k0.o0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f57842a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f57842a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f57846e = inflate;
        this.f57842a.setContentView(inflate);
        this.f57849h = this.f57846e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f57846e.findViewById(R.id.view_navigation_bar);
        this.f57845d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57842a.getString(R.string.bawu_manager_team));
        this.f57845d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57845d.showBottomLine();
        this.f57847f = (NoNetworkView) this.f57846e.findViewById(R.id.view_no_network);
        this.f57843b = (BdListView) this.f57846e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f57842a.getPageContext());
        this.f57844c = hVar;
        this.f57843b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f57844c.f(aVar);
    }

    public void c() {
        this.f57842a.hideNetRefreshView(this.f57846e);
        this.f57843b.setVisibility(0);
    }

    public View d() {
        return this.f57849h;
    }

    public boolean e() {
        return this.f57848g;
    }

    public void f(int i2) {
        this.f57842a.getLayoutMode().k(i2 == 1);
        this.f57842a.getLayoutMode().j(this.f57846e);
        this.f57845d.onChangeSkinType(this.f57842a.getPageContext(), i2);
        this.f57847f.c(this.f57842a.getPageContext(), i2);
        this.f57844c.notifyDataSetChanged();
    }

    public void g() {
        d.a.j0.s.i.b bVar = this.f57850i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f57847f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.f57850i == null) {
            this.f57850i = new d.a.j0.s.i.b(this.f57842a);
        }
        this.f57850i.p();
        this.f57850i.u(accountData);
        this.f57850i.z(1);
    }

    public void j() {
        this.f57843b.setVisibility(8);
        this.f57842a.showNetRefreshView(this.f57846e, this.f57842a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f57848g = false;
        } else {
            this.f57848g = true;
        }
        if (z && this.f57848g) {
            j();
            return;
        }
        c();
        this.f57844c.d(arrayList);
        this.f57844c.e(lVar);
        this.f57844c.notifyDataSetChanged();
    }
}
