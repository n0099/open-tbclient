package d.a.j0.i2.i.d;

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
import d.a.j0.i2.c.n;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55608a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55609b;

    /* renamed from: c  reason: collision with root package name */
    public View f55610c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f55611d;

    /* renamed from: e  reason: collision with root package name */
    public n f55612e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f55613f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55614g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.m0.b f55615h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f55616i = 1010;

    /* renamed from: d.a.j0.i2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1311a extends LinearLayoutManager {
        public C1311a(a aVar, Context context) {
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

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (a.this.f55615h == null) {
                a.this.f55615h = new d.a.i0.m0.b();
                a.this.f55615h.a(a.this.f55616i);
            }
            if (i2 == 0) {
                a.this.f55615h.e();
            } else {
                a.this.f55615h.d();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.f55608a = tbPageContext;
        this.f55610c = view;
        this.f55613f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        this.f55609b.s(view);
    }

    public n e() {
        return this.f55612e;
    }

    public View f() {
        return this.f55610c;
    }

    public void g() {
        this.f55609b.setNextPage(null);
    }

    public final void h() {
        int i2;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55610c.findViewById(R.id.new_person_center_common_lv);
        this.f55609b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new C1311a(this, bdTypeRecyclerView.getContext()));
        this.f55609b.addOnScrollListener(new b());
        PbListView pbListView = new PbListView(this.f55608a.getPageActivity());
        this.f55611d = pbListView;
        pbListView.a();
        this.f55611d.o(R.color.CAM_X0205);
        this.f55611d.r(l.g(this.f55608a.getPageActivity(), R.dimen.tbds182));
        this.f55611d.v();
        this.f55611d.E(R.dimen.tbfontsize33);
        this.f55611d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55611d.y(R.color.CAM_X0110);
        n nVar = new n(this.f55608a, this.f55609b, this.f55613f.getUniqueId());
        this.f55612e = nVar;
        nVar.d(this.f55613f.G0());
        this.f55612e.h(32);
        if (this.f55613f.G0()) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55613f;
            if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                i2 = 4;
            } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                i2 = 6;
            }
            this.f55612e.f(i2);
            this.f55612e.g(this.f55613f.F0());
        }
        i2 = 0;
        this.f55612e.f(i2);
        this.f55612e.g(this.f55613f.F0());
    }

    public void i(int i2) {
        SkinManager.setBackgroundResource(this.f55610c, R.color.CAM_X0201);
        n nVar = this.f55612e;
        if (nVar != null) {
            nVar.b();
        }
        NoDataView noDataView = this.f55614g;
        if (noDataView != null) {
            noDataView.f(this.f55608a, i2);
        }
        PbListView pbListView = this.f55611d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55611d.d(i2);
        }
    }

    public void j() {
        d.a.i0.m0.b bVar = this.f55615h;
        if (bVar != null) {
            bVar.c();
        }
        this.f55609b.setOnSrollToBottomListener(null);
    }

    public void k() {
        this.f55609b.smoothScrollToPosition(0);
    }

    public void l(BdListView.p pVar) {
        this.f55609b.setOnSrollToBottomListener(pVar);
    }

    public void m(int i2) {
        this.f55616i = i2;
    }

    public void n(List<d.a.c.j.e.n> list) {
        if (ListUtils.isEmpty(list)) {
            g();
            if (this.f55609b.getHeaderViewsCount() == 0) {
                p(R.string.person_center_listempty_txt);
            }
        } else {
            NoDataView noDataView = this.f55614g;
            if (noDataView != null && noDataView.getParent() != null) {
                this.f55609b.removeHeaderView(this.f55614g);
            }
        }
        this.f55609b.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f55613f.F0())));
    }

    public void o() {
        this.f55609b.setNextPage(this.f55611d);
        this.f55611d.J(0);
        this.f55611d.O();
    }

    public final void p(int i2) {
        String string;
        if (this.f55613f.F0() == 1) {
            string = this.f55613f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.f55613f.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.f55614g == null) {
            this.f55614g = NoDataViewFactory.a(this.f55608a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
        }
        this.f55614g.f(this.f55608a, TbadkApplication.getInst().getSkinType());
        this.f55614g.setVisibility(0);
        this.f55609b.removeHeaderView(this.f55614g);
        this.f55614g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f55609b.s(this.f55614g);
    }

    public void q() {
        this.f55609b.setNextPage(this.f55611d);
        this.f55611d.J(0);
        this.f55611d.f();
        this.f55611d.A(this.f55608a.getString(R.string.list_no_more));
    }

    public void r(int i2) {
        this.f55609b.setNextPage(this.f55611d);
        this.f55611d.J(0);
        this.f55611d.f();
        this.f55611d.A(this.f55608a.getString(i2));
    }
}
