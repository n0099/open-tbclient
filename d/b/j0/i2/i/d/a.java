package d.b.j0.i2.i.d;

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
import d.b.c.e.p.l;
import d.b.j0.i2.c.n;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57650a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57651b;

    /* renamed from: c  reason: collision with root package name */
    public View f57652c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f57653d;

    /* renamed from: e  reason: collision with root package name */
    public n f57654e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f57655f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f57656g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.m0.b f57657h = null;
    public int i = 1010;

    /* renamed from: d.b.j0.i2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1372a extends LinearLayoutManager {
        public C1372a(a aVar, Context context) {
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

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (a.this.f57657h == null) {
                a.this.f57657h = new d.b.i0.m0.b();
                a.this.f57657h.a(a.this.i);
            }
            if (i == 0) {
                a.this.f57657h.e();
            } else {
                a.this.f57657h.d();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.f57650a = tbPageContext;
        this.f57652c = view;
        this.f57655f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        this.f57651b.s(view);
    }

    public n e() {
        return this.f57654e;
    }

    public View f() {
        return this.f57652c;
    }

    public void g() {
        this.f57651b.setNextPage(null);
    }

    public final void h() {
        int i;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f57652c.findViewById(R.id.new_person_center_common_lv);
        this.f57651b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new C1372a(this, bdTypeRecyclerView.getContext()));
        this.f57651b.addOnScrollListener(new b());
        PbListView pbListView = new PbListView(this.f57650a.getPageActivity());
        this.f57653d = pbListView;
        pbListView.a();
        this.f57653d.o(R.color.CAM_X0205);
        this.f57653d.r(l.g(this.f57650a.getPageActivity(), R.dimen.tbds182));
        this.f57653d.v();
        this.f57653d.E(R.dimen.tbfontsize33);
        this.f57653d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57653d.y(R.color.CAM_X0110);
        n nVar = new n(this.f57650a, this.f57651b, this.f57655f.getUniqueId());
        this.f57654e = nVar;
        nVar.d(this.f57655f.G0());
        this.f57654e.h(32);
        if (this.f57655f.G0()) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f57655f;
            if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
            this.f57654e.f(i);
            this.f57654e.g(this.f57655f.F0());
        }
        i = 0;
        this.f57654e.f(i);
        this.f57654e.g(this.f57655f.F0());
    }

    public void i(int i) {
        SkinManager.setBackgroundResource(this.f57652c, R.color.CAM_X0201);
        n nVar = this.f57654e;
        if (nVar != null) {
            nVar.b();
        }
        NoDataView noDataView = this.f57656g;
        if (noDataView != null) {
            noDataView.f(this.f57650a, i);
        }
        PbListView pbListView = this.f57653d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57653d.d(i);
        }
    }

    public void j() {
        d.b.i0.m0.b bVar = this.f57657h;
        if (bVar != null) {
            bVar.c();
        }
        this.f57651b.setOnSrollToBottomListener(null);
    }

    public void k() {
        this.f57651b.smoothScrollToPosition(0);
    }

    public void l(BdListView.p pVar) {
        this.f57651b.setOnSrollToBottomListener(pVar);
    }

    public void m(int i) {
        this.i = i;
    }

    public void n(List<d.b.c.j.e.n> list) {
        if (ListUtils.isEmpty(list)) {
            g();
            if (this.f57651b.getHeaderViewsCount() == 0) {
                p(R.string.person_center_listempty_txt);
            }
        } else {
            NoDataView noDataView = this.f57656g;
            if (noDataView != null && noDataView.getParent() != null) {
                this.f57651b.removeHeaderView(this.f57656g);
            }
        }
        this.f57651b.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f57655f.F0())));
    }

    public void o() {
        this.f57651b.setNextPage(this.f57653d);
        this.f57653d.J(0);
        this.f57653d.O();
    }

    public final void p(int i) {
        String string;
        if (this.f57655f.F0() == 1) {
            string = this.f57655f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.f57655f.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.f57656g == null) {
            this.f57656g = NoDataViewFactory.a(this.f57650a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
        }
        this.f57656g.f(this.f57650a, TbadkApplication.getInst().getSkinType());
        this.f57656g.setVisibility(0);
        this.f57651b.removeHeaderView(this.f57656g);
        this.f57656g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f57651b.s(this.f57656g);
    }

    public void q() {
        this.f57651b.setNextPage(this.f57653d);
        this.f57653d.J(0);
        this.f57653d.f();
        this.f57653d.A(this.f57650a.getString(R.string.list_no_more));
    }

    public void r(int i) {
        this.f57651b.setNextPage(this.f57653d);
        this.f57653d.J(0);
        this.f57653d.f();
        this.f57653d.A(this.f57650a.getString(i));
    }
}
