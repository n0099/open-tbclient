package d.b.j0.o0.a;

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
import d.b.j0.o0.a.h;
import d.b.j0.o0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f59112a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f59113b;

    /* renamed from: c  reason: collision with root package name */
    public h f59114c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59115d;

    /* renamed from: e  reason: collision with root package name */
    public View f59116e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f59117f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59118g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f59119h;
    public d.b.i0.s.i.b i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.b.j0.o0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f59112a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f59112a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f59116e = inflate;
        this.f59112a.setContentView(inflate);
        this.f59119h = this.f59116e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f59116e.findViewById(R.id.view_navigation_bar);
        this.f59115d = navigationBar;
        navigationBar.setCenterTextTitle(this.f59112a.getString(R.string.bawu_manager_team));
        this.f59115d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59115d.showBottomLine();
        this.f59117f = (NoNetworkView) this.f59116e.findViewById(R.id.view_no_network);
        this.f59113b = (BdListView) this.f59116e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f59112a.getPageContext());
        this.f59114c = hVar;
        this.f59113b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f59114c.f(aVar);
    }

    public void c() {
        this.f59112a.hideNetRefreshView(this.f59116e);
        this.f59113b.setVisibility(0);
    }

    public View d() {
        return this.f59119h;
    }

    public boolean e() {
        return this.f59118g;
    }

    public void f(int i) {
        this.f59112a.getLayoutMode().k(i == 1);
        this.f59112a.getLayoutMode().j(this.f59116e);
        this.f59115d.onChangeSkinType(this.f59112a.getPageContext(), i);
        this.f59117f.c(this.f59112a.getPageContext(), i);
        this.f59114c.notifyDataSetChanged();
    }

    public void g() {
        d.b.i0.s.i.b bVar = this.i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f59117f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.i == null) {
            this.i = new d.b.i0.s.i.b(this.f59112a);
        }
        this.i.p();
        this.i.u(accountData);
        this.i.z(1);
    }

    public void j() {
        this.f59113b.setVisibility(8);
        this.f59112a.showNetRefreshView(this.f59116e, this.f59112a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f59118g = false;
        } else {
            this.f59118g = true;
        }
        if (z && this.f59118g) {
            j();
            return;
        }
        c();
        this.f59114c.d(arrayList);
        this.f59114c.e(lVar);
        this.f59114c.notifyDataSetChanged();
    }
}
