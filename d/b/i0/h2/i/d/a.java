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
    public TbPageContext f55370a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55371b;

    /* renamed from: c  reason: collision with root package name */
    public View f55372c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f55373d;

    /* renamed from: e  reason: collision with root package name */
    public n f55374e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f55375f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55376g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.m0.b f55377h = null;
    public int i = 1010;

    /* renamed from: d.b.i0.h2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1273a extends LinearLayoutManager {
        public C1273a(a aVar, Context context) {
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
            if (a.this.f55377h == null) {
                a.this.f55377h = new d.b.h0.m0.b();
                a.this.f55377h.a(a.this.i);
            }
            if (i == 0) {
                a.this.f55377h.e();
            } else {
                a.this.f55377h.d();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.f55370a = tbPageContext;
        this.f55372c = view;
        this.f55375f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        this.f55371b.s(view);
    }

    public n e() {
        return this.f55374e;
    }

    public View f() {
        return this.f55372c;
    }

    public void g() {
        this.f55371b.setNextPage(null);
    }

    public final void h() {
        int i;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55372c.findViewById(R.id.new_person_center_common_lv);
        this.f55371b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new C1273a(this, bdTypeRecyclerView.getContext()));
        this.f55371b.addOnScrollListener(new b());
        PbListView pbListView = new PbListView(this.f55370a.getPageActivity());
        this.f55373d = pbListView;
        pbListView.a();
        this.f55373d.o(R.color.CAM_X0205);
        this.f55373d.r(l.g(this.f55370a.getPageActivity(), R.dimen.tbds182));
        this.f55373d.v();
        this.f55373d.E(R.dimen.tbfontsize33);
        this.f55373d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55373d.y(R.color.CAM_X0110);
        n nVar = new n(this.f55370a, this.f55371b, this.f55375f.getUniqueId());
        this.f55374e = nVar;
        nVar.d(this.f55375f.G0());
        this.f55374e.h(32);
        if (this.f55375f.G0()) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55375f;
            if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
            this.f55374e.f(i);
            this.f55374e.g(this.f55375f.F0());
        }
        i = 0;
        this.f55374e.f(i);
        this.f55374e.g(this.f55375f.F0());
    }

    public void i(int i) {
        SkinManager.setBackgroundResource(this.f55372c, R.color.CAM_X0201);
        n nVar = this.f55374e;
        if (nVar != null) {
            nVar.b();
        }
        NoDataView noDataView = this.f55376g;
        if (noDataView != null) {
            noDataView.f(this.f55370a, i);
        }
        PbListView pbListView = this.f55373d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55373d.d(i);
        }
    }

    public void j() {
        d.b.h0.m0.b bVar = this.f55377h;
        if (bVar != null) {
            bVar.c();
        }
        this.f55371b.setOnSrollToBottomListener(null);
    }

    public void k() {
        this.f55371b.smoothScrollToPosition(0);
    }

    public void l(BdListView.p pVar) {
        this.f55371b.setOnSrollToBottomListener(pVar);
    }

    public void m(int i) {
        this.i = i;
    }

    public void n(List<d.b.b.j.e.n> list) {
        if (ListUtils.isEmpty(list)) {
            g();
            if (this.f55371b.getHeaderViewsCount() == 0) {
                p(R.string.person_center_listempty_txt);
            }
        } else {
            NoDataView noDataView = this.f55376g;
            if (noDataView != null && noDataView.getParent() != null) {
                this.f55371b.removeHeaderView(this.f55376g);
            }
        }
        this.f55371b.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f55375f.F0())));
    }

    public void o() {
        this.f55371b.setNextPage(this.f55373d);
        this.f55373d.J(0);
        this.f55373d.O();
    }

    public final void p(int i) {
        String string;
        if (this.f55375f.F0() == 1) {
            string = this.f55375f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.f55375f.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.f55376g == null) {
            this.f55376g = NoDataViewFactory.a(this.f55370a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
        }
        this.f55376g.f(this.f55370a, TbadkApplication.getInst().getSkinType());
        this.f55376g.setVisibility(0);
        this.f55371b.removeHeaderView(this.f55376g);
        this.f55376g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f55371b.s(this.f55376g);
    }

    public void q() {
        this.f55371b.setNextPage(this.f55373d);
        this.f55373d.J(0);
        this.f55373d.f();
        this.f55373d.A(this.f55370a.getString(R.string.list_no_more));
    }

    public void r(int i) {
        this.f55371b.setNextPage(this.f55373d);
        this.f55373d.J(0);
        this.f55373d.f();
        this.f55373d.A(this.f55370a.getString(i));
    }
}
