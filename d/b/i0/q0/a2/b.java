package d.b.i0.q0.a2;

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
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.d3.v;
import d.b.i0.m.f;
import d.b.i0.q0.e;
import d.b.i0.q0.j2.d;
import d.b.i0.q0.k;
import d.b.i0.q0.n1.d.a0;
import d.b.i0.q0.n1.d.g;
import d.b.i0.q0.n1.d.h;
import d.b.i0.q0.n1.d.j;
import d.b.i0.q0.n1.d.m;
import d.b.i0.q0.n1.d.p;
import d.b.i0.q0.n1.d.r;
import d.b.i0.q0.n1.d.s;
import d.b.i0.q0.n1.d.t;
import d.b.i0.q0.n1.d.u;
import d.b.i0.q0.n1.d.x;
import d.b.i0.q0.n1.d.y;
import d.b.i0.x.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f59039a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59040b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59041c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f59043e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f59044f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f59045g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f59046h;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59042d = new LinkedList();
    public CustomMessageListener i = new a(2003008);
    public CustomMessageListener j = new C1439b(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<d.b.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.b.c.j.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).i(b.this.f59039a.getPageContext(), b.this.f59039a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.f59042d != null) {
                    b.this.f59042d.addAll(arrayList);
                }
                if (b.this.f59040b != null) {
                    b.this.f59040b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.b.i0.q0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1439b extends CustomMessageListener {
        public C1439b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(b.this.f59041c)) {
                b bVar = b.this;
                bVar.i(bVar.f59040b);
                b bVar2 = b.this;
                bVar2.w(bVar2.f59044f, b.this.f59046h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f59040b = bdTypeRecyclerView;
        this.f59043e = new HashMap<>();
    }

    public void A() {
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar instanceof z) {
                ((z) aVar).p(3);
            }
        }
    }

    public void B(w wVar) {
        List<d.b.c.j.e.a> list = this.f59042d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).c0(wVar);
            }
        }
    }

    public final void C() {
        d.b.i0.q0.j2.b b2;
        if (this.f59046h == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if ((aVar instanceof d) && (b2 = ((d) aVar).b()) != null) {
                if (this.f59046h.needLog == 1) {
                    b2.f59399a = true;
                } else {
                    b2.f59399a = false;
                }
                if (this.f59046h.getForum() != null) {
                    b2.f59401c = this.f59046h.getForum().getId();
                }
                if (this.f59039a != null) {
                    b2.f59400b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59040b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f59040b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f59040b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.V2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59039a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f59039a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59039a != null && bdTypeRecyclerView != null) {
            this.f59041c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(this.f59039a.getPageContext(), g2.get(i), this.f59039a.getUniqueId());
                    if (a2 != null) {
                        this.f59042d.add(a2);
                        this.f59041c.add(a2);
                    }
                }
                if (ListUtils.isEmpty(this.f59041c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f59041c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> j() {
        return this.f59043e;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f59043e) != null && !hashMap.containsValue(nVar)) {
                this.f59043e.put(Integer.valueOf(i), (a2) nVar);
            }
        }
    }

    public List<n> l() {
        return this.f59044f;
    }

    public List<n> m() {
        return this.f59045g;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59039a = frsGoodFragment;
        this.i.setPriority(1);
        this.i.setSelfListener(true);
        this.f59039a.registerListener(this.i);
        y yVar = new y(frsGoodFragment.q(), a2.N2, this.f59039a.getUniqueId());
        d.b.i0.q0.n1.d.k kVar = new d.b.i0.q0.n1.d.k(frsGoodFragment.q(), a2.O2, this.f59039a.getUniqueId());
        d.b.i0.q0.n1.d.v vVar = new d.b.i0.q0.n1.d.v(frsGoodFragment.q(), a2.Q2, this.f59039a.getUniqueId());
        s sVar = new s(frsGoodFragment.q(), a2.R2, this.f59039a.getUniqueId());
        j jVar = new j(frsGoodFragment.q(), a2.T2, this.f59039a.getUniqueId());
        m mVar = new m(frsGoodFragment.q(), a2.U2, this.f59039a.getUniqueId());
        a0 a0Var = new a0(frsGoodFragment.q(), a2.Z2, this.f59039a.getUniqueId());
        d.b.i0.q0.n1.d.w wVar = new d.b.i0.q0.n1.d.w(frsGoodFragment.q(), a2.s3, this.f59039a.getUniqueId());
        u uVar = new u(frsGoodFragment.q(), a2.a3, this.f59039a.getUniqueId());
        r rVar = new r(frsGoodFragment.q(), a2.b3, this.f59039a.getUniqueId());
        d.b.i0.q0.n1.d.z zVar = new d.b.i0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.e3, this.f59039a.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), a2.c3, this.f59039a.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), a2.d3, this.f59039a.getUniqueId());
        d.b.i0.q0.n1.d.z zVar2 = new d.b.i0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.n3, this.f59039a.getUniqueId());
        d.b.i0.q0.s sVar2 = new d.b.i0.q0.s(frsGoodFragment.getPageContext(), d.b.i0.q0.t.f60247f);
        d.b.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), this.f59039a.getUniqueId(), true);
        d.b.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = e.e().c(frsGoodFragment.getPageContext(), a2.B3, this.f59039a.getUniqueId());
        d.b.c.j.e.a<?, ?> j = d.b.i0.s2.v.p().j(this.f59039a, AdvertAppInfo.h4);
        d.b.c.j.e.a<?, ?> j2 = d.b.i0.s2.v.p().j(this.f59039a, AdvertAppInfo.k4);
        x xVar = new x(frsGoodFragment.getPageContext(), a2.j3, this.f59039a.getUniqueId());
        d.b.i0.q0.n1.d.b bVar = new d.b.i0.q0.n1.d.b(frsGoodFragment.getPageContext(), a2.l3, this.f59039a.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), a2.k3, this.f59039a.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), a2.m3, this.f59039a.getUniqueId());
        d.b.i0.q0.n1.d.e eVar = new d.b.i0.q0.n1.d.e(frsGoodFragment.getPageContext(), a2.Y2, this.f59039a.getUniqueId());
        eVar.l0(bdTypeRecyclerView);
        this.f59042d.add(yVar);
        this.f59042d.add(kVar);
        this.f59042d.add(vVar);
        this.f59042d.add(sVar);
        this.f59042d.add(jVar);
        this.f59042d.add(mVar);
        this.f59042d.add(wVar);
        this.f59042d.add(a0Var);
        this.f59042d.add(uVar);
        this.f59042d.add(rVar);
        this.f59042d.add(zVar);
        this.f59042d.add(pVar);
        this.f59042d.add(pVar);
        this.f59042d.add(tVar);
        this.f59042d.add(sVar2);
        this.f59042d.add(zVar);
        this.f59042d.add(zVar2);
        this.f59042d.add(xVar);
        this.f59042d.add(bVar);
        this.f59042d.add(gVar);
        this.f59042d.add(hVar);
        this.f59042d.add(eVar);
        if (d2 != null) {
            this.f59042d.add(d2);
        }
        if (c2 != null) {
            this.f59042d.add(c2);
        }
        this.f59042d.add(j);
        this.f59042d.add(j2);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f59039a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        h(bdTypeRecyclerView);
        this.f59042d.add(d.b.i0.r0.b.e().c(this.f59039a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        this.f59042d.add(d.b.i0.r0.b.e().c(this.f59039a.getBaseFragmentActivity(), AdvertAppInfo.m4));
        d.b.i0.e.f.b bVar2 = new d.b.i0.e.f.b(this.f59039a, 1);
        bVar2.t(this.f59042d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f59042d);
        v("page_frs_good");
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar instanceof d.b.i0.x.a0) {
                ((d.b.i0.x.a0) aVar).d(true);
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        this.f59040b.getAdapter().notifyDataSetChanged();
    }

    public void q() {
        this.f59040b.getAdapter().notifyDataSetChanged();
    }

    public void r(int i) {
    }

    public void s() {
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar instanceof k) {
                ((k) aVar).m0();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public void t() {
        this.f59040b.setData(this.f59045g);
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
        List<d.b.c.j.e.a> list = this.f59042d;
        if (list == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).o(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.b.i0.q0.t)) {
            frsViewData.setThreadList(arrayList);
        }
        z(frsViewData);
        y();
        u(arrayList);
        v.f(arrayList, 1);
        k(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.f59040b.setData(switchThreadDataToThreadCardInfo);
        this.f59045g = switchThreadDataToThreadCardInfo;
        this.f59044f = arrayList;
        this.f59046h = frsViewData;
        C();
    }

    public void x(boolean z) {
        List<d.b.c.j.e.a> list = this.f59042d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        if (ListUtils.isEmpty(this.f59042d) || this.f59039a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f59039a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.b.c.j.e.a> list = this.f59042d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59042d) {
            if (aVar instanceof k) {
                ((k) aVar).p0(frsViewData);
            }
        }
    }
}
