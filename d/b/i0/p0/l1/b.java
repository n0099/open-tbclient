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
    public FrsCommonTabFragment f57785a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57786b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f57787c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.p0.l1.a f57788d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p0.l1.d f57789e;

    /* renamed from: f  reason: collision with root package name */
    public i f57790f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f57791g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.p0.n1.f.a.a f57792h;
    public boolean i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l = new a();
    public BdListView.p m = new C1394b();
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
    public class C1394b implements BdListView.p {
        public C1394b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f57786b != null) {
                b.this.f57786b.stopScroll();
            }
            if (b.this.f57787c == null || b.this.f57785a == null) {
                return;
            }
            if (j.z()) {
                b.this.f57786b.setNextPage(b.this.f57787c);
                b.this.f57787c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                b.this.f57787c.z(null);
                if (b.this.i) {
                    b.this.f57787c.L();
                    b.this.f57787c.z(null);
                    b.this.f57785a.U0();
                    return;
                }
                b.this.f57787c.A(b.this.f57785a.getResources().getString(R.string.list_has_no_more));
                b.this.f57787c.f();
                b.this.f57787c.z(null);
                return;
            }
            b.this.f57786b.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f57795a;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.f57790f != null) {
                    b.this.f57790f.n(b.this.f57786b.getFirstVisiblePosition(), b.this.f57786b.getLastVisiblePosition(), this.f57795a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f57795a = false;
            } else {
                this.f57795a = true;
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
            if (b.this.f57790f != null) {
                b.this.f57790f.k(view);
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
        this.f57785a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f57786b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f57785a.getContext()));
        this.f57786b.setFadingEdgeLength(0);
        this.f57786b.setOverScrollMode(2);
        this.f57786b.setOnSrollToBottomListener(this.m);
        this.f57786b.addOnScrollListener(this.n);
        this.f57786b.setRecyclerListener(new d());
        this.f57786b.addItemDecoration(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f57786b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f57786b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f57785a.getPageContext().getPageActivity());
        this.f57787c = pbListView;
        pbListView.b();
        this.f57787c.o(R.color.transparent);
        this.f57787c.r(l.g(this.f57785a.getActivity(), R.dimen.tbds182));
        this.f57787c.v();
        this.f57787c.E(R.dimen.tbfontsize33);
        this.f57787c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57787c.y(R.color.CAM_X0110);
        this.f57787c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f57785a;
        this.f57788d = new d.b.i0.p0.l1.a(frsCommonTabFragment2, this.f57786b, frsViewData, frsCommonTabFragment2.l == 16);
        v(false);
        if (this.f57790f == null) {
            this.f57790f = new i(this.f57785a.getPageContext(), this.f57786b);
        }
        this.f57790f.p(1);
        this.f57790f.t(this.f57785a.getUniqueId());
        if (g()) {
            this.f57791g = new RelativeLayout(this.f57785a.getContext());
            this.f57791g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f57792h = new d.b.i0.p0.n1.f.a.a(this.f57785a, this.f57791g);
            this.f57786b.t(this.f57791g, 0);
            this.f57792h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f57785a;
        if (frsCommonTabFragment3.l == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f57786b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        FrsCommonTabFragment frsCommonTabFragment = this.f57785a;
        if (frsCommonTabFragment != null) {
            return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
        }
        return false;
    }

    public final List<FrsTabInfo> h() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.f57785a.l);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.f57785a.l);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public i i() {
        return this.f57790f;
    }

    public BdTypeRecyclerView j() {
        return this.f57786b;
    }

    public void k(int i) {
        d.b.i0.p0.l1.a aVar = this.f57788d;
        if (aVar != null) {
            aVar.f();
        }
        PbListView pbListView = this.f57787c;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57787c.d(i);
        }
        d.b.i0.p0.n1.f.a.a aVar2 = this.f57792h;
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
        if (StringUtils.isNull(str) || (dVar = this.f57789e) == null || ListUtils.isEmpty(dVar.f57804g)) {
            return;
        }
        a2 a2Var = null;
        Iterator<n> it = this.f57789e.f57804g.iterator();
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
            this.f57789e.f57804g.remove(a2Var);
            if (ListUtils.isEmpty(this.f57789e.f57804g)) {
                this.f57789e.f57804g.add(new d.b.i0.p0.t());
            }
            this.f57788d.j(this.f57789e.f57804g);
            this.f57788d.f();
        }
    }

    public void m() {
        i iVar = this.f57790f;
        if (iVar != null) {
            iVar.h();
        }
        d.b.i0.p0.l1.a aVar = this.f57788d;
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
        this.i = dVar.f57802e;
        if (ListUtils.isEmpty(dVar.f57804g)) {
            d.b.i0.p0.t tVar = new d.b.i0.p0.t();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f57804g = arrayList;
            arrayList.add(tVar);
            dVar.f57802e = false;
        }
        this.f57789e = dVar;
        this.f57787c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57786b.setNextPage(this.f57787c);
        if (this.i) {
            if (ListUtils.getCount(dVar.f57804g) > 3) {
                this.f57787c.z(null);
                this.f57787c.K();
            } else {
                this.f57787c.K();
                this.f57787c.z(this.l);
                this.f57787c.A(this.f57785a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f57787c.A(this.f57785a.getResources().getString(R.string.list_has_no_more));
            this.f57787c.z(null);
            this.f57787c.f();
        }
        this.f57788d.j(dVar.f57804g);
        this.f57788d.f();
        i iVar = this.f57790f;
        if (iVar != null) {
            iVar.n(this.f57786b.getFirstVisiblePosition(), this.f57786b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f57792h) != null) {
            aVar.g(this.f57785a.S0());
            this.f57792h.j(this.f57785a.i);
        }
        this.k = dVar.n;
        if (this.f57785a.getFragmentActivity() instanceof m0) {
            ((m0) this.f57785a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f57785a.l != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void o() {
        i iVar = this.f57790f;
        if (iVar != null) {
            iVar.x();
        }
    }

    public void p() {
        this.f57788d.f();
    }

    public void q() {
        u uVar = new u();
        uVar.f58581a = this.f57785a.k;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void r() {
        i iVar = this.f57790f;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void s() {
        this.f57786b.scrollToPosition(0);
    }

    public void t(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57786b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(z ? 0 : 8);
        }
    }

    public void u(boolean z) {
        d.b.i0.p0.l1.a aVar = this.f57788d;
        if (aVar != null) {
            aVar.k(z);
        }
    }

    public void v(boolean z) {
        if (this.f57785a == null) {
            return;
        }
        u uVar = new u();
        uVar.f58581a = this.f57785a.k;
        uVar.f58582b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void w(RecyclerView.OnScrollListener onScrollListener) {
        this.f57786b.setOnScrollListener(onScrollListener);
    }

    public void x(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57786b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(i);
        }
    }
}
