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
import d.a.c.k.e.n;
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
    public FrsCommonTabFragment f62553a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62554b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f62555c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r0.l1.a f62556d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r0.l1.d f62557e;

    /* renamed from: f  reason: collision with root package name */
    public i f62558f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f62559g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r0.n1.f.a.a f62560h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62561i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l = new a();
    public BdListView.p m = new C1562b();
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
    public class C1562b implements BdListView.p {
        public C1562b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (b.this.f62554b != null) {
                b.this.f62554b.stopScroll();
            }
            if (b.this.f62555c == null || b.this.f62553a == null) {
                return;
            }
            if (j.z()) {
                b.this.f62554b.setNextPage(b.this.f62555c);
                b.this.f62555c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                b.this.f62555c.z(null);
                if (b.this.f62561i) {
                    b.this.f62555c.L();
                    b.this.f62555c.z(null);
                    b.this.f62553a.W0();
                    return;
                }
                b.this.f62555c.A(b.this.f62553a.getResources().getString(R.string.list_has_no_more));
                b.this.f62555c.f();
                b.this.f62555c.z(null);
                return;
            }
            b.this.f62554b.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f62564a;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (b.this.f62558f != null) {
                    b.this.f62558f.n(b.this.f62554b.getFirstVisiblePosition(), b.this.f62554b.getLastVisiblePosition(), this.f62564a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f62564a = false;
            } else {
                this.f62564a = true;
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
            if (b.this.f62558f != null) {
                b.this.f62558f.k(view);
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
        this.f62553a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f62554b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f62553a.getContext()));
        this.f62554b.setFadingEdgeLength(0);
        this.f62554b.setOverScrollMode(2);
        this.f62554b.setOnSrollToBottomListener(this.m);
        this.f62554b.addOnScrollListener(this.n);
        this.f62554b.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f62554b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f62554b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f62553a.getPageContext().getPageActivity());
        this.f62555c = pbListView;
        pbListView.b();
        this.f62555c.o(R.color.transparent);
        this.f62555c.r(l.g(this.f62553a.getActivity(), R.dimen.tbds182));
        this.f62555c.v();
        this.f62555c.E(R.dimen.tbfontsize33);
        this.f62555c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f62555c.y(R.color.CAM_X0110);
        this.f62555c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f62553a;
        this.f62556d = new d.a.n0.r0.l1.a(frsCommonTabFragment2, this.f62554b, frsViewData, frsCommonTabFragment2.l == 16);
        w(false);
        if (this.f62558f == null) {
            this.f62558f = new i(this.f62553a.getPageContext(), this.f62554b);
        }
        this.f62558f.p(1);
        this.f62558f.t(this.f62553a.getUniqueId());
        if (g()) {
            this.f62559g = new RelativeLayout(this.f62553a.getContext());
            this.f62559g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f62560h = new d.a.n0.r0.n1.f.a.a(this.f62553a, this.f62559g);
            this.f62554b.t(this.f62559g, 0);
            this.f62560h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f62553a;
        if (frsCommonTabFragment3.l == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f62554b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        FrsCommonTabFragment frsCommonTabFragment = this.f62553a;
        if (frsCommonTabFragment != null) {
            return frsCommonTabFragment.n == 1 || frsCommonTabFragment.l == 16;
        }
        return false;
    }

    public final List<FrsTabInfo> h() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.f62553a.l);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.f62553a.l);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public i i() {
        return this.f62558f;
    }

    public BdTypeRecyclerView j() {
        return this.f62554b;
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
        d.a.n0.r0.l1.a aVar = this.f62556d;
        if (aVar != null) {
            aVar.f();
        }
        PbListView pbListView = this.f62555c;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f62555c.d(i2);
        }
        d.a.n0.r0.n1.f.a.a aVar2 = this.f62560h;
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
        if (StringUtils.isNull(str) || (dVar = this.f62557e) == null || ListUtils.isEmpty(dVar.f62574g)) {
            return;
        }
        Iterator<n> it = this.f62557e.f62574g.iterator();
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
        if (ListUtils.isEmpty(this.f62557e.f62574g)) {
            this.f62557e.f62574g.add(new d.a.n0.r0.t());
        }
        this.f62556d.i(this.f62557e.f62574g);
        this.f62556d.f();
    }

    public void n() {
        i iVar = this.f62558f;
        if (iVar != null) {
            iVar.h();
        }
        d.a.n0.r0.l1.a aVar = this.f62556d;
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
        this.f62561i = dVar.f62572e;
        if (ListUtils.isEmpty(dVar.f62574g)) {
            d.a.n0.r0.t tVar = new d.a.n0.r0.t();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f62574g = arrayList;
            arrayList.add(tVar);
            dVar.f62572e = false;
        }
        this.f62557e = dVar;
        this.f62555c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f62561i) {
            this.f62554b.setNextPage(this.f62555c);
            if (k(dVar.f62574g, 3)) {
                this.f62555c.z(null);
                this.f62555c.K();
            } else {
                this.f62555c.K();
                this.f62555c.z(this.l);
                this.f62555c.A(this.f62553a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f62554b.setNextPage(null);
            this.f62555c.A(this.f62553a.getResources().getString(R.string.list_has_no_more));
            this.f62555c.z(null);
            this.f62555c.f();
        }
        this.f62556d.i(dVar.f62574g);
        this.f62556d.f();
        i iVar = this.f62558f;
        if (iVar != null) {
            iVar.n(this.f62554b.getFirstVisiblePosition(), this.f62554b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f62560h) != null) {
            aVar.g(this.f62553a.U0());
            this.f62560h.j(this.f62553a.f15333i);
        }
        this.k = dVar.n;
        if (this.f62553a.getFragmentActivity() instanceof m0) {
            ((m0) this.f62553a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f62553a.l != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        i iVar = this.f62558f;
        if (iVar != null) {
            iVar.x();
        }
    }

    public void q() {
        this.f62556d.f();
    }

    public void r() {
        u uVar = new u();
        uVar.f63352a = this.f62553a.k;
        uVar.f63353b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void s() {
        i iVar = this.f62558f;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void t() {
        this.f62554b.scrollToPosition(0);
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62554b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(z ? 0 : 8);
        }
    }

    public void v(boolean z) {
        d.a.n0.r0.l1.a aVar = this.f62556d;
        if (aVar != null) {
            aVar.j(z);
        }
    }

    public void w(boolean z) {
        if (this.f62553a == null) {
            return;
        }
        u uVar = new u();
        uVar.f63352a = this.f62553a.k;
        uVar.f63353b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        this.f62554b.setOnScrollListener(onScrollListener);
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62554b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(i2);
        }
    }
}
