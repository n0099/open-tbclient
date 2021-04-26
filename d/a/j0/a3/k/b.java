package d.a.j0.a3.k;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.adapter.LeftAdapter;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.v;
import d.a.i0.d0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f51397a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f51398b;

    /* renamed from: c  reason: collision with root package name */
    public g f51399c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f51400d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f51401e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f51402f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f51403g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f51404h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f51405i;
    public d.a.j0.a3.e.a j;
    public BdListView.p k;
    public BdListView.p l = new a();
    public final View m;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f51403g != null) {
                b.this.f51403g.stopScroll();
            }
            if (b.this.k != null) {
                b.this.k.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        this.f51397a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        int firstVisiblePosition = this.f51403g.getFirstVisiblePosition();
        View childAt = this.f51403g.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public String d() {
        return this.f51402f.f();
    }

    public void e() {
        this.f51403g.setNextPage(null);
    }

    public void f() {
        g gVar = this.f51399c;
        if (gVar != null) {
            gVar.dettachView(this.f51398b);
            this.f51399c = null;
        }
    }

    public final void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f51397a.getPageActivity());
        this.f51401e = linearLayoutManager;
        this.f51400d.setLayoutManager(linearLayoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(this.f51397a.getPageActivity());
        this.f51402f = leftAdapter;
        this.f51400d.setAdapter(leftAdapter);
        this.j = new d.a.j0.a3.e.a(this.f51397a, this.f51403g);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f51397a.getPageActivity());
        this.f51404h = linearLayoutManager2;
        this.f51403g.setLayoutManager(linearLayoutManager2);
        this.f51403g.setFadingEdgeLength(0);
        this.f51403g.setOverScrollMode(2);
        this.f51403g.setOnSrollToBottomListener(this.l);
        PbListView pbListView = new PbListView(this.f51397a.getPageActivity());
        this.f51405i = pbListView;
        pbListView.b();
        this.f51405i.o(R.color.CAM_X0205);
        this.f51405i.r(l.g(this.f51397a.getPageActivity(), R.dimen.tbds182));
        this.f51405i.v();
        this.f51405i.E(R.dimen.tbfontsize33);
        this.f51405i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f51405i.y(R.color.CAM_X0110);
        this.f51405i.q();
    }

    public final void h() {
        this.f51398b = (RelativeLayout) this.m.findViewById(R.id.right_container);
        this.f51400d = (RecyclerView) this.m.findViewById(R.id.rv_left);
        this.f51403g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
    }

    public final boolean i() {
        g gVar = this.f51399c;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public void j() {
        this.f51403g.setNextPage(this.f51405i);
        this.f51405i.i();
        this.f51405i.b().setPadding(0, l.g(this.f51397a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f51397a.getPageActivity(), R.dimen.tbds362));
        this.f51405i.A(this.f51397a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.f51405i.f();
    }

    public void k() {
        this.f51403g.setNextPage(this.f51405i);
        this.f51405i.i();
        this.f51405i.b().setPadding(0, 0, 0, 0);
        this.f51405i.L();
    }

    public void l() {
        this.f51403g.setNextPage(this.f51405i);
        this.f51405i.i();
        this.f51405i.b().setPadding(0, 0, 0, 0);
        this.f51405i.A(this.f51397a.getPageActivity().getString(R.string.pb_load_more));
        this.f51405i.f();
    }

    public void m(int i2) {
        d.a.j0.a3.e.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        LeftAdapter leftAdapter = this.f51402f;
        if (leftAdapter != null) {
            leftAdapter.notifyDataSetChanged();
        }
        PbListView pbListView = this.f51405i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f51405i.d(i2);
        }
        g gVar = this.f51399c;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51403g;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f51403g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f51403g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        int position = ListUtils.getPosition(list, str);
        this.f51402f.i(position, list);
        if (z) {
            z(position);
        }
    }

    public void p(List<n> list) {
        q(list, 0);
    }

    public void q(List<n> list, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        if (ListUtils.isEmpty(list)) {
            r();
            return;
        }
        if (i2 > 0) {
            Pair<Integer, Integer> c2 = c();
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            int i3 = intValue - i2;
            if (this.f51404h != null && (bdTypeRecyclerView = this.f51403g) != null) {
                bdTypeRecyclerView.z();
                this.f51404h.scrollToPositionWithOffset(i3, intValue2);
                this.f51403g.A();
            }
        }
        this.j.c(list);
    }

    public void r() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f40416e = this.f51397a.getString(R.string.forum_square_list_no_data);
        vVar.f40417f = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.j.c(arrayList);
    }

    public void s(int i2) {
        this.f51400d.setVisibility(i2);
        this.f51403g.setVisibility(i2);
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter = this.f51402f;
        if (leftAdapter != null) {
            leftAdapter.j(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51403g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.f51403g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        this.k = pVar;
    }

    public void w(int i2) {
        this.f51403g.setVisibility(i2);
    }

    public void x(String str) {
        if (str == null) {
            return;
        }
        int e2 = this.f51402f.e(str);
        this.f51402f.k(e2);
        z(e2);
    }

    public void y(boolean z) {
        if (i()) {
            return;
        }
        if (this.f51399c == null) {
            g gVar = new g(this.f51397a.getPageActivity());
            this.f51399c = gVar;
            gVar.q(this.f51397a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f51399c.onChangeSkinType();
        this.f51399c.attachView(this.f51398b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView = this.f51400d;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f51400d.getLayoutManager();
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > this.f51402f.getItemCount() - 1) {
            i2 = this.f51402f.getItemCount() - 1;
        }
        linearLayoutManager.scrollToPositionWithOffset(i2, 0);
    }
}
