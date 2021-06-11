package d.a.n0.r0.u1.e;

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
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63381a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.r0.u1.b.a f63382b;

    /* renamed from: c  reason: collision with root package name */
    public View f63383c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f63384d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f63385e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f63386f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f63387g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f63388h;

    /* renamed from: i  reason: collision with root package name */
    public g f63389i;
    public String j;
    public String k;

    /* renamed from: d.a.n0.r0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1610a implements View.OnClickListener {
        public View$OnClickListenerC1610a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.f63381a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        this.f63386f.z();
    }

    public void c() {
        if (this.f63386f == null || !j.z()) {
            return;
        }
        this.f63386f.F();
    }

    public FrameLayout d() {
        return this.f63384d;
    }

    public NavigationBar e() {
        return this.f63385e;
    }

    public View f() {
        return this.f63383c;
    }

    public final void g() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f63381a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f63381a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.f63383c = inflate;
        this.f63387g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f63384d = (FrameLayout) this.f63383c.findViewById(R.id.game_recom_container);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f63383c.findViewById(R.id.game_recom_listview);
        this.f63386f = bdTypeListView;
        bdTypeListView.setDivider(null);
        g gVar = new g(this.f63381a);
        this.f63389i = gVar;
        gVar.Z(this.f63381a.getUniqueId());
        this.f63386f.setPullRefresh(this.f63389i);
        NavigationBar navigationBar = (NavigationBar) this.f63383c.findViewById(R.id.view_navigation_bar);
        this.f63385e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1610a());
        this.f63385e.showBottomLine();
        PbListView pbListView = new PbListView(this.f63381a.getPageActivity());
        this.f63388h = pbListView;
        pbListView.a();
        this.f63382b = new d.a.n0.r0.u1.b.a(this.f63381a, this.f63386f, this.j, this.k);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i2) {
        NoNetworkView noNetworkView = this.f63387g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f63381a, i2);
        }
        NavigationBar navigationBar = this.f63385e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f63381a, i2);
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
        this.f63382b.c(list);
    }

    public void l(f.g gVar) {
        this.f63389i.a(gVar);
    }

    public void m() {
        this.f63386f.setNextPage(null);
    }

    public void n(BdListView.p pVar) {
        this.f63386f.setOnSrollToBottomListener(pVar);
    }

    public final void o() {
        PbListView pbListView = this.f63388h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f63386f.setNextPage(this.f63388h);
            }
            this.f63388h.M();
            this.f63388h.O();
        }
    }

    public final void p() {
        PbListView pbListView = this.f63388h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f63386f.setNextPage(this.f63388h);
            }
            this.f63388h.A(this.f63381a.getPageActivity().getResources().getString(R.string.list_no_more));
            this.f63388h.f();
        }
    }
}
