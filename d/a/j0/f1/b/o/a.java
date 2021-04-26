package d.a.j0.f1.b.o;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54204a;

    /* renamed from: b  reason: collision with root package name */
    public View f54205b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54206c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f54207d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f54208e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f54209f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f54210g;

    /* renamed from: h  reason: collision with root package name */
    public g f54211h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f54212i;
    public NoDataView j;
    public boolean k;
    public d.a.j0.f1.b.p.d l;
    public e m;
    public View.OnClickListener n = new View$OnClickListenerC1260a();
    public final f.g o = new b();

    /* renamed from: d.a.j0.f1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1260a implements View.OnClickListener {
        public View$OnClickListenerC1260a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54212i == null || a.this.m == null) {
                return;
            }
            a.this.f54212i.J(0);
            a.this.f54212i.z(null);
            a.this.f54212i.O();
            a.this.m.b();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                if (a.this.m != null) {
                    a.this.m.a();
                    return;
                }
                return;
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = a.this.f54209f;
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
            if (a.this.f54212i == null || a.this.m == null) {
                return;
            }
            a.this.f54212i.J(0);
            a.this.f54212i.z(null);
            a.this.f54212i.L();
            a.this.m.b();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.f54204a = tbPageContext;
        this.f54205b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new d.a.j0.f1.b.p.d(tbPageContext, this.f54210g);
    }

    public void c(int i2) {
        g gVar = this.f54211h;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoNetworkView noNetworkView = this.f54207d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f54204a, i2);
        }
        PbListView pbListView = this.f54212i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f54212i.d(i2);
        }
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.f(this.f54204a, i2);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
        NavigationBar navigationBar = this.f54206c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f54204a, i2);
        }
        d.a.j0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.c();
        }
        SkinManager.setBackgroundColor(this.f54205b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f54208e, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f54209f, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f54210g, R.color.CAM_X0204);
    }

    public RelativeLayout d() {
        return this.f54208e;
    }

    public List<n> e() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54210g;
        if (bdTypeRecyclerView == null) {
            return null;
        }
        return bdTypeRecyclerView.getData();
    }

    public View f() {
        return this.f54205b;
    }

    public final void g(TbPageContext tbPageContext) {
        if (this.f54205b == null) {
            return;
        }
        if (this.f54211h == null) {
            g gVar = new g(tbPageContext);
            this.f54211h = gVar;
            gVar.a(this.o);
        }
        this.f54211h.Z(tbPageContext.getUniqueId());
        if (this.f54212i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f54212i = pbListView;
            pbListView.b();
        }
        this.f54212i.o(R.color.CAM_X0205);
        this.f54212i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f54212i.v();
        this.f54212i.E(R.dimen.tbfontsize33);
        this.f54212i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f54212i.y(R.color.CAM_X0110);
        this.f54212i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f54205b.findViewById(R.id.no_networkview);
        this.f54207d = noNetworkView;
        noNetworkView.c(this.f54204a, TbadkCoreApplication.getInst().getSkinType());
        this.f54208e = (RelativeLayout) this.f54205b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f54205b.findViewById(R.id.view_navigation_bar);
        this.f54206c = navigationBar;
        navigationBar.showBottomLine();
        this.f54206c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54206c.setCenterTextTitle(this.f54204a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f54205b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f54209f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f54211h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f54205b.findViewById(R.id.agree_me_recycler_view);
        this.f54210g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f54210g.setLayoutManager(new LinearLayoutManager(this.f54204a.getContext()));
        this.f54210g.setFadingEdgeLength(0);
        this.f54210g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f54210g.setOverScrollMode(2);
        this.f54210g.addItemDecoration(new DeviderLineDecoration());
        this.f54210g.setRecyclerListener(new c(this));
        this.f54210g.setOnSrollToBottomListener(new d());
    }

    public void h() {
        d.a.j0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.d();
        }
        g gVar = this.f54211h;
        if (gVar != null) {
            gVar.X();
        }
    }

    public void i(w wVar) {
        d.a.j0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.e(wVar);
        }
    }

    public void j(e eVar) {
        this.m = eVar;
    }

    public void k(boolean z, ArrayList<n> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f54209f;
        if (bdSwipeRefreshLayout == null || this.f54212i == null || this.f54210g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f54212i.J(0);
            this.f54212i.f();
            this.f54212i.z(this.n);
        } else {
            this.f54212i.J(0);
            this.f54212i.f();
            this.f54212i.A(this.f54204a.getResources().getString(R.string.list_no_more));
            this.f54212i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f54204a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f54204a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f54210g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.f54204a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f54210g.setNextPage(null);
            return;
        }
        this.f54210g.removeHeaderView(this.j);
        this.k = false;
        this.f54210g.setNextPage(this.f54212i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f54209f;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }
}
