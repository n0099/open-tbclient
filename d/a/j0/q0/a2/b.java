package d.a.j0.q0.a2;

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
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.d3.v;
import d.a.j0.m.f;
import d.a.j0.q0.e;
import d.a.j0.q0.j2.d;
import d.a.j0.q0.k;
import d.a.j0.q0.n1.d.a0;
import d.a.j0.q0.n1.d.g;
import d.a.j0.q0.n1.d.h;
import d.a.j0.q0.n1.d.j;
import d.a.j0.q0.n1.d.m;
import d.a.j0.q0.n1.d.p;
import d.a.j0.q0.n1.d.r;
import d.a.j0.q0.n1.d.s;
import d.a.j0.q0.n1.d.t;
import d.a.j0.q0.n1.d.u;
import d.a.j0.q0.n1.d.x;
import d.a.j0.q0.n1.d.y;
import d.a.j0.x.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f57500a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57501b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57502c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f57504e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f57505f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f57506g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f57507h;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57503d = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f57508i = new a(2003008);
    public CustomMessageListener j = new C1401b(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.c.j.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).n(b.this.f57500a.getPageContext(), b.this.f57500a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.f57503d != null) {
                    b.this.f57503d.addAll(arrayList);
                }
                if (b.this.f57501b != null) {
                    b.this.f57501b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.a.j0.q0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1401b extends CustomMessageListener {
        public C1401b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(b.this.f57502c)) {
                b bVar = b.this;
                bVar.i(bVar.f57501b);
                b bVar2 = b.this;
                bVar2.w(bVar2.f57505f, b.this.f57507h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f57501b = bdTypeRecyclerView;
        this.f57504e = new HashMap<>();
    }

    public void A() {
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar instanceof z) {
                ((z) aVar).q(3);
            }
        }
    }

    public void B(w wVar) {
        List<d.a.c.j.e.a> list = this.f57503d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).Z(wVar);
            }
        }
    }

    public final void C() {
        d.a.j0.q0.j2.b i2;
        if (this.f57507h == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if ((aVar instanceof d) && (i2 = ((d) aVar).i()) != null) {
                if (this.f57507h.needLog == 1) {
                    i2.f57891a = true;
                } else {
                    i2.f57891a = false;
                }
                if (this.f57507h.getForum() != null) {
                    i2.f57893c = this.f57507h.getForum().getId();
                }
                if (this.f57500a != null) {
                    i2.f57892b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57501b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f57501b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f57501b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.V2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57500a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f57500a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57500a != null && bdTypeRecyclerView != null) {
            this.f57502c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f57500a.getPageContext(), g2.get(i2), this.f57500a.getUniqueId());
                    if (b2 != null) {
                        this.f57503d.add(b2);
                        this.f57502c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f57502c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f57502c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> j() {
        return this.f57504e;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f57504e) != null && !hashMap.containsValue(nVar)) {
                this.f57504e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<n> l() {
        return this.f57505f;
    }

    public List<n> m() {
        return this.f57506g;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57500a = frsGoodFragment;
        this.f57508i.setPriority(1);
        this.f57508i.setSelfListener(true);
        this.f57500a.registerListener(this.f57508i);
        y yVar = new y(frsGoodFragment.o(), a2.N2, this.f57500a.getUniqueId());
        d.a.j0.q0.n1.d.k kVar = new d.a.j0.q0.n1.d.k(frsGoodFragment.o(), a2.O2, this.f57500a.getUniqueId());
        d.a.j0.q0.n1.d.v vVar = new d.a.j0.q0.n1.d.v(frsGoodFragment.o(), a2.Q2, this.f57500a.getUniqueId());
        s sVar = new s(frsGoodFragment.o(), a2.R2, this.f57500a.getUniqueId());
        j jVar = new j(frsGoodFragment.o(), a2.T2, this.f57500a.getUniqueId());
        m mVar = new m(frsGoodFragment.o(), a2.U2, this.f57500a.getUniqueId());
        a0 a0Var = new a0(frsGoodFragment.o(), a2.Z2, this.f57500a.getUniqueId());
        d.a.j0.q0.n1.d.w wVar = new d.a.j0.q0.n1.d.w(frsGoodFragment.o(), a2.s3, this.f57500a.getUniqueId());
        u uVar = new u(frsGoodFragment.o(), a2.a3, this.f57500a.getUniqueId());
        r rVar = new r(frsGoodFragment.o(), a2.b3, this.f57500a.getUniqueId());
        d.a.j0.q0.n1.d.z zVar = new d.a.j0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.e3, this.f57500a.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), a2.c3, this.f57500a.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), a2.d3, this.f57500a.getUniqueId());
        d.a.j0.q0.n1.d.z zVar2 = new d.a.j0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.n3, this.f57500a.getUniqueId());
        d.a.j0.q0.s sVar2 = new d.a.j0.q0.s(frsGoodFragment.getPageContext(), d.a.j0.q0.t.f58775f);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f57500a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), a2.B3, this.f57500a.getUniqueId());
        d.a.c.j.e.a<?, ?> h2 = d.a.j0.s2.w.p().h(this.f57500a, AdvertAppInfo.h4);
        d.a.c.j.e.a<?, ?> h3 = d.a.j0.s2.w.p().h(this.f57500a, AdvertAppInfo.k4);
        x xVar = new x(frsGoodFragment.getPageContext(), a2.j3, this.f57500a.getUniqueId());
        d.a.j0.q0.n1.d.b bVar = new d.a.j0.q0.n1.d.b(frsGoodFragment.getPageContext(), a2.l3, this.f57500a.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), a2.k3, this.f57500a.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), a2.m3, this.f57500a.getUniqueId());
        d.a.j0.q0.n1.d.e eVar = new d.a.j0.q0.n1.d.e(frsGoodFragment.getPageContext(), a2.Y2, this.f57500a.getUniqueId());
        eVar.h0(bdTypeRecyclerView);
        this.f57503d.add(yVar);
        this.f57503d.add(kVar);
        this.f57503d.add(vVar);
        this.f57503d.add(sVar);
        this.f57503d.add(jVar);
        this.f57503d.add(mVar);
        this.f57503d.add(wVar);
        this.f57503d.add(a0Var);
        this.f57503d.add(uVar);
        this.f57503d.add(rVar);
        this.f57503d.add(zVar);
        this.f57503d.add(pVar);
        this.f57503d.add(pVar);
        this.f57503d.add(tVar);
        this.f57503d.add(sVar2);
        this.f57503d.add(zVar);
        this.f57503d.add(zVar2);
        this.f57503d.add(xVar);
        this.f57503d.add(bVar);
        this.f57503d.add(gVar);
        this.f57503d.add(hVar);
        this.f57503d.add(eVar);
        if (a2 != null) {
            this.f57503d.add(a2);
        }
        if (d2 != null) {
            this.f57503d.add(d2);
        }
        this.f57503d.add(h2);
        this.f57503d.add(h3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f57500a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        h(bdTypeRecyclerView);
        this.f57503d.add(d.a.j0.r0.b.e().b(this.f57500a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        this.f57503d.add(d.a.j0.r0.b.e().b(this.f57500a.getBaseFragmentActivity(), AdvertAppInfo.m4));
        d.a.j0.e.f.b bVar2 = new d.a.j0.e.f.b(this.f57500a, 1);
        bVar2.t(this.f57503d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f57503d);
        v("page_frs_good");
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar instanceof d.a.j0.x.a0) {
                ((d.a.j0.x.a0) aVar).k(true);
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        this.f57501b.getAdapter().notifyDataSetChanged();
    }

    public void q() {
        this.f57501b.getAdapter().notifyDataSetChanged();
    }

    public void r(int i2) {
    }

    public void s() {
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar instanceof k) {
                ((k) aVar).i0();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.f57508i);
    }

    public void t() {
        this.f57501b.setData(this.f57506g);
        p();
    }

    public final void u(ArrayList<n> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == a2.G2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<d.a.c.j.e.a> list = this.f57503d;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.a.j0.q0.t)) {
            frsViewData.setThreadList(arrayList);
        }
        z(frsViewData);
        y();
        u(arrayList);
        v.f(arrayList, 1);
        k(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.f57501b.setData(switchThreadDataToThreadCardInfo);
        this.f57506g = switchThreadDataToThreadCardInfo;
        this.f57505f = arrayList;
        this.f57507h = frsViewData;
        C();
    }

    public void x(boolean z) {
        List<d.a.c.j.e.a> list = this.f57503d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        if (ListUtils.isEmpty(this.f57503d) || this.f57500a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar instanceof k) {
                ((k) aVar).q0(this.f57500a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f57503d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57503d) {
            if (aVar instanceof k) {
                ((k) aVar).n0(frsViewData);
            }
        }
    }
}
