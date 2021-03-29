package d.b.i0.h2.i.d;

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
import d.b.b.e.p.l;
import d.b.i0.h2.c.n;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55371a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55372b;

    /* renamed from: c  reason: collision with root package name */
    public View f55373c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f55374d;

    /* renamed from: e  reason: collision with root package name */
    public n f55375e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f55376f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55377g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.m0.b f55378h = null;
    public int i = 1010;

    /* renamed from: d.b.i0.h2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1274a extends LinearLayoutManager {
        public C1274a(a aVar, Context context) {
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
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (a.this.f55378h == null) {
                a.this.f55378h = new d.b.h0.m0.b();
                a.this.f55378h.a(a.this.i);
            }
            if (i == 0) {
                a.this.f55378h.e();
            } else {
                a.this.f55378h.d();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.f55371a = tbPageContext;
        this.f55373c = view;
        this.f55376f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        this.f55372b.s(view);
    }

    public n e() {
        return this.f55375e;
    }

    public View f() {
        return this.f55373c;
    }

    public void g() {
        this.f55372b.setNextPage(null);
    }

    public final void h() {
        int i;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55373c.findViewById(R.id.new_person_center_common_lv);
        this.f55372b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new C1274a(this, bdTypeRecyclerView.getContext()));
        this.f55372b.addOnScrollListener(new b());
        PbListView pbListView = new PbListView(this.f55371a.getPageActivity());
        this.f55374d = pbListView;
        pbListView.a();
        this.f55374d.o(R.color.CAM_X0205);
        this.f55374d.r(l.g(this.f55371a.getPageActivity(), R.dimen.tbds182));
        this.f55374d.v();
        this.f55374d.E(R.dimen.tbfontsize33);
        this.f55374d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55374d.y(R.color.CAM_X0110);
        n nVar = new n(this.f55371a, this.f55372b, this.f55376f.getUniqueId());
        this.f55375e = nVar;
        nVar.d(this.f55376f.G0());
        this.f55375e.h(32);
        if (this.f55376f.G0()) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55376f;
            if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
            this.f55375e.f(i);
            this.f55375e.g(this.f55376f.F0());
        }
        i = 0;
        this.f55375e.f(i);
        this.f55375e.g(this.f55376f.F0());
    }

    public void i(int i) {
        SkinManager.setBackgroundResource(this.f55373c, R.color.CAM_X0201);
        n nVar = this.f55375e;
        if (nVar != null) {
            nVar.b();
        }
        NoDataView noDataView = this.f55377g;
        if (noDataView != null) {
            noDataView.f(this.f55371a, i);
        }
        PbListView pbListView = this.f55374d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55374d.d(i);
        }
    }

    public void j() {
        d.b.h0.m0.b bVar = this.f55378h;
        if (bVar != null) {
            bVar.c();
        }
        this.f55372b.setOnSrollToBottomListener(null);
    }

    public void k() {
        this.f55372b.smoothScrollToPosition(0);
    }

    public void l(BdListView.p pVar) {
        this.f55372b.setOnSrollToBottomListener(pVar);
    }

    public void m(int i) {
        this.i = i;
    }

    public void n(List<d.b.b.j.e.n> list) {
        if (ListUtils.isEmpty(list)) {
            g();
            if (this.f55372b.getHeaderViewsCount() == 0) {
                p(R.string.person_center_listempty_txt);
            }
        } else {
            NoDataView noDataView = this.f55377g;
            if (noDataView != null && noDataView.getParent() != null) {
                this.f55372b.removeHeaderView(this.f55377g);
            }
        }
        this.f55372b.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f55376f.F0())));
    }

    public void o() {
        this.f55372b.setNextPage(this.f55374d);
        this.f55374d.J(0);
        this.f55374d.O();
    }

    public final void p(int i) {
        String string;
        if (this.f55376f.F0() == 1) {
            string = this.f55376f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.f55376f.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.f55377g == null) {
            this.f55377g = NoDataViewFactory.a(this.f55371a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
        }
        this.f55377g.f(this.f55371a, TbadkApplication.getInst().getSkinType());
        this.f55377g.setVisibility(0);
        this.f55372b.removeHeaderView(this.f55377g);
        this.f55377g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f55372b.s(this.f55377g);
    }

    public void q() {
        this.f55372b.setNextPage(this.f55374d);
        this.f55374d.J(0);
        this.f55374d.f();
        this.f55374d.A(this.f55371a.getString(R.string.list_no_more));
    }

    public void r(int i) {
        this.f55372b.setNextPage(this.f55374d);
        this.f55374d.J(0);
        this.f55374d.f();
        this.f55374d.A(this.f55371a.getString(i));
    }
}
