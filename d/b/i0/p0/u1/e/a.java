package d.b.i0.p0.u1.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58609a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.p0.u1.b.a f58610b;

    /* renamed from: c  reason: collision with root package name */
    public View f58611c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58612d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f58613e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f58614f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f58615g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f58616h;
    public g i;
    public String j;
    public String k;

    /* renamed from: d.b.i0.p0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1441a implements View.OnClickListener {
        public View$OnClickListenerC1441a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.f58609a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        this.f58614f.z();
    }

    public void c() {
        if (this.f58614f == null || !j.z()) {
            return;
        }
        this.f58614f.F();
    }

    public FrameLayout d() {
        return this.f58612d;
    }

    public NavigationBar e() {
        return this.f58613e;
    }

    public View f() {
        return this.f58611c;
    }

    public final void g() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f58609a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f58609a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.f58611c = inflate;
        this.f58615g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f58612d = (FrameLayout) this.f58611c.findViewById(R.id.game_recom_container);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f58611c.findViewById(R.id.game_recom_listview);
        this.f58614f = bdTypeListView;
        bdTypeListView.setDivider(null);
        g gVar = new g(this.f58609a);
        this.i = gVar;
        gVar.Z(this.f58609a.getUniqueId());
        this.f58614f.setPullRefresh(this.i);
        NavigationBar navigationBar = (NavigationBar) this.f58611c.findViewById(R.id.view_navigation_bar);
        this.f58613e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1441a());
        this.f58613e.showBottomLine();
        PbListView pbListView = new PbListView(this.f58609a.getPageActivity());
        this.f58616h = pbListView;
        pbListView.a();
        this.f58610b = new d.b.i0.p0.u1.b.a(this.f58609a, this.f58614f, this.j, this.k);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i) {
        NoNetworkView noNetworkView = this.f58615g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58609a, i);
        }
        NavigationBar navigationBar = this.f58613e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58609a, i);
        }
    }

    public void j() {
    }

    public void k(List<n> list, boolean z) {
        if (z) {
            o();
        } else {
            p();
        }
        this.f58610b.c(list);
    }

    public void l(f.g gVar) {
        this.i.b(gVar);
    }

    public void m() {
        this.f58614f.setNextPage(null);
    }

    public void n(BdListView.p pVar) {
        this.f58614f.setOnSrollToBottomListener(pVar);
    }

    public final void o() {
        PbListView pbListView = this.f58616h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58614f.setNextPage(this.f58616h);
            }
            this.f58616h.M();
            this.f58616h.O();
        }
    }

    public final void p() {
        PbListView pbListView = this.f58616h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58614f.setNextPage(this.f58616h);
            }
            this.f58616h.A(this.f58609a.getPageActivity().getResources().getString(R.string.list_no_more));
            this.f58616h.f();
        }
    }
}
