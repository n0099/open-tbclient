package d.b.i0.o0.a;

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
import d.b.i0.o0.a.h;
import d.b.i0.o0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f58691a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f58692b;

    /* renamed from: c  reason: collision with root package name */
    public h f58693c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58694d;

    /* renamed from: e  reason: collision with root package name */
    public View f58695e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f58696f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58697g = false;

    /* renamed from: h  reason: collision with root package name */
    public View f58698h;
    public d.b.h0.s.i.b i;
    public h.d j;

    /* loaded from: classes4.dex */
    public class a implements h.d {
        public a() {
        }

        @Override // d.b.i0.o0.a.h.d
        public void a(String str) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                UrlManager.getInstance().dealOneLink(g.this.f58691a.getPageContext(), new String[]{str});
            } else {
                g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.f58691a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f58695e = inflate;
        this.f58691a.setContentView(inflate);
        this.f58698h = this.f58695e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f58695e.findViewById(R.id.view_navigation_bar);
        this.f58694d = navigationBar;
        navigationBar.setCenterTextTitle(this.f58691a.getString(R.string.bawu_manager_team));
        this.f58694d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58694d.showBottomLine();
        this.f58696f = (NoNetworkView) this.f58695e.findViewById(R.id.view_no_network);
        this.f58692b = (BdListView) this.f58695e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f58691a.getPageContext());
        this.f58693c = hVar;
        this.f58692b.setAdapter((ListAdapter) hVar);
        a aVar = new a();
        this.j = aVar;
        this.f58693c.f(aVar);
    }

    public void c() {
        this.f58691a.hideNetRefreshView(this.f58695e);
        this.f58692b.setVisibility(0);
    }

    public View d() {
        return this.f58698h;
    }

    public boolean e() {
        return this.f58697g;
    }

    public void f(int i) {
        this.f58691a.getLayoutMode().k(i == 1);
        this.f58691a.getLayoutMode().j(this.f58695e);
        this.f58694d.onChangeSkinType(this.f58691a.getPageContext(), i);
        this.f58696f.c(this.f58691a.getPageContext(), i);
        this.f58693c.notifyDataSetChanged();
    }

    public void g() {
        d.b.h0.s.i.b bVar = this.i;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void h(NoNetworkView.b bVar) {
        this.f58696f.a(bVar);
    }

    public final void i(AccountData accountData) {
        if (this.i == null) {
            this.i = new d.b.h0.s.i.b(this.f58691a);
        }
        this.i.p();
        this.i.u(accountData);
        this.i.z(1);
    }

    public void j() {
        this.f58692b.setVisibility(8);
        this.f58691a.showNetRefreshView(this.f58695e, this.f58691a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f58697g = false;
        } else {
            this.f58697g = true;
        }
        if (z && this.f58697g) {
            j();
            return;
        }
        c();
        this.f58693c.d(arrayList);
        this.f58693c.e(lVar);
        this.f58693c.notifyDataSetChanged();
    }
}
