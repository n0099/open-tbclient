package d.a.n0.j2.i.d;

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
import d.a.n0.j2.c.n;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56499a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f56500b;

    /* renamed from: c  reason: collision with root package name */
    public View f56501c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f56502d;

    /* renamed from: e  reason: collision with root package name */
    public n f56503e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f56504f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f56505g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.m0.b f56506h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f56507i = 1010;

    /* renamed from: d.a.n0.j2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1401a extends LinearLayoutManager {
        public C1401a(a aVar, Context context) {
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
            if (a.this.f56506h == null) {
                a.this.f56506h = new d.a.m0.m0.b();
                a.this.f56506h.a(a.this.f56507i);
            }
            if (i2 == 0) {
                a.this.f56506h.e();
            } else {
                a.this.f56506h.d();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.f56499a = tbPageContext;
        this.f56501c = view;
        this.f56504f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        this.f56500b.s(view);
    }

    public n e() {
        return this.f56503e;
    }

    public View f() {
        return this.f56501c;
    }

    public void g() {
        this.f56500b.setNextPage(null);
    }

    public final void h() {
        int i2;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f56501c.findViewById(R.id.new_person_center_common_lv);
        this.f56500b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new C1401a(this, bdTypeRecyclerView.getContext()));
        this.f56500b.addOnScrollListener(new b());
        PbListView pbListView = new PbListView(this.f56499a.getPageActivity());
        this.f56502d = pbListView;
        pbListView.a();
        this.f56502d.o(R.color.CAM_X0205);
        this.f56502d.r(l.g(this.f56499a.getPageActivity(), R.dimen.tbds182));
        this.f56502d.v();
        this.f56502d.E(R.dimen.tbfontsize33);
        this.f56502d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f56502d.y(R.color.CAM_X0110);
        n nVar = new n(this.f56499a, this.f56500b, this.f56504f.getUniqueId());
        this.f56503e = nVar;
        nVar.d(this.f56504f.F0());
        this.f56503e.h(32);
        if (this.f56504f.F0()) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f56504f;
            if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                i2 = 4;
            } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                i2 = 6;
            }
            this.f56503e.f(i2);
            this.f56503e.g(this.f56504f.E0());
        }
        i2 = 0;
        this.f56503e.f(i2);
        this.f56503e.g(this.f56504f.E0());
    }

    public void i(int i2) {
        SkinManager.setBackgroundResource(this.f56501c, R.color.CAM_X0201);
        n nVar = this.f56503e;
        if (nVar != null) {
            nVar.b();
        }
        NoDataView noDataView = this.f56505g;
        if (noDataView != null) {
            noDataView.f(this.f56499a, i2);
        }
        PbListView pbListView = this.f56502d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56502d.d(i2);
        }
    }

    public void j() {
        d.a.m0.m0.b bVar = this.f56506h;
        if (bVar != null) {
            bVar.c();
        }
        this.f56500b.setOnSrollToBottomListener(null);
    }

    public void k() {
        this.f56500b.smoothScrollToPosition(0);
    }

    public void l(BdListView.p pVar) {
        this.f56500b.setOnSrollToBottomListener(pVar);
    }

    public void m(int i2) {
        this.f56507i = i2;
    }

    public void n(List<d.a.c.j.e.n> list) {
        if (ListUtils.isEmpty(list)) {
            g();
            if (this.f56500b.getHeaderViewsCount() == 0) {
                p(R.string.person_center_listempty_txt);
            }
        } else {
            NoDataView noDataView = this.f56505g;
            if (noDataView != null && noDataView.getParent() != null) {
                this.f56500b.removeHeaderView(this.f56505g);
            }
        }
        this.f56500b.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f56504f.E0())));
    }

    public void o() {
        this.f56500b.setNextPage(this.f56502d);
        this.f56502d.J(0);
        this.f56502d.O();
    }

    public final void p(int i2) {
        String string;
        if (this.f56504f.E0() == 1) {
            string = this.f56504f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.f56504f.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.f56505g == null) {
            this.f56505g = NoDataViewFactory.a(this.f56499a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
        }
        this.f56505g.f(this.f56499a, TbadkApplication.getInst().getSkinType());
        this.f56505g.setVisibility(0);
        this.f56500b.removeHeaderView(this.f56505g);
        this.f56505g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f56500b.s(this.f56505g);
    }

    public void q() {
        this.f56500b.setNextPage(this.f56502d);
        this.f56502d.J(0);
        this.f56502d.f();
        this.f56502d.A(this.f56499a.getString(R.string.list_no_more));
    }

    public void r(int i2) {
        this.f56500b.setNextPage(this.f56502d);
        this.f56502d.J(0);
        this.f56502d.f();
        this.f56502d.A(this.f56499a.getString(i2));
    }
}
