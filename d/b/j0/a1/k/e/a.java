package d.b.j0.a1.k.e;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i.u0.a;
import d.b.i0.d0.g;
import d.b.i0.d0.h;
import d.b.i0.r.f0.f;
import d.b.j0.j2.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53454a;

    /* renamed from: b  reason: collision with root package name */
    public View f53455b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53456c;

    /* renamed from: d  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f53457d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.a1.g.i.a f53458e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.a1.g.k.e f53459f;

    /* renamed from: g  reason: collision with root package name */
    public h f53460g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f53461h;
    public g i;
    public d.b.j0.a1.k.b.a j;
    public View k;
    public FrameLayout l;
    public i m;
    public NEGFeedBackView.b n;
    public BdUniqueId t;
    public int o = 0;
    public int p = 0;
    public boolean q = false;
    public boolean r = true;
    public boolean s = false;
    public f.h u = new C1190a();
    public f.InterfaceC1110f v = new b();
    public CustomMessageListener w = new c(2921420);
    public CustomMessageListener x = new d(2921381);
    public RecyclerView.RecyclerListener y = new e();
    public RecyclerView.OnScrollListener z = new f();

    /* renamed from: d.b.j0.a1.k.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1190a implements f.h {
        public C1190a() {
        }

        @Override // d.b.i0.r.f0.f.h
        public void a(boolean z) {
            a.this.W();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.InterfaceC1110f {
        public b() {
        }

        @Override // d.b.i0.r.f0.f.InterfaceC1110f
        public void a(View view, boolean z) {
            a.this.L(true);
            if (a.this.m == null || a.this.q || !a.this.r) {
                return;
            }
            a.this.m.n(a.this.o, a.this.p, a.this.s, true);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {

        /* renamed from: d.b.j0.a1.k.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1191a implements Runnable {
            public RunnableC1191a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.j.c();
                if (a.this.q || !a.this.r) {
                    return;
                }
                a.this.m.n(a.this.o, a.this.p, a.this.s, true);
            }
        }

        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.c.e.m.e.a().postDelayed(new RunnableC1191a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder p;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (p = a.this.p()) == null || p.b() == null) {
                return;
            }
            p.b().o(new a.C1072a(3));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements RecyclerView.RecyclerListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (a.this.m != null) {
                a.this.m.k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f53468a = -1;

        public f() {
        }

        public final void a(int i, int i2) {
            a.this.o = i;
            a.this.p = (i + i2) - 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.m != null && a.this.r) {
                a.this.m.m(a.this.o, a.this.p, a.this.s, 1);
            }
            if (this.f53468a == i) {
                return;
            }
            this.f53468a = i;
            if (i == 1) {
                a.this.N(true);
            } else {
                a.this.Y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView instanceof BdRecyclerView) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                i4 = bdRecyclerView.getFirstVisiblePosition();
                i3 = bdRecyclerView.getLastVisiblePosition();
            } else {
                i3 = 0;
            }
            a(i4, (i3 - i4) + 1);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        this.f53454a = tbPageContext;
        this.t = bdUniqueId;
        this.n = bVar;
        w();
    }

    public void A() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.m();
        }
        X(null);
        d.b.j0.a1.g.i.a aVar = this.f53458e;
        if (aVar != null) {
            aVar.X();
        }
        d.b.j0.a1.k.b.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.d();
        }
        i iVar = this.m;
        if (iVar != null) {
            iVar.h();
        }
        o();
        MessageManager.getInstance().unRegisterListener(this.x);
        MessageManager.getInstance().unRegisterListener(this.w);
    }

    public void B() {
        d.b.j0.a1.k.b.a aVar = this.j;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void C() {
        z(true);
    }

    public void D() {
        z(false);
    }

    public void E() {
        i iVar = this.m;
        if (iVar == null || !this.r) {
            return;
        }
        iVar.n(this.o, this.p, this.s, true);
    }

    public final boolean F(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void G() {
        d.b.j0.a1.k.b.a aVar = this.j;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void H() {
        this.w.setTag(this.t);
        MessageManager.getInstance().registerListener(this.w);
        this.x.setTag(this.t);
        MessageManager.getInstance().registerListener(this.x);
    }

    public void I(String str) {
        List<Integer> s = s(str, this.f53456c);
        int intValue = s.get(0).intValue();
        int intValue2 = s.get(1).intValue();
        if (intValue == -1 || intValue2 == -1) {
            return;
        }
        this.f53456c.E(intValue, intValue2);
    }

    public void J(List<n> list) {
        d.b.j0.a1.k.b.a aVar = this.j;
        if (aVar != null) {
            aVar.f(list);
        }
        E();
    }

    public void K(f.g gVar) {
        d.b.j0.a1.g.i.a aVar = this.f53458e;
        if (aVar != null) {
            aVar.b(gVar);
        }
    }

    public void L(boolean z) {
        this.r = z;
    }

    public void M(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53456c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void N(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    public void O(boolean z) {
        this.q = z;
    }

    public void P(View.OnClickListener onClickListener) {
        PbListView pbListView = this.f53461h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f53456c.setNextPage(this.f53461h);
            }
            this.f53461h.r(l.g(this.f53454a.getPageActivity(), R.dimen.tbds178));
            this.f53461h.A(this.f53454a.getResources().getString(R.string.video_tab_click_load));
            this.f53461h.z(onClickListener);
            this.f53461h.f();
        }
    }

    public void Q() {
        PbListView pbListView = this.f53461h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f53456c.setNextPage(this.f53461h);
            }
            this.f53461h.r(l.g(this.f53454a.getPageActivity(), R.dimen.tbds178));
            this.f53461h.A(this.f53454a.getResources().getString(R.string.loading));
            this.f53461h.z(null);
            this.f53461h.O();
        }
    }

    public void R() {
        if (x()) {
            return;
        }
        if (this.i == null) {
            g gVar = new g(this.f53454a.getPageActivity());
            this.i = gVar;
            gVar.onChangeSkinType();
        }
        this.i.attachView(this.f53455b, false);
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.f53460g == null) {
            this.f53460g = new h(this.f53454a.getPageActivity(), onClickListener);
        }
        this.f53460g.o();
        this.f53460g.l(null);
        this.f53460g.m(this.f53454a.getResources().getString(R.string.refresh_view_title_text));
        this.f53460g.i(R.drawable.new_pic_emotion_08);
        this.f53460g.k(0);
        this.f53460g.attachView(this.l, false);
    }

    public void T() {
        if (this.f53460g == null) {
            this.f53460g = new h(this.f53454a.getPageActivity(), null);
        }
        this.f53460g.e();
        this.f53460g.i(R.drawable.new_pic_emotion_03);
        this.f53460g.n(this.f53454a.getString(R.string.no_data_common_txt));
        this.f53460g.attachView(this.l, false);
    }

    public void U() {
        PbListView pbListView = this.f53461h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f53456c.setNextPage(this.f53461h);
            }
            this.f53461h.r(l.g(this.f53454a.getPageActivity(), R.dimen.tbds178));
            this.f53461h.A(this.f53454a.getResources().getString(R.string.video_tab_no_more));
            this.f53461h.z(null);
            this.f53461h.f();
        }
    }

    public void V() {
        this.f53457d.setRefreshing(true);
    }

    public void W() {
        i iVar = this.m;
        if (iVar != null) {
            iVar.w();
        }
    }

    public void X(f.i iVar) {
        this.f53457d.z(iVar);
    }

    public final void Y() {
        if (F(this.f53456c)) {
            N(false);
        } else {
            N(true);
        }
    }

    public void m() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        g gVar = this.i;
        if (gVar != null) {
            gVar.p(TbadkCoreApplication.getInst().getSkinType());
            this.i.onChangeSkinType();
        }
        h hVar = this.f53460g;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.b.j0.a1.g.i.a aVar = this.f53458e;
        if (aVar != null) {
            aVar.I(skinType);
        }
        d.b.j0.a1.k.b.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public void n() {
        J(new LinkedList());
    }

    public final void o() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53456c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.z);
            this.f53456c.setRecyclerListener(null);
        }
        d.b.j0.a1.g.i.a aVar = this.f53458e;
        if (aVar != null) {
            aVar.c(null);
            this.f53458e.g(null);
        }
    }

    public final ThreadCardViewHolder p() {
        i iVar = this.m;
        if (iVar == null || iVar.j() == null || !(this.m.j().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.m.j().getTag();
    }

    public List<n> q() {
        d.b.j0.a1.k.b.a aVar = this.j;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public View r() {
        return this.f53455b;
    }

    public final List<Integer> s(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
            n B = bdTypeRecyclerView.B(i3);
            if (B instanceof d.b.j0.x.e0.b) {
                d.b.j0.x.e0.b bVar = (d.b.j0.x.e0.b) B;
                if (bVar.n() != null && bVar.n().w1().equals(str)) {
                    if (!z) {
                        i = i3;
                    }
                    z = true;
                    i2 = i3;
                }
            }
        }
        arrayList.add(Integer.valueOf(i));
        arrayList.add(Integer.valueOf(i2));
        return arrayList;
    }

    public void t() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this.f53455b);
        }
    }

    public void u() {
        h hVar = this.f53460g;
        if (hVar != null) {
            hVar.dettachView(this.l);
            this.f53460g = null;
        }
    }

    public void v() {
        this.f53456c.addOnScrollListener(this.z);
        this.f53456c.setRecyclerListener(this.y);
        this.f53458e.c(this.u);
        this.f53458e.g(this.v);
        this.f53458e.Z(this.f53454a.getUniqueId());
        H();
    }

    public final void w() {
        View inflate = LayoutInflater.from(this.f53454a.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.f53455b = inflate;
        inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.l = (FrameLayout) this.f53455b.findViewById(R.id.video_tab_framelayout);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f53455b.findViewById(R.id.video_tab_recycle_view);
        this.f53456c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f53454a.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f53456c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        i iVar = new i(this.f53454a, this.f53456c);
        this.m = iVar;
        iVar.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.m.t(this.t);
        this.f53457d = (BigdaySwipeRefreshLayout) this.f53455b.findViewById(R.id.video_tab_refresh_layout);
        d.b.j0.a1.g.i.a aVar = new d.b.j0.a1.g.i.a(this.f53454a);
        this.f53458e = aVar;
        this.f53457d.setProgressView(aVar);
        int i = (int) (this.f53454a.getResources().getDisplayMetrics().density * 86.0f);
        this.f53457d.setCustomDistances(i, i, i * 2);
        PbListView pbListView = new PbListView(this.f53454a.getPageActivity());
        this.f53461h = pbListView;
        pbListView.a();
        this.f53461h.o(R.color.transparent);
        this.f53461h.r(l.g(this.f53454a.getPageActivity(), R.dimen.tbds178));
        this.f53461h.v();
        this.f53461h.E(R.dimen.tbfontsize36);
        this.f53461h.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f53461h.y(R.color.CAM_X0110);
        this.f53461h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        d.b.j0.a1.k.b.a aVar2 = new d.b.j0.a1.k.b.a(this.f53454a, this.f53456c);
        this.j = aVar2;
        aVar2.g(this.n);
        this.j.h(this.t);
        d.b.j0.a1.g.k.e eVar = new d.b.j0.a1.g.k.e();
        this.f53459f = eVar;
        eVar.a(this.t);
        this.j.i(this.f53459f);
        this.k = this.f53455b.findViewById(R.id.video_tab_divider_shadow);
        m();
    }

    public final boolean x() {
        g gVar = this.i;
        if (gVar == null) {
            return false;
        }
        return gVar.isViewAttached();
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53456c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(0);
        }
    }

    public final void z(boolean z) {
        this.q = z;
        i iVar = this.m;
        if (iVar == null) {
            return;
        }
        iVar.q(!z);
        ThreadCardViewHolder p = p();
        boolean z2 = false;
        if (p != null && p.b() != null) {
            z2 = p.b().o(new a.C1072a(8, Boolean.valueOf(z)));
        }
        if (z2) {
            return;
        }
        if (z) {
            this.m.w();
        } else if (this.r) {
            this.m.n(this.o, this.p, this.s, true);
        }
    }
}
