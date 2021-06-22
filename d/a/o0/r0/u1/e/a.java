package d.a.o0.r0.u1.e;

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
import d.a.c.k.e.n;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63506a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.r0.u1.b.a f63507b;

    /* renamed from: c  reason: collision with root package name */
    public View f63508c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f63509d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f63510e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f63511f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f63512g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f63513h;

    /* renamed from: i  reason: collision with root package name */
    public g f63514i;
    public String j;
    public String k;

    /* renamed from: d.a.o0.r0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1614a implements View.OnClickListener {
        public View$OnClickListenerC1614a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.f63506a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        this.f63511f.z();
    }

    public void c() {
        if (this.f63511f == null || !j.z()) {
            return;
        }
        this.f63511f.F();
    }

    public FrameLayout d() {
        return this.f63509d;
    }

    public NavigationBar e() {
        return this.f63510e;
    }

    public View f() {
        return this.f63508c;
    }

    public final void g() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f63506a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f63506a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.f63508c = inflate;
        this.f63512g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f63509d = (FrameLayout) this.f63508c.findViewById(R.id.game_recom_container);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f63508c.findViewById(R.id.game_recom_listview);
        this.f63511f = bdTypeListView;
        bdTypeListView.setDivider(null);
        g gVar = new g(this.f63506a);
        this.f63514i = gVar;
        gVar.Z(this.f63506a.getUniqueId());
        this.f63511f.setPullRefresh(this.f63514i);
        NavigationBar navigationBar = (NavigationBar) this.f63508c.findViewById(R.id.view_navigation_bar);
        this.f63510e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1614a());
        this.f63510e.showBottomLine();
        PbListView pbListView = new PbListView(this.f63506a.getPageActivity());
        this.f63513h = pbListView;
        pbListView.a();
        this.f63507b = new d.a.o0.r0.u1.b.a(this.f63506a, this.f63511f, this.j, this.k);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i2) {
        NoNetworkView noNetworkView = this.f63512g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f63506a, i2);
        }
        NavigationBar navigationBar = this.f63510e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f63506a, i2);
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
        this.f63507b.c(list);
    }

    public void l(f.g gVar) {
        this.f63514i.a(gVar);
    }

    public void m() {
        this.f63511f.setNextPage(null);
    }

    public void n(BdListView.p pVar) {
        this.f63511f.setOnSrollToBottomListener(pVar);
    }

    public final void o() {
        PbListView pbListView = this.f63513h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f63511f.setNextPage(this.f63513h);
            }
            this.f63513h.M();
            this.f63513h.O();
        }
    }

    public final void p() {
        PbListView pbListView = this.f63513h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f63511f.setNextPage(this.f63513h);
            }
            this.f63513h.A(this.f63506a.getPageActivity().getResources().getString(R.string.list_no_more));
            this.f63513h.f();
        }
    }
}
