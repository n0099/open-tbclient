package d.a.k0.a1.g.h;

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
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c0 {
    public v A;
    public x B;
    public u C;
    public n D;
    public q E;
    public r F;
    public t G;
    public d.a.k0.a1.g.h.c H;
    public d.a.k0.a1.b.e.z I;
    public d.a.c.j.e.a J;
    public d.a.c.j.e.a K;
    public d.a.c.j.e.a L;
    public d.a.c.j.e.a M;
    public d.a.c.j.e.a N;
    public d.a.c.j.e.a O;
    public d.a.c.j.e.a P;
    public List<d.a.c.j.e.a> Q;
    public boolean R;
    public boolean S;
    public f T;
    public CustomMessageListener U = new a(2016470);
    public CustomMessageListener V = new b(2001115);
    public CustomMessageListener W = new c(2001335);
    public CustomMessageListener X = new d(2001336);
    public CustomMessageListener Y = new e(2921394);

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51561a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.j.e.s f51562b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.n> f51563c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f51564d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.a1.g.h.a f51565e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f51566f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.a1.g.h.b f51567g;

    /* renamed from: h  reason: collision with root package name */
    public n f51568h;

    /* renamed from: i  reason: collision with root package name */
    public y f51569i;
    public h j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public g r;
    public d.a.k0.a1.g.h.f s;
    public d.a.k0.a1.g.h.e t;
    public z u;
    public d.a.k0.a1.g.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

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
            c0.this.f();
            if (c0.this.f51563c != null) {
                c0 c0Var = c0.this;
                c0Var.z(c0Var.f51563c);
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
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12666a) {
                return;
            }
            c0.this.g(updateAttentionMessage.getData());
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
            d.a.k0.j1.p.b bVar = new d.a.k0.j1.p.b();
            bVar.f56559a = String.valueOf(customResponsedMessage.getData());
            bVar.f56560b = true;
            c0.this.g(bVar);
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
            d.a.k0.j1.p.b bVar = new d.a.k0.j1.p.b();
            bVar.f56559a = String.valueOf(customResponsedMessage.getData());
            bVar.f56560b = false;
            c0.this.g(bVar);
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
            if (StringUtils.isNull(str, true) || (i2 = c0.this.i(str)) == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, i2));
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public c0(Context context, d.a.c.j.e.s sVar) {
        this.f51562b = sVar;
        this.f51564d = (TbPageContext) d.a.c.a.j.a(context);
        j(context);
        y(sVar);
        sVar.a(this.f51561a);
    }

    public void A(List<d.a.c.j.e.n> list, int i2) {
        d.a.k0.d3.v.f(list, 2);
        ViewGroup listView = this.f51562b.getListView();
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
        this.f51562b.setData(list);
        this.f51563c = list;
        f fVar = this.T;
        if (fVar != null) {
            fVar.a();
        }
    }

    public final void e() {
        this.S = f();
    }

    public final boolean f() {
        BdUniqueId bdUniqueId;
        List<d.a.c.j.e.a> list = this.Q;
        if (list == null || list.size() <= 0) {
            this.Q = new ArrayList();
            ArrayList<BdUniqueId> g2 = d.a.k0.d3.v.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.k0.j1.o.g.a b2 = d.a.k0.j1.r.b.d().b(this.f51564d, g2.get(i2), 2);
                if (this.R) {
                    b2.e0(3);
                }
                n nVar = this.f51568h;
                if (nVar != null && (bdUniqueId = nVar.n) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.Q.add(b2);
            }
            this.f51562b.a(this.Q);
            return true;
        }
        return true;
    }

    public final void g(Object obj) {
        List<d.a.c.j.e.n> list = this.f51563c;
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
        return this.f51563c;
    }

    public final d.a.d.m.e.b i(String str) {
        int i2;
        d.a.k0.x.e0.l lVar;
        a2 a2Var;
        List<d.a.c.j.e.n> list = this.f51563c;
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
            if (i3 >= this.f51563c.size()) {
                i2 = -1;
                break;
            }
            if (this.f51563c.get(i3) instanceof d.a.k0.a1.g.j.h) {
                i4++;
            }
            if (this.f51563c.get(i3) instanceof d.a.k0.a1.g.j.a) {
                if (l(this.f51563c.get(i3))) {
                    if (z) {
                        i2 = ((d.a.k0.a1.g.j.a) this.f51563c.get(i3)).position;
                        break;
                    }
                    i6 = ((d.a.k0.a1.g.j.a) this.f51563c.get(i3)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.f51563c.get(i3) instanceof d.a.k0.x.e0.l) && (lVar = (d.a.k0.x.e0.l) this.f51563c.get(i3)) != null && (a2Var = lVar.f63179e) != null && str.equals(a2Var.o0())) {
                i7 = ((d.a.k0.x.e0.l) this.f51563c.get(i3)).position;
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
        this.f51565e = new d.a.k0.a1.g.h.a(this.f51564d);
        this.f51566f = new a0(this.f51564d);
        this.f51567g = new d.a.k0.a1.g.h.b(this.f51564d, d.a.k0.a1.g.j.f.f51644f);
        this.f51568h = new n(this.f51564d, d.a.k0.x.e0.k.m0);
        this.f51569i = new y(this.f51564d, d.a.k0.x.e0.k.w0);
        this.j = new h(this.f51564d, d.a.k0.x.e0.k.D0);
        this.k = new i(this.f51564d, d.a.k0.x.e0.k.x0);
        this.l = new j(this.f51564d, d.a.k0.x.e0.k.E0);
        this.m = new s(this.f51564d, d.a.k0.x.e0.k.C0);
        this.n = new k(this.f51564d, d.a.k0.x.e0.k.K0);
        this.o = new p(this.f51564d, d.a.k0.x.e0.k.L0);
        this.p = new m(this.f51564d, d.a.k0.x.e0.k.M0);
        this.q = new o(this.f51564d, d.a.k0.x.e0.k.N0);
        this.r = new g(this.f51564d, d.a.k0.x.e0.k.y0);
        this.s = new d.a.k0.a1.g.h.f(this.f51564d, d.a.k0.x.e0.k.z0);
        this.t = new d.a.k0.a1.g.h.e(this.f51564d, d.a.k0.x.e0.k.A0);
        this.u = new z(this.f51564d, d.a.k0.x.e0.l.W);
        this.w = new l(this.f51564d, d.a.k0.x.e0.k.o0);
        this.x = new HomePageAlaLiveThreadAdapter(this.f51564d, d.a.k0.x.e0.j.O0);
        this.y = new HomePageAlaFriendRoomAdapter(this.f51564d, d.a.k0.x.e0.j.P0);
        this.z = new w(this.f51564d, d.a.k0.x.e0.k.p0);
        this.A = new v(this.f51564d, d.a.k0.x.e0.k.q0);
        this.B = new x(this.f51564d, d.a.k0.x.e0.k.s0);
        this.C = new u(this.f51564d, d.a.k0.x.e0.k.r0);
        this.D = new n(this.f51564d, d.a.k0.x.e0.k.n0);
        this.E = new q(this.f51564d, d.a.k0.x.e0.k.t0);
        this.F = new r(this.f51564d, d.a.k0.x.e0.k.u0);
        this.G = new t(this.f51564d, d.a.k0.a1.j.b.c.a.e0);
        this.H = new d.a.k0.a1.g.h.c(this.f51564d, d.a.k0.x.e0.e.O0);
        this.v = new d.a.k0.a1.g.h.d(this.f51564d, d.a.k0.x.e0.k.B0);
        this.I = new d.a.k0.a1.b.e.z(this.f51564d, d.a.k0.x.e0.k.v0, (byte) 3);
        this.f51561a.add(this.f51565e);
        this.f51561a.add(this.f51566f);
        this.f51561a.add(this.f51567g);
        this.f51561a.add(this.f51568h);
        this.f51561a.add(this.f51569i);
        this.f51561a.add(this.j);
        this.f51561a.add(this.k);
        this.f51561a.add(this.l);
        this.f51561a.add(this.m);
        this.f51561a.add(this.n);
        this.f51561a.add(this.o);
        this.f51561a.add(this.p);
        this.f51561a.add(this.q);
        this.f51561a.add(this.r);
        this.f51561a.add(this.s);
        this.f51561a.add(this.t);
        this.f51561a.add(this.u);
        this.f51561a.add(this.w);
        this.f51561a.add(this.D);
        this.f51561a.add(new ReadProgessDelegetAdapter(this.f51564d, d.a.k0.a1.g.l.b.f51676g));
        this.f51561a.add(this.x);
        this.f51561a.add(this.y);
        this.f51561a.add(this.z);
        this.f51561a.add(this.A);
        this.f51561a.add(this.C);
        this.f51561a.add(this.B);
        this.f51561a.add(new b0(this.f51564d, d.a.k0.a1.g.j.h.f51646i));
        this.f51561a.add(this.E);
        this.f51561a.add(this.F);
        this.f51561a.add(this.G);
        this.f51561a.add(this.H);
        this.f51561a.add(this.v);
        this.f51561a.add(this.I);
        e();
        k();
        r("page_recommend");
    }

    public final void k() {
        if (!a2.v3.get()) {
            AdvertAppInfo.Y3.set(false);
            return;
        }
        this.J = d.a.k0.s2.x.p().l(this.f51564d, AdvertAppInfo.b4, "INDEX");
        this.K = d.a.k0.s2.x.p().l(this.f51564d, AdvertAppInfo.c4, "INDEX");
        this.L = d.a.k0.s2.x.p().l(this.f51564d, AdvertAppInfo.d4, "INDEX");
        this.M = d.a.k0.s2.x.p().l(this.f51564d, AdvertAppInfo.e4, "INDEX");
        this.N = d.a.k0.s2.x.p().l(this.f51564d, AdvertAppInfo.f4, "INDEX");
        this.O = d.a.k0.s2.x.p().l(this.f51564d, AdvertAppInfo.h4, "INDEX");
        this.P = d.a.k0.s2.x.p().l(this.f51564d, AdvertAppInfo.g4, "INDEX");
        this.f51561a.add(this.J);
        this.f51561a.add(this.K);
        this.f51561a.add(this.L);
        this.f51561a.add(this.M);
        this.f51561a.add(this.N);
        this.f51561a.add(this.O);
        this.f51561a.add(this.P);
        if (this.f51564d.getPageActivity() instanceof BaseFragmentActivity) {
            this.f51561a.add(d.a.k0.r0.b.e().c((BaseFragmentActivity) this.f51564d.getPageActivity(), AdvertAppInfo.k4));
            this.f51561a.add(d.a.k0.r0.b.e().c((BaseFragmentActivity) this.f51564d.getPageActivity(), AdvertAppInfo.j4));
        }
        AdvertAppInfo.Y3.set(true);
    }

    public final boolean l(d.a.c.j.e.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof d.a.k0.a1.g.j.a) && (advertAppInfo = ((d.a.k0.a1.g.j.a) nVar).f63184e) != null && advertAppInfo.G4() == 0;
    }

    public void m() {
        d.a.c.j.e.s sVar = this.f51562b;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        m();
        this.f51565e.e0(i2);
    }

    public void o() {
    }

    public void p() {
        z zVar = this.u;
        if (zVar != null) {
            zVar.onPause();
        }
    }

    public void q() {
        z zVar = this.u;
        if (zVar != null) {
            zVar.onResume();
        }
        m();
    }

    public final void r(String str) {
        List<d.a.c.j.e.a> list = this.f51561a;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.k0.m.f) {
                ((d.a.k0.m.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        for (d.a.c.j.e.a aVar2 : this.f51561a) {
            if (aVar2 instanceof d.a.k0.a1.a) {
                ((d.a.k0.a1.a) aVar2).e0(aVar);
            }
        }
    }

    public void t(boolean z) {
        n nVar = this.f51568h;
        if (nVar != null) {
            nVar.setFromCDN(z);
            this.D.setFromCDN(z);
            this.w.setFromCDN(z);
            this.z.setFromCDN(z);
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.setFromCDN(z);
        }
        d.a.k0.a1.g.h.d dVar = this.v;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
        d.a.c.j.e.a aVar = this.K;
        if (aVar == null || !(aVar instanceof d.a.k0.s2.t)) {
            return;
        }
        ((d.a.k0.s2.t) aVar).j(z);
    }

    public void u(NEGFeedBackView.b bVar) {
        n nVar = this.f51568h;
        if (nVar != null) {
            nVar.q0(bVar);
        }
        s sVar = this.m;
        if (sVar != null) {
            sVar.n0(bVar);
        }
        i iVar = this.k;
        if (iVar != null) {
            iVar.m0(bVar);
        }
        l lVar = this.w;
        if (lVar != null) {
            lVar.j0(bVar);
        }
        HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
        if (homePageAlaLiveThreadAdapter != null) {
            homePageAlaLiveThreadAdapter.j0(bVar);
        }
        HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
        if (homePageAlaFriendRoomAdapter != null) {
            homePageAlaFriendRoomAdapter.j0(bVar);
        }
        w wVar = this.z;
        if (wVar != null) {
            wVar.j0(bVar);
        }
        v vVar = this.A;
        if (vVar != null) {
            vVar.s0(bVar);
        }
        u uVar = this.C;
        if (uVar != null) {
            uVar.n0(bVar);
        }
        x xVar = this.B;
        if (xVar != null) {
            xVar.p0(bVar);
        }
        n nVar2 = this.D;
        if (nVar2 != null) {
            nVar2.q0(bVar);
        }
        q qVar = this.E;
        if (qVar != null) {
            qVar.p0(bVar);
        }
        r rVar = this.F;
        if (rVar != null) {
            rVar.n0(bVar);
        }
        t tVar = this.G;
        if (tVar != null) {
            tVar.h0(bVar);
        }
        d.a.k0.a1.g.h.c cVar = this.H;
        if (cVar != null) {
            cVar.n0(bVar);
        }
    }

    public void v(f fVar) {
        this.T = fVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        d.a.k0.a1.g.h.b bVar = this.f51567g;
        if (bVar != null) {
            bVar.g0(bdUniqueId);
        }
        n nVar = this.f51568h;
        if (nVar != null) {
            nVar.n = bdUniqueId;
        }
        y yVar = this.f51569i;
        if (yVar != null) {
            yVar.n = bdUniqueId;
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
        s sVar = this.m;
        if (sVar != null) {
            sVar.m = bdUniqueId;
        }
        k kVar = this.n;
        if (kVar != null) {
            kVar.m = bdUniqueId;
        }
        p pVar = this.o;
        if (pVar != null) {
            pVar.m = bdUniqueId;
        }
        m mVar = this.p;
        if (mVar != null) {
            mVar.m = bdUniqueId;
        }
        o oVar = this.q;
        if (oVar != null) {
            oVar.m = bdUniqueId;
        }
        g gVar = this.r;
        if (gVar != null) {
            gVar.m = bdUniqueId;
        }
        d.a.k0.a1.g.h.f fVar = this.s;
        if (fVar != null) {
            fVar.m = bdUniqueId;
        }
        d.a.k0.a1.g.h.e eVar = this.t;
        if (eVar != null) {
            eVar.m = bdUniqueId;
        }
        l lVar = this.w;
        if (lVar != null) {
            lVar.n = bdUniqueId;
        }
        z zVar = this.u;
        if (zVar != null) {
            zVar.m = bdUniqueId;
        }
        d.a.k0.a1.g.h.a aVar = this.f51565e;
        if (aVar != null) {
            aVar.h0(bdUniqueId);
        }
        HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
        if (homePageAlaLiveThreadAdapter != null) {
            homePageAlaLiveThreadAdapter.m = bdUniqueId;
        }
        HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
        if (homePageAlaFriendRoomAdapter != null) {
            homePageAlaFriendRoomAdapter.m = bdUniqueId;
        }
        w wVar = this.z;
        if (wVar != null) {
            wVar.n = bdUniqueId;
        }
        v vVar = this.A;
        if (vVar != null) {
            vVar.n = bdUniqueId;
        }
        u uVar = this.C;
        if (uVar != null) {
            uVar.n = bdUniqueId;
        }
        x xVar = this.B;
        if (xVar != null) {
            xVar.n = bdUniqueId;
        }
        n nVar2 = this.D;
        if (nVar2 != null) {
            nVar2.n = bdUniqueId;
        }
        q qVar = this.E;
        if (qVar != null) {
            qVar.m = bdUniqueId;
        }
        r rVar = this.F;
        if (rVar != null) {
            rVar.m = bdUniqueId;
        }
        t tVar = this.G;
        if (tVar != null) {
            tVar.m = bdUniqueId;
        }
        d.a.k0.a1.g.h.c cVar = this.H;
        if (cVar != null) {
            cVar.n = bdUniqueId;
        }
        d.a.k0.a1.g.h.d dVar = this.v;
        if (dVar != null) {
            dVar.m = bdUniqueId;
        }
        d.a.k0.a1.b.e.z zVar2 = this.I;
        if (zVar2 != null) {
            zVar2.n = bdUniqueId;
        }
        if (!ListUtils.isEmpty(this.Q)) {
            for (d.a.c.j.e.a aVar2 : this.Q) {
                if (aVar2 instanceof d.a.k0.j1.o.g.a) {
                    ((d.a.k0.j1.o.g.a) aVar2).setUniqueId(bdUniqueId);
                }
            }
        }
        this.V.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.V);
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
        if (this.S) {
            return;
        }
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
    }

    public void x(d.a.k0.a1.g.k.e eVar) {
        this.f51568h.s0(eVar);
        this.f51569i.p0(eVar);
        this.j.n0(eVar);
        this.l.n0(eVar);
        this.m.p0(eVar);
        this.q.m0(eVar);
        this.r.n0(eVar);
        this.s.n0(eVar);
        this.t.n0(eVar);
        this.u.s0(eVar);
        this.v.p0(eVar);
    }

    public final void y(d.a.c.j.e.s sVar) {
        this.f51569i.q0(sVar);
        this.j.p0(sVar);
        this.k.n0(sVar);
        this.l.p0(sVar);
        this.m.q0(sVar);
        this.n.g0(sVar);
        this.o.h0(sVar);
        this.p.g0(sVar);
        this.q.n0(sVar);
        this.r.p0(sVar);
        this.s.p0(sVar);
        this.t.p0(sVar);
        this.v.q0(sVar);
        this.u.t0(sVar);
        this.H.p0(sVar);
        this.A.t0(sVar);
        this.A.t0(sVar);
        this.C.p0(sVar);
        this.I.g0(sVar);
    }

    public void z(List<d.a.c.j.e.n> list) {
        d.a.k0.d3.v.f(list, 2);
        this.f51562b.setData(list);
        this.f51563c = list;
        f fVar = this.T;
        if (fVar != null) {
            fVar.a();
        }
    }
}
