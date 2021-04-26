package d.a.j0.o0.a;

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
import d.a.j0.o0.a.h;
import d.a.j0.o0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f57135a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f57136b;

    /* renamed from: c  reason: collision with root package name */
    public h f57137c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57138d;

    /* renamed from: e  reason: collision with root package name */
    public View f57139e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f57140f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57141g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f57142h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.s.i.b f57143i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.a.j0.o0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f57135a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f57135a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f57139e = inflate;
        this.f57135a.setContentView(inflate);
        this.f57142h = this.f57139e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f57139e.findViewById(R.id.view_navigation_bar);
        this.f57138d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57135a.getString(R.string.bawu_manager_team));
        this.f57138d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57138d.showBottomLine();
        this.f57140f = (NoNetworkView) this.f57139e.findViewById(R.id.view_no_network);
        this.f57136b = (BdListView) this.f57139e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f57135a.getPageContext());
        this.f57137c = hVar;
        this.f57136b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f57137c.f(aVar);
    }

    public void c() {
        this.f57135a.hideNetRefreshView(this.f57139e);
        this.f57136b.setVisibility(0);
    }

    public View d() {
        return this.f57142h;
    }

    public boolean e() {
        return this.f57141g;
    }

    public void f(int i2) {
        this.f57135a.getLayoutMode().k(i2 == 1);
        this.f57135a.getLayoutMode().j(this.f57139e);
        this.f57138d.onChangeSkinType(this.f57135a.getPageContext(), i2);
        this.f57140f.c(this.f57135a.getPageContext(), i2);
        this.f57137c.notifyDataSetChanged();
    }

    public void g() {
        d.a.i0.s.i.b bVar = this.f57143i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f57140f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.f57143i == null) {
            this.f57143i = new d.a.i0.s.i.b(this.f57135a);
        }
        this.f57143i.p();
        this.f57143i.u(accountData);
        this.f57143i.z(1);
    }

    public void j() {
        this.f57136b.setVisibility(8);
        this.f57135a.showNetRefreshView(this.f57139e, this.f57135a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f57141g = false;
        } else {
            this.f57141g = true;
        }
        if (z && this.f57141g) {
            j();
            return;
        }
        c();
        this.f57137c.d(arrayList);
        this.f57137c.e(lVar);
        this.f57137c.notifyDataSetChanged();
    }
}
