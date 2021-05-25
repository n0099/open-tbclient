package d.a.n0.g1.b.o;

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
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55099a;

    /* renamed from: b  reason: collision with root package name */
    public View f55100b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f55101c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f55102d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f55103e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f55104f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f55105g;

    /* renamed from: h  reason: collision with root package name */
    public g f55106h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f55107i;
    public NoDataView j;
    public boolean k;
    public d.a.n0.g1.b.p.d l;
    public e m;
    public View.OnClickListener n = new View$OnClickListenerC1350a();
    public final f.g o = new b();

    /* renamed from: d.a.n0.g1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1350a implements View.OnClickListener {
        public View$OnClickListenerC1350a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55107i == null || a.this.m == null) {
                return;
            }
            a.this.f55107i.J(0);
            a.this.f55107i.z(null);
            a.this.f55107i.O();
            a.this.m.b();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                if (a.this.m != null) {
                    a.this.m.a();
                    return;
                }
                return;
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = a.this.f55104f;
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
            if (a.this.f55107i == null || a.this.m == null) {
                return;
            }
            a.this.f55107i.J(0);
            a.this.f55107i.z(null);
            a.this.f55107i.L();
            a.this.m.b();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.f55099a = tbPageContext;
        this.f55100b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new d.a.n0.g1.b.p.d(tbPageContext, this.f55105g);
    }

    public void c(int i2) {
        g gVar = this.f55106h;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoNetworkView noNetworkView = this.f55102d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f55099a, i2);
        }
        PbListView pbListView = this.f55107i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f55107i.d(i2);
        }
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.f(this.f55099a, i2);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
        NavigationBar navigationBar = this.f55101c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f55099a, i2);
        }
        d.a.n0.g1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.c();
        }
        SkinManager.setBackgroundColor(this.f55100b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f55103e, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f55104f, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f55105g, R.color.CAM_X0204);
    }

    public RelativeLayout d() {
        return this.f55103e;
    }

    public List<n> e() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55105g;
        if (bdTypeRecyclerView == null) {
            return null;
        }
        return bdTypeRecyclerView.getData();
    }

    public View f() {
        return this.f55100b;
    }

    public final void g(TbPageContext tbPageContext) {
        if (this.f55100b == null) {
            return;
        }
        if (this.f55106h == null) {
            g gVar = new g(tbPageContext);
            this.f55106h = gVar;
            gVar.a(this.o);
        }
        this.f55106h.Z(tbPageContext.getUniqueId());
        if (this.f55107i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f55107i = pbListView;
            pbListView.b();
        }
        this.f55107i.o(R.color.CAM_X0205);
        this.f55107i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f55107i.v();
        this.f55107i.E(R.dimen.tbfontsize33);
        this.f55107i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f55107i.y(R.color.CAM_X0110);
        this.f55107i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f55100b.findViewById(R.id.no_networkview);
        this.f55102d = noNetworkView;
        noNetworkView.c(this.f55099a, TbadkCoreApplication.getInst().getSkinType());
        this.f55103e = (RelativeLayout) this.f55100b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f55100b.findViewById(R.id.view_navigation_bar);
        this.f55101c = navigationBar;
        navigationBar.showBottomLine();
        this.f55101c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55101c.setCenterTextTitle(this.f55099a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f55100b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f55104f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f55106h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55100b.findViewById(R.id.agree_me_recycler_view);
        this.f55105g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f55105g.setLayoutManager(new LinearLayoutManager(this.f55099a.getContext()));
        this.f55105g.setFadingEdgeLength(0);
        this.f55105g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f55105g.setOverScrollMode(2);
        this.f55105g.addItemDecoration(new DeviderLineDecoration());
        this.f55105g.setRecyclerListener(new c(this));
        this.f55105g.setOnSrollToBottomListener(new d());
    }

    public void h() {
        d.a.n0.g1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.d();
        }
        g gVar = this.f55106h;
        if (gVar != null) {
            gVar.X();
        }
    }

    public void i(w wVar) {
        d.a.n0.g1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.e(wVar);
        }
    }

    public void j(e eVar) {
        this.m = eVar;
    }

    public void k(boolean z, ArrayList<n> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55104f;
        if (bdSwipeRefreshLayout == null || this.f55107i == null || this.f55105g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f55107i.J(0);
            this.f55107i.f();
            this.f55107i.z(this.n);
        } else {
            this.f55107i.J(0);
            this.f55107i.f();
            this.f55107i.A(this.f55099a.getResources().getString(R.string.list_no_more));
            this.f55107i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f55099a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f55099a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f55105g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.f55099a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f55105g.setNextPage(null);
            return;
        }
        this.f55105g.removeHeaderView(this.j);
        this.k = false;
        this.f55105g.setNextPage(this.f55107i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55104f;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }
}
