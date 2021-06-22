package d.a.o0.r0.l1;

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
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.k2.i;
import d.a.o0.r0.i0;
import d.a.o0.r0.m0;
import d.a.o0.r0.u;
import d.a.o0.z.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f62678a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62679b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f62680c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.r0.l1.a f62681d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r0.l1.d f62682e;

    /* renamed from: f  reason: collision with root package name */
    public i f62683f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f62684g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.r0.n1.f.a.a f62685h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62686i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l = new a();
    public BdListView.p m = new C1566b();
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

    /* renamed from: d.a.o0.r0.l1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1566b implements BdListView.p {
        public C1566b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f62679b != null) {
                b.this.f62679b.stopScroll();
            }
            if (b.this.f62680c == null || b.this.f62678a == null) {
                return;
            }
            if (j.z()) {
                b.this.f62679b.setNextPage(b.this.f62680c);
                b.this.f62680c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                b.this.f62680c.z(null);
                if (b.this.f62686i) {
                    b.this.f62680c.L();
                    b.this.f62680c.z(null);
                    b.this.f62678a.W0();
                    return;
                }
                b.this.f62680c.A(b.this.f62678a.getResources().getString(R.string.list_has_no_more));
                b.this.f62680c.f();
                b.this.f62680c.z(null);
                return;
            }
            b.this.f62679b.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f62689a;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (b.this.f62683f != null) {
                    b.this.f62683f.n(b.this.f62679b.getFirstVisiblePosition(), b.this.f62679b.getLastVisiblePosition(), this.f62689a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f62689a = false;
            } else {
                this.f62689a = true;
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
            if (b.this.f62683f != null) {
                b.this.f62683f.k(view);
            }
            if (view != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.h();
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

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f62678a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f62679b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f62678a.getContext()));
        this.f62679b.setFadingEdgeLength(0);
        this.f62679b.setOverScrollMode(2);
        this.f62679b.setOnSrollToBottomListener(this.m);
        this.f62679b.addOnScrollListener(this.n);
        this.f62679b.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f62679b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f62679b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f62678a.getPageContext().getPageActivity());
        this.f62680c = pbListView;
        pbListView.b();
        this.f62680c.o(R.color.transparent);
        this.f62680c.r(l.g(this.f62678a.getActivity(), R.dimen.tbds182));
        this.f62680c.v();
        this.f62680c.E(R.dimen.tbfontsize33);
        this.f62680c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f62680c.y(R.color.CAM_X0110);
        this.f62680c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f62678a;
        this.f62681d = new d.a.o0.r0.l1.a(frsCommonTabFragment2, this.f62679b, frsViewData, frsCommonTabFragment2.l == 16);
        w(false);
        if (this.f62683f == null) {
            this.f62683f = new i(this.f62678a.getPageContext(), this.f62679b);
        }
        this.f62683f.p(1);
        this.f62683f.t(this.f62678a.getUniqueId());
        if (g()) {
            this.f62684g = new RelativeLayout(this.f62678a.getContext());
            this.f62684g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f62685h = new d.a.o0.r0.n1.f.a.a(this.f62678a, this.f62684g);
            this.f62679b.t(this.f62684g, 0);
            this.f62685h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f62678a;
        if (frsCommonTabFragment3.l == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f62679b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        FrsCommonTabFragment frsCommonTabFragment = this.f62678a;
        if (frsCommonTabFragment != null) {
            return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
        }
        return false;
    }

    public final List<FrsTabInfo> h() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.f62678a.l);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.f62678a.l);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public i i() {
        return this.f62683f;
    }

    public BdTypeRecyclerView j() {
        return this.f62679b;
    }

    public final boolean k(ArrayList<n> arrayList, int i2) {
        int i3;
        if (ListUtils.isEmpty(arrayList) || i2 < 0) {
            return false;
        }
        if (i2 == 0) {
            return true;
        }
        int i4 = 1;
        while (i3 < arrayList.size() && i4 <= i2) {
            if (arrayList.get(i3) instanceof z1) {
                int i5 = i3 - 1;
                i3 = ((arrayList.get(i5) instanceof z1) && ((z1) arrayList.get(i3)).position == ((z1) arrayList.get(i5)).position) ? i3 + 1 : 1;
            }
            i4++;
        }
        return i4 > i2;
    }

    public void l(int i2) {
        d.a.o0.r0.l1.a aVar = this.f62681d;
        if (aVar != null) {
            aVar.f();
        }
        PbListView pbListView = this.f62680c;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f62680c.d(i2);
        }
        d.a.o0.r0.n1.f.a.a aVar2 = this.f62685h;
        if (aVar2 != null) {
            aVar2.h();
        }
        i0 i0Var = this.j;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    public void m(String str) {
        d.a.o0.r0.l1.d dVar;
        if (StringUtils.isNull(str) || (dVar = this.f62682e) == null || ListUtils.isEmpty(dVar.f62699g)) {
            return;
        }
        Iterator<n> it = this.f62682e.f62699g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            a2 a2Var = null;
            if (next instanceof z1) {
                a2Var = ((z1) next).w;
            } else if (next instanceof a2) {
                a2Var = (a2) next;
            }
            if (a2Var != null && TextUtils.equals(str, a2Var.o0())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.f62682e.f62699g)) {
            this.f62682e.f62699g.add(new d.a.o0.r0.t());
        }
        this.f62681d.i(this.f62682e.f62699g);
        this.f62681d.f();
    }

    public void n() {
        i iVar = this.f62683f;
        if (iVar != null) {
            iVar.h();
        }
        d.a.o0.r0.l1.a aVar = this.f62681d;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void o(d.a.o0.r0.l1.d dVar) {
        i0 i0Var;
        d.a.o0.r0.n1.f.a.a aVar;
        if (dVar == null) {
            return;
        }
        this.f62686i = dVar.f62697e;
        if (ListUtils.isEmpty(dVar.f62699g)) {
            d.a.o0.r0.t tVar = new d.a.o0.r0.t();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f62699g = arrayList;
            arrayList.add(tVar);
            dVar.f62697e = false;
        }
        this.f62682e = dVar;
        this.f62680c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f62686i) {
            this.f62679b.setNextPage(this.f62680c);
            if (k(dVar.f62699g, 3)) {
                this.f62680c.z(null);
                this.f62680c.K();
            } else {
                this.f62680c.K();
                this.f62680c.z(this.l);
                this.f62680c.A(this.f62678a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f62679b.setNextPage(null);
            this.f62680c.A(this.f62678a.getResources().getString(R.string.list_has_no_more));
            this.f62680c.z(null);
            this.f62680c.f();
        }
        this.f62681d.i(dVar.f62699g);
        this.f62681d.f();
        i iVar = this.f62683f;
        if (iVar != null) {
            iVar.n(this.f62679b.getFirstVisiblePosition(), this.f62679b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f62685h) != null) {
            aVar.g(this.f62678a.U0());
            this.f62685h.j(this.f62678a.f15415i);
        }
        this.k = dVar.n;
        if (this.f62678a.getFragmentActivity() instanceof m0) {
            ((m0) this.f62678a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f62678a.l != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        i iVar = this.f62683f;
        if (iVar != null) {
            iVar.x();
        }
    }

    public void q() {
        this.f62681d.f();
    }

    public void r() {
        u uVar = new u();
        uVar.f63477a = this.f62678a.k;
        uVar.f63478b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void s() {
        i iVar = this.f62683f;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void t() {
        this.f62679b.scrollToPosition(0);
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62679b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(z ? 0 : 8);
        }
    }

    public void v(boolean z) {
        d.a.o0.r0.l1.a aVar = this.f62681d;
        if (aVar != null) {
            aVar.j(z);
        }
    }

    public void w(boolean z) {
        if (this.f62678a == null) {
            return;
        }
        u uVar = new u();
        uVar.f63477a = this.f62678a.k;
        uVar.f63478b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        this.f62679b.setOnScrollListener(onScrollListener);
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62679b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(i2);
        }
    }
}
