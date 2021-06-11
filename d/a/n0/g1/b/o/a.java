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
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58788a;

    /* renamed from: b  reason: collision with root package name */
    public View f58789b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58790c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f58791d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f58792e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f58793f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f58794g;

    /* renamed from: h  reason: collision with root package name */
    public g f58795h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f58796i;
    public NoDataView j;
    public boolean k;
    public d.a.n0.g1.b.p.d l;
    public e m;
    public View.OnClickListener n = new View$OnClickListenerC1406a();
    public final f.g o = new b();

    /* renamed from: d.a.n0.g1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1406a implements View.OnClickListener {
        public View$OnClickListenerC1406a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58796i == null || a.this.m == null) {
                return;
            }
            a.this.f58796i.J(0);
            a.this.f58796i.z(null);
            a.this.f58796i.O();
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
            BdSwipeRefreshLayout bdSwipeRefreshLayout = a.this.f58793f;
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
            if (a.this.f58796i == null || a.this.m == null) {
                return;
            }
            a.this.f58796i.J(0);
            a.this.f58796i.z(null);
            a.this.f58796i.L();
            a.this.m.b();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.f58788a = tbPageContext;
        this.f58789b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new d.a.n0.g1.b.p.d(tbPageContext, this.f58794g);
    }

    public void c(int i2) {
        g gVar = this.f58795h;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoNetworkView noNetworkView = this.f58791d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58788a, i2);
        }
        PbListView pbListView = this.f58796i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f58796i.d(i2);
        }
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.f(this.f58788a, i2);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
        NavigationBar navigationBar = this.f58790c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58788a, i2);
        }
        d.a.n0.g1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.c();
        }
        SkinManager.setBackgroundColor(this.f58789b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f58792e, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f58793f, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f58794g, R.color.CAM_X0204);
    }

    public RelativeLayout d() {
        return this.f58792e;
    }

    public List<n> e() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58794g;
        if (bdTypeRecyclerView == null) {
            return null;
        }
        return bdTypeRecyclerView.getData();
    }

    public View f() {
        return this.f58789b;
    }

    public final void g(TbPageContext tbPageContext) {
        if (this.f58789b == null) {
            return;
        }
        if (this.f58795h == null) {
            g gVar = new g(tbPageContext);
            this.f58795h = gVar;
            gVar.a(this.o);
        }
        this.f58795h.Z(tbPageContext.getUniqueId());
        if (this.f58796i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f58796i = pbListView;
            pbListView.b();
        }
        this.f58796i.o(R.color.CAM_X0205);
        this.f58796i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f58796i.v();
        this.f58796i.E(R.dimen.tbfontsize33);
        this.f58796i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f58796i.y(R.color.CAM_X0110);
        this.f58796i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f58789b.findViewById(R.id.no_networkview);
        this.f58791d = noNetworkView;
        noNetworkView.c(this.f58788a, TbadkCoreApplication.getInst().getSkinType());
        this.f58792e = (RelativeLayout) this.f58789b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f58789b.findViewById(R.id.view_navigation_bar);
        this.f58790c = navigationBar;
        navigationBar.showBottomLine();
        this.f58790c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58790c.setCenterTextTitle(this.f58788a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f58789b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f58793f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f58795h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f58789b.findViewById(R.id.agree_me_recycler_view);
        this.f58794g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f58794g.setLayoutManager(new LinearLayoutManager(this.f58788a.getContext()));
        this.f58794g.setFadingEdgeLength(0);
        this.f58794g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f58794g.setOverScrollMode(2);
        this.f58794g.addItemDecoration(new DeviderLineDecoration());
        this.f58794g.setRecyclerListener(new c(this));
        this.f58794g.setOnSrollToBottomListener(new d());
    }

    public void h() {
        d.a.n0.g1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.d();
        }
        g gVar = this.f58795h;
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
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f58793f;
        if (bdSwipeRefreshLayout == null || this.f58796i == null || this.f58794g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f58796i.J(0);
            this.f58796i.f();
            this.f58796i.z(this.n);
        } else {
            this.f58796i.J(0);
            this.f58796i.f();
            this.f58796i.A(this.f58788a.getResources().getString(R.string.list_no_more));
            this.f58796i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f58788a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f58788a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f58794g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.f58788a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f58794g.setNextPage(null);
            return;
        }
        this.f58794g.removeHeaderView(this.j);
        this.k = false;
        this.f58794g.setNextPage(this.f58796i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f58793f;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }
}
