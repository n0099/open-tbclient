package d.a.n0.b3.k;

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
import d.a.m0.d0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f52263a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f52264b;

    /* renamed from: c  reason: collision with root package name */
    public g f52265c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f52266d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f52267e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f52268f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f52269g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f52270h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f52271i;
    public d.a.n0.b3.e.a j;
    public BdListView.p k;
    public BdListView.p l = new a();
    public final View m;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f52269g != null) {
                b.this.f52269g.stopScroll();
            }
            if (b.this.k != null) {
                b.this.k.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        this.f52263a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        int firstVisiblePosition = this.f52269g.getFirstVisiblePosition();
        View childAt = this.f52269g.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public String d() {
        return this.f52268f.f();
    }

    public void e() {
        this.f52269g.setNextPage(null);
    }

    public void f() {
        g gVar = this.f52265c;
        if (gVar != null) {
            gVar.dettachView(this.f52264b);
            this.f52265c = null;
        }
    }

    public final void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f52263a.getPageActivity());
        this.f52267e = linearLayoutManager;
        this.f52266d.setLayoutManager(linearLayoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(this.f52263a.getPageActivity());
        this.f52268f = leftAdapter;
        this.f52266d.setAdapter(leftAdapter);
        this.j = new d.a.n0.b3.e.a(this.f52263a, this.f52269g);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f52263a.getPageActivity());
        this.f52270h = linearLayoutManager2;
        this.f52269g.setLayoutManager(linearLayoutManager2);
        this.f52269g.setFadingEdgeLength(0);
        this.f52269g.setOverScrollMode(2);
        this.f52269g.setOnSrollToBottomListener(this.l);
        PbListView pbListView = new PbListView(this.f52263a.getPageActivity());
        this.f52271i = pbListView;
        pbListView.b();
        this.f52271i.o(R.color.CAM_X0205);
        this.f52271i.r(l.g(this.f52263a.getPageActivity(), R.dimen.tbds182));
        this.f52271i.v();
        this.f52271i.E(R.dimen.tbfontsize33);
        this.f52271i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f52271i.y(R.color.CAM_X0110);
        this.f52271i.q();
    }

    public final void h() {
        this.f52264b = (RelativeLayout) this.m.findViewById(R.id.right_container);
        this.f52266d = (RecyclerView) this.m.findViewById(R.id.rv_left);
        this.f52269g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
    }

    public final boolean i() {
        g gVar = this.f52265c;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public void j() {
        this.f52269g.setNextPage(this.f52271i);
        this.f52271i.i();
        this.f52271i.b().setPadding(0, l.g(this.f52263a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f52263a.getPageActivity(), R.dimen.tbds362));
        this.f52271i.A(this.f52263a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.f52271i.f();
    }

    public void k() {
        this.f52269g.setNextPage(this.f52271i);
        this.f52271i.i();
        this.f52271i.b().setPadding(0, 0, 0, 0);
        this.f52271i.L();
    }

    public void l() {
        this.f52269g.setNextPage(this.f52271i);
        this.f52271i.i();
        this.f52271i.b().setPadding(0, 0, 0, 0);
        this.f52271i.A(this.f52263a.getPageActivity().getString(R.string.pb_load_more));
        this.f52271i.f();
    }

    public void m(int i2) {
        d.a.n0.b3.e.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        LeftAdapter leftAdapter = this.f52268f;
        if (leftAdapter != null) {
            leftAdapter.notifyDataSetChanged();
        }
        PbListView pbListView = this.f52271i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52271i.d(i2);
        }
        g gVar = this.f52265c;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52269g;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f52269g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f52269g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        int position = ListUtils.getPosition(list, str);
        this.f52268f.i(position, list);
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
            if (this.f52270h != null && (bdTypeRecyclerView = this.f52269g) != null) {
                bdTypeRecyclerView.z();
                this.f52270h.scrollToPositionWithOffset(i3, intValue2);
                this.f52269g.A();
            }
        }
        this.j.c(list);
    }

    public void r() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f39325e = this.f52263a.getString(R.string.forum_square_list_no_data);
        vVar.f39326f = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.j.c(arrayList);
    }

    public void s(int i2) {
        this.f52266d.setVisibility(i2);
        this.f52269g.setVisibility(i2);
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter = this.f52268f;
        if (leftAdapter != null) {
            leftAdapter.j(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52269g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.f52269g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        this.k = pVar;
    }

    public void w(int i2) {
        this.f52269g.setVisibility(i2);
    }

    public void x(String str) {
        if (str == null) {
            return;
        }
        int e2 = this.f52268f.e(str);
        this.f52268f.k(e2);
        z(e2);
    }

    public void y(boolean z) {
        if (i()) {
            return;
        }
        if (this.f52265c == null) {
            g gVar = new g(this.f52263a.getPageActivity());
            this.f52265c = gVar;
            gVar.q(this.f52263a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f52265c.onChangeSkinType();
        this.f52265c.attachView(this.f52264b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView = this.f52266d;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f52266d.getLayoutManager();
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > this.f52268f.getItemCount() - 1) {
            i2 = this.f52268f.getItemCount() - 1;
        }
        linearLayoutManager.scrollToPositionWithOffset(i2, 0);
    }
}
