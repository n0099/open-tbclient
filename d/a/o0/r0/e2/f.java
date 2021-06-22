package d.a.o0.r0.e2;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.e3.v;
import d.a.o0.r0.n1.d.a0;
import d.a.o0.r0.n1.d.p;
import d.a.o0.r0.n1.d.r;
import d.a.o0.r0.n1.d.s;
import d.a.o0.r0.n1.d.t;
import d.a.o0.r0.n1.d.u;
import d.a.o0.r0.n1.d.w;
import d.a.o0.r0.n1.d.y;
import d.a.o0.r0.n1.d.z;
import d.a.o0.t2.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f62324a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62325b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62326c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f62328e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f62329f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f62330g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62327d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f62331h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f62326c)) {
                f fVar = f.this;
                fVar.g(fVar.f62325b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f62329f, f.this.f62330g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f62325b = bdTypeRecyclerView;
        this.f62328e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f62324a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f62324a.registerListener(this.f62331h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f62324a != null && bdTypeRecyclerView != null) {
            this.f62326c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.o0.r0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = d.a.o0.r0.e.e().b(this.f62324a.getPageContext(), g2.get(i2), this.f62324a.getUniqueId());
                    if (b2 != null) {
                        this.f62327d.add(b2);
                        this.f62326c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f62326c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f62326c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> h() {
        return this.f62328e;
    }

    public final void i(ArrayList<d.a.c.k.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.k.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f62328e) != null && !hashMap.containsValue(nVar)) {
                this.f62328e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<d.a.c.k.e.n> j() {
        return this.f62329f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62324a = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.p(), a2.S2, this.f62324a.getUniqueId());
        yVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.k kVar = new d.a.o0.r0.n1.d.k(frsNewAreaFragment.p(), a2.T2, this.f62324a.getUniqueId());
        kVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.v vVar = new d.a.o0.r0.n1.d.v(frsNewAreaFragment.p(), a2.V2, this.f62324a.getUniqueId());
        vVar.m0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.p(), a2.W2, this.f62324a.getUniqueId());
        sVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.j jVar = new d.a.o0.r0.n1.d.j(frsNewAreaFragment.p(), a2.Y2, this.f62324a.getUniqueId());
        jVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.m mVar = new d.a.o0.r0.n1.d.m(frsNewAreaFragment.p(), a2.Z2, this.f62324a.getUniqueId());
        mVar.m0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.p(), a2.e3, this.f62324a.getUniqueId());
        a0Var.m0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.p(), a2.x3, this.f62324a.getUniqueId());
        wVar.m0(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.p(), a2.f3, this.f62324a.getUniqueId());
        r rVar = new r(frsNewAreaFragment.p(), a2.g3, this.f62324a.getUniqueId());
        z zVar = new z(frsNewAreaFragment.getPageContext(), a2.j3, this.f62324a.getUniqueId());
        zVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.l lVar = new d.a.o0.r0.n1.d.l(frsNewAreaFragment.getPageContext(), a2.C3, this.f62324a.getUniqueId());
        lVar.m0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.h3, this.f62324a.getUniqueId());
        pVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.b bVar = new d.a.o0.r0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.q3, this.f62324a.getUniqueId());
        bVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.g gVar = new d.a.o0.r0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.p3, this.f62324a.getUniqueId());
        gVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.h hVar = new d.a.o0.r0.n1.d.h(frsNewAreaFragment.getPageContext(), a2.r3, this.f62324a.getUniqueId());
        hVar.m0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.i3, this.f62324a.getUniqueId());
        tVar.m0(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), a2.s3, this.f62324a.getUniqueId());
        zVar2.m0(bdTypeRecyclerView);
        d.a.o0.r0.s sVar2 = new d.a.o0.r0.s(frsNewAreaFragment.getPageContext(), d.a.o0.r0.t.f63474f);
        sVar2.m0(bdTypeRecyclerView);
        d.a.c.k.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.o0.r0.e.e().a(frsNewAreaFragment.getPageContext(), this.f62324a.getUniqueId(), true);
        d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.o0.r0.e.e().d(frsNewAreaFragment.getPageContext(), a2.G3, this.f62324a.getUniqueId());
        d.a.c.k.e.a<?, ?> h2 = x.p().h(this.f62324a, AdvertAppInfo.d4);
        d.a.c.k.e.a<?, ?> h3 = x.p().h(this.f62324a, AdvertAppInfo.g4);
        d.a.o0.r0.n1.d.x xVar = new d.a.o0.r0.n1.d.x(frsNewAreaFragment.getPageContext(), a2.o3, this.f62324a.getUniqueId());
        xVar.m0(bdTypeRecyclerView);
        d.a.o0.r0.n1.d.e eVar = new d.a.o0.r0.n1.d.e(frsNewAreaFragment.getPageContext(), a2.d3, this.f62324a.getUniqueId());
        eVar.i0(bdTypeRecyclerView);
        this.f62327d.add(yVar);
        this.f62327d.add(kVar);
        this.f62327d.add(vVar);
        this.f62327d.add(sVar);
        this.f62327d.add(jVar);
        this.f62327d.add(mVar);
        this.f62327d.add(wVar);
        this.f62327d.add(a0Var);
        this.f62327d.add(uVar);
        this.f62327d.add(rVar);
        this.f62327d.add(zVar);
        this.f62327d.add(pVar);
        this.f62327d.add(bVar);
        this.f62327d.add(gVar);
        this.f62327d.add(hVar);
        this.f62327d.add(tVar);
        this.f62327d.add(sVar2);
        this.f62327d.add(lVar);
        this.f62327d.add(zVar2);
        this.f62327d.add(xVar);
        this.f62327d.add(eVar);
        if (a2 != null) {
            this.f62327d.add(a2);
        }
        if (d2 != null) {
            this.f62327d.add(d2);
        }
        this.f62327d.add(h2);
        this.f62327d.add(h3);
        d.a.c.k.e.a<?, ?> b2 = d.a.o0.s0.b.e().b(this.f62324a.getBaseFragmentActivity(), AdvertAppInfo.o4);
        d.a.c.k.e.a<?, ?> b3 = d.a.o0.s0.b.e().b(this.f62324a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        this.f62327d.add(b2);
        this.f62327d.add(b3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f62324a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.k.e.a<?, ?> next = it.next();
                if (next instanceof d.a.o0.r0.k) {
                    ((d.a.o0.r0.k) next).o(this.f62324a.getPageContext(), this.f62324a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.k.e.a> list = this.f62327d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.a.o0.e.f.b bVar2 = new d.a.o0.e.f.b(this.f62324a, 1);
        bVar2.t(this.f62327d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f62327d);
    }

    public void l() {
        this.f62325b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f62325b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
    }

    public void o() {
        for (d.a.c.k.e.a aVar : this.f62327d) {
            if (aVar instanceof d.a.o0.r0.k) {
                ((d.a.o0.r0.k) aVar).i0();
            } else if (aVar instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f62325b.setData(this.f62329f);
        l();
    }

    public void q(ArrayList<d.a.c.k.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f62325b.setData(arrayList);
        this.f62329f = arrayList;
        this.f62330g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.a.c.k.e.a> list = this.f62327d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62327d) {
            if (aVar instanceof d.a.o0.r0.k) {
                ((d.a.o0.r0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f62327d) || this.f62324a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62327d) {
            if (aVar instanceof d.a.o0.r0.k) {
                ((d.a.o0.r0.k) aVar).p0(this.f62324a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list = this.f62327d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62327d) {
            if (aVar instanceof d.a.o0.r0.k) {
                ((d.a.o0.r0.k) aVar).l0(frsViewData);
            }
        }
    }

    public void u(d.a.c.k.e.w wVar) {
        List<d.a.c.k.e.a> list = this.f62327d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62327d) {
            if (aVar != null && (aVar instanceof d.a.o0.r0.k)) {
                ((d.a.o0.r0.k) aVar).a0(wVar);
            }
        }
    }

    public final void v() {
        d.a.o0.r0.j2.b j;
        if (this.f62330g == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62327d) {
            if ((aVar instanceof d.a.o0.r0.j2.d) && (j = ((d.a.o0.r0.j2.d) aVar).j()) != null) {
                if (this.f62330g.needLog == 1) {
                    j.f62590a = true;
                } else {
                    j.f62590a = false;
                }
                if (this.f62330g.getForum() != null) {
                    j.f62592c = this.f62330g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62325b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f62325b.getData().size() == 0) {
            return;
        }
        for (d.a.c.k.e.n nVar : this.f62325b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.y0() != 0) {
                    z1Var.w.Z2();
                }
            }
        }
    }
}
