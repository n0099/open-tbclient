package d.b.j0.q0.e2;

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
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.j0.d3.v;
import d.b.j0.q0.n1.d.a0;
import d.b.j0.q0.n1.d.p;
import d.b.j0.q0.n1.d.r;
import d.b.j0.q0.n1.d.s;
import d.b.j0.q0.n1.d.t;
import d.b.j0.q0.n1.d.u;
import d.b.j0.q0.n1.d.w;
import d.b.j0.q0.n1.d.x;
import d.b.j0.q0.n1.d.y;
import d.b.j0.q0.n1.d.z;
import d.b.j0.s2.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f59570a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59571b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59572c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f59574e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.b.c.j.e.n> f59575f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f59576g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59573d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f59577h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f59572c)) {
                f fVar = f.this;
                fVar.g(fVar.f59571b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f59575f, f.this.f59576g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f59571b = bdTypeRecyclerView;
        this.f59574e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59570a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f59570a.registerListener(this.f59577h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59570a != null && bdTypeRecyclerView != null) {
            this.f59572c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    d.b.j0.q0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = d.b.j0.q0.e.e().a(this.f59570a.getPageContext(), g2.get(i), this.f59570a.getUniqueId());
                    if (a2 != null) {
                        this.f59573d.add(a2);
                        this.f59572c.add(a2);
                    }
                }
                if (ListUtils.isEmpty(this.f59572c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f59572c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> h() {
        return this.f59574e;
    }

    public final void i(ArrayList<d.b.c.j.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.c.j.e.n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f59574e) != null && !hashMap.containsValue(nVar)) {
                this.f59574e.put(Integer.valueOf(i), (a2) nVar);
            }
        }
    }

    public List<d.b.c.j.e.n> j() {
        return this.f59575f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59570a = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.q(), a2.N2, this.f59570a.getUniqueId());
        yVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.k kVar = new d.b.j0.q0.n1.d.k(frsNewAreaFragment.q(), a2.O2, this.f59570a.getUniqueId());
        kVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.v vVar = new d.b.j0.q0.n1.d.v(frsNewAreaFragment.q(), a2.Q2, this.f59570a.getUniqueId());
        vVar.q0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.q(), a2.R2, this.f59570a.getUniqueId());
        sVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.j jVar = new d.b.j0.q0.n1.d.j(frsNewAreaFragment.q(), a2.T2, this.f59570a.getUniqueId());
        jVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.m mVar = new d.b.j0.q0.n1.d.m(frsNewAreaFragment.q(), a2.U2, this.f59570a.getUniqueId());
        mVar.q0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.q(), a2.Z2, this.f59570a.getUniqueId());
        a0Var.q0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.q(), a2.s3, this.f59570a.getUniqueId());
        wVar.q0(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.q(), a2.a3, this.f59570a.getUniqueId());
        r rVar = new r(frsNewAreaFragment.q(), a2.b3, this.f59570a.getUniqueId());
        z zVar = new z(frsNewAreaFragment.getPageContext(), a2.e3, this.f59570a.getUniqueId());
        zVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.l lVar = new d.b.j0.q0.n1.d.l(frsNewAreaFragment.getPageContext(), a2.x3, this.f59570a.getUniqueId());
        lVar.q0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.c3, this.f59570a.getUniqueId());
        pVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.b bVar = new d.b.j0.q0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.l3, this.f59570a.getUniqueId());
        bVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.g gVar = new d.b.j0.q0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.k3, this.f59570a.getUniqueId());
        gVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.h hVar = new d.b.j0.q0.n1.d.h(frsNewAreaFragment.getPageContext(), a2.m3, this.f59570a.getUniqueId());
        hVar.q0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.d3, this.f59570a.getUniqueId());
        tVar.q0(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), a2.n3, this.f59570a.getUniqueId());
        zVar2.q0(bdTypeRecyclerView);
        d.b.j0.q0.s sVar2 = new d.b.j0.q0.s(frsNewAreaFragment.getPageContext(), d.b.j0.q0.t.f60668f);
        sVar2.q0(bdTypeRecyclerView);
        d.b.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = d.b.j0.q0.e.e().d(frsNewAreaFragment.getPageContext(), this.f59570a.getUniqueId(), true);
        d.b.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = d.b.j0.q0.e.e().c(frsNewAreaFragment.getPageContext(), a2.B3, this.f59570a.getUniqueId());
        d.b.c.j.e.a<?, ?> j = d.b.j0.s2.v.p().j(this.f59570a, AdvertAppInfo.h4);
        d.b.c.j.e.a<?, ?> j2 = d.b.j0.s2.v.p().j(this.f59570a, AdvertAppInfo.k4);
        x xVar = new x(frsNewAreaFragment.getPageContext(), a2.j3, this.f59570a.getUniqueId());
        xVar.q0(bdTypeRecyclerView);
        d.b.j0.q0.n1.d.e eVar = new d.b.j0.q0.n1.d.e(frsNewAreaFragment.getPageContext(), a2.Y2, this.f59570a.getUniqueId());
        eVar.l0(bdTypeRecyclerView);
        this.f59573d.add(yVar);
        this.f59573d.add(kVar);
        this.f59573d.add(vVar);
        this.f59573d.add(sVar);
        this.f59573d.add(jVar);
        this.f59573d.add(mVar);
        this.f59573d.add(wVar);
        this.f59573d.add(a0Var);
        this.f59573d.add(uVar);
        this.f59573d.add(rVar);
        this.f59573d.add(zVar);
        this.f59573d.add(pVar);
        this.f59573d.add(bVar);
        this.f59573d.add(gVar);
        this.f59573d.add(hVar);
        this.f59573d.add(tVar);
        this.f59573d.add(sVar2);
        this.f59573d.add(lVar);
        this.f59573d.add(zVar2);
        this.f59573d.add(xVar);
        this.f59573d.add(eVar);
        if (d2 != null) {
            this.f59573d.add(d2);
        }
        if (c2 != null) {
            this.f59573d.add(c2);
        }
        this.f59573d.add(j);
        this.f59573d.add(j2);
        d.b.c.j.e.a<?, ?> c3 = d.b.j0.r0.b.e().c(this.f59570a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        d.b.c.j.e.a<?, ?> c4 = d.b.j0.r0.b.e().c(this.f59570a.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.f59573d.add(c3);
        this.f59573d.add(c4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f59570a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.b.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.b.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.b.j0.q0.k) {
                    ((d.b.j0.q0.k) next).i(this.f59570a.getPageContext(), this.f59570a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.b.c.j.e.a> list = this.f59573d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.b.j0.e.f.b bVar2 = new d.b.j0.e.f.b(this.f59570a, 1);
        bVar2.t(this.f59573d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f59573d);
    }

    public void l() {
        this.f59571b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f59571b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i) {
    }

    public void o() {
        for (d.b.c.j.e.a aVar : this.f59573d) {
            if (aVar instanceof d.b.j0.q0.k) {
                ((d.b.j0.q0.k) aVar).m0();
            } else if (aVar instanceof o) {
                ((o) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f59571b.setData(this.f59575f);
        l();
    }

    public void q(ArrayList<d.b.c.j.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f59571b.setData(arrayList);
        this.f59575f = arrayList;
        this.f59576g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.b.c.j.e.a> list = this.f59573d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59573d) {
            if (aVar instanceof d.b.j0.q0.k) {
                ((d.b.j0.q0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f59573d) || this.f59570a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59573d) {
            if (aVar instanceof d.b.j0.q0.k) {
                ((d.b.j0.q0.k) aVar).r0(this.f59570a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.b.c.j.e.a> list = this.f59573d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59573d) {
            if (aVar instanceof d.b.j0.q0.k) {
                ((d.b.j0.q0.k) aVar).p0(frsViewData);
            }
        }
    }

    public void u(d.b.c.j.e.w wVar) {
        List<d.b.c.j.e.a> list = this.f59573d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59573d) {
            if (aVar != null && (aVar instanceof d.b.j0.q0.k)) {
                ((d.b.j0.q0.k) aVar).c0(wVar);
            }
        }
    }

    public final void v() {
        d.b.j0.q0.j2.b b2;
        if (this.f59576g == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59573d) {
            if ((aVar instanceof d.b.j0.q0.j2.d) && (b2 = ((d.b.j0.q0.j2.d) aVar).b()) != null) {
                if (this.f59576g.needLog == 1) {
                    b2.f59820a = true;
                } else {
                    b2.f59820a = false;
                }
                if (this.f59576g.getForum() != null) {
                    b2.f59822c = this.f59576g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59571b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f59571b.getData().size() == 0) {
            return;
        }
        for (d.b.c.j.e.n nVar : this.f59571b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.V2();
                }
            }
        }
    }
}
