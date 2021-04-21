package d.b.j0.a1.g.h;

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
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import d.b.i0.r.q.a2;
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
    public d.b.j0.a1.g.h.c G;
    public d.b.j0.a1.b.e.z H;
    public d.b.c.j.e.a I;
    public d.b.c.j.e.a J;
    public d.b.c.j.e.a K;
    public d.b.c.j.e.a L;
    public d.b.c.j.e.a M;
    public d.b.c.j.e.a N;
    public d.b.c.j.e.a O;
    public List<d.b.c.j.e.a> P;
    public boolean Q;
    public boolean R;
    public f S;
    public CustomMessageListener T = new a(2016470);
    public CustomMessageListener U = new b(2001115);
    public CustomMessageListener V = new c(2001335);
    public CustomMessageListener W = new d(2001336);
    public CustomMessageListener X = new e(2921394);

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53148a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public d.b.c.j.e.s f53149b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.n> f53150c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f53151d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.a1.g.h.a f53152e;

    /* renamed from: f  reason: collision with root package name */
    public z f53153f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.a1.g.h.b f53154g;

    /* renamed from: h  reason: collision with root package name */
    public n f53155h;
    public x i;
    public h j;
    public i k;
    public j l;
    public r m;
    public k n;
    public o o;
    public m p;
    public g q;
    public d.b.j0.a1.g.h.f r;
    public d.b.j0.a1.g.h.e s;
    public y t;
    public d.b.j0.a1.g.h.d u;
    public l v;
    public HomePageAlaLiveThreadAdapter w;
    public HomePageAlaFriendRoomAdapter x;
    public v y;
    public u z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            b0.this.f();
            if (b0.this.f53150c != null) {
                b0 b0Var = b0.this;
                b0Var.z(b0Var.f53150c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f13362a) {
                return;
            }
            b0.this.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.b.j0.j1.p.b bVar = new d.b.j0.j1.p.b();
            bVar.f57881a = String.valueOf(customResponsedMessage.getData());
            bVar.f57882b = true;
            b0.this.g(bVar);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.b.j0.j1.p.b bVar = new d.b.j0.j1.p.b();
            bVar.f57881a = String.valueOf(customResponsedMessage.getData());
            bVar.f57882b = false;
            b0.this.g(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.d.m.e.b i;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str, true) || (i = b0.this.i(str)) == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, i));
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public b0(Context context, d.b.c.j.e.s sVar) {
        this.f53149b = sVar;
        this.f53151d = (TbPageContext) d.b.c.a.j.a(context);
        j(context);
        y(sVar);
        sVar.a(this.f53148a);
    }

    public void A(List<d.b.c.j.e.n> list, int i) {
        d.b.j0.d3.v.f(list, 2);
        ViewGroup listView = this.f53149b.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
            int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
            View childAt = bdRecyclerView.getChildAt(0);
            int top = childAt != null ? childAt.getTop() : 0;
            RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                bdRecyclerView.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                bdRecyclerView.A();
            }
        }
        this.f53149b.setData(list);
        this.f53150c = list;
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
        List<d.b.c.j.e.a> list = this.P;
        if (list == null || list.size() <= 0) {
            this.P = new ArrayList();
            ArrayList<BdUniqueId> g2 = d.b.j0.d3.v.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i = 0; i < size; i++) {
                d.b.j0.j1.o.g.a c2 = d.b.j0.j1.r.b.d().c(this.f53151d, g2.get(i), 2);
                if (this.Q) {
                    c2.h0(3);
                }
                n nVar = this.f53155h;
                if (nVar != null && (bdUniqueId = nVar.n) != null) {
                    c2.setUniqueId(bdUniqueId);
                }
                this.P.add(c2);
            }
            this.f53149b.a(this.P);
            return true;
        }
        return true;
    }

    public final void g(Object obj) {
        List<d.b.c.j.e.n> list = this.f53150c;
        if (list != null) {
            boolean z = false;
            for (d.b.c.j.e.n nVar : list) {
                if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                m();
            }
        }
    }

    public List<d.b.c.j.e.n> h() {
        return this.f53150c;
    }

    public final d.b.d.m.e.b i(String str) {
        int i;
        d.b.j0.x.e0.l lVar;
        a2 a2Var;
        List<d.b.c.j.e.n> list = this.f53150c;
        if (list == null || list.isEmpty() || str == null) {
            return null;
        }
        d.b.d.m.e.b bVar = new d.b.d.m.e.b();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= this.f53150c.size()) {
                i = -1;
                break;
            }
            if (this.f53150c.get(i2) instanceof d.b.j0.a1.g.j.h) {
                i3++;
            }
            if (this.f53150c.get(i2) instanceof d.b.j0.a1.g.j.a) {
                if (l(this.f53150c.get(i2))) {
                    if (z) {
                        i = ((d.b.j0.a1.g.j.a) this.f53150c.get(i2)).position;
                        break;
                    }
                    i5 = ((d.b.j0.a1.g.j.a) this.f53150c.get(i2)).position;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.f53150c.get(i2) instanceof d.b.j0.x.e0.l) && (lVar = (d.b.j0.x.e0.l) this.f53150c.get(i2)) != null && (a2Var = lVar.f64193e) != null && str.equals(a2Var.o0())) {
                i6 = ((d.b.j0.x.e0.l) this.f53150c.get(i2)).position;
                z = true;
            }
            i2++;
        }
        if (i != -1 && (i = i - i4) < -1) {
            i = -1;
        }
        bVar.h(str);
        int i7 = i6 - i3;
        bVar.e(i7 >= -1 ? i7 : -1);
        bVar.g(i5);
        bVar.f(i);
        return bVar;
    }

    public final void j(Context context) {
        this.f53152e = new d.b.j0.a1.g.h.a(this.f53151d);
        this.f53153f = new z(this.f53151d);
        this.f53154g = new d.b.j0.a1.g.h.b(this.f53151d, d.b.j0.a1.g.j.f.f53229f);
        this.f53155h = new n(this.f53151d, d.b.j0.x.e0.k.l0);
        this.i = new x(this.f53151d, d.b.j0.x.e0.k.v0);
        this.j = new h(this.f53151d, d.b.j0.x.e0.k.C0);
        this.k = new i(this.f53151d, d.b.j0.x.e0.k.w0);
        this.l = new j(this.f53151d, d.b.j0.x.e0.k.D0);
        this.m = new r(this.f53151d, d.b.j0.x.e0.k.B0);
        this.n = new k(this.f53151d, d.b.j0.x.e0.k.E0);
        this.o = new o(this.f53151d, d.b.j0.x.e0.k.K0);
        this.p = new m(this.f53151d, d.b.j0.x.e0.k.L0);
        this.q = new g(this.f53151d, d.b.j0.x.e0.k.x0);
        this.r = new d.b.j0.a1.g.h.f(this.f53151d, d.b.j0.x.e0.k.y0);
        this.s = new d.b.j0.a1.g.h.e(this.f53151d, d.b.j0.x.e0.k.z0);
        this.t = new y(this.f53151d, d.b.j0.x.e0.l.V);
        this.v = new l(this.f53151d, d.b.j0.x.e0.k.n0);
        this.w = new HomePageAlaLiveThreadAdapter(this.f53151d, d.b.j0.x.e0.j.M0);
        this.x = new HomePageAlaFriendRoomAdapter(this.f53151d, d.b.j0.x.e0.j.N0);
        this.y = new v(this.f53151d, d.b.j0.x.e0.k.o0);
        this.z = new u(this.f53151d, d.b.j0.x.e0.k.p0);
        this.A = new w(this.f53151d, d.b.j0.x.e0.k.r0);
        this.B = new t(this.f53151d, d.b.j0.x.e0.k.q0);
        this.C = new n(this.f53151d, d.b.j0.x.e0.k.m0);
        this.D = new p(this.f53151d, d.b.j0.x.e0.k.s0);
        this.E = new q(this.f53151d, d.b.j0.x.e0.k.t0);
        this.F = new s(this.f53151d, d.b.j0.a1.j.b.c.a.d0);
        this.G = new d.b.j0.a1.g.h.c(this.f53151d, d.b.j0.x.e0.e.M0);
        this.u = new d.b.j0.a1.g.h.d(this.f53151d, d.b.j0.x.e0.k.A0);
        this.H = new d.b.j0.a1.b.e.z(this.f53151d, d.b.j0.x.e0.k.u0, (byte) 3);
        this.f53148a.add(this.f53152e);
        this.f53148a.add(this.f53153f);
        this.f53148a.add(this.f53154g);
        this.f53148a.add(this.f53155h);
        this.f53148a.add(this.i);
        this.f53148a.add(this.j);
        this.f53148a.add(this.k);
        this.f53148a.add(this.l);
        this.f53148a.add(this.m);
        this.f53148a.add(this.n);
        this.f53148a.add(this.o);
        this.f53148a.add(this.p);
        this.f53148a.add(this.q);
        this.f53148a.add(this.r);
        this.f53148a.add(this.s);
        this.f53148a.add(this.t);
        this.f53148a.add(this.v);
        this.f53148a.add(this.C);
        this.f53148a.add(new ReadProgessDelegetAdapter(this.f53151d, d.b.j0.a1.g.l.b.f53259g));
        this.f53148a.add(this.w);
        this.f53148a.add(this.x);
        this.f53148a.add(this.y);
        this.f53148a.add(this.z);
        this.f53148a.add(this.B);
        this.f53148a.add(this.A);
        this.f53148a.add(new a0(this.f53151d, d.b.j0.a1.g.j.h.i));
        this.f53148a.add(this.D);
        this.f53148a.add(this.E);
        this.f53148a.add(this.F);
        this.f53148a.add(this.G);
        this.f53148a.add(this.u);
        this.f53148a.add(this.H);
        e();
        k();
        r("page_recommend");
    }

    public final void k() {
        if (!a2.u3.get()) {
            AdvertAppInfo.t4.set(false);
            return;
        }
        this.I = d.b.j0.s2.v.p().f(this.f53151d, AdvertAppInfo.j4, "INDEX");
        this.J = d.b.j0.s2.v.p().f(this.f53151d, AdvertAppInfo.k4, "INDEX");
        this.K = d.b.j0.s2.v.p().f(this.f53151d, AdvertAppInfo.o4, "INDEX");
        this.L = d.b.j0.s2.v.p().f(this.f53151d, AdvertAppInfo.p4, "INDEX");
        this.M = d.b.j0.s2.v.p().f(this.f53151d, AdvertAppInfo.q4, "INDEX");
        this.N = d.b.j0.s2.v.p().f(this.f53151d, AdvertAppInfo.s4, "INDEX");
        this.O = d.b.j0.s2.v.p().f(this.f53151d, AdvertAppInfo.r4, "INDEX");
        this.f53148a.add(this.I);
        this.f53148a.add(this.J);
        this.f53148a.add(this.K);
        this.f53148a.add(this.L);
        this.f53148a.add(this.M);
        this.f53148a.add(this.N);
        this.f53148a.add(this.O);
        if (this.f53151d.getPageActivity() instanceof BaseFragmentActivity) {
            this.f53148a.add(d.b.j0.r0.b.e().d((BaseFragmentActivity) this.f53151d.getPageActivity(), AdvertAppInfo.n4));
            this.f53148a.add(d.b.j0.r0.b.e().d((BaseFragmentActivity) this.f53151d.getPageActivity(), AdvertAppInfo.m4));
        }
        AdvertAppInfo.t4.set(true);
    }

    public final boolean l(d.b.c.j.e.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof d.b.j0.a1.g.j.a) && (advertAppInfo = ((d.b.j0.a1.g.j.a) nVar).f64197e) != null && advertAppInfo.E4() == 0;
    }

    public void m() {
        d.b.c.j.e.s sVar = this.f53149b;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i) {
        m();
        this.f53152e.h0(i);
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
        List<d.b.c.j.e.a> list = this.f53148a;
        if (list == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : list) {
            if (aVar instanceof d.b.j0.m.f) {
                ((d.b.j0.m.f) aVar).o(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        for (d.b.c.j.e.a aVar2 : this.f53148a) {
            if (aVar2 instanceof d.b.j0.a1.a) {
                ((d.b.j0.a1.a) aVar2).h0(aVar);
            }
        }
    }

    public void t(boolean z) {
        n nVar = this.f53155h;
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
        d.b.j0.a1.g.h.d dVar = this.u;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
        d.b.c.j.e.a aVar = this.J;
        if (aVar == null || !(aVar instanceof d.b.j0.s2.s)) {
            return;
        }
        ((d.b.j0.s2.s) aVar).c(z);
    }

    public void u(NEGFeedBackView.b bVar) {
        n nVar = this.f53155h;
        if (nVar != null) {
            nVar.r0(bVar);
        }
        r rVar = this.m;
        if (rVar != null) {
            rVar.p0(bVar);
        }
        i iVar = this.k;
        if (iVar != null) {
            iVar.o0(bVar);
        }
        l lVar = this.v;
        if (lVar != null) {
            lVar.n0(bVar);
        }
        HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.w;
        if (homePageAlaLiveThreadAdapter != null) {
            homePageAlaLiveThreadAdapter.n0(bVar);
        }
        HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.x;
        if (homePageAlaFriendRoomAdapter != null) {
            homePageAlaFriendRoomAdapter.n0(bVar);
        }
        v vVar = this.y;
        if (vVar != null) {
            vVar.n0(bVar);
        }
        u uVar = this.z;
        if (uVar != null) {
            uVar.s0(bVar);
        }
        t tVar = this.B;
        if (tVar != null) {
            tVar.p0(bVar);
        }
        w wVar = this.A;
        if (wVar != null) {
            wVar.q0(bVar);
        }
        n nVar2 = this.C;
        if (nVar2 != null) {
            nVar2.r0(bVar);
        }
        p pVar = this.D;
        if (pVar != null) {
            pVar.q0(bVar);
        }
        q qVar = this.E;
        if (qVar != null) {
            qVar.p0(bVar);
        }
        s sVar = this.F;
        if (sVar != null) {
            sVar.l0(bVar);
        }
        d.b.j0.a1.g.h.c cVar = this.G;
        if (cVar != null) {
            cVar.p0(bVar);
        }
    }

    public void v(f fVar) {
        this.S = fVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        d.b.j0.a1.g.h.b bVar = this.f53154g;
        if (bVar != null) {
            bVar.j0(bdUniqueId);
        }
        n nVar = this.f53155h;
        if (nVar != null) {
            nVar.n = bdUniqueId;
        }
        x xVar = this.i;
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
        d.b.j0.a1.g.h.f fVar = this.r;
        if (fVar != null) {
            fVar.m = bdUniqueId;
        }
        d.b.j0.a1.g.h.e eVar = this.s;
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
        d.b.j0.a1.g.h.a aVar = this.f53152e;
        if (aVar != null) {
            aVar.l0(bdUniqueId);
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
        d.b.j0.a1.g.h.c cVar = this.G;
        if (cVar != null) {
            cVar.n = bdUniqueId;
        }
        d.b.j0.a1.g.h.d dVar = this.u;
        if (dVar != null) {
            dVar.m = bdUniqueId;
        }
        d.b.j0.a1.b.e.z zVar = this.H;
        if (zVar != null) {
            zVar.n = bdUniqueId;
        }
        if (!ListUtils.isEmpty(this.P)) {
            for (d.b.c.j.e.a aVar2 : this.P) {
                if (aVar2 instanceof d.b.j0.j1.o.g.a) {
                    ((d.b.j0.j1.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void x(d.b.j0.a1.g.k.e eVar) {
        this.f53155h.s0(eVar);
        this.i.q0(eVar);
        this.j.p0(eVar);
        this.l.p0(eVar);
        this.m.q0(eVar);
        this.q.p0(eVar);
        this.r.p0(eVar);
        this.s.p0(eVar);
        this.t.s0(eVar);
        this.u.q0(eVar);
    }

    public final void y(d.b.c.j.e.s sVar) {
        this.i.r0(sVar);
        this.j.q0(sVar);
        this.k.p0(sVar);
        this.l.q0(sVar);
        this.m.r0(sVar);
        this.n.j0(sVar);
        this.o.l0(sVar);
        this.p.j0(sVar);
        this.q.q0(sVar);
        this.r.q0(sVar);
        this.s.q0(sVar);
        this.u.r0(sVar);
        this.t.t0(sVar);
        this.G.q0(sVar);
        this.z.t0(sVar);
        this.z.t0(sVar);
        this.B.q0(sVar);
        this.H.j0(sVar);
    }

    public void z(List<d.b.c.j.e.n> list) {
        d.b.j0.d3.v.f(list, 2);
        this.f53149b.setData(list);
        this.f53150c = list;
        f fVar = this.S;
        if (fVar != null) {
            fVar.a();
        }
    }
}
