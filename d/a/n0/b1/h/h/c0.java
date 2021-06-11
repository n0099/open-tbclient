package d.a.n0.b1.h.h;

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
import d.a.m0.r.q.a2;
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
    public d.a.n0.b1.h.h.c H;
    public d.a.n0.b1.c.e.z I;
    public d.a.c.k.e.a J;
    public d.a.c.k.e.a K;
    public d.a.c.k.e.a L;
    public d.a.c.k.e.a M;
    public d.a.c.k.e.a N;
    public d.a.c.k.e.a O;
    public d.a.c.k.e.a P;
    public List<d.a.c.k.e.a> Q;
    public boolean R;
    public boolean S;
    public f T;
    public CustomMessageListener U = new a(2016470);
    public CustomMessageListener V = new b(2001115);
    public CustomMessageListener W = new c(2001335);
    public CustomMessageListener X = new d(2001336);
    public CustomMessageListener Y = new e(2921394);

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55411a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.k.e.s f55412b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.n> f55413c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f55414d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.h.h.a f55415e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f55416f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.h.h.b f55417g;

    /* renamed from: h  reason: collision with root package name */
    public n f55418h;

    /* renamed from: i  reason: collision with root package name */
    public y f55419i;
    public h j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public g r;
    public d.a.n0.b1.h.h.f s;
    public d.a.n0.b1.h.h.e t;
    public z u;
    public d.a.n0.b1.h.h.d v;
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
            if (c0.this.f55413c != null) {
                c0 c0Var = c0.this;
                c0Var.z(c0Var.f55413c);
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
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12636a) {
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
            d.a.n0.k1.p.b bVar = new d.a.n0.k1.p.b();
            bVar.f60428a = String.valueOf(customResponsedMessage.getData());
            bVar.f60429b = true;
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
            d.a.n0.k1.p.b bVar = new d.a.n0.k1.p.b();
            bVar.f60428a = String.valueOf(customResponsedMessage.getData());
            bVar.f60429b = false;
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

    public c0(Context context, d.a.c.k.e.s sVar) {
        this.f55412b = sVar;
        this.f55414d = (TbPageContext) d.a.c.a.j.a(context);
        j(context);
        y(sVar);
        sVar.a(this.f55411a);
    }

    public void A(List<d.a.c.k.e.n> list, int i2) {
        d.a.n0.e3.v.f(list, 2);
        ViewGroup listView = this.f55412b.getListView();
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
        this.f55412b.setData(list);
        this.f55413c = list;
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
        List<d.a.c.k.e.a> list = this.Q;
        if (list == null || list.size() <= 0) {
            this.Q = new ArrayList();
            ArrayList<BdUniqueId> g2 = d.a.n0.e3.v.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.n0.k1.o.g.a b2 = d.a.n0.k1.r.b.d().b(this.f55414d, g2.get(i2), 2);
                if (this.R) {
                    b2.e0(3);
                }
                n nVar = this.f55418h;
                if (nVar != null && (bdUniqueId = nVar.n) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.Q.add(b2);
            }
            this.f55412b.a(this.Q);
            return true;
        }
        return true;
    }

    public final void g(Object obj) {
        List<d.a.c.k.e.n> list = this.f55413c;
        if (list != null) {
            boolean z = false;
            for (d.a.c.k.e.n nVar : list) {
                if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                m();
            }
        }
    }

    public List<d.a.c.k.e.n> h() {
        return this.f55413c;
    }

    public final d.a.d.m.e.b i(String str) {
        int i2;
        d.a.n0.z.e0.l lVar;
        a2 a2Var;
        List<d.a.c.k.e.n> list = this.f55413c;
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
            if (i3 >= this.f55413c.size()) {
                i2 = -1;
                break;
            }
            if (this.f55413c.get(i3) instanceof d.a.n0.b1.h.j.h) {
                i4++;
            }
            if (this.f55413c.get(i3) instanceof d.a.n0.b1.h.j.a) {
                if (l(this.f55413c.get(i3))) {
                    if (z) {
                        i2 = ((d.a.n0.b1.h.j.a) this.f55413c.get(i3)).position;
                        break;
                    }
                    i6 = ((d.a.n0.b1.h.j.a) this.f55413c.get(i3)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.f55413c.get(i3) instanceof d.a.n0.z.e0.l) && (lVar = (d.a.n0.z.e0.l) this.f55413c.get(i3)) != null && (a2Var = lVar.f67177e) != null && str.equals(a2Var.o0())) {
                i7 = ((d.a.n0.z.e0.l) this.f55413c.get(i3)).position;
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
        this.f55415e = new d.a.n0.b1.h.h.a(this.f55414d);
        this.f55416f = new a0(this.f55414d);
        this.f55417g = new d.a.n0.b1.h.h.b(this.f55414d, d.a.n0.b1.h.j.f.f55494f);
        this.f55418h = new n(this.f55414d, d.a.n0.z.e0.k.m0);
        this.f55419i = new y(this.f55414d, d.a.n0.z.e0.k.w0);
        this.j = new h(this.f55414d, d.a.n0.z.e0.k.D0);
        this.k = new i(this.f55414d, d.a.n0.z.e0.k.x0);
        this.l = new j(this.f55414d, d.a.n0.z.e0.k.E0);
        this.m = new s(this.f55414d, d.a.n0.z.e0.k.C0);
        this.n = new k(this.f55414d, d.a.n0.z.e0.k.F0);
        this.o = new p(this.f55414d, d.a.n0.z.e0.k.G0);
        this.p = new m(this.f55414d, d.a.n0.z.e0.k.M0);
        this.q = new o(this.f55414d, d.a.n0.z.e0.k.N0);
        this.r = new g(this.f55414d, d.a.n0.z.e0.k.y0);
        this.s = new d.a.n0.b1.h.h.f(this.f55414d, d.a.n0.z.e0.k.z0);
        this.t = new d.a.n0.b1.h.h.e(this.f55414d, d.a.n0.z.e0.k.A0);
        this.u = new z(this.f55414d, d.a.n0.z.e0.l.W);
        this.w = new l(this.f55414d, d.a.n0.z.e0.k.o0);
        this.x = new HomePageAlaLiveThreadAdapter(this.f55414d, d.a.n0.z.e0.j.O0);
        this.y = new HomePageAlaFriendRoomAdapter(this.f55414d, d.a.n0.z.e0.j.P0);
        this.z = new w(this.f55414d, d.a.n0.z.e0.k.p0);
        this.A = new v(this.f55414d, d.a.n0.z.e0.k.q0);
        this.B = new x(this.f55414d, d.a.n0.z.e0.k.s0);
        this.C = new u(this.f55414d, d.a.n0.z.e0.k.r0);
        this.D = new n(this.f55414d, d.a.n0.z.e0.k.n0);
        this.E = new q(this.f55414d, d.a.n0.z.e0.k.t0);
        this.F = new r(this.f55414d, d.a.n0.z.e0.k.u0);
        this.G = new t(this.f55414d, d.a.n0.b1.k.b.c.a.e0);
        this.H = new d.a.n0.b1.h.h.c(this.f55414d, d.a.n0.z.e0.e.O0);
        this.v = new d.a.n0.b1.h.h.d(this.f55414d, d.a.n0.z.e0.k.B0);
        this.I = new d.a.n0.b1.c.e.z(this.f55414d, d.a.n0.z.e0.k.v0, (byte) 3);
        this.f55411a.add(this.f55415e);
        this.f55411a.add(this.f55416f);
        this.f55411a.add(this.f55417g);
        this.f55411a.add(this.f55418h);
        this.f55411a.add(this.f55419i);
        this.f55411a.add(this.j);
        this.f55411a.add(this.k);
        this.f55411a.add(this.l);
        this.f55411a.add(this.m);
        this.f55411a.add(this.n);
        this.f55411a.add(this.o);
        this.f55411a.add(this.p);
        this.f55411a.add(this.q);
        this.f55411a.add(this.r);
        this.f55411a.add(this.s);
        this.f55411a.add(this.t);
        this.f55411a.add(this.u);
        this.f55411a.add(this.w);
        this.f55411a.add(this.D);
        this.f55411a.add(new ReadProgessDelegetAdapter(this.f55414d, d.a.n0.b1.h.l.b.f55526g));
        this.f55411a.add(this.x);
        this.f55411a.add(this.y);
        this.f55411a.add(this.z);
        this.f55411a.add(this.A);
        this.f55411a.add(this.C);
        this.f55411a.add(this.B);
        this.f55411a.add(new b0(this.f55414d, d.a.n0.b1.h.j.h.f55496i));
        this.f55411a.add(this.E);
        this.f55411a.add(this.F);
        this.f55411a.add(this.G);
        this.f55411a.add(this.H);
        this.f55411a.add(this.v);
        this.f55411a.add(this.I);
        e();
        k();
        r("page_recommend");
    }

    public final void k() {
        if (!a2.z3.get()) {
            AdvertAppInfo.c4.set(false);
            return;
        }
        this.J = d.a.n0.t2.x.p().l(this.f55414d, AdvertAppInfo.f4, "INDEX");
        this.K = d.a.n0.t2.x.p().l(this.f55414d, AdvertAppInfo.g4, "INDEX");
        this.L = d.a.n0.t2.x.p().l(this.f55414d, AdvertAppInfo.h4, "INDEX");
        this.M = d.a.n0.t2.x.p().l(this.f55414d, AdvertAppInfo.i4, "INDEX");
        this.N = d.a.n0.t2.x.p().l(this.f55414d, AdvertAppInfo.j4, "INDEX");
        this.O = d.a.n0.t2.x.p().l(this.f55414d, AdvertAppInfo.l4, "INDEX");
        this.P = d.a.n0.t2.x.p().l(this.f55414d, AdvertAppInfo.k4, "INDEX");
        this.f55411a.add(this.J);
        this.f55411a.add(this.K);
        this.f55411a.add(this.L);
        this.f55411a.add(this.M);
        this.f55411a.add(this.N);
        this.f55411a.add(this.O);
        this.f55411a.add(this.P);
        if (this.f55414d.getPageActivity() instanceof BaseFragmentActivity) {
            this.f55411a.add(d.a.n0.s0.b.e().c((BaseFragmentActivity) this.f55414d.getPageActivity(), AdvertAppInfo.o4));
            this.f55411a.add(d.a.n0.s0.b.e().c((BaseFragmentActivity) this.f55414d.getPageActivity(), AdvertAppInfo.n4));
        }
        AdvertAppInfo.c4.set(true);
    }

    public final boolean l(d.a.c.k.e.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof d.a.n0.b1.h.j.a) && (advertAppInfo = ((d.a.n0.b1.h.j.a) nVar).f67182e) != null && advertAppInfo.I4() == 0;
    }

    public void m() {
        d.a.c.k.e.s sVar = this.f55412b;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        m();
        this.f55415e.e0(i2);
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
        List<d.a.c.k.e.a> list = this.f55411a;
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.n0.o.f) {
                ((d.a.n0.o.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        for (d.a.c.k.e.a aVar2 : this.f55411a) {
            if (aVar2 instanceof d.a.n0.b1.a) {
                ((d.a.n0.b1.a) aVar2).e0(aVar);
            }
        }
    }

    public void t(boolean z) {
        n nVar = this.f55418h;
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
        d.a.n0.b1.h.h.d dVar = this.v;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
        d.a.c.k.e.a aVar = this.K;
        if (aVar == null || !(aVar instanceof d.a.n0.t2.t)) {
            return;
        }
        ((d.a.n0.t2.t) aVar).k(z);
    }

    public void u(NEGFeedBackView.b bVar) {
        n nVar = this.f55418h;
        if (nVar != null) {
            nVar.q0(bVar);
        }
        s sVar = this.m;
        if (sVar != null) {
            sVar.m0(bVar);
        }
        i iVar = this.k;
        if (iVar != null) {
            iVar.l0(bVar);
        }
        l lVar = this.w;
        if (lVar != null) {
            lVar.k0(bVar);
        }
        HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
        if (homePageAlaLiveThreadAdapter != null) {
            homePageAlaLiveThreadAdapter.k0(bVar);
        }
        HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
        if (homePageAlaFriendRoomAdapter != null) {
            homePageAlaFriendRoomAdapter.k0(bVar);
        }
        w wVar = this.z;
        if (wVar != null) {
            wVar.k0(bVar);
        }
        v vVar = this.A;
        if (vVar != null) {
            vVar.s0(bVar);
        }
        u uVar = this.C;
        if (uVar != null) {
            uVar.m0(bVar);
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
            rVar.m0(bVar);
        }
        t tVar = this.G;
        if (tVar != null) {
            tVar.i0(bVar);
        }
        d.a.n0.b1.h.h.c cVar = this.H;
        if (cVar != null) {
            cVar.m0(bVar);
        }
    }

    public void v(f fVar) {
        this.T = fVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        d.a.n0.b1.h.h.b bVar = this.f55417g;
        if (bVar != null) {
            bVar.h0(bdUniqueId);
        }
        n nVar = this.f55418h;
        if (nVar != null) {
            nVar.n = bdUniqueId;
        }
        y yVar = this.f55419i;
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
        d.a.n0.b1.h.h.f fVar = this.s;
        if (fVar != null) {
            fVar.m = bdUniqueId;
        }
        d.a.n0.b1.h.h.e eVar = this.t;
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
        d.a.n0.b1.h.h.a aVar = this.f55415e;
        if (aVar != null) {
            aVar.i0(bdUniqueId);
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
        d.a.n0.b1.h.h.c cVar = this.H;
        if (cVar != null) {
            cVar.n = bdUniqueId;
        }
        d.a.n0.b1.h.h.d dVar = this.v;
        if (dVar != null) {
            dVar.m = bdUniqueId;
        }
        d.a.n0.b1.c.e.z zVar2 = this.I;
        if (zVar2 != null) {
            zVar2.n = bdUniqueId;
        }
        if (!ListUtils.isEmpty(this.Q)) {
            for (d.a.c.k.e.a aVar2 : this.Q) {
                if (aVar2 instanceof d.a.n0.k1.o.g.a) {
                    ((d.a.n0.k1.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void x(d.a.n0.b1.h.k.e eVar) {
        this.f55418h.s0(eVar);
        this.f55419i.p0(eVar);
        this.j.m0(eVar);
        this.l.m0(eVar);
        this.m.p0(eVar);
        this.q.l0(eVar);
        this.r.m0(eVar);
        this.s.m0(eVar);
        this.t.m0(eVar);
        this.u.s0(eVar);
        this.v.p0(eVar);
    }

    public final void y(d.a.c.k.e.s sVar) {
        this.f55419i.q0(sVar);
        this.j.p0(sVar);
        this.k.m0(sVar);
        this.l.p0(sVar);
        this.m.q0(sVar);
        this.n.h0(sVar);
        this.o.i0(sVar);
        this.p.h0(sVar);
        this.q.m0(sVar);
        this.r.p0(sVar);
        this.s.p0(sVar);
        this.t.p0(sVar);
        this.v.q0(sVar);
        this.u.t0(sVar);
        this.H.p0(sVar);
        this.A.t0(sVar);
        this.A.t0(sVar);
        this.C.p0(sVar);
        this.I.h0(sVar);
    }

    public void z(List<d.a.c.k.e.n> list) {
        d.a.n0.e3.v.f(list, 2);
        this.f55412b.setData(list);
        this.f55413c = list;
        f fVar = this.T;
        if (fVar != null) {
            fVar.a();
        }
    }
}
