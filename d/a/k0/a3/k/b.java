package d.a.k0.a3.k;

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
import d.a.j0.d0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f52096a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f52097b;

    /* renamed from: c  reason: collision with root package name */
    public g f52098c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f52099d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f52100e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f52101f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f52102g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f52103h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f52104i;
    public d.a.k0.a3.e.a j;
    public BdListView.p k;
    public BdListView.p l = new a();
    public final View m;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f52102g != null) {
                b.this.f52102g.stopScroll();
            }
            if (b.this.k != null) {
                b.this.k.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        this.f52096a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        int firstVisiblePosition = this.f52102g.getFirstVisiblePosition();
        View childAt = this.f52102g.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public String d() {
        return this.f52101f.f();
    }

    public void e() {
        this.f52102g.setNextPage(null);
    }

    public void f() {
        g gVar = this.f52098c;
        if (gVar != null) {
            gVar.dettachView(this.f52097b);
            this.f52098c = null;
        }
    }

    public final void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f52096a.getPageActivity());
        this.f52100e = linearLayoutManager;
        this.f52099d.setLayoutManager(linearLayoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(this.f52096a.getPageActivity());
        this.f52101f = leftAdapter;
        this.f52099d.setAdapter(leftAdapter);
        this.j = new d.a.k0.a3.e.a(this.f52096a, this.f52102g);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f52096a.getPageActivity());
        this.f52103h = linearLayoutManager2;
        this.f52102g.setLayoutManager(linearLayoutManager2);
        this.f52102g.setFadingEdgeLength(0);
        this.f52102g.setOverScrollMode(2);
        this.f52102g.setOnSrollToBottomListener(this.l);
        PbListView pbListView = new PbListView(this.f52096a.getPageActivity());
        this.f52104i = pbListView;
        pbListView.b();
        this.f52104i.o(R.color.CAM_X0205);
        this.f52104i.r(l.g(this.f52096a.getPageActivity(), R.dimen.tbds182));
        this.f52104i.v();
        this.f52104i.E(R.dimen.tbfontsize33);
        this.f52104i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f52104i.y(R.color.CAM_X0110);
        this.f52104i.q();
    }

    public final void h() {
        this.f52097b = (RelativeLayout) this.m.findViewById(R.id.right_container);
        this.f52099d = (RecyclerView) this.m.findViewById(R.id.rv_left);
        this.f52102g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
    }

    public final boolean i() {
        g gVar = this.f52098c;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public void j() {
        this.f52102g.setNextPage(this.f52104i);
        this.f52104i.i();
        this.f52104i.b().setPadding(0, l.g(this.f52096a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f52096a.getPageActivity(), R.dimen.tbds362));
        this.f52104i.A(this.f52096a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.f52104i.f();
    }

    public void k() {
        this.f52102g.setNextPage(this.f52104i);
        this.f52104i.i();
        this.f52104i.b().setPadding(0, 0, 0, 0);
        this.f52104i.L();
    }

    public void l() {
        this.f52102g.setNextPage(this.f52104i);
        this.f52104i.i();
        this.f52104i.b().setPadding(0, 0, 0, 0);
        this.f52104i.A(this.f52096a.getPageActivity().getString(R.string.pb_load_more));
        this.f52104i.f();
    }

    public void m(int i2) {
        d.a.k0.a3.e.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        LeftAdapter leftAdapter = this.f52101f;
        if (leftAdapter != null) {
            leftAdapter.notifyDataSetChanged();
        }
        PbListView pbListView = this.f52104i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52104i.d(i2);
        }
        g gVar = this.f52098c;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52102g;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f52102g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f52102g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        int position = ListUtils.getPosition(list, str);
        this.f52101f.i(position, list);
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
            if (this.f52103h != null && (bdTypeRecyclerView = this.f52102g) != null) {
                bdTypeRecyclerView.z();
                this.f52103h.scrollToPositionWithOffset(i3, intValue2);
                this.f52102g.A();
            }
        }
        this.j.c(list);
    }

    public void r() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f39661e = this.f52096a.getString(R.string.forum_square_list_no_data);
        vVar.f39662f = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.j.c(arrayList);
    }

    public void s(int i2) {
        this.f52099d.setVisibility(i2);
        this.f52102g.setVisibility(i2);
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter = this.f52101f;
        if (leftAdapter != null) {
            leftAdapter.j(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52102g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.f52102g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        this.k = pVar;
    }

    public void w(int i2) {
        this.f52102g.setVisibility(i2);
    }

    public void x(String str) {
        if (str == null) {
            return;
        }
        int e2 = this.f52101f.e(str);
        this.f52101f.k(e2);
        z(e2);
    }

    public void y(boolean z) {
        if (i()) {
            return;
        }
        if (this.f52098c == null) {
            g gVar = new g(this.f52096a.getPageActivity());
            this.f52098c = gVar;
            gVar.q(this.f52096a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f52098c.onChangeSkinType();
        this.f52098c.attachView(this.f52097b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView = this.f52099d;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f52099d.getLayoutManager();
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > this.f52101f.getItemCount() - 1) {
            i2 = this.f52101f.getItemCount() - 1;
        }
        linearLayoutManager.scrollToPositionWithOffset(i2, 0);
    }
}
