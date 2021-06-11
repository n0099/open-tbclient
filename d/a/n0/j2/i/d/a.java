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
    public TbPageContext f60188a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f60189b;

    /* renamed from: c  reason: collision with root package name */
    public View f60190c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f60191d;

    /* renamed from: e  reason: collision with root package name */
    public n f60192e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f60193f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f60194g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.m0.b f60195h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f60196i = 1010;

    /* renamed from: d.a.n0.j2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1457a extends LinearLayoutManager {
        public C1457a(a aVar, Context context) {
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
            if (a.this.f60195h == null) {
                a.this.f60195h = new d.a.m0.m0.b();
                a.this.f60195h.a(a.this.f60196i);
            }
            if (i2 == 0) {
                a.this.f60195h.e();
            } else {
                a.this.f60195h.d();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.f60188a = tbPageContext;
        this.f60190c = view;
        this.f60193f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        this.f60189b.s(view);
    }

    public n e() {
        return this.f60192e;
    }

    public View f() {
        return this.f60190c;
    }

    public void g() {
        this.f60189b.setNextPage(null);
    }

    public final void h() {
        int i2;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f60190c.findViewById(R.id.new_person_center_common_lv);
        this.f60189b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new C1457a(this, bdTypeRecyclerView.getContext()));
        this.f60189b.addOnScrollListener(new b());
        PbListView pbListView = new PbListView(this.f60188a.getPageActivity());
        this.f60191d = pbListView;
        pbListView.a();
        this.f60191d.o(R.color.CAM_X0205);
        this.f60191d.r(l.g(this.f60188a.getPageActivity(), R.dimen.tbds182));
        this.f60191d.v();
        this.f60191d.E(R.dimen.tbfontsize33);
        this.f60191d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f60191d.y(R.color.CAM_X0110);
        n nVar = new n(this.f60188a, this.f60189b, this.f60193f.getUniqueId());
        this.f60192e = nVar;
        nVar.d(this.f60193f.I0());
        this.f60192e.h(32);
        if (this.f60193f.I0()) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f60193f;
            if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                i2 = 4;
            } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                i2 = 6;
            }
            this.f60192e.f(i2);
            this.f60192e.g(this.f60193f.H0());
        }
        i2 = 0;
        this.f60192e.f(i2);
        this.f60192e.g(this.f60193f.H0());
    }

    public void i(int i2) {
        SkinManager.setBackgroundResource(this.f60190c, R.color.CAM_X0201);
        n nVar = this.f60192e;
        if (nVar != null) {
            nVar.b();
        }
        NoDataView noDataView = this.f60194g;
        if (noDataView != null) {
            noDataView.f(this.f60188a, i2);
        }
        PbListView pbListView = this.f60191d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f60191d.d(i2);
        }
    }

    public void j() {
        d.a.m0.m0.b bVar = this.f60195h;
        if (bVar != null) {
            bVar.c();
        }
        this.f60189b.setOnSrollToBottomListener(null);
    }

    public void k() {
        this.f60189b.smoothScrollToPosition(0);
    }

    public void l(BdListView.p pVar) {
        this.f60189b.setOnSrollToBottomListener(pVar);
    }

    public void m(int i2) {
        this.f60196i = i2;
    }

    public void n(List<d.a.c.k.e.n> list) {
        if (ListUtils.isEmpty(list)) {
            g();
            if (this.f60189b.getHeaderViewsCount() == 0) {
                p(R.string.person_center_listempty_txt);
            }
        } else {
            NoDataView noDataView = this.f60194g;
            if (noDataView != null && noDataView.getParent() != null) {
                this.f60189b.removeHeaderView(this.f60194g);
            }
        }
        this.f60189b.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f60193f.H0())));
    }

    public void o() {
        this.f60189b.setNextPage(this.f60191d);
        this.f60191d.J(0);
        this.f60191d.O();
    }

    public final void p(int i2) {
        String string;
        if (this.f60193f.H0() == 1) {
            string = this.f60193f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.f60193f.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.f60194g == null) {
            this.f60194g = NoDataViewFactory.a(this.f60188a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
        }
        this.f60194g.f(this.f60188a, TbadkApplication.getInst().getSkinType());
        this.f60194g.setVisibility(0);
        this.f60189b.removeHeaderView(this.f60194g);
        this.f60194g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f60189b.s(this.f60194g);
    }

    public void q() {
        this.f60189b.setNextPage(this.f60191d);
        this.f60191d.J(0);
        this.f60191d.f();
        this.f60191d.A(this.f60188a.getString(R.string.list_no_more));
    }

    public void r(int i2) {
        this.f60189b.setNextPage(this.f60191d);
        this.f60191d.J(0);
        this.f60191d.f();
        this.f60191d.A(this.f60188a.getString(i2));
    }
}
