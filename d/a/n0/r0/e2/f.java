package d.a.n0.r0.e2;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.e3.v;
import d.a.n0.r0.n1.d.a0;
import d.a.n0.r0.n1.d.p;
import d.a.n0.r0.n1.d.r;
import d.a.n0.r0.n1.d.s;
import d.a.n0.r0.n1.d.t;
import d.a.n0.r0.n1.d.u;
import d.a.n0.r0.n1.d.w;
import d.a.n0.r0.n1.d.y;
import d.a.n0.r0.n1.d.z;
import d.a.n0.t2.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f58508a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58509b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58510c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f58512e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f58513f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f58514g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58511d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f58515h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f58510c)) {
                f fVar = f.this;
                fVar.g(fVar.f58509b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f58513f, f.this.f58514g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f58509b = bdTypeRecyclerView;
        this.f58512e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58508a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f58508a.registerListener(this.f58515h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58508a != null && bdTypeRecyclerView != null) {
            this.f58510c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.n0.r0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = d.a.n0.r0.e.e().b(this.f58508a.getPageContext(), g2.get(i2), this.f58508a.getUniqueId());
                    if (b2 != null) {
                        this.f58511d.add(b2);
                        this.f58510c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f58510c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f58510c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> h() {
        return this.f58512e;
    }

    public final void i(ArrayList<d.a.c.j.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.j.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f58512e) != null && !hashMap.containsValue(nVar)) {
                this.f58512e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<d.a.c.j.e.n> j() {
        return this.f58513f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58508a = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.o(), a2.P2, this.f58508a.getUniqueId());
        yVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.k kVar = new d.a.n0.r0.n1.d.k(frsNewAreaFragment.o(), a2.Q2, this.f58508a.getUniqueId());
        kVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.v vVar = new d.a.n0.r0.n1.d.v(frsNewAreaFragment.o(), a2.S2, this.f58508a.getUniqueId());
        vVar.n0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.o(), a2.T2, this.f58508a.getUniqueId());
        sVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.j jVar = new d.a.n0.r0.n1.d.j(frsNewAreaFragment.o(), a2.V2, this.f58508a.getUniqueId());
        jVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.m mVar = new d.a.n0.r0.n1.d.m(frsNewAreaFragment.o(), a2.W2, this.f58508a.getUniqueId());
        mVar.n0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.o(), a2.b3, this.f58508a.getUniqueId());
        a0Var.n0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.o(), a2.u3, this.f58508a.getUniqueId());
        wVar.n0(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.o(), a2.c3, this.f58508a.getUniqueId());
        r rVar = new r(frsNewAreaFragment.o(), a2.d3, this.f58508a.getUniqueId());
        z zVar = new z(frsNewAreaFragment.getPageContext(), a2.g3, this.f58508a.getUniqueId());
        zVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.l lVar = new d.a.n0.r0.n1.d.l(frsNewAreaFragment.getPageContext(), a2.z3, this.f58508a.getUniqueId());
        lVar.n0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.e3, this.f58508a.getUniqueId());
        pVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.b bVar = new d.a.n0.r0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.n3, this.f58508a.getUniqueId());
        bVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.g gVar = new d.a.n0.r0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.m3, this.f58508a.getUniqueId());
        gVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.h hVar = new d.a.n0.r0.n1.d.h(frsNewAreaFragment.getPageContext(), a2.o3, this.f58508a.getUniqueId());
        hVar.n0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.f3, this.f58508a.getUniqueId());
        tVar.n0(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), a2.p3, this.f58508a.getUniqueId());
        zVar2.n0(bdTypeRecyclerView);
        d.a.n0.r0.s sVar2 = new d.a.n0.r0.s(frsNewAreaFragment.getPageContext(), d.a.n0.r0.t.f59658f);
        sVar2.n0(bdTypeRecyclerView);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.n0.r0.e.e().a(frsNewAreaFragment.getPageContext(), this.f58508a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.n0.r0.e.e().d(frsNewAreaFragment.getPageContext(), a2.D3, this.f58508a.getUniqueId());
        d.a.c.j.e.a<?, ?> h2 = x.p().h(this.f58508a, AdvertAppInfo.a4);
        d.a.c.j.e.a<?, ?> h3 = x.p().h(this.f58508a, AdvertAppInfo.d4);
        d.a.n0.r0.n1.d.x xVar = new d.a.n0.r0.n1.d.x(frsNewAreaFragment.getPageContext(), a2.l3, this.f58508a.getUniqueId());
        xVar.n0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.e eVar = new d.a.n0.r0.n1.d.e(frsNewAreaFragment.getPageContext(), a2.a3, this.f58508a.getUniqueId());
        eVar.h0(bdTypeRecyclerView);
        this.f58511d.add(yVar);
        this.f58511d.add(kVar);
        this.f58511d.add(vVar);
        this.f58511d.add(sVar);
        this.f58511d.add(jVar);
        this.f58511d.add(mVar);
        this.f58511d.add(wVar);
        this.f58511d.add(a0Var);
        this.f58511d.add(uVar);
        this.f58511d.add(rVar);
        this.f58511d.add(zVar);
        this.f58511d.add(pVar);
        this.f58511d.add(bVar);
        this.f58511d.add(gVar);
        this.f58511d.add(hVar);
        this.f58511d.add(tVar);
        this.f58511d.add(sVar2);
        this.f58511d.add(lVar);
        this.f58511d.add(zVar2);
        this.f58511d.add(xVar);
        this.f58511d.add(eVar);
        if (a2 != null) {
            this.f58511d.add(a2);
        }
        if (d2 != null) {
            this.f58511d.add(d2);
        }
        this.f58511d.add(h2);
        this.f58511d.add(h3);
        d.a.c.j.e.a<?, ?> b2 = d.a.n0.s0.b.e().b(this.f58508a.getBaseFragmentActivity(), AdvertAppInfo.l4);
        d.a.c.j.e.a<?, ?> b3 = d.a.n0.s0.b.e().b(this.f58508a.getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.f58511d.add(b2);
        this.f58511d.add(b3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f58508a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.a.n0.r0.k) {
                    ((d.a.n0.r0.k) next).n(this.f58508a.getPageContext(), this.f58508a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.j.e.a> list = this.f58511d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.a.n0.e.f.b bVar2 = new d.a.n0.e.f.b(this.f58508a, 1);
        bVar2.t(this.f58511d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f58511d);
    }

    public void l() {
        this.f58509b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f58509b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
    }

    public void o() {
        for (d.a.c.j.e.a aVar : this.f58511d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).h0();
            } else if (aVar instanceof d.a.n0.t2.p) {
                ((d.a.n0.t2.p) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f58509b.setData(this.f58513f);
        l();
    }

    public void q(ArrayList<d.a.c.j.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f58509b.setData(arrayList);
        this.f58513f = arrayList;
        this.f58514g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.a.c.j.e.a> list = this.f58511d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58511d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f58511d) || this.f58508a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58511d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).p0(this.f58508a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f58511d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58511d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).m0(frsViewData);
            }
        }
    }

    public void u(d.a.c.j.e.w wVar) {
        List<d.a.c.j.e.a> list = this.f58511d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58511d) {
            if (aVar != null && (aVar instanceof d.a.n0.r0.k)) {
                ((d.a.n0.r0.k) aVar).Z(wVar);
            }
        }
    }

    public final void v() {
        d.a.n0.r0.j2.b i2;
        if (this.f58514g == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58511d) {
            if ((aVar instanceof d.a.n0.r0.j2.d) && (i2 = ((d.a.n0.r0.j2.d) aVar).i()) != null) {
                if (this.f58514g.needLog == 1) {
                    i2.f58774a = true;
                } else {
                    i2.f58774a = false;
                }
                if (this.f58514g.getForum() != null) {
                    i2.f58776c = this.f58514g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58509b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f58509b.getData().size() == 0) {
            return;
        }
        for (d.a.c.j.e.n nVar : this.f58509b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.y0() != 0) {
                    z1Var.w.Y2();
                }
            }
        }
    }
}
