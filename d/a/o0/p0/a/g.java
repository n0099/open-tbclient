package d.a.o0.p0.a;

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
import d.a.o0.p0.a.h;
import d.a.o0.p0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f61767a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f61768b;

    /* renamed from: c  reason: collision with root package name */
    public h f61769c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61770d;

    /* renamed from: e  reason: collision with root package name */
    public View f61771e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f61772f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61773g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f61774h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.s.i.b f61775i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.a.o0.p0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f61767a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f61767a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f61771e = inflate;
        this.f61767a.setContentView(inflate);
        this.f61774h = this.f61771e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f61771e.findViewById(R.id.view_navigation_bar);
        this.f61770d = navigationBar;
        navigationBar.setCenterTextTitle(this.f61767a.getString(R.string.bawu_manager_team));
        this.f61770d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61770d.showBottomLine();
        this.f61772f = (NoNetworkView) this.f61771e.findViewById(R.id.view_no_network);
        this.f61768b = (BdListView) this.f61771e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f61767a.getPageContext());
        this.f61769c = hVar;
        this.f61768b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f61769c.f(aVar);
    }

    public void c() {
        this.f61767a.hideNetRefreshView(this.f61771e);
        this.f61768b.setVisibility(0);
    }

    public View d() {
        return this.f61774h;
    }

    public boolean e() {
        return this.f61773g;
    }

    public void f(int i2) {
        this.f61767a.getLayoutMode().k(i2 == 1);
        this.f61767a.getLayoutMode().j(this.f61771e);
        this.f61770d.onChangeSkinType(this.f61767a.getPageContext(), i2);
        this.f61772f.c(this.f61767a.getPageContext(), i2);
        this.f61769c.notifyDataSetChanged();
    }

    public void g() {
        d.a.n0.s.i.b bVar = this.f61775i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f61772f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.f61775i == null) {
            this.f61775i = new d.a.n0.s.i.b(this.f61767a);
        }
        this.f61775i.p();
        this.f61775i.u(accountData);
        this.f61775i.z(1);
    }

    public void j() {
        this.f61768b.setVisibility(8);
        this.f61767a.showNetRefreshView(this.f61771e, this.f61767a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f61773g = false;
        } else {
            this.f61773g = true;
        }
        if (z && this.f61773g) {
            j();
            return;
        }
        c();
        this.f61769c.d(arrayList);
        this.f61769c.e(lVar);
        this.f61769c.notifyDataSetChanged();
    }
}
