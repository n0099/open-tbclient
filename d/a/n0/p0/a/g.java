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
    public BawuTeamInfoActivity f57951a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f57952b;

    /* renamed from: c  reason: collision with root package name */
    public h f57953c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57954d;

    /* renamed from: e  reason: collision with root package name */
    public View f57955e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f57956f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57957g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f57958h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.s.i.b f57959i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.a.n0.p0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f57951a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f57951a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f57955e = inflate;
        this.f57951a.setContentView(inflate);
        this.f57958h = this.f57955e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f57955e.findViewById(R.id.view_navigation_bar);
        this.f57954d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57951a.getString(R.string.bawu_manager_team));
        this.f57954d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57954d.showBottomLine();
        this.f57956f = (NoNetworkView) this.f57955e.findViewById(R.id.view_no_network);
        this.f57952b = (BdListView) this.f57955e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f57951a.getPageContext());
        this.f57953c = hVar;
        this.f57952b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f57953c.f(aVar);
    }

    public void c() {
        this.f57951a.hideNetRefreshView(this.f57955e);
        this.f57952b.setVisibility(0);
    }

    public View d() {
        return this.f57958h;
    }

    public boolean e() {
        return this.f57957g;
    }

    public void f(int i2) {
        this.f57951a.getLayoutMode().k(i2 == 1);
        this.f57951a.getLayoutMode().j(this.f57955e);
        this.f57954d.onChangeSkinType(this.f57951a.getPageContext(), i2);
        this.f57956f.c(this.f57951a.getPageContext(), i2);
        this.f57953c.notifyDataSetChanged();
    }

    public void g() {
        d.a.m0.s.i.b bVar = this.f57959i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f57956f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.f57959i == null) {
            this.f57959i = new d.a.m0.s.i.b(this.f57951a);
        }
        this.f57959i.p();
        this.f57959i.u(accountData);
        this.f57959i.z(1);
    }

    public void j() {
        this.f57952b.setVisibility(8);
        this.f57951a.showNetRefreshView(this.f57955e, this.f57951a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f57957g = false;
        } else {
            this.f57957g = true;
        }
        if (z && this.f57957g) {
            j();
            return;
        }
        c();
        this.f57953c.d(arrayList);
        this.f57953c.e(lVar);
        this.f57953c.notifyDataSetChanged();
    }
}
