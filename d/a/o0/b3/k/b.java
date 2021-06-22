package d.a.o0.b3.k;

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
import d.a.c.k.e.n;
import d.a.c.k.e.v;
import d.a.n0.d0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56077a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f56078b;

    /* renamed from: c  reason: collision with root package name */
    public g f56079c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f56080d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f56081e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f56082f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f56083g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f56084h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f56085i;
    public d.a.o0.b3.e.a j;
    public BdListView.p k;
    public BdListView.p l = new a();
    public final View m;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f56083g != null) {
                b.this.f56083g.stopScroll();
            }
            if (b.this.k != null) {
                b.this.k.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        this.f56077a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        int firstVisiblePosition = this.f56083g.getFirstVisiblePosition();
        View childAt = this.f56083g.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public String d() {
        return this.f56082f.m();
    }

    public void e() {
        this.f56083g.setNextPage(null);
    }

    public void f() {
        g gVar = this.f56079c;
        if (gVar != null) {
            gVar.dettachView(this.f56078b);
            this.f56079c = null;
        }
    }

    public final void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f56077a.getPageActivity());
        this.f56081e = linearLayoutManager;
        this.f56080d.setLayoutManager(linearLayoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(this.f56077a.getPageActivity());
        this.f56082f = leftAdapter;
        this.f56080d.setAdapter(leftAdapter);
        this.j = new d.a.o0.b3.e.a(this.f56077a, this.f56083g);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f56077a.getPageActivity());
        this.f56084h = linearLayoutManager2;
        this.f56083g.setLayoutManager(linearLayoutManager2);
        this.f56083g.setFadingEdgeLength(0);
        this.f56083g.setOverScrollMode(2);
        this.f56083g.setOnSrollToBottomListener(this.l);
        PbListView pbListView = new PbListView(this.f56077a.getPageActivity());
        this.f56085i = pbListView;
        pbListView.b();
        this.f56085i.o(R.color.CAM_X0205);
        this.f56085i.r(l.g(this.f56077a.getPageActivity(), R.dimen.tbds182));
        this.f56085i.v();
        this.f56085i.E(R.dimen.tbfontsize33);
        this.f56085i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f56085i.y(R.color.CAM_X0110);
        this.f56085i.q();
    }

    public final void h() {
        this.f56078b = (RelativeLayout) this.m.findViewById(R.id.right_container);
        this.f56080d = (RecyclerView) this.m.findViewById(R.id.rv_left);
        this.f56083g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
    }

    public final boolean i() {
        g gVar = this.f56079c;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public void j() {
        this.f56083g.setNextPage(this.f56085i);
        this.f56085i.i();
        this.f56085i.b().setPadding(0, l.g(this.f56077a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f56077a.getPageActivity(), R.dimen.tbds362));
        this.f56085i.A(this.f56077a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.f56085i.f();
    }

    public void k() {
        this.f56083g.setNextPage(this.f56085i);
        this.f56085i.i();
        this.f56085i.b().setPadding(0, 0, 0, 0);
        this.f56085i.L();
    }

    public void l() {
        this.f56083g.setNextPage(this.f56085i);
        this.f56085i.i();
        this.f56085i.b().setPadding(0, 0, 0, 0);
        this.f56085i.A(this.f56077a.getPageActivity().getString(R.string.pb_load_more));
        this.f56085i.f();
    }

    public void m(int i2) {
        d.a.o0.b3.e.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        LeftAdapter leftAdapter = this.f56082f;
        if (leftAdapter != null) {
            leftAdapter.notifyDataSetChanged();
        }
        PbListView pbListView = this.f56085i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56085i.d(i2);
        }
        g gVar = this.f56079c;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56083g;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f56083g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f56083g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        int position = ListUtils.getPosition(list, str);
        this.f56082f.p(position, list);
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
            if (this.f56084h != null && (bdTypeRecyclerView = this.f56083g) != null) {
                bdTypeRecyclerView.z();
                this.f56084h.scrollToPositionWithOffset(i3, intValue2);
                this.f56083g.A();
            }
        }
        this.j.c(list);
    }

    public void r() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f43109e = this.f56077a.getString(R.string.forum_square_list_no_data);
        vVar.f43110f = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.j.c(arrayList);
    }

    public void s(int i2) {
        this.f56080d.setVisibility(i2);
        this.f56083g.setVisibility(i2);
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter = this.f56082f;
        if (leftAdapter != null) {
            leftAdapter.q(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56083g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.f56083g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        this.k = pVar;
    }

    public void w(int i2) {
        this.f56083g.setVisibility(i2);
    }

    public void x(String str) {
        if (str == null) {
            return;
        }
        int h2 = this.f56082f.h(str);
        this.f56082f.r(h2);
        z(h2);
    }

    public void y(boolean z) {
        if (i()) {
            return;
        }
        if (this.f56079c == null) {
            g gVar = new g(this.f56077a.getPageActivity());
            this.f56079c = gVar;
            gVar.q(this.f56077a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f56079c.onChangeSkinType();
        this.f56079c.attachView(this.f56078b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView = this.f56080d;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f56080d.getLayoutManager();
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > this.f56082f.getItemCount() - 1) {
            i2 = this.f56082f.getItemCount() - 1;
        }
        linearLayoutManager.scrollToPositionWithOffset(i2, 0);
    }
}
