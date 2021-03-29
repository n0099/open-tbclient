package d.b.i0.p0.l1;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.i2.i;
import d.b.i0.p0.i0;
import d.b.i0.p0.m0;
import d.b.i0.p0.u;
import d.b.i0.x.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f57786a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57787b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f57788c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.p0.l1.a f57789d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p0.l1.d f57790e;

    /* renamed from: f  reason: collision with root package name */
    public i f57791f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f57792g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.p0.n1.f.a.a f57793h;
    public boolean i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l = new a();
    public BdListView.p m = new C1395b();
    public RecyclerView.OnScrollListener n = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.m.onScrollToBottom();
        }
    }

    /* renamed from: d.b.i0.p0.l1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1395b implements BdListView.p {
        public C1395b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f57787b != null) {
                b.this.f57787b.stopScroll();
            }
            if (b.this.f57788c == null || b.this.f57786a == null) {
                return;
            }
            if (j.z()) {
                b.this.f57787b.setNextPage(b.this.f57788c);
                b.this.f57788c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                b.this.f57788c.z(null);
                if (b.this.i) {
                    b.this.f57788c.L();
                    b.this.f57788c.z(null);
                    b.this.f57786a.U0();
                    return;
                }
                b.this.f57788c.A(b.this.f57786a.getResources().getString(R.string.list_has_no_more));
                b.this.f57788c.f();
                b.this.f57788c.z(null);
                return;
            }
            b.this.f57787b.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f57796a;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.f57791f != null) {
                    b.this.f57791f.n(b.this.f57787b.getFirstVisiblePosition(), b.this.f57787b.getLastVisiblePosition(), this.f57796a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f57796a = false;
            } else {
                this.f57796a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecyclerView.RecyclerListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (b.this.f57791f != null) {
                b.this.f57791f.k(view);
            }
            if (view != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.l();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.ItemDecoration {
        public e(b bVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.set(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
            if ((view instanceof BaseLegoCardView) || view.getVisibility() == 8) {
                rect.set(0, 0, 0, 0);
            }
        }
    }

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f57786a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f57787b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f57786a.getContext()));
        this.f57787b.setFadingEdgeLength(0);
        this.f57787b.setOverScrollMode(2);
        this.f57787b.setOnSrollToBottomListener(this.m);
        this.f57787b.addOnScrollListener(this.n);
        this.f57787b.setRecyclerListener(new d());
        this.f57787b.addItemDecoration(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f57787b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f57787b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f57786a.getPageContext().getPageActivity());
        this.f57788c = pbListView;
        pbListView.b();
        this.f57788c.o(R.color.transparent);
        this.f57788c.r(l.g(this.f57786a.getActivity(), R.dimen.tbds182));
        this.f57788c.v();
        this.f57788c.E(R.dimen.tbfontsize33);
        this.f57788c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57788c.y(R.color.CAM_X0110);
        this.f57788c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f57786a;
        this.f57789d = new d.b.i0.p0.l1.a(frsCommonTabFragment2, this.f57787b, frsViewData, frsCommonTabFragment2.l == 16);
        v(false);
        if (this.f57791f == null) {
            this.f57791f = new i(this.f57786a.getPageContext(), this.f57787b);
        }
        this.f57791f.p(1);
        this.f57791f.t(this.f57786a.getUniqueId());
        if (g()) {
            this.f57792g = new RelativeLayout(this.f57786a.getContext());
            this.f57792g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f57793h = new d.b.i0.p0.n1.f.a.a(this.f57786a, this.f57792g);
            this.f57787b.t(this.f57792g, 0);
            this.f57793h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f57786a;
        if (frsCommonTabFragment3.l == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f57787b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        FrsCommonTabFragment frsCommonTabFragment = this.f57786a;
        if (frsCommonTabFragment != null) {
            return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
        }
        return false;
    }

    public final List<FrsTabInfo> h() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.f57786a.l);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.f57786a.l);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public i i() {
        return this.f57791f;
    }

    public BdTypeRecyclerView j() {
        return this.f57787b;
    }

    public void k(int i) {
        d.b.i0.p0.l1.a aVar = this.f57789d;
        if (aVar != null) {
            aVar.f();
        }
        PbListView pbListView = this.f57788c;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57788c.d(i);
        }
        d.b.i0.p0.n1.f.a.a aVar2 = this.f57793h;
        if (aVar2 != null) {
            aVar2.h();
        }
        i0 i0Var = this.j;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    public void l(String str) {
        d.b.i0.p0.l1.d dVar;
        if (StringUtils.isNull(str) || (dVar = this.f57790e) == null || ListUtils.isEmpty(dVar.f57805g)) {
            return;
        }
        a2 a2Var = null;
        Iterator<n> it = this.f57790e.f57805g.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (next instanceof a2)) {
                a2 a2Var2 = (a2) next;
                if (TextUtils.equals(str, a2Var2.o0())) {
                    a2Var = a2Var2;
                    break;
                }
            }
        }
        if (a2Var != null) {
            this.f57790e.f57805g.remove(a2Var);
            if (ListUtils.isEmpty(this.f57790e.f57805g)) {
                this.f57790e.f57805g.add(new d.b.i0.p0.t());
            }
            this.f57789d.j(this.f57790e.f57805g);
            this.f57789d.f();
        }
    }

    public void m() {
        i iVar = this.f57791f;
        if (iVar != null) {
            iVar.h();
        }
        d.b.i0.p0.l1.a aVar = this.f57789d;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void n(d.b.i0.p0.l1.d dVar) {
        i0 i0Var;
        d.b.i0.p0.n1.f.a.a aVar;
        if (dVar == null) {
            return;
        }
        this.i = dVar.f57803e;
        if (ListUtils.isEmpty(dVar.f57805g)) {
            d.b.i0.p0.t tVar = new d.b.i0.p0.t();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f57805g = arrayList;
            arrayList.add(tVar);
            dVar.f57803e = false;
        }
        this.f57790e = dVar;
        this.f57788c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57787b.setNextPage(this.f57788c);
        if (this.i) {
            if (ListUtils.getCount(dVar.f57805g) > 3) {
                this.f57788c.z(null);
                this.f57788c.K();
            } else {
                this.f57788c.K();
                this.f57788c.z(this.l);
                this.f57788c.A(this.f57786a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f57788c.A(this.f57786a.getResources().getString(R.string.list_has_no_more));
            this.f57788c.z(null);
            this.f57788c.f();
        }
        this.f57789d.j(dVar.f57805g);
        this.f57789d.f();
        i iVar = this.f57791f;
        if (iVar != null) {
            iVar.n(this.f57787b.getFirstVisiblePosition(), this.f57787b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f57793h) != null) {
            aVar.g(this.f57786a.S0());
            this.f57793h.j(this.f57786a.i);
        }
        this.k = dVar.n;
        if (this.f57786a.getFragmentActivity() instanceof m0) {
            ((m0) this.f57786a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f57786a.l != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void o() {
        i iVar = this.f57791f;
        if (iVar != null) {
            iVar.x();
        }
    }

    public void p() {
        this.f57789d.f();
    }

    public void q() {
        u uVar = new u();
        uVar.f58582a = this.f57786a.k;
        uVar.f58583b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void r() {
        i iVar = this.f57791f;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void s() {
        this.f57787b.scrollToPosition(0);
    }

    public void t(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57787b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(z ? 0 : 8);
        }
    }

    public void u(boolean z) {
        d.b.i0.p0.l1.a aVar = this.f57789d;
        if (aVar != null) {
            aVar.k(z);
        }
    }

    public void v(boolean z) {
        if (this.f57786a == null) {
            return;
        }
        u uVar = new u();
        uVar.f58582a = this.f57786a.k;
        uVar.f58583b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void w(RecyclerView.OnScrollListener onScrollListener) {
        this.f57787b.setOnScrollListener(onScrollListener);
    }

    public void x(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57787b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(i);
        }
    }
}
