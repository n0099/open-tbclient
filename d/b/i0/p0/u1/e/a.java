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
    public TbPageContext f58610a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.p0.u1.b.a f58611b;

    /* renamed from: c  reason: collision with root package name */
    public View f58612c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58613d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f58614e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f58615f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f58616g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f58617h;
    public g i;
    public String j;
    public String k;

    /* renamed from: d.b.i0.p0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1442a implements View.OnClickListener {
        public View$OnClickListenerC1442a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.f58610a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        this.f58615f.z();
    }

    public void c() {
        if (this.f58615f == null || !j.z()) {
            return;
        }
        this.f58615f.F();
    }

    public FrameLayout d() {
        return this.f58613d;
    }

    public NavigationBar e() {
        return this.f58614e;
    }

    public View f() {
        return this.f58612c;
    }

    public final void g() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f58610a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f58610a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.f58612c = inflate;
        this.f58616g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f58613d = (FrameLayout) this.f58612c.findViewById(R.id.game_recom_container);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f58612c.findViewById(R.id.game_recom_listview);
        this.f58615f = bdTypeListView;
        bdTypeListView.setDivider(null);
        g gVar = new g(this.f58610a);
        this.i = gVar;
        gVar.Z(this.f58610a.getUniqueId());
        this.f58615f.setPullRefresh(this.i);
        NavigationBar navigationBar = (NavigationBar) this.f58612c.findViewById(R.id.view_navigation_bar);
        this.f58614e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1442a());
        this.f58614e.showBottomLine();
        PbListView pbListView = new PbListView(this.f58610a.getPageActivity());
        this.f58617h = pbListView;
        pbListView.a();
        this.f58611b = new d.b.i0.p0.u1.b.a(this.f58610a, this.f58615f, this.j, this.k);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i) {
        NoNetworkView noNetworkView = this.f58616g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58610a, i);
        }
        NavigationBar navigationBar = this.f58614e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58610a, i);
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
        this.f58611b.c(list);
    }

    public void l(f.g gVar) {
        this.i.b(gVar);
    }

    public void m() {
        this.f58615f.setNextPage(null);
    }

    public void n(BdListView.p pVar) {
        this.f58615f.setOnSrollToBottomListener(pVar);
    }

    public final void o() {
        PbListView pbListView = this.f58617h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58615f.setNextPage(this.f58617h);
            }
            this.f58617h.M();
            this.f58617h.O();
        }
    }

    public final void p() {
        PbListView pbListView = this.f58617h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58615f.setNextPage(this.f58617h);
            }
            this.f58617h.A(this.f58610a.getPageActivity().getResources().getString(R.string.list_no_more));
            this.f58617h.f();
        }
    }
}
