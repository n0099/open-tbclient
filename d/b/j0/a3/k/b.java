package d.b.j0.a3.k;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.v;
import d.b.i0.d0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f53656a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f53657b;

    /* renamed from: c  reason: collision with root package name */
    public g f53658c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f53659d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f53660e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f53661f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f53662g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f53663h;
    public PbListView i;
    public d.b.j0.a3.e.a j;
    public BdListView.p k;
    public BdListView.p l = new a();
    public final View m;

    /* loaded from: classes4.dex */
    public class a implements BdListView.p {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f53662g != null) {
                b.this.f53662g.stopScroll();
            }
            if (b.this.k != null) {
                b.this.k.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        this.f53656a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        int firstVisiblePosition = this.f53662g.getFirstVisiblePosition();
        View childAt = this.f53662g.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public String d() {
        return this.f53661f.m();
    }

    public void e() {
        this.f53662g.setNextPage(null);
    }

    public void f() {
        g gVar = this.f53658c;
        if (gVar != null) {
            gVar.dettachView(this.f53657b);
            this.f53658c = null;
        }
    }

    public final void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f53656a.getPageActivity());
        this.f53660e = linearLayoutManager;
        this.f53659d.setLayoutManager(linearLayoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(this.f53656a.getPageActivity());
        this.f53661f = leftAdapter;
        this.f53659d.setAdapter(leftAdapter);
        this.j = new d.b.j0.a3.e.a(this.f53656a, this.f53662g);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f53656a.getPageActivity());
        this.f53663h = linearLayoutManager2;
        this.f53662g.setLayoutManager(linearLayoutManager2);
        this.f53662g.setFadingEdgeLength(0);
        this.f53662g.setOverScrollMode(2);
        this.f53662g.setOnSrollToBottomListener(this.l);
        PbListView pbListView = new PbListView(this.f53656a.getPageActivity());
        this.i = pbListView;
        pbListView.b();
        this.i.o(R.color.CAM_X0205);
        this.i.r(l.g(this.f53656a.getPageActivity(), R.dimen.tbds182));
        this.i.v();
        this.i.E(R.dimen.tbfontsize33);
        this.i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.i.y(R.color.CAM_X0110);
        this.i.q();
    }

    public final void h() {
        this.f53657b = (RelativeLayout) this.m.findViewById(R.id.right_container);
        this.f53659d = (RecyclerView) this.m.findViewById(R.id.rv_left);
        this.f53662g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
    }

    public final boolean i() {
        g gVar = this.f53658c;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public void j() {
        this.f53662g.setNextPage(this.i);
        this.i.i();
        this.i.b().setPadding(0, l.g(this.f53656a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f53656a.getPageActivity(), R.dimen.tbds362));
        this.i.A(this.f53656a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.i.f();
    }

    public void k() {
        this.f53662g.setNextPage(this.i);
        this.i.i();
        this.i.b().setPadding(0, 0, 0, 0);
        this.i.L();
    }

    public void l() {
        this.f53662g.setNextPage(this.i);
        this.i.i();
        this.i.b().setPadding(0, 0, 0, 0);
        this.i.A(this.f53656a.getPageActivity().getString(R.string.pb_load_more));
        this.i.f();
    }

    public void m(int i) {
        d.b.j0.a3.e.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        LeftAdapter leftAdapter = this.f53661f;
        if (leftAdapter != null) {
            leftAdapter.notifyDataSetChanged();
        }
        PbListView pbListView = this.i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.i.d(i);
        }
        g gVar = this.f53658c;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    public void n(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53662g;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i > this.f53662g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f53662g.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void o(String str, List<String> list, boolean z) {
        int position = ListUtils.getPosition(list, str);
        this.f53661f.p(position, list);
        if (z) {
            z(position);
        }
    }

    public void p(List<n> list) {
        q(list, 0);
    }

    public void q(List<n> list, int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        if (ListUtils.isEmpty(list)) {
            r();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> c2 = c();
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            int i2 = intValue - i;
            if (this.f53663h != null && (bdTypeRecyclerView = this.f53662g) != null) {
                bdTypeRecyclerView.z();
                this.f53663h.scrollToPositionWithOffset(i2, intValue2);
                this.f53662g.A();
            }
        }
        this.j.c(list);
    }

    public void r() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f43184e = this.f53656a.getString(R.string.forum_square_list_no_data);
        vVar.f43185f = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.j.c(arrayList);
    }

    public void s(int i) {
        this.f53659d.setVisibility(i);
        this.f53662g.setVisibility(i);
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter = this.f53661f;
        if (leftAdapter != null) {
            leftAdapter.q(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53662g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.f53662g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        this.k = pVar;
    }

    public void w(int i) {
        this.f53662g.setVisibility(i);
    }

    public void x(String str) {
        if (str == null) {
            return;
        }
        int h2 = this.f53661f.h(str);
        this.f53661f.r(h2);
        z(h2);
    }

    public void y(boolean z) {
        if (i()) {
            return;
        }
        if (this.f53658c == null) {
            g gVar = new g(this.f53656a.getPageActivity());
            this.f53658c = gVar;
            gVar.q(this.f53656a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f53658c.onChangeSkinType();
        this.f53658c.attachView(this.f53657b, z);
    }

    public final void z(int i) {
        RecyclerView recyclerView = this.f53659d;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f53659d.getLayoutManager();
        if (i < 0) {
            i = 0;
        } else if (i > this.f53661f.getItemCount() - 1) {
            i = this.f53661f.getItemCount() - 1;
        }
        linearLayoutManager.scrollToPositionWithOffset(i, 0);
    }
}
