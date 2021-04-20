package d.b.i0.q0.e2;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.d3.v;
import d.b.i0.q0.n1.d.a0;
import d.b.i0.q0.n1.d.p;
import d.b.i0.q0.n1.d.r;
import d.b.i0.q0.n1.d.s;
import d.b.i0.q0.n1.d.t;
import d.b.i0.q0.n1.d.u;
import d.b.i0.q0.n1.d.w;
import d.b.i0.q0.n1.d.x;
import d.b.i0.q0.n1.d.y;
import d.b.i0.q0.n1.d.z;
import d.b.i0.s2.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f59149a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59150b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59151c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f59153e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.b.c.j.e.n> f59154f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f59155g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59152d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f59156h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f59151c)) {
                f fVar = f.this;
                fVar.g(fVar.f59150b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f59154f, f.this.f59155g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f59150b = bdTypeRecyclerView;
        this.f59153e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59149a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f59149a.registerListener(this.f59156h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59149a != null && bdTypeRecyclerView != null) {
            this.f59151c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    d.b.i0.q0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = d.b.i0.q0.e.e().a(this.f59149a.getPageContext(), g2.get(i), this.f59149a.getUniqueId());
                    if (a2 != null) {
                        this.f59152d.add(a2);
                        this.f59151c.add(a2);
                    }
                }
                if (ListUtils.isEmpty(this.f59151c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f59151c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> h() {
        return this.f59153e;
    }

    public final void i(ArrayList<d.b.c.j.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.c.j.e.n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f59153e) != null && !hashMap.containsValue(nVar)) {
                this.f59153e.put(Integer.valueOf(i), (a2) nVar);
            }
        }
    }

    public List<d.b.c.j.e.n> j() {
        return this.f59154f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59149a = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.q(), a2.N2, this.f59149a.getUniqueId());
        yVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.k kVar = new d.b.i0.q0.n1.d.k(frsNewAreaFragment.q(), a2.O2, this.f59149a.getUniqueId());
        kVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.v vVar = new d.b.i0.q0.n1.d.v(frsNewAreaFragment.q(), a2.Q2, this.f59149a.getUniqueId());
        vVar.q0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.q(), a2.R2, this.f59149a.getUniqueId());
        sVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.j jVar = new d.b.i0.q0.n1.d.j(frsNewAreaFragment.q(), a2.T2, this.f59149a.getUniqueId());
        jVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.m mVar = new d.b.i0.q0.n1.d.m(frsNewAreaFragment.q(), a2.U2, this.f59149a.getUniqueId());
        mVar.q0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.q(), a2.Z2, this.f59149a.getUniqueId());
        a0Var.q0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.q(), a2.s3, this.f59149a.getUniqueId());
        wVar.q0(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.q(), a2.a3, this.f59149a.getUniqueId());
        r rVar = new r(frsNewAreaFragment.q(), a2.b3, this.f59149a.getUniqueId());
        z zVar = new z(frsNewAreaFragment.getPageContext(), a2.e3, this.f59149a.getUniqueId());
        zVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.l lVar = new d.b.i0.q0.n1.d.l(frsNewAreaFragment.getPageContext(), a2.x3, this.f59149a.getUniqueId());
        lVar.q0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.c3, this.f59149a.getUniqueId());
        pVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.b bVar = new d.b.i0.q0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.l3, this.f59149a.getUniqueId());
        bVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.g gVar = new d.b.i0.q0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.k3, this.f59149a.getUniqueId());
        gVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.h hVar = new d.b.i0.q0.n1.d.h(frsNewAreaFragment.getPageContext(), a2.m3, this.f59149a.getUniqueId());
        hVar.q0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.d3, this.f59149a.getUniqueId());
        tVar.q0(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), a2.n3, this.f59149a.getUniqueId());
        zVar2.q0(bdTypeRecyclerView);
        d.b.i0.q0.s sVar2 = new d.b.i0.q0.s(frsNewAreaFragment.getPageContext(), d.b.i0.q0.t.f60247f);
        sVar2.q0(bdTypeRecyclerView);
        d.b.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = d.b.i0.q0.e.e().d(frsNewAreaFragment.getPageContext(), this.f59149a.getUniqueId(), true);
        d.b.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = d.b.i0.q0.e.e().c(frsNewAreaFragment.getPageContext(), a2.B3, this.f59149a.getUniqueId());
        d.b.c.j.e.a<?, ?> j = d.b.i0.s2.v.p().j(this.f59149a, AdvertAppInfo.h4);
        d.b.c.j.e.a<?, ?> j2 = d.b.i0.s2.v.p().j(this.f59149a, AdvertAppInfo.k4);
        x xVar = new x(frsNewAreaFragment.getPageContext(), a2.j3, this.f59149a.getUniqueId());
        xVar.q0(bdTypeRecyclerView);
        d.b.i0.q0.n1.d.e eVar = new d.b.i0.q0.n1.d.e(frsNewAreaFragment.getPageContext(), a2.Y2, this.f59149a.getUniqueId());
        eVar.l0(bdTypeRecyclerView);
        this.f59152d.add(yVar);
        this.f59152d.add(kVar);
        this.f59152d.add(vVar);
        this.f59152d.add(sVar);
        this.f59152d.add(jVar);
        this.f59152d.add(mVar);
        this.f59152d.add(wVar);
        this.f59152d.add(a0Var);
        this.f59152d.add(uVar);
        this.f59152d.add(rVar);
        this.f59152d.add(zVar);
        this.f59152d.add(pVar);
        this.f59152d.add(bVar);
        this.f59152d.add(gVar);
        this.f59152d.add(hVar);
        this.f59152d.add(tVar);
        this.f59152d.add(sVar2);
        this.f59152d.add(lVar);
        this.f59152d.add(zVar2);
        this.f59152d.add(xVar);
        this.f59152d.add(eVar);
        if (d2 != null) {
            this.f59152d.add(d2);
        }
        if (c2 != null) {
            this.f59152d.add(c2);
        }
        this.f59152d.add(j);
        this.f59152d.add(j2);
        d.b.c.j.e.a<?, ?> c3 = d.b.i0.r0.b.e().c(this.f59149a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        d.b.c.j.e.a<?, ?> c4 = d.b.i0.r0.b.e().c(this.f59149a.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.f59152d.add(c3);
        this.f59152d.add(c4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f59149a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.b.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.b.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.b.i0.q0.k) {
                    ((d.b.i0.q0.k) next).i(this.f59149a.getPageContext(), this.f59149a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.b.c.j.e.a> list = this.f59152d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.b.i0.e.f.b bVar2 = new d.b.i0.e.f.b(this.f59149a, 1);
        bVar2.t(this.f59152d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f59152d);
    }

    public void l() {
        this.f59150b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f59150b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i) {
    }

    public void o() {
        for (d.b.c.j.e.a aVar : this.f59152d) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).m0();
            } else if (aVar instanceof o) {
                ((o) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f59150b.setData(this.f59154f);
        l();
    }

    public void q(ArrayList<d.b.c.j.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f59150b.setData(arrayList);
        this.f59154f = arrayList;
        this.f59155g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.b.c.j.e.a> list = this.f59152d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59152d) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f59152d) || this.f59149a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59152d) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).r0(this.f59149a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.b.c.j.e.a> list = this.f59152d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59152d) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).p0(frsViewData);
            }
        }
    }

    public void u(d.b.c.j.e.w wVar) {
        List<d.b.c.j.e.a> list = this.f59152d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59152d) {
            if (aVar != null && (aVar instanceof d.b.i0.q0.k)) {
                ((d.b.i0.q0.k) aVar).c0(wVar);
            }
        }
    }

    public final void v() {
        d.b.i0.q0.j2.b b2;
        if (this.f59155g == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59152d) {
            if ((aVar instanceof d.b.i0.q0.j2.d) && (b2 = ((d.b.i0.q0.j2.d) aVar).b()) != null) {
                if (this.f59155g.needLog == 1) {
                    b2.f59399a = true;
                } else {
                    b2.f59399a = false;
                }
                if (this.f59155g.getForum() != null) {
                    b2.f59401c = this.f59155g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59150b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f59150b.getData().size() == 0) {
            return;
        }
        for (d.b.c.j.e.n nVar : this.f59150b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.V2();
                }
            }
        }
    }
}
