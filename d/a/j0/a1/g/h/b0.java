package d.a.j0.a1.g.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b0 {
    public w A;
    public t B;
    public n C;
    public p D;
    public q E;
    public s F;
    public d.a.j0.a1.g.h.c G;
    public d.a.j0.a1.b.e.z H;
    public d.a.c.j.e.a I;
    public d.a.c.j.e.a J;
    public d.a.c.j.e.a K;
    public d.a.c.j.e.a L;
    public d.a.c.j.e.a M;
    public d.a.c.j.e.a N;
    public d.a.c.j.e.a O;
    public List<d.a.c.j.e.a> P;
    public boolean Q;
    public boolean R;
    public f S;
    public CustomMessageListener T = new a(2016470);
    public CustomMessageListener U = new b(2001115);
    public CustomMessageListener V = new c(2001335);
    public CustomMessageListener W = new d(2001336);
    public CustomMessageListener X = new e(2921394);

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f50862a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.j.e.s f50863b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.n> f50864c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f50865d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.a1.g.h.a f50866e;

    /* renamed from: f  reason: collision with root package name */
    public z f50867f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.a1.g.h.b f50868g;

    /* renamed from: h  reason: collision with root package name */
    public n f50869h;

    /* renamed from: i  reason: collision with root package name */
    public x f50870i;
    public h j;
    public i k;
    public j l;
    public r m;
    public k n;
    public o o;
    public m p;
    public g q;
    public d.a.j0.a1.g.h.f r;
    public d.a.j0.a1.g.h.e s;
    public y t;
    public d.a.j0.a1.g.h.d u;
    public l v;
    public HomePageAlaLiveThreadAdapter w;
    public HomePageAlaFriendRoomAdapter x;
    public v y;
    public u z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            b0.this.f();
            if (b0.this.f50864c != null) {
                b0 b0Var = b0.this;
                b0Var.z(b0Var.f50864c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f13330a) {
                return;
            }
            b0.this.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.a.j0.j1.p.b bVar = new d.a.j0.j1.p.b();
            bVar.f55852a = String.valueOf(customResponsedMessage.getData());
            bVar.f55853b = true;
            b0.this.g(bVar);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.a.j0.j1.p.b bVar = new d.a.j0.j1.p.b();
            bVar.f55852a = String.valueOf(customResponsedMessage.getData());
            bVar.f55853b = false;
            b0.this.g(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.d.m.e.b i2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str, true) || (i2 = b0.this.i(str)) == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, i2));
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public b0(Context context, d.a.c.j.e.s sVar) {
        this.f50863b = sVar;
        this.f50865d = (TbPageContext) d.a.c.a.j.a(context);
        j(context);
        y(sVar);
        sVar.a(this.f50862a);
    }

    public void A(List<d.a.c.j.e.n> list, int i2) {
        d.a.j0.d3.v.f(list, 2);
        ViewGroup listView = this.f50863b.getListView();
        if (i2 > 0 && (listView instanceof BdRecyclerView)) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
            int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
            View childAt = bdRecyclerView.getChildAt(0);
            int top = childAt != null ? childAt.getTop() : 0;
            RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
            int i3 = firstVisiblePosition - i2;
            if (layoutManager instanceof LinearLayoutManager) {
                bdRecyclerView.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, top);
                bdRecyclerView.A();
            }
        }
        this.f50863b.setData(list);
        this.f50864c = list;
        f fVar = this.S;
        if (fVar != null) {
            fVar.a();
        }
    }

    public final void e() {
        this.R = f();
    }

    public final boolean f() {
        BdUniqueId bdUniqueId;
        List<d.a.c.j.e.a> list = this.P;
        if (list == null || list.size() <= 0) {
            this.P = new ArrayList();
            ArrayList<BdUniqueId> g2 = d.a.j0.d3.v.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.j0.j1.o.g.a b2 = d.a.j0.j1.r.b.d().b(this.f50865d, g2.get(i2), 2);
                if (this.Q) {
                    b2.e0(3);
                }
                n nVar = this.f50869h;
                if (nVar != null && (bdUniqueId = nVar.n) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.P.add(b2);
            }
            this.f50863b.a(this.P);
            return true;
        }
        return true;
    }

    public final void g(Object obj) {
        List<d.a.c.j.e.n> list = this.f50864c;
        if (list != null) {
            boolean z = false;
            for (d.a.c.j.e.n nVar : list) {
                if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                m();
            }
        }
    }

    public List<d.a.c.j.e.n> h() {
        return this.f50864c;
    }

    public final d.a.d.m.e.b i(String str) {
        int i2;
        d.a.j0.x.e0.l lVar;
        a2 a2Var;
        List<d.a.c.j.e.n> list = this.f50864c;
        if (list == null || list.isEmpty() || str == null) {
            return null;
        }
        d.a.d.m.e.b bVar = new d.a.d.m.e.b();
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i3 >= this.f50864c.size()) {
                i2 = -1;
                break;
            }
            if (this.f50864c.get(i3) instanceof d.a.j0.a1.g.j.h) {
                i4++;
            }
            if (this.f50864c.get(i3) instanceof d.a.j0.a1.g.j.a) {
                if (l(this.f50864c.get(i3))) {
                    if (z) {
                        i2 = ((d.a.j0.a1.g.j.a) this.f50864c.get(i3)).position;
                        break;
                    }
                    i6 = ((d.a.j0.a1.g.j.a) this.f50864c.get(i3)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.f50864c.get(i3) instanceof d.a.j0.x.e0.l) && (lVar = (d.a.j0.x.e0.l) this.f50864c.get(i3)) != null && (a2Var = lVar.f62455e) != null && str.equals(a2Var.o0())) {
                i7 = ((d.a.j0.x.e0.l) this.f50864c.get(i3)).position;
                z = true;
            }
            i3++;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.h(str);
        int i8 = i7 - i4;
        bVar.e(i8 >= -1 ? i8 : -1);
        bVar.g(i6);
        bVar.f(i2);
        return bVar;
    }

    public final void j(Context context) {
        this.f50866e = new d.a.j0.a1.g.h.a(this.f50865d);
        this.f50867f = new z(this.f50865d);
        this.f50868g = new d.a.j0.a1.g.h.b(this.f50865d, d.a.j0.a1.g.j.f.f50945f);
        this.f50869h = new n(this.f50865d, d.a.j0.x.e0.k.l0);
        this.f50870i = new x(this.f50865d, d.a.j0.x.e0.k.v0);
        this.j = new h(this.f50865d, d.a.j0.x.e0.k.C0);
        this.k = new i(this.f50865d, d.a.j0.x.e0.k.w0);
        this.l = new j(this.f50865d, d.a.j0.x.e0.k.D0);
        this.m = new r(this.f50865d, d.a.j0.x.e0.k.B0);
        this.n = new k(this.f50865d, d.a.j0.x.e0.k.E0);
        this.o = new o(this.f50865d, d.a.j0.x.e0.k.K0);
        this.p = new m(this.f50865d, d.a.j0.x.e0.k.L0);
        this.q = new g(this.f50865d, d.a.j0.x.e0.k.x0);
        this.r = new d.a.j0.a1.g.h.f(this.f50865d, d.a.j0.x.e0.k.y0);
        this.s = new d.a.j0.a1.g.h.e(this.f50865d, d.a.j0.x.e0.k.z0);
        this.t = new y(this.f50865d, d.a.j0.x.e0.l.V);
        this.v = new l(this.f50865d, d.a.j0.x.e0.k.n0);
        this.w = new HomePageAlaLiveThreadAdapter(this.f50865d, d.a.j0.x.e0.j.M0);
        this.x = new HomePageAlaFriendRoomAdapter(this.f50865d, d.a.j0.x.e0.j.N0);
        this.y = new v(this.f50865d, d.a.j0.x.e0.k.o0);
        this.z = new u(this.f50865d, d.a.j0.x.e0.k.p0);
        this.A = new w(this.f50865d, d.a.j0.x.e0.k.r0);
        this.B = new t(this.f50865d, d.a.j0.x.e0.k.q0);
        this.C = new n(this.f50865d, d.a.j0.x.e0.k.m0);
        this.D = new p(this.f50865d, d.a.j0.x.e0.k.s0);
        this.E = new q(this.f50865d, d.a.j0.x.e0.k.t0);
        this.F = new s(this.f50865d, d.a.j0.a1.j.b.c.a.d0);
        this.G = new d.a.j0.a1.g.h.c(this.f50865d, d.a.j0.x.e0.e.M0);
        this.u = new d.a.j0.a1.g.h.d(this.f50865d, d.a.j0.x.e0.k.A0);
        this.H = new d.a.j0.a1.b.e.z(this.f50865d, d.a.j0.x.e0.k.u0, (byte) 3);
        this.f50862a.add(this.f50866e);
        this.f50862a.add(this.f50867f);
        this.f50862a.add(this.f50868g);
        this.f50862a.add(this.f50869h);
        this.f50862a.add(this.f50870i);
        this.f50862a.add(this.j);
        this.f50862a.add(this.k);
        this.f50862a.add(this.l);
        this.f50862a.add(this.m);
        this.f50862a.add(this.n);
        this.f50862a.add(this.o);
        this.f50862a.add(this.p);
        this.f50862a.add(this.q);
        this.f50862a.add(this.r);
        this.f50862a.add(this.s);
        this.f50862a.add(this.t);
        this.f50862a.add(this.v);
        this.f50862a.add(this.C);
        this.f50862a.add(new ReadProgessDelegetAdapter(this.f50865d, d.a.j0.a1.g.l.b.f50977g));
        this.f50862a.add(this.w);
        this.f50862a.add(this.x);
        this.f50862a.add(this.y);
        this.f50862a.add(this.z);
        this.f50862a.add(this.B);
        this.f50862a.add(this.A);
        this.f50862a.add(new a0(this.f50865d, d.a.j0.a1.g.j.h.f50947i));
        this.f50862a.add(this.D);
        this.f50862a.add(this.E);
        this.f50862a.add(this.F);
        this.f50862a.add(this.G);
        this.f50862a.add(this.u);
        this.f50862a.add(this.H);
        e();
        k();
        r("page_recommend");
    }

    public final void k() {
        if (!a2.u3.get()) {
            AdvertAppInfo.t4.set(false);
            return;
        }
        this.I = d.a.j0.s2.w.p().l(this.f50865d, AdvertAppInfo.j4, "INDEX");
        this.J = d.a.j0.s2.w.p().l(this.f50865d, AdvertAppInfo.k4, "INDEX");
        this.K = d.a.j0.s2.w.p().l(this.f50865d, AdvertAppInfo.o4, "INDEX");
        this.L = d.a.j0.s2.w.p().l(this.f50865d, AdvertAppInfo.p4, "INDEX");
        this.M = d.a.j0.s2.w.p().l(this.f50865d, AdvertAppInfo.q4, "INDEX");
        this.N = d.a.j0.s2.w.p().l(this.f50865d, AdvertAppInfo.s4, "INDEX");
        this.O = d.a.j0.s2.w.p().l(this.f50865d, AdvertAppInfo.r4, "INDEX");
        this.f50862a.add(this.I);
        this.f50862a.add(this.J);
        this.f50862a.add(this.K);
        this.f50862a.add(this.L);
        this.f50862a.add(this.M);
        this.f50862a.add(this.N);
        this.f50862a.add(this.O);
        if (this.f50865d.getPageActivity() instanceof BaseFragmentActivity) {
            this.f50862a.add(d.a.j0.r0.b.e().c((BaseFragmentActivity) this.f50865d.getPageActivity(), AdvertAppInfo.n4));
            this.f50862a.add(d.a.j0.r0.b.e().c((BaseFragmentActivity) this.f50865d.getPageActivity(), AdvertAppInfo.m4));
        }
        AdvertAppInfo.t4.set(true);
    }

    public final boolean l(d.a.c.j.e.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof d.a.j0.a1.g.j.a) && (advertAppInfo = ((d.a.j0.a1.g.j.a) nVar).f62460e) != null && advertAppInfo.E4() == 0;
    }

    public void m() {
        d.a.c.j.e.s sVar = this.f50863b;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        m();
        this.f50866e.e0(i2);
    }

    public void o() {
    }

    public void p() {
        y yVar = this.t;
        if (yVar != null) {
            yVar.onPause();
        }
    }

    public void q() {
        y yVar = this.t;
        if (yVar != null) {
            yVar.onResume();
        }
        m();
    }

    public final void r(String str) {
        List<d.a.c.j.e.a> list = this.f50862a;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.j0.m.f) {
                ((d.a.j0.m.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        for (d.a.c.j.e.a aVar2 : this.f50862a) {
            if (aVar2 instanceof d.a.j0.a1.a) {
                ((d.a.j0.a1.a) aVar2).e0(aVar);
            }
        }
    }

    public void t(boolean z) {
        n nVar = this.f50869h;
        if (nVar != null) {
            nVar.setFromCDN(z);
            this.C.setFromCDN(z);
            this.v.setFromCDN(z);
            this.y.setFromCDN(z);
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.setFromCDN(z);
        }
        d.a.j0.a1.g.h.d dVar = this.u;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
        d.a.c.j.e.a aVar = this.J;
        if (aVar == null || !(aVar instanceof d.a.j0.s2.s)) {
            return;
        }
        ((d.a.j0.s2.s) aVar).j(z);
    }

    public void u(NEGFeedBackView.b bVar) {
        n nVar = this.f50869h;
        if (nVar != null) {
            nVar.q0(bVar);
        }
        r rVar = this.m;
        if (rVar != null) {
            rVar.n0(bVar);
        }
        i iVar = this.k;
        if (iVar != null) {
            iVar.m0(bVar);
        }
        l lVar = this.v;
        if (lVar != null) {
            lVar.j0(bVar);
        }
        HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.w;
        if (homePageAlaLiveThreadAdapter != null) {
            homePageAlaLiveThreadAdapter.j0(bVar);
        }
        HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.x;
        if (homePageAlaFriendRoomAdapter != null) {
            homePageAlaFriendRoomAdapter.j0(bVar);
        }
        v vVar = this.y;
        if (vVar != null) {
            vVar.j0(bVar);
        }
        u uVar = this.z;
        if (uVar != null) {
            uVar.r0(bVar);
        }
        t tVar = this.B;
        if (tVar != null) {
            tVar.n0(bVar);
        }
        w wVar = this.A;
        if (wVar != null) {
            wVar.p0(bVar);
        }
        n nVar2 = this.C;
        if (nVar2 != null) {
            nVar2.q0(bVar);
        }
        p pVar = this.D;
        if (pVar != null) {
            pVar.p0(bVar);
        }
        q qVar = this.E;
        if (qVar != null) {
            qVar.n0(bVar);
        }
        s sVar = this.F;
        if (sVar != null) {
            sVar.h0(bVar);
        }
        d.a.j0.a1.g.h.c cVar = this.G;
        if (cVar != null) {
            cVar.n0(bVar);
        }
    }

    public void v(f fVar) {
        this.S = fVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        d.a.j0.a1.g.h.b bVar = this.f50868g;
        if (bVar != null) {
            bVar.g0(bdUniqueId);
        }
        n nVar = this.f50869h;
        if (nVar != null) {
            nVar.n = bdUniqueId;
        }
        x xVar = this.f50870i;
        if (xVar != null) {
            xVar.n = bdUniqueId;
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.m = bdUniqueId;
        }
        i iVar = this.k;
        if (iVar != null) {
            iVar.m = bdUniqueId;
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.m = bdUniqueId;
        }
        r rVar = this.m;
        if (rVar != null) {
            rVar.m = bdUniqueId;
        }
        k kVar = this.n;
        if (kVar != null) {
            kVar.m = bdUniqueId;
        }
        o oVar = this.o;
        if (oVar != null) {
            oVar.m = bdUniqueId;
        }
        m mVar = this.p;
        if (mVar != null) {
            mVar.m = bdUniqueId;
        }
        g gVar = this.q;
        if (gVar != null) {
            gVar.m = bdUniqueId;
        }
        d.a.j0.a1.g.h.f fVar = this.r;
        if (fVar != null) {
            fVar.m = bdUniqueId;
        }
        d.a.j0.a1.g.h.e eVar = this.s;
        if (eVar != null) {
            eVar.m = bdUniqueId;
        }
        l lVar = this.v;
        if (lVar != null) {
            lVar.n = bdUniqueId;
        }
        y yVar = this.t;
        if (yVar != null) {
            yVar.m = bdUniqueId;
        }
        d.a.j0.a1.g.h.a aVar = this.f50866e;
        if (aVar != null) {
            aVar.h0(bdUniqueId);
        }
        HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.w;
        if (homePageAlaLiveThreadAdapter != null) {
            homePageAlaLiveThreadAdapter.m = bdUniqueId;
        }
        HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.x;
        if (homePageAlaFriendRoomAdapter != null) {
            homePageAlaFriendRoomAdapter.m = bdUniqueId;
        }
        v vVar = this.y;
        if (vVar != null) {
            vVar.n = bdUniqueId;
        }
        u uVar = this.z;
        if (uVar != null) {
            uVar.n = bdUniqueId;
        }
        t tVar = this.B;
        if (tVar != null) {
            tVar.n = bdUniqueId;
        }
        w wVar = this.A;
        if (wVar != null) {
            wVar.n = bdUniqueId;
        }
        n nVar2 = this.C;
        if (nVar2 != null) {
            nVar2.n = bdUniqueId;
        }
        p pVar = this.D;
        if (pVar != null) {
            pVar.m = bdUniqueId;
        }
        q qVar = this.E;
        if (qVar != null) {
            qVar.m = bdUniqueId;
        }
        s sVar = this.F;
        if (sVar != null) {
            sVar.m = bdUniqueId;
        }
        d.a.j0.a1.g.h.c cVar = this.G;
        if (cVar != null) {
            cVar.n = bdUniqueId;
        }
        d.a.j0.a1.g.h.d dVar = this.u;
        if (dVar != null) {
            dVar.m = bdUniqueId;
        }
        d.a.j0.a1.b.e.z zVar = this.H;
        if (zVar != null) {
            zVar.n = bdUniqueId;
        }
        if (!ListUtils.isEmpty(this.P)) {
            for (d.a.c.j.e.a aVar2 : this.P) {
                if (aVar2 instanceof d.a.j0.j1.o.g.a) {
                    ((d.a.j0.j1.o.g.a) aVar2).setUniqueId(bdUniqueId);
                }
            }
        }
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
        this.V.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.V);
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        if (this.R) {
            return;
        }
        this.T.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.T);
    }

    public void x(d.a.j0.a1.g.k.e eVar) {
        this.f50869h.r0(eVar);
        this.f50870i.p0(eVar);
        this.j.n0(eVar);
        this.l.n0(eVar);
        this.m.p0(eVar);
        this.q.n0(eVar);
        this.r.n0(eVar);
        this.s.n0(eVar);
        this.t.r0(eVar);
        this.u.p0(eVar);
    }

    public final void y(d.a.c.j.e.s sVar) {
        this.f50870i.q0(sVar);
        this.j.p0(sVar);
        this.k.n0(sVar);
        this.l.p0(sVar);
        this.m.q0(sVar);
        this.n.g0(sVar);
        this.o.h0(sVar);
        this.p.g0(sVar);
        this.q.p0(sVar);
        this.r.p0(sVar);
        this.s.p0(sVar);
        this.u.q0(sVar);
        this.t.t0(sVar);
        this.G.p0(sVar);
        this.z.t0(sVar);
        this.z.t0(sVar);
        this.B.p0(sVar);
        this.H.g0(sVar);
    }

    public void z(List<d.a.c.j.e.n> list) {
        d.a.j0.d3.v.f(list, 2);
        this.f50863b.setData(list);
        this.f50864c = list;
        f fVar = this.S;
        if (fVar != null) {
            fVar.a();
        }
    }
}
