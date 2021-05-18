package d.a.k0.i2.i.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import d.a.c.e.p.l;
import d.a.k0.i2.c.n;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56315a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f56316b;

    /* renamed from: c  reason: collision with root package name */
    public View f56317c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f56318d;

    /* renamed from: e  reason: collision with root package name */
    public n f56319e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f56320f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f56321g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.m0.b f56322h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f56323i = 1010;

    /* renamed from: d.a.k0.i2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1383a extends LinearLayoutManager {
        public C1383a(a aVar, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (a.this.f56322h == null) {
                a.this.f56322h = new d.a.j0.m0.b();
                a.this.f56322h.a(a.this.f56323i);
            }
            if (i2 == 0) {
                a.this.f56322h.e();
            } else {
                a.this.f56322h.d();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.f56315a = tbPageContext;
        this.f56317c = view;
        this.f56320f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        this.f56316b.s(view);
    }

    public n e() {
        return this.f56319e;
    }

    public View f() {
        return this.f56317c;
    }

    public void g() {
        this.f56316b.setNextPage(null);
    }

    public final void h() {
        int i2;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f56317c.findViewById(R.id.new_person_center_common_lv);
        this.f56316b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new C1383a(this, bdTypeRecyclerView.getContext()));
        this.f56316b.addOnScrollListener(new b());
        PbListView pbListView = new PbListView(this.f56315a.getPageActivity());
        this.f56318d = pbListView;
        pbListView.a();
        this.f56318d.o(R.color.CAM_X0205);
        this.f56318d.r(l.g(this.f56315a.getPageActivity(), R.dimen.tbds182));
        this.f56318d.v();
        this.f56318d.E(R.dimen.tbfontsize33);
        this.f56318d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f56318d.y(R.color.CAM_X0110);
        n nVar = new n(this.f56315a, this.f56316b, this.f56320f.getUniqueId());
        this.f56319e = nVar;
        nVar.d(this.f56320f.F0());
        this.f56319e.h(32);
        if (this.f56320f.F0()) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f56320f;
            if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                i2 = 4;
            } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                i2 = 6;
            }
            this.f56319e.f(i2);
            this.f56319e.g(this.f56320f.E0());
        }
        i2 = 0;
        this.f56319e.f(i2);
        this.f56319e.g(this.f56320f.E0());
    }

    public void i(int i2) {
        SkinManager.setBackgroundResource(this.f56317c, R.color.CAM_X0201);
        n nVar = this.f56319e;
        if (nVar != null) {
            nVar.b();
        }
        NoDataView noDataView = this.f56321g;
        if (noDataView != null) {
            noDataView.f(this.f56315a, i2);
        }
        PbListView pbListView = this.f56318d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56318d.d(i2);
        }
    }

    public void j() {
        d.a.j0.m0.b bVar = this.f56322h;
        if (bVar != null) {
            bVar.c();
        }
        this.f56316b.setOnSrollToBottomListener(null);
    }

    public void k() {
        this.f56316b.smoothScrollToPosition(0);
    }

    public void l(BdListView.p pVar) {
        this.f56316b.setOnSrollToBottomListener(pVar);
    }

    public void m(int i2) {
        this.f56323i = i2;
    }

    public void n(List<d.a.c.j.e.n> list) {
        if (ListUtils.isEmpty(list)) {
            g();
            if (this.f56316b.getHeaderViewsCount() == 0) {
                p(R.string.person_center_listempty_txt);
            }
        } else {
            NoDataView noDataView = this.f56321g;
            if (noDataView != null && noDataView.getParent() != null) {
                this.f56316b.removeHeaderView(this.f56321g);
            }
        }
        this.f56316b.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f56320f.E0())));
    }

    public void o() {
        this.f56316b.setNextPage(this.f56318d);
        this.f56318d.J(0);
        this.f56318d.O();
    }

    public final void p(int i2) {
        String string;
        if (this.f56320f.E0() == 1) {
            string = this.f56320f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.f56320f.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.f56321g == null) {
            this.f56321g = NoDataViewFactory.a(this.f56315a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
        }
        this.f56321g.f(this.f56315a, TbadkApplication.getInst().getSkinType());
        this.f56321g.setVisibility(0);
        this.f56316b.removeHeaderView(this.f56321g);
        this.f56321g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f56316b.s(this.f56321g);
    }

    public void q() {
        this.f56316b.setNextPage(this.f56318d);
        this.f56318d.J(0);
        this.f56318d.f();
        this.f56318d.A(this.f56315a.getString(R.string.list_no_more));
    }

    public void r(int i2) {
        this.f56316b.setNextPage(this.f56318d);
        this.f56318d.J(0);
        this.f56318d.f();
        this.f56318d.A(this.f56315a.getString(i2));
    }
}
