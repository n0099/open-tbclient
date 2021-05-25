package d.a.n0.b1.k.e;

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
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i.v0.a;
import d.a.m0.d0.g;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.n0.k2.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52048a;

    /* renamed from: b  reason: collision with root package name */
    public View f52049b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f52050c;

    /* renamed from: d  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f52051d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.g.i.a f52052e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.g.k.e f52053f;

    /* renamed from: g  reason: collision with root package name */
    public h f52054g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f52055h;

    /* renamed from: i  reason: collision with root package name */
    public g f52056i;
    public d.a.n0.b1.k.b.a j;
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
    public f.h u = new C1218a();
    public f.InterfaceC1134f v = new b();
    public CustomMessageListener w = new c(2921420);
    public CustomMessageListener x = new d(2921381);
    public RecyclerView.RecyclerListener y = new e();
    public RecyclerView.OnScrollListener z = new f();

    /* renamed from: d.a.n0.b1.k.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1218a implements f.h {
        public C1218a() {
        }

        @Override // d.a.m0.r.f0.f.h
        public void a(boolean z) {
            a.this.W();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.InterfaceC1134f {
        public b() {
        }

        @Override // d.a.m0.r.f0.f.InterfaceC1134f
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

        /* renamed from: d.a.n0.b1.k.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1219a implements Runnable {
            public RunnableC1219a() {
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

        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.c.e.m.e.a().postDelayed(new RunnableC1219a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
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
            p.b().o(new a.C0544a(3));
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
        public int f52063a = -1;

        public f() {
        }

        public final void a(int i2, int i3) {
            a.this.o = i2;
            a.this.p = (i2 + i3) - 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0 && a.this.m != null && a.this.r) {
                a.this.m.m(a.this.o, a.this.p, a.this.s, 1);
            }
            if (this.f52063a == i2) {
                return;
            }
            this.f52063a = i2;
            if (i2 == 1) {
                a.this.N(true);
            } else {
                a.this.Y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            int i5 = 0;
            if (recyclerView instanceof BdRecyclerView) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                i5 = bdRecyclerView.getFirstVisiblePosition();
                i4 = bdRecyclerView.getLastVisiblePosition();
            } else {
                i4 = 0;
            }
            a(i5, (i4 - i5) + 1);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        this.f52048a = tbPageContext;
        this.t = bdUniqueId;
        this.n = bVar;
        w();
    }

    public void A() {
        g gVar = this.f52056i;
        if (gVar != null) {
            gVar.m();
        }
        X(null);
        d.a.n0.b1.g.i.a aVar = this.f52052e;
        if (aVar != null) {
            aVar.X();
        }
        d.a.n0.b1.k.b.a aVar2 = this.j;
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
        d.a.n0.b1.k.b.a aVar = this.j;
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
        d.a.n0.b1.k.b.a aVar = this.j;
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
        List<Integer> s = s(str, this.f52050c);
        int intValue = s.get(0).intValue();
        int intValue2 = s.get(1).intValue();
        if (intValue == -1 || intValue2 == -1) {
            return;
        }
        this.f52050c.E(intValue, intValue2);
    }

    public void J(List<n> list) {
        d.a.n0.b1.k.b.a aVar = this.j;
        if (aVar != null) {
            aVar.f(list);
        }
        E();
    }

    public void K(f.g gVar) {
        d.a.n0.b1.g.i.a aVar = this.f52052e;
        if (aVar != null) {
            aVar.a(gVar);
        }
    }

    public void L(boolean z) {
        this.r = z;
    }

    public void M(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52050c;
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
        PbListView pbListView = this.f52055h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f52050c.setNextPage(this.f52055h);
            }
            this.f52055h.r(l.g(this.f52048a.getPageActivity(), R.dimen.tbds178));
            this.f52055h.A(this.f52048a.getResources().getString(R.string.video_tab_click_load));
            this.f52055h.z(onClickListener);
            this.f52055h.f();
        }
    }

    public void Q() {
        PbListView pbListView = this.f52055h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f52050c.setNextPage(this.f52055h);
            }
            this.f52055h.r(l.g(this.f52048a.getPageActivity(), R.dimen.tbds178));
            this.f52055h.A(this.f52048a.getResources().getString(R.string.loading));
            this.f52055h.z(null);
            this.f52055h.O();
        }
    }

    public void R() {
        if (x()) {
            return;
        }
        if (this.f52056i == null) {
            g gVar = new g(this.f52048a.getPageActivity());
            this.f52056i = gVar;
            gVar.onChangeSkinType();
        }
        this.f52056i.attachView(this.f52049b, false);
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.f52054g == null) {
            this.f52054g = new h(this.f52048a.getPageActivity(), onClickListener);
        }
        this.f52054g.o();
        this.f52054g.l(null);
        this.f52054g.m(this.f52048a.getResources().getString(R.string.refresh_view_title_text));
        this.f52054g.i(R.drawable.new_pic_emotion_08);
        this.f52054g.k(0);
        this.f52054g.attachView(this.l, false);
    }

    public void T() {
        if (this.f52054g == null) {
            this.f52054g = new h(this.f52048a.getPageActivity(), null);
        }
        this.f52054g.e();
        this.f52054g.i(R.drawable.new_pic_emotion_03);
        this.f52054g.n(this.f52048a.getString(R.string.no_data_common_txt));
        this.f52054g.attachView(this.l, false);
    }

    public void U() {
        PbListView pbListView = this.f52055h;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f52050c.setNextPage(this.f52055h);
            }
            this.f52055h.r(l.g(this.f52048a.getPageActivity(), R.dimen.tbds178));
            this.f52055h.A(this.f52048a.getResources().getString(R.string.video_tab_no_more));
            this.f52055h.z(null);
            this.f52055h.f();
        }
    }

    public void V() {
        this.f52051d.setRefreshing(true);
    }

    public void W() {
        i iVar = this.m;
        if (iVar != null) {
            iVar.w();
        }
    }

    public void X(f.i iVar) {
        this.f52051d.z(iVar);
    }

    public final void Y() {
        if (F(this.f52050c)) {
            N(false);
        } else {
            N(true);
        }
    }

    public void m() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        g gVar = this.f52056i;
        if (gVar != null) {
            gVar.p(TbadkCoreApplication.getInst().getSkinType());
            this.f52056i.onChangeSkinType();
        }
        h hVar = this.f52054g;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.a.n0.b1.g.i.a aVar = this.f52052e;
        if (aVar != null) {
            aVar.I(skinType);
        }
        d.a.n0.b1.k.b.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public void n() {
        J(new LinkedList());
    }

    public final void o() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52050c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.z);
            this.f52050c.setRecyclerListener(null);
        }
        d.a.n0.b1.g.i.a aVar = this.f52052e;
        if (aVar != null) {
            aVar.b(null);
            this.f52052e.l(null);
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
        d.a.n0.b1.k.b.a aVar = this.j;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public View r() {
        return this.f52049b;
    }

    public final List<Integer> s(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
            n B = bdTypeRecyclerView.B(i4);
            if (B instanceof d.a.n0.z.e0.b) {
                d.a.n0.z.e0.b bVar = (d.a.n0.z.e0.b) B;
                if (bVar.m() != null && bVar.m().y1().equals(str)) {
                    if (!z) {
                        i2 = i4;
                    }
                    z = true;
                    i3 = i4;
                }
            }
        }
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        return arrayList;
    }

    public void t() {
        g gVar = this.f52056i;
        if (gVar != null) {
            gVar.dettachView(this.f52049b);
        }
    }

    public void u() {
        h hVar = this.f52054g;
        if (hVar != null) {
            hVar.dettachView(this.l);
            this.f52054g = null;
        }
    }

    public void v() {
        this.f52050c.addOnScrollListener(this.z);
        this.f52050c.setRecyclerListener(this.y);
        this.f52052e.b(this.u);
        this.f52052e.l(this.v);
        this.f52052e.Z(this.f52048a.getUniqueId());
        H();
    }

    public final void w() {
        View inflate = LayoutInflater.from(this.f52048a.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.f52049b = inflate;
        inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.l = (FrameLayout) this.f52049b.findViewById(R.id.video_tab_framelayout);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f52049b.findViewById(R.id.video_tab_recycle_view);
        this.f52050c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f52048a.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f52050c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        i iVar = new i(this.f52048a, this.f52050c);
        this.m = iVar;
        iVar.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.m.t(this.t);
        this.f52051d = (BigdaySwipeRefreshLayout) this.f52049b.findViewById(R.id.video_tab_refresh_layout);
        d.a.n0.b1.g.i.a aVar = new d.a.n0.b1.g.i.a(this.f52048a);
        this.f52052e = aVar;
        this.f52051d.setProgressView(aVar);
        int i2 = (int) (this.f52048a.getResources().getDisplayMetrics().density * 86.0f);
        this.f52051d.setCustomDistances(i2, i2, i2 * 2);
        PbListView pbListView = new PbListView(this.f52048a.getPageActivity());
        this.f52055h = pbListView;
        pbListView.a();
        this.f52055h.o(R.color.transparent);
        this.f52055h.r(l.g(this.f52048a.getPageActivity(), R.dimen.tbds178));
        this.f52055h.v();
        this.f52055h.E(R.dimen.tbfontsize36);
        this.f52055h.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f52055h.y(R.color.CAM_X0110);
        this.f52055h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        d.a.n0.b1.k.b.a aVar2 = new d.a.n0.b1.k.b.a(this.f52048a, this.f52050c);
        this.j = aVar2;
        aVar2.g(this.n);
        this.j.h(this.t);
        d.a.n0.b1.g.k.e eVar = new d.a.n0.b1.g.k.e();
        this.f52053f = eVar;
        eVar.a(this.t);
        this.j.i(this.f52053f);
        this.k = this.f52049b.findViewById(R.id.video_tab_divider_shadow);
        m();
    }

    public final boolean x() {
        g gVar = this.f52056i;
        if (gVar == null) {
            return false;
        }
        return gVar.isViewAttached();
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52050c;
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
            z2 = p.b().o(new a.C0544a(8, Boolean.valueOf(z)));
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
