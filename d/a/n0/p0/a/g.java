package d.a.n0.p0.a;

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
import d.a.n0.p0.a.h;
import d.a.n0.p0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f61642a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f61643b;

    /* renamed from: c  reason: collision with root package name */
    public h f61644c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61645d;

    /* renamed from: e  reason: collision with root package name */
    public View f61646e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f61647f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61648g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f61649h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.s.i.b f61650i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.a.n0.p0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f61642a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f61642a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f61646e = inflate;
        this.f61642a.setContentView(inflate);
        this.f61649h = this.f61646e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f61646e.findViewById(R.id.view_navigation_bar);
        this.f61645d = navigationBar;
        navigationBar.setCenterTextTitle(this.f61642a.getString(R.string.bawu_manager_team));
        this.f61645d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61645d.showBottomLine();
        this.f61647f = (NoNetworkView) this.f61646e.findViewById(R.id.view_no_network);
        this.f61643b = (BdListView) this.f61646e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f61642a.getPageContext());
        this.f61644c = hVar;
        this.f61643b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f61644c.f(aVar);
    }

    public void c() {
        this.f61642a.hideNetRefreshView(this.f61646e);
        this.f61643b.setVisibility(0);
    }

    public View d() {
        return this.f61649h;
    }

    public boolean e() {
        return this.f61648g;
    }

    public void f(int i2) {
        this.f61642a.getLayoutMode().k(i2 == 1);
        this.f61642a.getLayoutMode().j(this.f61646e);
        this.f61645d.onChangeSkinType(this.f61642a.getPageContext(), i2);
        this.f61647f.c(this.f61642a.getPageContext(), i2);
        this.f61644c.notifyDataSetChanged();
    }

    public void g() {
        d.a.m0.s.i.b bVar = this.f61650i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f61647f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.f61650i == null) {
            this.f61650i = new d.a.m0.s.i.b(this.f61642a);
        }
        this.f61650i.p();
        this.f61650i.u(accountData);
        this.f61650i.z(1);
    }

    public void j() {
        this.f61643b.setVisibility(8);
        this.f61642a.showNetRefreshView(this.f61646e, this.f61642a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f61648g = false;
        } else {
            this.f61648g = true;
        }
        if (z && this.f61648g) {
            j();
            return;
        }
        c();
        this.f61644c.d(arrayList);
        this.f61644c.e(lVar);
        this.f61644c.notifyDataSetChanged();
    }
}
