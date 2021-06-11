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
import d.a.c.k.e.n;
import d.a.c.k.e.v;
import d.a.m0.d0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55952a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f55953b;

    /* renamed from: c  reason: collision with root package name */
    public g f55954c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f55955d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f55956e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f55957f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f55958g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f55959h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f55960i;
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
            if (b.this.f55958g != null) {
                b.this.f55958g.stopScroll();
            }
            if (b.this.k != null) {
                b.this.k.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        this.f55952a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        int firstVisiblePosition = this.f55958g.getFirstVisiblePosition();
        View childAt = this.f55958g.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public String d() {
        return this.f55957f.m();
    }

    public void e() {
        this.f55958g.setNextPage(null);
    }

    public void f() {
        g gVar = this.f55954c;
        if (gVar != null) {
            gVar.dettachView(this.f55953b);
            this.f55954c = null;
        }
    }

    public final void g() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f55952a.getPageActivity());
        this.f55956e = linearLayoutManager;
        this.f55955d.setLayoutManager(linearLayoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(this.f55952a.getPageActivity());
        this.f55957f = leftAdapter;
        this.f55955d.setAdapter(leftAdapter);
        this.j = new d.a.n0.b3.e.a(this.f55952a, this.f55958g);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f55952a.getPageActivity());
        this.f55959h = linearLayoutManager2;
        this.f55958g.setLayoutManager(linearLayoutManager2);
        this.f55958g.setFadingEdgeLength(0);
        this.f55958g.setOverScrollMode(2);
        this.f55958g.setOnSrollToBottomListener(this.l);
        PbListView pbListView = new PbListView(this.f55952a.getPageActivity());
        this.f55960i = pbListView;
        pbListView.b();
        this.f55960i.o(R.color.CAM_X0205);
        this.f55960i.r(l.g(this.f55952a.getPageActivity(), R.dimen.tbds182));
        this.f55960i.v();
        this.f55960i.E(R.dimen.tbfontsize33);
        this.f55960i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55960i.y(R.color.CAM_X0110);
        this.f55960i.q();
    }

    public final void h() {
        this.f55953b = (RelativeLayout) this.m.findViewById(R.id.right_container);
        this.f55955d = (RecyclerView) this.m.findViewById(R.id.rv_left);
        this.f55958g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
    }

    public final boolean i() {
        g gVar = this.f55954c;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public void j() {
        this.f55958g.setNextPage(this.f55960i);
        this.f55960i.i();
        this.f55960i.b().setPadding(0, l.g(this.f55952a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f55952a.getPageActivity(), R.dimen.tbds362));
        this.f55960i.A(this.f55952a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.f55960i.f();
    }

    public void k() {
        this.f55958g.setNextPage(this.f55960i);
        this.f55960i.i();
        this.f55960i.b().setPadding(0, 0, 0, 0);
        this.f55960i.L();
    }

    public void l() {
        this.f55958g.setNextPage(this.f55960i);
        this.f55960i.i();
        this.f55960i.b().setPadding(0, 0, 0, 0);
        this.f55960i.A(this.f55952a.getPageActivity().getString(R.string.pb_load_more));
        this.f55960i.f();
    }

    public void m(int i2) {
        d.a.n0.b3.e.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        LeftAdapter leftAdapter = this.f55957f;
        if (leftAdapter != null) {
            leftAdapter.notifyDataSetChanged();
        }
        PbListView pbListView = this.f55960i;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55960i.d(i2);
        }
        g gVar = this.f55954c;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55958g;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f55958g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f55958g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        int position = ListUtils.getPosition(list, str);
        this.f55957f.p(position, list);
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
            if (this.f55959h != null && (bdTypeRecyclerView = this.f55958g) != null) {
                bdTypeRecyclerView.z();
                this.f55959h.scrollToPositionWithOffset(i3, intValue2);
                this.f55958g.A();
            }
        }
        this.j.c(list);
    }

    public void r() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f43006e = this.f55952a.getString(R.string.forum_square_list_no_data);
        vVar.f43007f = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.j.c(arrayList);
    }

    public void s(int i2) {
        this.f55955d.setVisibility(i2);
        this.f55958g.setVisibility(i2);
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter = this.f55957f;
        if (leftAdapter != null) {
            leftAdapter.q(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55958g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.f55958g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        this.k = pVar;
    }

    public void w(int i2) {
        this.f55958g.setVisibility(i2);
    }

    public void x(String str) {
        if (str == null) {
            return;
        }
        int h2 = this.f55957f.h(str);
        this.f55957f.r(h2);
        z(h2);
    }

    public void y(boolean z) {
        if (i()) {
            return;
        }
        if (this.f55954c == null) {
            g gVar = new g(this.f55952a.getPageActivity());
            this.f55954c = gVar;
            gVar.q(this.f55952a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f55954c.onChangeSkinType();
        this.f55954c.attachView(this.f55953b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView = this.f55955d;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f55955d.getLayoutManager();
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > this.f55957f.getItemCount() - 1) {
            i2 = this.f55957f.getItemCount() - 1;
        }
        linearLayoutManager.scrollToPositionWithOffset(i2, 0);
    }
}
