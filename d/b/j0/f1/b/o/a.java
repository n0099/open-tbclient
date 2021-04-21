package d.b.j0.f1.b.o;

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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56321a;

    /* renamed from: b  reason: collision with root package name */
    public View f56322b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56323c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f56324d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f56325e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f56326f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f56327g;

    /* renamed from: h  reason: collision with root package name */
    public g f56328h;
    public PbListView i;
    public NoDataView j;
    public boolean k;
    public d.b.j0.f1.b.p.d l;
    public e m;
    public View.OnClickListener n = new View$OnClickListenerC1321a();
    public final f.g o = new b();

    /* renamed from: d.b.j0.f1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1321a implements View.OnClickListener {
        public View$OnClickListenerC1321a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i == null || a.this.m == null) {
                return;
            }
            a.this.i.J(0);
            a.this.i.z(null);
            a.this.i.O();
            a.this.m.a();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                if (a.this.m != null) {
                    a.this.m.b();
                    return;
                }
                return;
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = a.this.f56326f;
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
            if (a.this.i == null || a.this.m == null) {
                return;
            }
            a.this.i.J(0);
            a.this.i.z(null);
            a.this.i.L();
            a.this.m.a();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.f56321a = tbPageContext;
        this.f56322b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new d.b.j0.f1.b.p.d(tbPageContext, this.f56327g);
    }

    public void c(int i) {
        g gVar = this.f56328h;
        if (gVar != null) {
            gVar.I(i);
        }
        NoNetworkView noNetworkView = this.f56324d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56321a, i);
        }
        PbListView pbListView = this.i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.i.d(i);
        }
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.f(this.f56321a, i);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
        NavigationBar navigationBar = this.f56323c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56321a, i);
        }
        d.b.j0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.c();
        }
        SkinManager.setBackgroundColor(this.f56322b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f56325e, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f56326f, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f56327g, R.color.CAM_X0204);
    }

    public RelativeLayout d() {
        return this.f56325e;
    }

    public List<n> e() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56327g;
        if (bdTypeRecyclerView == null) {
            return null;
        }
        return bdTypeRecyclerView.getData();
    }

    public View f() {
        return this.f56322b;
    }

    public final void g(TbPageContext tbPageContext) {
        if (this.f56322b == null) {
            return;
        }
        if (this.f56328h == null) {
            g gVar = new g(tbPageContext);
            this.f56328h = gVar;
            gVar.b(this.o);
        }
        this.f56328h.Z(tbPageContext.getUniqueId());
        if (this.i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.i = pbListView;
            pbListView.b();
        }
        this.i.o(R.color.CAM_X0205);
        this.i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.i.v();
        this.i.E(R.dimen.tbfontsize33);
        this.i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.i.y(R.color.CAM_X0110);
        this.i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f56322b.findViewById(R.id.no_networkview);
        this.f56324d = noNetworkView;
        noNetworkView.c(this.f56321a, TbadkCoreApplication.getInst().getSkinType());
        this.f56325e = (RelativeLayout) this.f56322b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f56322b.findViewById(R.id.view_navigation_bar);
        this.f56323c = navigationBar;
        navigationBar.showBottomLine();
        this.f56323c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56323c.setCenterTextTitle(this.f56321a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f56322b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f56326f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f56328h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f56322b.findViewById(R.id.agree_me_recycler_view);
        this.f56327g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f56327g.setLayoutManager(new LinearLayoutManager(this.f56321a.getContext()));
        this.f56327g.setFadingEdgeLength(0);
        this.f56327g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f56327g.setOverScrollMode(2);
        this.f56327g.addItemDecoration(new DeviderLineDecoration());
        this.f56327g.setRecyclerListener(new c(this));
        this.f56327g.setOnSrollToBottomListener(new d());
    }

    public void h() {
        d.b.j0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.d();
        }
        g gVar = this.f56328h;
        if (gVar != null) {
            gVar.X();
        }
    }

    public void i(w wVar) {
        d.b.j0.f1.b.p.d dVar = this.l;
        if (dVar != null) {
            dVar.e(wVar);
        }
    }

    public void j(e eVar) {
        this.m = eVar;
    }

    public void k(boolean z, ArrayList<n> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f56326f;
        if (bdSwipeRefreshLayout == null || this.i == null || this.f56327g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.i.J(0);
            this.i.f();
            this.i.z(this.n);
        } else {
            this.i.J(0);
            this.i.f();
            this.i.A(this.f56321a.getResources().getString(R.string.list_no_more));
            this.i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f56321a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f56321a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f56327g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.f56321a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f56327g.setNextPage(null);
            return;
        }
        this.f56327g.removeHeaderView(this.j);
        this.k = false;
        this.f56327g.setNextPage(this.i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f56326f;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }
}
