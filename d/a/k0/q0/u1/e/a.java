package d.a.k0.q0.u1.e;

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
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59549a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.q0.u1.b.a f59550b;

    /* renamed from: c  reason: collision with root package name */
    public View f59551c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f59552d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f59553e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f59554f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f59555g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f59556h;

    /* renamed from: i  reason: collision with root package name */
    public g f59557i;
    public String j;
    public String k;

    /* renamed from: d.a.k0.q0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1541a implements View.OnClickListener {
        public View$OnClickListenerC1541a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.f59549a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        this.f59554f.z();
    }

    public void c() {
        if (this.f59554f == null || !j.z()) {
            return;
        }
        this.f59554f.F();
    }

    public FrameLayout d() {
        return this.f59552d;
    }

    public NavigationBar e() {
        return this.f59553e;
    }

    public View f() {
        return this.f59551c;
    }

    public final void g() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f59549a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f59549a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.f59551c = inflate;
        this.f59555g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f59552d = (FrameLayout) this.f59551c.findViewById(R.id.game_recom_container);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f59551c.findViewById(R.id.game_recom_listview);
        this.f59554f = bdTypeListView;
        bdTypeListView.setDivider(null);
        g gVar = new g(this.f59549a);
        this.f59557i = gVar;
        gVar.Z(this.f59549a.getUniqueId());
        this.f59554f.setPullRefresh(this.f59557i);
        NavigationBar navigationBar = (NavigationBar) this.f59551c.findViewById(R.id.view_navigation_bar);
        this.f59553e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1541a());
        this.f59553e.showBottomLine();
        PbListView pbListView = new PbListView(this.f59549a.getPageActivity());
        this.f59556h = pbListView;
        pbListView.a();
        this.f59550b = new d.a.k0.q0.u1.b.a(this.f59549a, this.f59554f, this.j, this.k);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i2) {
        NoNetworkView noNetworkView = this.f59555g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f59549a, i2);
        }
        NavigationBar navigationBar = this.f59553e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f59549a, i2);
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
        this.f59550b.c(list);
    }

    public void l(f.g gVar) {
        this.f59557i.a(gVar);
    }

    public void m() {
        this.f59554f.setNextPage(null);
    }

    public void n(BdListView.p pVar) {
        this.f59554f.setOnSrollToBottomListener(pVar);
    }

    public final void o() {
        PbListView pbListView = this.f59556h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f59554f.setNextPage(this.f59556h);
            }
            this.f59556h.M();
            this.f59556h.O();
        }
    }

    public final void p() {
        PbListView pbListView = this.f59556h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f59554f.setNextPage(this.f59556h);
            }
            this.f59556h.A(this.f59549a.getPageActivity().getResources().getString(R.string.list_no_more));
            this.f59556h.f();
        }
    }
}
