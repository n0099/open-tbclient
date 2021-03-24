package d.b.i0.z0.g.h;

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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import d.b.h0.r.q.a2;
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
    public d.b.i0.z0.g.h.c G;
    public d.b.i0.z0.b.e.z H;
    public d.b.b.j.e.a I;
    public d.b.b.j.e.a J;
    public d.b.b.j.e.a K;
    public d.b.b.j.e.a L;
    public d.b.b.j.e.a M;
    public d.b.b.j.e.a N;
    public d.b.b.j.e.a O;
    public List<d.b.b.j.e.a> P;
    public boolean Q;
    public boolean R;
    public f S;
    public CustomMessageListener T = new a(2016470);
    public CustomMessageListener U = new b(2001115);
    public CustomMessageListener V = new c(2001335);
    public CustomMessageListener W = new d(2001336);
    public CustomMessageListener X = new e(2921394);

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.b.j.e.a> f63107a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.j.e.s f63108b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.n> f63109c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f63110d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.z0.g.h.a f63111e;

    /* renamed from: f  reason: collision with root package name */
    public z f63112f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.z0.g.h.b f63113g;

    /* renamed from: h  reason: collision with root package name */
    public n f63114h;
    public x i;
    public h j;
    public i k;
    public j l;
    public r m;
    public k n;
    public o o;
    public m p;
    public g q;
    public d.b.i0.z0.g.h.f r;
    public d.b.i0.z0.g.h.e s;
    public y t;
    public d.b.i0.z0.g.h.d u;
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
            if (b0.this.f63109c != null) {
                b0 b0Var = b0.this;
                b0Var.z(b0Var.f63109c);
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
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f13692a) {
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
            d.b.i0.i1.p.b bVar = new d.b.i0.i1.p.b();
            bVar.f56012a = String.valueOf(customResponsedMessage.getData());
            bVar.f56013b = true;
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
            d.b.i0.i1.p.b bVar = new d.b.i0.i1.p.b();
            bVar.f56012a = String.valueOf(customResponsedMessage.getData());
            bVar.f56013b = false;
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
            d.b.c.m.e.b i;
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

    public b0(Context context, d.b.b.j.e.s sVar) {
        this.f63108b = sVar;
        this.f63110d = (TbPageContext) d.b.b.a.j.a(context);
        j(context);
        y(sVar);
        sVar.a(this.f63107a);
    }

    public void A(List<d.b.b.j.e.n> list, int i) {
        d.b.i0.c3.v.f(list, 2);
        ViewGroup listView = this.f63108b.getListView();
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
        this.f63108b.setData(list);
        this.f63109c = list;
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
        List<d.b.b.j.e.a> list = this.P;
        if (list == null || list.size() <= 0) {
            this.P = new ArrayList();
            ArrayList<BdUniqueId> g2 = d.b.i0.c3.v.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i = 0; i < size; i++) {
                d.b.i0.i1.o.g.a c2 = d.b.i0.i1.r.b.d().c(this.f63110d, g2.get(i), 2);
                if (this.Q) {
                    c2.h0(3);
                }
                n nVar = this.f63114h;
                if (nVar != null && (bdUniqueId = nVar.n) != null) {
                    c2.setUniqueId(bdUniqueId);
                }
                this.P.add(c2);
            }
            this.f63108b.a(this.P);
            return true;
        }
        return true;
    }

    public final void g(Object obj) {
        List<d.b.b.j.e.n> list = this.f63109c;
        if (list != null) {
            boolean z = false;
            for (d.b.b.j.e.n nVar : list) {
                if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                m();
            }
        }
    }

    public List<d.b.b.j.e.n> h() {
        return this.f63109c;
    }

    public final d.b.c.m.e.b i(String str) {
        int i;
        d.b.i0.x.e0.l lVar;
        a2 a2Var;
        List<d.b.b.j.e.n> list = this.f63109c;
        if (list == null || list.isEmpty() || str == null) {
            return null;
        }
        d.b.c.m.e.b bVar = new d.b.c.m.e.b();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= this.f63109c.size()) {
                i = -1;
                break;
            }
            if (this.f63109c.get(i2) instanceof d.b.i0.z0.g.j.h) {
                i3++;
            }
            if (this.f63109c.get(i2) instanceof d.b.i0.z0.g.j.a) {
                if (l(this.f63109c.get(i2))) {
                    if (z) {
                        i = ((d.b.i0.z0.g.j.a) this.f63109c.get(i2)).position;
                        break;
                    }
                    i5 = ((d.b.i0.z0.g.j.a) this.f63109c.get(i2)).position;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.f63109c.get(i2) instanceof d.b.i0.x.e0.l) && (lVar = (d.b.i0.x.e0.l) this.f63109c.get(i2)) != null && (a2Var = lVar.f62196e) != null && str.equals(a2Var.o0())) {
                i6 = ((d.b.i0.x.e0.l) this.f63109c.get(i2)).position;
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
        this.f63111e = new d.b.i0.z0.g.h.a(this.f63110d);
        this.f63112f = new z(this.f63110d);
        this.f63113g = new d.b.i0.z0.g.h.b(this.f63110d, d.b.i0.z0.g.j.f.f63188f);
        this.f63114h = new n(this.f63110d, d.b.i0.x.e0.k.l0);
        this.i = new x(this.f63110d, d.b.i0.x.e0.k.v0);
        this.j = new h(this.f63110d, d.b.i0.x.e0.k.C0);
        this.k = new i(this.f63110d, d.b.i0.x.e0.k.w0);
        this.l = new j(this.f63110d, d.b.i0.x.e0.k.D0);
        this.m = new r(this.f63110d, d.b.i0.x.e0.k.B0);
        this.n = new k(this.f63110d, d.b.i0.x.e0.k.E0);
        this.o = new o(this.f63110d, d.b.i0.x.e0.k.K0);
        this.p = new m(this.f63110d, d.b.i0.x.e0.k.L0);
        this.q = new g(this.f63110d, d.b.i0.x.e0.k.x0);
        this.r = new d.b.i0.z0.g.h.f(this.f63110d, d.b.i0.x.e0.k.y0);
        this.s = new d.b.i0.z0.g.h.e(this.f63110d, d.b.i0.x.e0.k.z0);
        this.t = new y(this.f63110d, d.b.i0.x.e0.l.V);
        this.v = new l(this.f63110d, d.b.i0.x.e0.k.n0);
        this.w = new HomePageAlaLiveThreadAdapter(this.f63110d, d.b.i0.x.e0.j.M0);
        this.x = new HomePageAlaFriendRoomAdapter(this.f63110d, d.b.i0.x.e0.j.N0);
        this.y = new v(this.f63110d, d.b.i0.x.e0.k.o0);
        this.z = new u(this.f63110d, d.b.i0.x.e0.k.p0);
        this.A = new w(this.f63110d, d.b.i0.x.e0.k.r0);
        this.B = new t(this.f63110d, d.b.i0.x.e0.k.q0);
        this.C = new n(this.f63110d, d.b.i0.x.e0.k.m0);
        this.D = new p(this.f63110d, d.b.i0.x.e0.k.s0);
        this.E = new q(this.f63110d, d.b.i0.x.e0.k.t0);
        this.F = new s(this.f63110d, d.b.i0.z0.j.b.c.a.d0);
        this.G = new d.b.i0.z0.g.h.c(this.f63110d, d.b.i0.x.e0.e.M0);
        this.u = new d.b.i0.z0.g.h.d(this.f63110d, d.b.i0.x.e0.k.A0);
        this.H = new d.b.i0.z0.b.e.z(this.f63110d, d.b.i0.x.e0.k.u0, (byte) 3);
        this.f63107a.add(this.f63111e);
        this.f63107a.add(this.f63112f);
        this.f63107a.add(this.f63113g);
        this.f63107a.add(this.f63114h);
        this.f63107a.add(this.i);
        this.f63107a.add(this.j);
        this.f63107a.add(this.k);
        this.f63107a.add(this.l);
        this.f63107a.add(this.m);
        this.f63107a.add(this.n);
        this.f63107a.add(this.o);
        this.f63107a.add(this.p);
        this.f63107a.add(this.q);
        this.f63107a.add(this.r);
        this.f63107a.add(this.s);
        this.f63107a.add(this.t);
        this.f63107a.add(this.v);
        this.f63107a.add(this.C);
        this.f63107a.add(new ReadProgessDelegetAdapter(this.f63110d, d.b.i0.z0.g.l.b.f63218g));
        this.f63107a.add(this.w);
        this.f63107a.add(this.x);
        this.f63107a.add(this.y);
        this.f63107a.add(this.z);
        this.f63107a.add(this.B);
        this.f63107a.add(this.A);
        this.f63107a.add(new a0(this.f63110d, d.b.i0.z0.g.j.h.i));
        this.f63107a.add(this.D);
        this.f63107a.add(this.E);
        this.f63107a.add(this.F);
        this.f63107a.add(this.G);
        this.f63107a.add(this.u);
        this.f63107a.add(this.H);
        e();
        k();
        r("page_recommend");
    }

    public final void k() {
        if (!a2.u3.get()) {
            AdvertAppInfo.t4.set(false);
            return;
        }
        this.I = d.b.i0.r2.s.o().f(this.f63110d, AdvertAppInfo.j4, "INDEX");
        this.J = d.b.i0.r2.s.o().f(this.f63110d, AdvertAppInfo.k4, "INDEX");
        this.K = d.b.i0.r2.s.o().f(this.f63110d, AdvertAppInfo.o4, "INDEX");
        this.L = d.b.i0.r2.s.o().f(this.f63110d, AdvertAppInfo.p4, "INDEX");
        this.M = d.b.i0.r2.s.o().f(this.f63110d, AdvertAppInfo.q4, "INDEX");
        this.N = d.b.i0.r2.s.o().f(this.f63110d, AdvertAppInfo.s4, "INDEX");
        this.O = d.b.i0.r2.s.o().f(this.f63110d, AdvertAppInfo.r4, "INDEX");
        this.f63107a.add(this.I);
        this.f63107a.add(this.J);
        this.f63107a.add(this.K);
        this.f63107a.add(this.L);
        this.f63107a.add(this.M);
        this.f63107a.add(this.N);
        this.f63107a.add(this.O);
        AdvertAppInfo.t4.set(true);
    }

    public final boolean l(d.b.b.j.e.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof d.b.i0.z0.g.j.a) && (advertAppInfo = ((d.b.i0.z0.g.j.a) nVar).f62200e) != null && advertAppInfo.D4() == 0;
    }

    public void m() {
        d.b.b.j.e.s sVar = this.f63108b;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i) {
        m();
        this.f63111e.h0(i);
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
        List<d.b.b.j.e.a> list = this.f63107a;
        if (list == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.m.f) {
                ((d.b.i0.m.f) aVar).o(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        for (d.b.b.j.e.a aVar2 : this.f63107a) {
            if (aVar2 instanceof d.b.i0.z0.a) {
                ((d.b.i0.z0.a) aVar2).h0(aVar);
            }
        }
    }

    public void t(boolean z) {
        n nVar = this.f63114h;
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
        d.b.i0.z0.g.h.d dVar = this.u;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
        d.b.b.j.e.a aVar = this.J;
        if (aVar == null || !(aVar instanceof d.b.i0.r2.p)) {
            return;
        }
        ((d.b.i0.r2.p) aVar).c(z);
    }

    public void u(NEGFeedBackView.b bVar) {
        n nVar = this.f63114h;
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
        d.b.i0.z0.g.h.c cVar = this.G;
        if (cVar != null) {
            cVar.p0(bVar);
        }
    }

    public void v(f fVar) {
        this.S = fVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        d.b.i0.z0.g.h.b bVar = this.f63113g;
        if (bVar != null) {
            bVar.j0(bdUniqueId);
        }
        n nVar = this.f63114h;
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
        d.b.i0.z0.g.h.f fVar = this.r;
        if (fVar != null) {
            fVar.m = bdUniqueId;
        }
        d.b.i0.z0.g.h.e eVar = this.s;
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
        d.b.i0.z0.g.h.a aVar = this.f63111e;
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
        d.b.i0.z0.g.h.c cVar = this.G;
        if (cVar != null) {
            cVar.n = bdUniqueId;
        }
        d.b.i0.z0.g.h.d dVar = this.u;
        if (dVar != null) {
            dVar.m = bdUniqueId;
        }
        d.b.i0.z0.b.e.z zVar = this.H;
        if (zVar != null) {
            zVar.n = bdUniqueId;
        }
        if (!ListUtils.isEmpty(this.P)) {
            for (d.b.b.j.e.a aVar2 : this.P) {
                if (aVar2 instanceof d.b.i0.i1.o.g.a) {
                    ((d.b.i0.i1.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void x(d.b.i0.z0.g.k.e eVar) {
        this.f63114h.s0(eVar);
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

    public final void y(d.b.b.j.e.s sVar) {
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

    public void z(List<d.b.b.j.e.n> list) {
        d.b.i0.c3.v.f(list, 2);
        this.f63108b.setData(list);
        this.f63109c = list;
        f fVar = this.S;
        if (fVar != null) {
            fVar.a();
        }
    }
}
