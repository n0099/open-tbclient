package d.a.j0.q0.l1;

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
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.j2.i;
import d.a.j0.q0.i0;
import d.a.j0.q0.m0;
import d.a.j0.q0.u;
import d.a.j0.x.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f57979a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57980b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f57981c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.q0.l1.a f57982d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.q0.l1.d f57983e;

    /* renamed from: f  reason: collision with root package name */
    public i f57984f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f57985g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.q0.n1.f.a.a f57986h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57987i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l = new a();
    public BdListView.p m = new C1419b();
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

    /* renamed from: d.a.j0.q0.l1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1419b implements BdListView.p {
        public C1419b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f57980b != null) {
                b.this.f57980b.stopScroll();
            }
            if (b.this.f57981c == null || b.this.f57979a == null) {
                return;
            }
            if (j.z()) {
                b.this.f57980b.setNextPage(b.this.f57981c);
                b.this.f57981c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                b.this.f57981c.z(null);
                if (b.this.f57987i) {
                    b.this.f57981c.L();
                    b.this.f57981c.z(null);
                    b.this.f57979a.U0();
                    return;
                }
                b.this.f57981c.A(b.this.f57979a.getResources().getString(R.string.list_has_no_more));
                b.this.f57981c.f();
                b.this.f57981c.z(null);
                return;
            }
            b.this.f57980b.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f57990a;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (b.this.f57984f != null) {
                    b.this.f57984f.n(b.this.f57980b.getFirstVisiblePosition(), b.this.f57980b.getLastVisiblePosition(), this.f57990a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f57990a = false;
            } else {
                this.f57990a = true;
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
            if (b.this.f57984f != null) {
                b.this.f57984f.k(view);
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
        this.f57979a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f57980b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f57979a.getContext()));
        this.f57980b.setFadingEdgeLength(0);
        this.f57980b.setOverScrollMode(2);
        this.f57980b.setOnSrollToBottomListener(this.m);
        this.f57980b.addOnScrollListener(this.n);
        this.f57980b.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f57980b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f57980b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f57979a.getPageContext().getPageActivity());
        this.f57981c = pbListView;
        pbListView.b();
        this.f57981c.o(R.color.transparent);
        this.f57981c.r(l.g(this.f57979a.getActivity(), R.dimen.tbds182));
        this.f57981c.v();
        this.f57981c.E(R.dimen.tbfontsize33);
        this.f57981c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57981c.y(R.color.CAM_X0110);
        this.f57981c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f57979a;
        this.f57982d = new d.a.j0.q0.l1.a(frsCommonTabFragment2, this.f57980b, frsViewData, frsCommonTabFragment2.l == 16);
        w(false);
        if (this.f57984f == null) {
            this.f57984f = new i(this.f57979a.getPageContext(), this.f57980b);
        }
        this.f57984f.p(1);
        this.f57984f.t(this.f57979a.getUniqueId());
        if (g()) {
            this.f57985g = new RelativeLayout(this.f57979a.getContext());
            this.f57985g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f57986h = new d.a.j0.q0.n1.f.a.a(this.f57979a, this.f57985g);
            this.f57980b.t(this.f57985g, 0);
            this.f57986h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f57979a;
        if (frsCommonTabFragment3.l == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f57980b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        FrsCommonTabFragment frsCommonTabFragment = this.f57979a;
        if (frsCommonTabFragment != null) {
            return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
        }
        return false;
    }

    public final List<FrsTabInfo> h() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.f57979a.l);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.f57979a.l);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public i i() {
        return this.f57984f;
    }

    public BdTypeRecyclerView j() {
        return this.f57980b;
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
        d.a.j0.q0.l1.a aVar = this.f57982d;
        if (aVar != null) {
            aVar.f();
        }
        PbListView pbListView = this.f57981c;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57981c.d(i2);
        }
        d.a.j0.q0.n1.f.a.a aVar2 = this.f57986h;
        if (aVar2 != null) {
            aVar2.h();
        }
        i0 i0Var = this.j;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    public void m(String str) {
        d.a.j0.q0.l1.d dVar;
        if (StringUtils.isNull(str) || (dVar = this.f57983e) == null || ListUtils.isEmpty(dVar.f58000g)) {
            return;
        }
        Iterator<n> it = this.f57983e.f58000g.iterator();
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
        if (ListUtils.isEmpty(this.f57983e.f58000g)) {
            this.f57983e.f58000g.add(new d.a.j0.q0.t());
        }
        this.f57982d.i(this.f57983e.f58000g);
        this.f57982d.f();
    }

    public void n() {
        i iVar = this.f57984f;
        if (iVar != null) {
            iVar.h();
        }
        d.a.j0.q0.l1.a aVar = this.f57982d;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void o(d.a.j0.q0.l1.d dVar) {
        i0 i0Var;
        d.a.j0.q0.n1.f.a.a aVar;
        if (dVar == null) {
            return;
        }
        this.f57987i = dVar.f57998e;
        if (ListUtils.isEmpty(dVar.f58000g)) {
            d.a.j0.q0.t tVar = new d.a.j0.q0.t();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f58000g = arrayList;
            arrayList.add(tVar);
            dVar.f57998e = false;
        }
        this.f57983e = dVar;
        this.f57981c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f57987i) {
            this.f57980b.setNextPage(this.f57981c);
            if (k(dVar.f58000g, 3)) {
                this.f57981c.z(null);
                this.f57981c.K();
            } else {
                this.f57981c.K();
                this.f57981c.z(this.l);
                this.f57981c.A(this.f57979a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f57980b.setNextPage(null);
            this.f57981c.A(this.f57979a.getResources().getString(R.string.list_has_no_more));
            this.f57981c.z(null);
            this.f57981c.f();
        }
        this.f57982d.i(dVar.f58000g);
        this.f57982d.f();
        i iVar = this.f57984f;
        if (iVar != null) {
            iVar.n(this.f57980b.getFirstVisiblePosition(), this.f57980b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f57986h) != null) {
            aVar.g(this.f57979a.S0());
            this.f57986h.j(this.f57979a.f16053i);
        }
        this.k = dVar.n;
        if (this.f57979a.getFragmentActivity() instanceof m0) {
            ((m0) this.f57979a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f57979a.l != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        i iVar = this.f57984f;
        if (iVar != null) {
            iVar.x();
        }
    }

    public void q() {
        this.f57982d.f();
    }

    public void r() {
        u uVar = new u();
        uVar.f58778a = this.f57979a.k;
        uVar.f58779b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void s() {
        i iVar = this.f57984f;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void t() {
        this.f57980b.scrollToPosition(0);
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57980b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(z ? 0 : 8);
        }
    }

    public void v(boolean z) {
        d.a.j0.q0.l1.a aVar = this.f57982d;
        if (aVar != null) {
            aVar.j(z);
        }
    }

    public void w(boolean z) {
        if (this.f57979a == null) {
            return;
        }
        u uVar = new u();
        uVar.f58778a = this.f57979a.k;
        uVar.f58779b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        this.f57980b.setOnScrollListener(onScrollListener);
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57980b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(i2);
        }
    }
}
