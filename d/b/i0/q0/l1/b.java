package d.b.i0.q0.l1;

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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.j2.i;
import d.b.i0.q0.i0;
import d.b.i0.q0.m0;
import d.b.i0.q0.u;
import d.b.i0.x.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f59485a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59486b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f59487c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q0.l1.a f59488d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q0.l1.d f59489e;

    /* renamed from: f  reason: collision with root package name */
    public i f59490f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f59491g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.q0.n1.f.a.a f59492h;
    public boolean i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l = new a();
    public BdListView.p m = new C1457b();
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

    /* renamed from: d.b.i0.q0.l1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1457b implements BdListView.p {
        public C1457b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f59486b != null) {
                b.this.f59486b.stopScroll();
            }
            if (b.this.f59487c == null || b.this.f59485a == null) {
                return;
            }
            if (j.z()) {
                b.this.f59486b.setNextPage(b.this.f59487c);
                b.this.f59487c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                b.this.f59487c.z(null);
                if (b.this.i) {
                    b.this.f59487c.L();
                    b.this.f59487c.z(null);
                    b.this.f59485a.U0();
                    return;
                }
                b.this.f59487c.A(b.this.f59485a.getResources().getString(R.string.list_has_no_more));
                b.this.f59487c.f();
                b.this.f59487c.z(null);
                return;
            }
            b.this.f59486b.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59495a;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.f59490f != null) {
                    b.this.f59490f.n(b.this.f59486b.getFirstVisiblePosition(), b.this.f59486b.getLastVisiblePosition(), this.f59495a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f59495a = false;
            } else {
                this.f59495a = true;
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
            if (b.this.f59490f != null) {
                b.this.f59490f.k(view);
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
        this.f59485a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f59486b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f59485a.getContext()));
        this.f59486b.setFadingEdgeLength(0);
        this.f59486b.setOverScrollMode(2);
        this.f59486b.setOnSrollToBottomListener(this.m);
        this.f59486b.addOnScrollListener(this.n);
        this.f59486b.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f59486b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f59486b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f59485a.getPageContext().getPageActivity());
        this.f59487c = pbListView;
        pbListView.b();
        this.f59487c.o(R.color.transparent);
        this.f59487c.r(l.g(this.f59485a.getActivity(), R.dimen.tbds182));
        this.f59487c.v();
        this.f59487c.E(R.dimen.tbfontsize33);
        this.f59487c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f59487c.y(R.color.CAM_X0110);
        this.f59487c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f59485a;
        this.f59488d = new d.b.i0.q0.l1.a(frsCommonTabFragment2, this.f59486b, frsViewData, frsCommonTabFragment2.l == 16);
        w(false);
        if (this.f59490f == null) {
            this.f59490f = new i(this.f59485a.getPageContext(), this.f59486b);
        }
        this.f59490f.p(1);
        this.f59490f.t(this.f59485a.getUniqueId());
        if (g()) {
            this.f59491g = new RelativeLayout(this.f59485a.getContext());
            this.f59491g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f59492h = new d.b.i0.q0.n1.f.a.a(this.f59485a, this.f59491g);
            this.f59486b.t(this.f59491g, 0);
            this.f59492h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f59485a;
        if (frsCommonTabFragment3.l == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f59486b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        FrsCommonTabFragment frsCommonTabFragment = this.f59485a;
        if (frsCommonTabFragment != null) {
            return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
        }
        return false;
    }

    public final List<FrsTabInfo> h() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.f59485a.l);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.f59485a.l);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public i i() {
        return this.f59490f;
    }

    public BdTypeRecyclerView j() {
        return this.f59486b;
    }

    public final boolean k(ArrayList<n> arrayList, int i) {
        int i2;
        if (ListUtils.isEmpty(arrayList) || i < 0) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        int i3 = 1;
        while (i2 < arrayList.size() && i3 <= i) {
            if (arrayList.get(i2) instanceof z1) {
                int i4 = i2 - 1;
                i2 = ((arrayList.get(i4) instanceof z1) && ((z1) arrayList.get(i2)).position == ((z1) arrayList.get(i4)).position) ? i2 + 1 : 1;
            }
            i3++;
        }
        return i3 > i;
    }

    public void l(int i) {
        d.b.i0.q0.l1.a aVar = this.f59488d;
        if (aVar != null) {
            aVar.f();
        }
        PbListView pbListView = this.f59487c;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f59487c.d(i);
        }
        d.b.i0.q0.n1.f.a.a aVar2 = this.f59492h;
        if (aVar2 != null) {
            aVar2.h();
        }
        i0 i0Var = this.j;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    public void m(String str) {
        d.b.i0.q0.l1.d dVar;
        if (StringUtils.isNull(str) || (dVar = this.f59489e) == null || ListUtils.isEmpty(dVar.f59504g)) {
            return;
        }
        Iterator<n> it = this.f59489e.f59504g.iterator();
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
        if (ListUtils.isEmpty(this.f59489e.f59504g)) {
            this.f59489e.f59504g.add(new d.b.i0.q0.t());
        }
        this.f59488d.i(this.f59489e.f59504g);
        this.f59488d.f();
    }

    public void n() {
        i iVar = this.f59490f;
        if (iVar != null) {
            iVar.h();
        }
        d.b.i0.q0.l1.a aVar = this.f59488d;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void o(d.b.i0.q0.l1.d dVar) {
        i0 i0Var;
        d.b.i0.q0.n1.f.a.a aVar;
        if (dVar == null) {
            return;
        }
        this.i = dVar.f59502e;
        if (ListUtils.isEmpty(dVar.f59504g)) {
            d.b.i0.q0.t tVar = new d.b.i0.q0.t();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f59504g = arrayList;
            arrayList.add(tVar);
            dVar.f59502e = false;
        }
        this.f59489e = dVar;
        this.f59487c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.f59486b.setNextPage(this.f59487c);
            if (k(dVar.f59504g, 3)) {
                this.f59487c.z(null);
                this.f59487c.K();
            } else {
                this.f59487c.K();
                this.f59487c.z(this.l);
                this.f59487c.A(this.f59485a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f59486b.setNextPage(null);
            this.f59487c.A(this.f59485a.getResources().getString(R.string.list_has_no_more));
            this.f59487c.z(null);
            this.f59487c.f();
        }
        this.f59488d.i(dVar.f59504g);
        this.f59488d.f();
        i iVar = this.f59490f;
        if (iVar != null) {
            iVar.n(this.f59486b.getFirstVisiblePosition(), this.f59486b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f59492h) != null) {
            aVar.g(this.f59485a.S0());
            this.f59492h.j(this.f59485a.i);
        }
        this.k = dVar.n;
        if (this.f59485a.getFragmentActivity() instanceof m0) {
            ((m0) this.f59485a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f59485a.l != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        i iVar = this.f59490f;
        if (iVar != null) {
            iVar.x();
        }
    }

    public void q() {
        this.f59488d.f();
    }

    public void r() {
        u uVar = new u();
        uVar.f60250a = this.f59485a.k;
        uVar.f60251b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void s() {
        i iVar = this.f59490f;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void t() {
        this.f59486b.scrollToPosition(0);
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59486b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(z ? 0 : 8);
        }
    }

    public void v(boolean z) {
        d.b.i0.q0.l1.a aVar = this.f59488d;
        if (aVar != null) {
            aVar.j(z);
        }
    }

    public void w(boolean z) {
        if (this.f59485a == null) {
            return;
        }
        u uVar = new u();
        uVar.f60250a = this.f59485a.k;
        uVar.f60251b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        this.f59486b.setOnScrollListener(onScrollListener);
    }

    public void y(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59486b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(i);
        }
    }
}
