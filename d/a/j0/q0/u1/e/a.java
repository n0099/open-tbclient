package d.a.j0.q0.u1.e;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58807a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.q0.u1.b.a f58808b;

    /* renamed from: c  reason: collision with root package name */
    public View f58809c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58810d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f58811e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f58812f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f58813g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f58814h;

    /* renamed from: i  reason: collision with root package name */
    public g f58815i;
    public String j;
    public String k;

    /* renamed from: d.a.j0.q0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1467a implements View.OnClickListener {
        public View$OnClickListenerC1467a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.f58807a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        this.f58812f.z();
    }

    public void c() {
        if (this.f58812f == null || !j.z()) {
            return;
        }
        this.f58812f.F();
    }

    public FrameLayout d() {
        return this.f58810d;
    }

    public NavigationBar e() {
        return this.f58811e;
    }

    public View f() {
        return this.f58809c;
    }

    public final void g() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f58807a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f58807a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.f58809c = inflate;
        this.f58813g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f58810d = (FrameLayout) this.f58809c.findViewById(R.id.game_recom_container);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f58809c.findViewById(R.id.game_recom_listview);
        this.f58812f = bdTypeListView;
        bdTypeListView.setDivider(null);
        g gVar = new g(this.f58807a);
        this.f58815i = gVar;
        gVar.Z(this.f58807a.getUniqueId());
        this.f58812f.setPullRefresh(this.f58815i);
        NavigationBar navigationBar = (NavigationBar) this.f58809c.findViewById(R.id.view_navigation_bar);
        this.f58811e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1467a());
        this.f58811e.showBottomLine();
        PbListView pbListView = new PbListView(this.f58807a.getPageActivity());
        this.f58814h = pbListView;
        pbListView.a();
        this.f58808b = new d.a.j0.q0.u1.b.a(this.f58807a, this.f58812f, this.j, this.k);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i2) {
        NoNetworkView noNetworkView = this.f58813g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58807a, i2);
        }
        NavigationBar navigationBar = this.f58811e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58807a, i2);
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
        this.f58808b.c(list);
    }

    public void l(f.g gVar) {
        this.f58815i.a(gVar);
    }

    public void m() {
        this.f58812f.setNextPage(null);
    }

    public void n(BdListView.p pVar) {
        this.f58812f.setOnSrollToBottomListener(pVar);
    }

    public final void o() {
        PbListView pbListView = this.f58814h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58812f.setNextPage(this.f58814h);
            }
            this.f58814h.M();
            this.f58814h.O();
        }
    }

    public final void p() {
        PbListView pbListView = this.f58814h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58812f.setNextPage(this.f58814h);
            }
            this.f58814h.A(this.f58807a.getPageActivity().getResources().getString(R.string.list_no_more));
            this.f58814h.f();
        }
    }
}
