package d.a.k0.f1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54911a;

    /* renamed from: b  reason: collision with root package name */
    public View f54912b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54913c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f54914d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f54915e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f54916f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f54917g;

    /* renamed from: h  reason: collision with root package name */
    public g f54918h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f54919i;
    public NoDataView j;
    public boolean k;
    public d.a.k0.f1.b.p.d l;
    public e m;
    public View.OnClickListener n = new View$OnClickListenerC1332a();
    public final f.g o = new b();

    /* renamed from: d.a.k0.f1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1332a implements View.OnClickListener {
        public View$OnClickListenerC1332a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54919i == null || a.this.m == null) {
                return;
            }
            a.this.f54919i.J(0);
            a.this.f54919i.z(null);
            a.this.f54919i.O();
            a.this.m.b();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.j0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                if (a.this.m != null) {
                    a.this.m.a();
                    return;
                }
                return;
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = a.this.f54916f;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements RecyclerView.RecyclerListener {
        public c(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f54919i == null || a.this.m == null) {
                return;
            }
            a.this.f54919i.J(0);
            a.this.f54919i.z(null);
            a.this.f54919i.L();
            a.this.m.b();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.f54911a = tbPageContext;
        this.f54912b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new d.a.k0.f1.b.p.d(tbPageContext, this.f54917g);
    }

    public void c(int i2) {
        g gVar = this.f54918h;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoNetworkView noNetworkView = this.f54914d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f54911a, i2);
        }
        PbListView pbListView = this.f54919i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f54919i.d(i2);
        }
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.f(this.f54911a, i2);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
        NavigationBar navigationBar = this.f54913c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f54911a, i2);
        }
        d.a.k0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.c();
        }
        SkinManager.setBackgroundColor(this.f54912b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f54915e, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f54916f, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f54917g, R.color.CAM_X0204);
    }

    public RelativeLayout d() {
        return this.f54915e;
    }

    public List<n> e() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54917g;
        if (bdTypeRecyclerView == null) {
            return null;
        }
        return bdTypeRecyclerView.getData();
    }

    public View f() {
        return this.f54912b;
    }

    public final void g(TbPageContext tbPageContext) {
        if (this.f54912b == null) {
            return;
        }
        if (this.f54918h == null) {
            g gVar = new g(tbPageContext);
            this.f54918h = gVar;
            gVar.a(this.o);
        }
        this.f54918h.Z(tbPageContext.getUniqueId());
        if (this.f54919i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f54919i = pbListView;
            pbListView.b();
        }
        this.f54919i.o(R.color.CAM_X0205);
        this.f54919i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f54919i.v();
        this.f54919i.E(R.dimen.tbfontsize33);
        this.f54919i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f54919i.y(R.color.CAM_X0110);
        this.f54919i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f54912b.findViewById(R.id.no_networkview);
        this.f54914d = noNetworkView;
        noNetworkView.c(this.f54911a, TbadkCoreApplication.getInst().getSkinType());
        this.f54915e = (RelativeLayout) this.f54912b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f54912b.findViewById(R.id.view_navigation_bar);
        this.f54913c = navigationBar;
        navigationBar.showBottomLine();
        this.f54913c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54913c.setCenterTextTitle(this.f54911a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f54912b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f54916f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f54918h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f54912b.findViewById(R.id.agree_me_recycler_view);
        this.f54917g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f54917g.setLayoutManager(new LinearLayoutManager(this.f54911a.getContext()));
        this.f54917g.setFadingEdgeLength(0);
        this.f54917g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f54917g.setOverScrollMode(2);
        this.f54917g.addItemDecoration(new DeviderLineDecoration());
        this.f54917g.setRecyclerListener(new c(this));
        this.f54917g.setOnSrollToBottomListener(new d());
    }

    public void h() {
        d.a.k0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.d();
        }
        g gVar = this.f54918h;
        if (gVar != null) {
            gVar.X();
        }
    }

    public void i(w wVar) {
        d.a.k0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.e(wVar);
        }
    }

    public void j(e eVar) {
        this.m = eVar;
    }

    public void k(boolean z, ArrayList<n> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f54916f;
        if (bdSwipeRefreshLayout == null || this.f54919i == null || this.f54917g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f54919i.J(0);
            this.f54919i.f();
            this.f54919i.z(this.n);
        } else {
            this.f54919i.J(0);
            this.f54919i.f();
            this.f54919i.A(this.f54911a.getResources().getString(R.string.list_no_more));
            this.f54919i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f54911a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f54911a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f54917g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.f54911a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f54917g.setNextPage(null);
            return;
        }
        this.f54917g.removeHeaderView(this.j);
        this.k = false;
        this.f54917g.setNextPage(this.f54919i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f54916f;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }
}
