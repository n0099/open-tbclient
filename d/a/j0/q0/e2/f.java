package d.a.j0.q0.e2;

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
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.d3.v;
import d.a.j0.q0.n1.d.a0;
import d.a.j0.q0.n1.d.p;
import d.a.j0.q0.n1.d.r;
import d.a.j0.q0.n1.d.s;
import d.a.j0.q0.n1.d.t;
import d.a.j0.q0.n1.d.u;
import d.a.j0.q0.n1.d.w;
import d.a.j0.q0.n1.d.x;
import d.a.j0.q0.n1.d.y;
import d.a.j0.q0.n1.d.z;
import d.a.j0.s2.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f57625a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57626b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57627c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f57629e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f57630f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f57631g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57628d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f57632h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f57627c)) {
                f fVar = f.this;
                fVar.g(fVar.f57626b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f57630f, f.this.f57631g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f57626b = bdTypeRecyclerView;
        this.f57629e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57625a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f57625a.registerListener(this.f57632h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57625a != null && bdTypeRecyclerView != null) {
            this.f57627c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.j0.q0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = d.a.j0.q0.e.e().b(this.f57625a.getPageContext(), g2.get(i2), this.f57625a.getUniqueId());
                    if (b2 != null) {
                        this.f57628d.add(b2);
                        this.f57627c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f57627c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f57627c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> h() {
        return this.f57629e;
    }

    public final void i(ArrayList<d.a.c.j.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.j.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f57629e) != null && !hashMap.containsValue(nVar)) {
                this.f57629e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<d.a.c.j.e.n> j() {
        return this.f57630f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57625a = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.o(), a2.N2, this.f57625a.getUniqueId());
        yVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.k kVar = new d.a.j0.q0.n1.d.k(frsNewAreaFragment.o(), a2.O2, this.f57625a.getUniqueId());
        kVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.v vVar = new d.a.j0.q0.n1.d.v(frsNewAreaFragment.o(), a2.Q2, this.f57625a.getUniqueId());
        vVar.p0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.o(), a2.R2, this.f57625a.getUniqueId());
        sVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.j jVar = new d.a.j0.q0.n1.d.j(frsNewAreaFragment.o(), a2.T2, this.f57625a.getUniqueId());
        jVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.m mVar = new d.a.j0.q0.n1.d.m(frsNewAreaFragment.o(), a2.U2, this.f57625a.getUniqueId());
        mVar.p0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.o(), a2.Z2, this.f57625a.getUniqueId());
        a0Var.p0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.o(), a2.s3, this.f57625a.getUniqueId());
        wVar.p0(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.o(), a2.a3, this.f57625a.getUniqueId());
        r rVar = new r(frsNewAreaFragment.o(), a2.b3, this.f57625a.getUniqueId());
        z zVar = new z(frsNewAreaFragment.getPageContext(), a2.e3, this.f57625a.getUniqueId());
        zVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.l lVar = new d.a.j0.q0.n1.d.l(frsNewAreaFragment.getPageContext(), a2.x3, this.f57625a.getUniqueId());
        lVar.p0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.c3, this.f57625a.getUniqueId());
        pVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.b bVar = new d.a.j0.q0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.l3, this.f57625a.getUniqueId());
        bVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.g gVar = new d.a.j0.q0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.k3, this.f57625a.getUniqueId());
        gVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.h hVar = new d.a.j0.q0.n1.d.h(frsNewAreaFragment.getPageContext(), a2.m3, this.f57625a.getUniqueId());
        hVar.p0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.d3, this.f57625a.getUniqueId());
        tVar.p0(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), a2.n3, this.f57625a.getUniqueId());
        zVar2.p0(bdTypeRecyclerView);
        d.a.j0.q0.s sVar2 = new d.a.j0.q0.s(frsNewAreaFragment.getPageContext(), d.a.j0.q0.t.f58775f);
        sVar2.p0(bdTypeRecyclerView);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.j0.q0.e.e().a(frsNewAreaFragment.getPageContext(), this.f57625a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.j0.q0.e.e().d(frsNewAreaFragment.getPageContext(), a2.B3, this.f57625a.getUniqueId());
        d.a.c.j.e.a<?, ?> h2 = d.a.j0.s2.w.p().h(this.f57625a, AdvertAppInfo.h4);
        d.a.c.j.e.a<?, ?> h3 = d.a.j0.s2.w.p().h(this.f57625a, AdvertAppInfo.k4);
        x xVar = new x(frsNewAreaFragment.getPageContext(), a2.j3, this.f57625a.getUniqueId());
        xVar.p0(bdTypeRecyclerView);
        d.a.j0.q0.n1.d.e eVar = new d.a.j0.q0.n1.d.e(frsNewAreaFragment.getPageContext(), a2.Y2, this.f57625a.getUniqueId());
        eVar.h0(bdTypeRecyclerView);
        this.f57628d.add(yVar);
        this.f57628d.add(kVar);
        this.f57628d.add(vVar);
        this.f57628d.add(sVar);
        this.f57628d.add(jVar);
        this.f57628d.add(mVar);
        this.f57628d.add(wVar);
        this.f57628d.add(a0Var);
        this.f57628d.add(uVar);
        this.f57628d.add(rVar);
        this.f57628d.add(zVar);
        this.f57628d.add(pVar);
        this.f57628d.add(bVar);
        this.f57628d.add(gVar);
        this.f57628d.add(hVar);
        this.f57628d.add(tVar);
        this.f57628d.add(sVar2);
        this.f57628d.add(lVar);
        this.f57628d.add(zVar2);
        this.f57628d.add(xVar);
        this.f57628d.add(eVar);
        if (a2 != null) {
            this.f57628d.add(a2);
        }
        if (d2 != null) {
            this.f57628d.add(d2);
        }
        this.f57628d.add(h2);
        this.f57628d.add(h3);
        d.a.c.j.e.a<?, ?> b2 = d.a.j0.r0.b.e().b(this.f57625a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        d.a.c.j.e.a<?, ?> b3 = d.a.j0.r0.b.e().b(this.f57625a.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.f57628d.add(b2);
        this.f57628d.add(b3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f57625a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.a.j0.q0.k) {
                    ((d.a.j0.q0.k) next).n(this.f57625a.getPageContext(), this.f57625a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.j.e.a> list = this.f57628d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.a.j0.e.f.b bVar2 = new d.a.j0.e.f.b(this.f57625a, 1);
        bVar2.t(this.f57628d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f57628d);
    }

    public void l() {
        this.f57626b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f57626b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
    }

    public void o() {
        for (d.a.c.j.e.a aVar : this.f57628d) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).i0();
            } else if (aVar instanceof o) {
                ((o) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f57626b.setData(this.f57630f);
        l();
    }

    public void q(ArrayList<d.a.c.j.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f57626b.setData(arrayList);
        this.f57630f = arrayList;
        this.f57631g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.a.c.j.e.a> list = this.f57628d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57628d) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f57628d) || this.f57625a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57628d) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).q0(this.f57625a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f57628d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57628d) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).n0(frsViewData);
            }
        }
    }

    public void u(d.a.c.j.e.w wVar) {
        List<d.a.c.j.e.a> list = this.f57628d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57628d) {
            if (aVar != null && (aVar instanceof d.a.j0.q0.k)) {
                ((d.a.j0.q0.k) aVar).Z(wVar);
            }
        }
    }

    public final void v() {
        d.a.j0.q0.j2.b i2;
        if (this.f57631g == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57628d) {
            if ((aVar instanceof d.a.j0.q0.j2.d) && (i2 = ((d.a.j0.q0.j2.d) aVar).i()) != null) {
                if (this.f57631g.needLog == 1) {
                    i2.f57891a = true;
                } else {
                    i2.f57891a = false;
                }
                if (this.f57631g.getForum() != null) {
                    i2.f57893c = this.f57631g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57626b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f57626b.getData().size() == 0) {
            return;
        }
        for (d.a.c.j.e.n nVar : this.f57626b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.V2();
                }
            }
        }
    }
}
