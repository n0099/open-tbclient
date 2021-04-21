package d.b.j0.q0.u1.e;

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
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60699a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.q0.u1.b.a f60700b;

    /* renamed from: c  reason: collision with root package name */
    public View f60701c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f60702d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f60703e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f60704f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f60705g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f60706h;
    public g i;
    public String j;
    public String k;

    /* renamed from: d.b.j0.q0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1528a implements View.OnClickListener {
        public View$OnClickListenerC1528a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.f60699a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        this.f60704f.z();
    }

    public void c() {
        if (this.f60704f == null || !j.z()) {
            return;
        }
        this.f60704f.F();
    }

    public FrameLayout d() {
        return this.f60702d;
    }

    public NavigationBar e() {
        return this.f60703e;
    }

    public View f() {
        return this.f60701c;
    }

    public final void g() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f60699a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f60699a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.f60701c = inflate;
        this.f60705g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f60702d = (FrameLayout) this.f60701c.findViewById(R.id.game_recom_container);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f60701c.findViewById(R.id.game_recom_listview);
        this.f60704f = bdTypeListView;
        bdTypeListView.setDivider(null);
        g gVar = new g(this.f60699a);
        this.i = gVar;
        gVar.Z(this.f60699a.getUniqueId());
        this.f60704f.setPullRefresh(this.i);
        NavigationBar navigationBar = (NavigationBar) this.f60701c.findViewById(R.id.view_navigation_bar);
        this.f60703e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1528a());
        this.f60703e.showBottomLine();
        PbListView pbListView = new PbListView(this.f60699a.getPageActivity());
        this.f60706h = pbListView;
        pbListView.a();
        this.f60700b = new d.b.j0.q0.u1.b.a(this.f60699a, this.f60704f, this.j, this.k);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i) {
        NoNetworkView noNetworkView = this.f60705g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f60699a, i);
        }
        NavigationBar navigationBar = this.f60703e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60699a, i);
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
        this.f60700b.c(list);
    }

    public void l(f.g gVar) {
        this.i.b(gVar);
    }

    public void m() {
        this.f60704f.setNextPage(null);
    }

    public void n(BdListView.p pVar) {
        this.f60704f.setOnSrollToBottomListener(pVar);
    }

    public final void o() {
        PbListView pbListView = this.f60706h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60704f.setNextPage(this.f60706h);
            }
            this.f60706h.M();
            this.f60706h.O();
        }
    }

    public final void p() {
        PbListView pbListView = this.f60706h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f60704f.setNextPage(this.f60706h);
            }
            this.f60706h.A(this.f60699a.getPageActivity().getResources().getString(R.string.list_no_more));
            this.f60706h.f();
        }
    }
}
