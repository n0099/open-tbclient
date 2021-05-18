package d.a.k0.q0.e2;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.k0.d3.v;
import d.a.k0.q0.n1.d.a0;
import d.a.k0.q0.n1.d.p;
import d.a.k0.q0.n1.d.r;
import d.a.k0.q0.n1.d.s;
import d.a.k0.q0.n1.d.t;
import d.a.k0.q0.n1.d.u;
import d.a.k0.q0.n1.d.w;
import d.a.k0.q0.n1.d.y;
import d.a.k0.q0.n1.d.z;
import d.a.k0.s2.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f58367a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58368b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58369c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f58371e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f58372f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f58373g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58370d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f58374h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f58369c)) {
                f fVar = f.this;
                fVar.g(fVar.f58368b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f58372f, f.this.f58373g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f58368b = bdTypeRecyclerView;
        this.f58371e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58367a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f58367a.registerListener(this.f58374h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58367a != null && bdTypeRecyclerView != null) {
            this.f58369c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.k0.q0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = d.a.k0.q0.e.e().b(this.f58367a.getPageContext(), g2.get(i2), this.f58367a.getUniqueId());
                    if (b2 != null) {
                        this.f58370d.add(b2);
                        this.f58369c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f58369c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f58369c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> h() {
        return this.f58371e;
    }

    public final void i(ArrayList<d.a.c.j.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.j.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f58371e) != null && !hashMap.containsValue(nVar)) {
                this.f58371e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<d.a.c.j.e.n> j() {
        return this.f58372f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58367a = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.o(), a2.O2, this.f58367a.getUniqueId());
        yVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.k kVar = new d.a.k0.q0.n1.d.k(frsNewAreaFragment.o(), a2.P2, this.f58367a.getUniqueId());
        kVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.v vVar = new d.a.k0.q0.n1.d.v(frsNewAreaFragment.o(), a2.R2, this.f58367a.getUniqueId());
        vVar.n0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.o(), a2.S2, this.f58367a.getUniqueId());
        sVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.j jVar = new d.a.k0.q0.n1.d.j(frsNewAreaFragment.o(), a2.U2, this.f58367a.getUniqueId());
        jVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.m mVar = new d.a.k0.q0.n1.d.m(frsNewAreaFragment.o(), a2.V2, this.f58367a.getUniqueId());
        mVar.n0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.o(), a2.a3, this.f58367a.getUniqueId());
        a0Var.n0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.o(), a2.t3, this.f58367a.getUniqueId());
        wVar.n0(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.o(), a2.b3, this.f58367a.getUniqueId());
        r rVar = new r(frsNewAreaFragment.o(), a2.c3, this.f58367a.getUniqueId());
        z zVar = new z(frsNewAreaFragment.getPageContext(), a2.f3, this.f58367a.getUniqueId());
        zVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.l lVar = new d.a.k0.q0.n1.d.l(frsNewAreaFragment.getPageContext(), a2.y3, this.f58367a.getUniqueId());
        lVar.n0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.d3, this.f58367a.getUniqueId());
        pVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.b bVar = new d.a.k0.q0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.m3, this.f58367a.getUniqueId());
        bVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.g gVar = new d.a.k0.q0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.l3, this.f58367a.getUniqueId());
        gVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.h hVar = new d.a.k0.q0.n1.d.h(frsNewAreaFragment.getPageContext(), a2.n3, this.f58367a.getUniqueId());
        hVar.n0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.e3, this.f58367a.getUniqueId());
        tVar.n0(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), a2.o3, this.f58367a.getUniqueId());
        zVar2.n0(bdTypeRecyclerView);
        d.a.k0.q0.s sVar2 = new d.a.k0.q0.s(frsNewAreaFragment.getPageContext(), d.a.k0.q0.t.f59517f);
        sVar2.n0(bdTypeRecyclerView);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.k0.q0.e.e().a(frsNewAreaFragment.getPageContext(), this.f58367a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.k0.q0.e.e().d(frsNewAreaFragment.getPageContext(), a2.C3, this.f58367a.getUniqueId());
        d.a.c.j.e.a<?, ?> h2 = x.p().h(this.f58367a, AdvertAppInfo.Z3);
        d.a.c.j.e.a<?, ?> h3 = x.p().h(this.f58367a, AdvertAppInfo.c4);
        d.a.k0.q0.n1.d.x xVar = new d.a.k0.q0.n1.d.x(frsNewAreaFragment.getPageContext(), a2.k3, this.f58367a.getUniqueId());
        xVar.n0(bdTypeRecyclerView);
        d.a.k0.q0.n1.d.e eVar = new d.a.k0.q0.n1.d.e(frsNewAreaFragment.getPageContext(), a2.Z2, this.f58367a.getUniqueId());
        eVar.h0(bdTypeRecyclerView);
        this.f58370d.add(yVar);
        this.f58370d.add(kVar);
        this.f58370d.add(vVar);
        this.f58370d.add(sVar);
        this.f58370d.add(jVar);
        this.f58370d.add(mVar);
        this.f58370d.add(wVar);
        this.f58370d.add(a0Var);
        this.f58370d.add(uVar);
        this.f58370d.add(rVar);
        this.f58370d.add(zVar);
        this.f58370d.add(pVar);
        this.f58370d.add(bVar);
        this.f58370d.add(gVar);
        this.f58370d.add(hVar);
        this.f58370d.add(tVar);
        this.f58370d.add(sVar2);
        this.f58370d.add(lVar);
        this.f58370d.add(zVar2);
        this.f58370d.add(xVar);
        this.f58370d.add(eVar);
        if (a2 != null) {
            this.f58370d.add(a2);
        }
        if (d2 != null) {
            this.f58370d.add(d2);
        }
        this.f58370d.add(h2);
        this.f58370d.add(h3);
        d.a.c.j.e.a<?, ?> b2 = d.a.k0.r0.b.e().b(this.f58367a.getBaseFragmentActivity(), AdvertAppInfo.k4);
        d.a.c.j.e.a<?, ?> b3 = d.a.k0.r0.b.e().b(this.f58367a.getBaseFragmentActivity(), AdvertAppInfo.j4);
        this.f58370d.add(b2);
        this.f58370d.add(b3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f58367a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.a.k0.q0.k) {
                    ((d.a.k0.q0.k) next).n(this.f58367a.getPageContext(), this.f58367a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.j.e.a> list = this.f58370d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.a.k0.e.f.b bVar2 = new d.a.k0.e.f.b(this.f58367a, 1);
        bVar2.t(this.f58370d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f58370d);
    }

    public void l() {
        this.f58368b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f58368b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
    }

    public void o() {
        for (d.a.c.j.e.a aVar : this.f58370d) {
            if (aVar instanceof d.a.k0.q0.k) {
                ((d.a.k0.q0.k) aVar).h0();
            } else if (aVar instanceof d.a.k0.s2.p) {
                ((d.a.k0.s2.p) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f58368b.setData(this.f58372f);
        l();
    }

    public void q(ArrayList<d.a.c.j.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f58368b.setData(arrayList);
        this.f58372f = arrayList;
        this.f58373g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.a.c.j.e.a> list = this.f58370d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58370d) {
            if (aVar instanceof d.a.k0.q0.k) {
                ((d.a.k0.q0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f58370d) || this.f58367a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58370d) {
            if (aVar instanceof d.a.k0.q0.k) {
                ((d.a.k0.q0.k) aVar).p0(this.f58367a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f58370d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58370d) {
            if (aVar instanceof d.a.k0.q0.k) {
                ((d.a.k0.q0.k) aVar).m0(frsViewData);
            }
        }
    }

    public void u(d.a.c.j.e.w wVar) {
        List<d.a.c.j.e.a> list = this.f58370d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58370d) {
            if (aVar != null && (aVar instanceof d.a.k0.q0.k)) {
                ((d.a.k0.q0.k) aVar).Z(wVar);
            }
        }
    }

    public final void v() {
        d.a.k0.q0.j2.b i2;
        if (this.f58373g == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58370d) {
            if ((aVar instanceof d.a.k0.q0.j2.d) && (i2 = ((d.a.k0.q0.j2.d) aVar).i()) != null) {
                if (this.f58373g.needLog == 1) {
                    i2.f58633a = true;
                } else {
                    i2.f58633a = false;
                }
                if (this.f58373g.getForum() != null) {
                    i2.f58635c = this.f58373g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58368b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f58368b.getData().size() == 0) {
            return;
        }
        for (d.a.c.j.e.n nVar : this.f58368b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.X2();
                }
            }
        }
    }
}
