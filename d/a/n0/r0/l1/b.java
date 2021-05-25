package d.a.n0.r0.l1;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.k2.i;
import d.a.n0.r0.i0;
import d.a.n0.r0.m0;
import d.a.n0.r0.u;
import d.a.n0.z.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f58862a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58863b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f58864c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r0.l1.a f58865d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r0.l1.d f58866e;

    /* renamed from: f  reason: collision with root package name */
    public i f58867f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f58868g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r0.n1.f.a.a f58869h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58870i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l = new a();
    public BdListView.p m = new C1506b();
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

    /* renamed from: d.a.n0.r0.l1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1506b implements BdListView.p {
        public C1506b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f58863b != null) {
                b.this.f58863b.stopScroll();
            }
            if (b.this.f58864c == null || b.this.f58862a == null) {
                return;
            }
            if (j.z()) {
                b.this.f58863b.setNextPage(b.this.f58864c);
                b.this.f58864c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                b.this.f58864c.z(null);
                if (b.this.f58870i) {
                    b.this.f58864c.L();
                    b.this.f58864c.z(null);
                    b.this.f58862a.T0();
                    return;
                }
                b.this.f58864c.A(b.this.f58862a.getResources().getString(R.string.list_has_no_more));
                b.this.f58864c.f();
                b.this.f58864c.z(null);
                return;
            }
            b.this.f58863b.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f58873a;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (b.this.f58867f != null) {
                    b.this.f58867f.n(b.this.f58863b.getFirstVisiblePosition(), b.this.f58863b.getLastVisiblePosition(), this.f58873a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f58873a = false;
            } else {
                this.f58873a = true;
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
            if (b.this.f58867f != null) {
                b.this.f58867f.k(view);
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
        this.f58862a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f58863b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f58862a.getContext()));
        this.f58863b.setFadingEdgeLength(0);
        this.f58863b.setOverScrollMode(2);
        this.f58863b.setOnSrollToBottomListener(this.m);
        this.f58863b.addOnScrollListener(this.n);
        this.f58863b.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f58863b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f58863b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f58862a.getPageContext().getPageActivity());
        this.f58864c = pbListView;
        pbListView.b();
        this.f58864c.o(R.color.transparent);
        this.f58864c.r(l.g(this.f58862a.getActivity(), R.dimen.tbds182));
        this.f58864c.v();
        this.f58864c.E(R.dimen.tbfontsize33);
        this.f58864c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f58864c.y(R.color.CAM_X0110);
        this.f58864c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f58862a;
        this.f58865d = new d.a.n0.r0.l1.a(frsCommonTabFragment2, this.f58863b, frsViewData, frsCommonTabFragment2.l == 16);
        w(false);
        if (this.f58867f == null) {
            this.f58867f = new i(this.f58862a.getPageContext(), this.f58863b);
        }
        this.f58867f.p(1);
        this.f58867f.t(this.f58862a.getUniqueId());
        if (g()) {
            this.f58868g = new RelativeLayout(this.f58862a.getContext());
            this.f58868g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f58869h = new d.a.n0.r0.n1.f.a.a(this.f58862a, this.f58868g);
            this.f58863b.t(this.f58868g, 0);
            this.f58869h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f58862a;
        if (frsCommonTabFragment3.l == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f58863b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        FrsCommonTabFragment frsCommonTabFragment = this.f58862a;
        if (frsCommonTabFragment != null) {
            return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
        }
        return false;
    }

    public final List<FrsTabInfo> h() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.f58862a.l);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.f58862a.l);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public i i() {
        return this.f58867f;
    }

    public BdTypeRecyclerView j() {
        return this.f58863b;
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
        d.a.n0.r0.l1.a aVar = this.f58865d;
        if (aVar != null) {
            aVar.f();
        }
        PbListView pbListView = this.f58864c;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58864c.d(i2);
        }
        d.a.n0.r0.n1.f.a.a aVar2 = this.f58869h;
        if (aVar2 != null) {
            aVar2.h();
        }
        i0 i0Var = this.j;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    public void m(String str) {
        d.a.n0.r0.l1.d dVar;
        if (StringUtils.isNull(str) || (dVar = this.f58866e) == null || ListUtils.isEmpty(dVar.f58883g)) {
            return;
        }
        Iterator<n> it = this.f58866e.f58883g.iterator();
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
        if (ListUtils.isEmpty(this.f58866e.f58883g)) {
            this.f58866e.f58883g.add(new d.a.n0.r0.t());
        }
        this.f58865d.i(this.f58866e.f58883g);
        this.f58865d.f();
    }

    public void n() {
        i iVar = this.f58867f;
        if (iVar != null) {
            iVar.h();
        }
        d.a.n0.r0.l1.a aVar = this.f58865d;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void o(d.a.n0.r0.l1.d dVar) {
        i0 i0Var;
        d.a.n0.r0.n1.f.a.a aVar;
        if (dVar == null) {
            return;
        }
        this.f58870i = dVar.f58881e;
        if (ListUtils.isEmpty(dVar.f58883g)) {
            d.a.n0.r0.t tVar = new d.a.n0.r0.t();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f58883g = arrayList;
            arrayList.add(tVar);
            dVar.f58881e = false;
        }
        this.f58866e = dVar;
        this.f58864c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f58870i) {
            this.f58863b.setNextPage(this.f58864c);
            if (k(dVar.f58883g, 3)) {
                this.f58864c.z(null);
                this.f58864c.K();
            } else {
                this.f58864c.K();
                this.f58864c.z(this.l);
                this.f58864c.A(this.f58862a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f58863b.setNextPage(null);
            this.f58864c.A(this.f58862a.getResources().getString(R.string.list_has_no_more));
            this.f58864c.z(null);
            this.f58864c.f();
        }
        this.f58865d.i(dVar.f58883g);
        this.f58865d.f();
        i iVar = this.f58867f;
        if (iVar != null) {
            iVar.n(this.f58863b.getFirstVisiblePosition(), this.f58863b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f58869h) != null) {
            aVar.g(this.f58862a.R0());
            this.f58869h.j(this.f58862a.f15271i);
        }
        this.k = dVar.n;
        if (this.f58862a.getFragmentActivity() instanceof m0) {
            ((m0) this.f58862a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f58862a.l != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        i iVar = this.f58867f;
        if (iVar != null) {
            iVar.x();
        }
    }

    public void q() {
        this.f58865d.f();
    }

    public void r() {
        u uVar = new u();
        uVar.f59661a = this.f58862a.k;
        uVar.f59662b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void s() {
        i iVar = this.f58867f;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void t() {
        this.f58863b.scrollToPosition(0);
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58863b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(z ? 0 : 8);
        }
    }

    public void v(boolean z) {
        d.a.n0.r0.l1.a aVar = this.f58865d;
        if (aVar != null) {
            aVar.j(z);
        }
    }

    public void w(boolean z) {
        if (this.f58862a == null) {
            return;
        }
        u uVar = new u();
        uVar.f59661a = this.f58862a.k;
        uVar.f59662b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        this.f58863b.setOnScrollListener(onScrollListener);
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58863b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(i2);
        }
    }
}
