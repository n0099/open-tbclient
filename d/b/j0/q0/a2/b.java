package d.b.j0.q0.a2;

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
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.j0.d3.v;
import d.b.j0.m.f;
import d.b.j0.q0.e;
import d.b.j0.q0.j2.d;
import d.b.j0.q0.k;
import d.b.j0.q0.n1.d.a0;
import d.b.j0.q0.n1.d.g;
import d.b.j0.q0.n1.d.h;
import d.b.j0.q0.n1.d.j;
import d.b.j0.q0.n1.d.m;
import d.b.j0.q0.n1.d.p;
import d.b.j0.q0.n1.d.r;
import d.b.j0.q0.n1.d.s;
import d.b.j0.q0.n1.d.t;
import d.b.j0.q0.n1.d.u;
import d.b.j0.q0.n1.d.x;
import d.b.j0.q0.n1.d.y;
import d.b.j0.x.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f59460a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59461b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59462c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f59464e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f59465f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f59466g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f59467h;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59463d = new LinkedList();
    public CustomMessageListener i = new a(2003008);
    public CustomMessageListener j = new C1462b(2016470);

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
                        ((k) next).i(b.this.f59460a.getPageContext(), b.this.f59460a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.f59463d != null) {
                    b.this.f59463d.addAll(arrayList);
                }
                if (b.this.f59461b != null) {
                    b.this.f59461b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.b.j0.q0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1462b extends CustomMessageListener {
        public C1462b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(b.this.f59462c)) {
                b bVar = b.this;
                bVar.i(bVar.f59461b);
                b bVar2 = b.this;
                bVar2.w(bVar2.f59465f, b.this.f59467h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f59461b = bdTypeRecyclerView;
        this.f59464e = new HashMap<>();
    }

    public void A() {
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar instanceof z) {
                ((z) aVar).p(3);
            }
        }
    }

    public void B(w wVar) {
        List<d.b.c.j.e.a> list = this.f59463d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).c0(wVar);
            }
        }
    }

    public final void C() {
        d.b.j0.q0.j2.b b2;
        if (this.f59467h == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if ((aVar instanceof d) && (b2 = ((d) aVar).b()) != null) {
                if (this.f59467h.needLog == 1) {
                    b2.f59820a = true;
                } else {
                    b2.f59820a = false;
                }
                if (this.f59467h.getForum() != null) {
                    b2.f59822c = this.f59467h.getForum().getId();
                }
                if (this.f59460a != null) {
                    b2.f59821b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59461b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f59461b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f59461b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.V2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59460a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f59460a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f59460a != null && bdTypeRecyclerView != null) {
            this.f59462c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(this.f59460a.getPageContext(), g2.get(i), this.f59460a.getUniqueId());
                    if (a2 != null) {
                        this.f59463d.add(a2);
                        this.f59462c.add(a2);
                    }
                }
                if (ListUtils.isEmpty(this.f59462c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f59462c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> j() {
        return this.f59464e;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f59464e) != null && !hashMap.containsValue(nVar)) {
                this.f59464e.put(Integer.valueOf(i), (a2) nVar);
            }
        }
    }

    public List<n> l() {
        return this.f59465f;
    }

    public List<n> m() {
        return this.f59466g;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59460a = frsGoodFragment;
        this.i.setPriority(1);
        this.i.setSelfListener(true);
        this.f59460a.registerListener(this.i);
        y yVar = new y(frsGoodFragment.q(), a2.N2, this.f59460a.getUniqueId());
        d.b.j0.q0.n1.d.k kVar = new d.b.j0.q0.n1.d.k(frsGoodFragment.q(), a2.O2, this.f59460a.getUniqueId());
        d.b.j0.q0.n1.d.v vVar = new d.b.j0.q0.n1.d.v(frsGoodFragment.q(), a2.Q2, this.f59460a.getUniqueId());
        s sVar = new s(frsGoodFragment.q(), a2.R2, this.f59460a.getUniqueId());
        j jVar = new j(frsGoodFragment.q(), a2.T2, this.f59460a.getUniqueId());
        m mVar = new m(frsGoodFragment.q(), a2.U2, this.f59460a.getUniqueId());
        a0 a0Var = new a0(frsGoodFragment.q(), a2.Z2, this.f59460a.getUniqueId());
        d.b.j0.q0.n1.d.w wVar = new d.b.j0.q0.n1.d.w(frsGoodFragment.q(), a2.s3, this.f59460a.getUniqueId());
        u uVar = new u(frsGoodFragment.q(), a2.a3, this.f59460a.getUniqueId());
        r rVar = new r(frsGoodFragment.q(), a2.b3, this.f59460a.getUniqueId());
        d.b.j0.q0.n1.d.z zVar = new d.b.j0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.e3, this.f59460a.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), a2.c3, this.f59460a.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), a2.d3, this.f59460a.getUniqueId());
        d.b.j0.q0.n1.d.z zVar2 = new d.b.j0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.n3, this.f59460a.getUniqueId());
        d.b.j0.q0.s sVar2 = new d.b.j0.q0.s(frsGoodFragment.getPageContext(), d.b.j0.q0.t.f60668f);
        d.b.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), this.f59460a.getUniqueId(), true);
        d.b.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = e.e().c(frsGoodFragment.getPageContext(), a2.B3, this.f59460a.getUniqueId());
        d.b.c.j.e.a<?, ?> j = d.b.j0.s2.v.p().j(this.f59460a, AdvertAppInfo.h4);
        d.b.c.j.e.a<?, ?> j2 = d.b.j0.s2.v.p().j(this.f59460a, AdvertAppInfo.k4);
        x xVar = new x(frsGoodFragment.getPageContext(), a2.j3, this.f59460a.getUniqueId());
        d.b.j0.q0.n1.d.b bVar = new d.b.j0.q0.n1.d.b(frsGoodFragment.getPageContext(), a2.l3, this.f59460a.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), a2.k3, this.f59460a.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), a2.m3, this.f59460a.getUniqueId());
        d.b.j0.q0.n1.d.e eVar = new d.b.j0.q0.n1.d.e(frsGoodFragment.getPageContext(), a2.Y2, this.f59460a.getUniqueId());
        eVar.l0(bdTypeRecyclerView);
        this.f59463d.add(yVar);
        this.f59463d.add(kVar);
        this.f59463d.add(vVar);
        this.f59463d.add(sVar);
        this.f59463d.add(jVar);
        this.f59463d.add(mVar);
        this.f59463d.add(wVar);
        this.f59463d.add(a0Var);
        this.f59463d.add(uVar);
        this.f59463d.add(rVar);
        this.f59463d.add(zVar);
        this.f59463d.add(pVar);
        this.f59463d.add(pVar);
        this.f59463d.add(tVar);
        this.f59463d.add(sVar2);
        this.f59463d.add(zVar);
        this.f59463d.add(zVar2);
        this.f59463d.add(xVar);
        this.f59463d.add(bVar);
        this.f59463d.add(gVar);
        this.f59463d.add(hVar);
        this.f59463d.add(eVar);
        if (d2 != null) {
            this.f59463d.add(d2);
        }
        if (c2 != null) {
            this.f59463d.add(c2);
        }
        this.f59463d.add(j);
        this.f59463d.add(j2);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f59460a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        h(bdTypeRecyclerView);
        this.f59463d.add(d.b.j0.r0.b.e().c(this.f59460a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        this.f59463d.add(d.b.j0.r0.b.e().c(this.f59460a.getBaseFragmentActivity(), AdvertAppInfo.m4));
        d.b.j0.e.f.b bVar2 = new d.b.j0.e.f.b(this.f59460a, 1);
        bVar2.t(this.f59463d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f59463d);
        v("page_frs_good");
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar instanceof d.b.j0.x.a0) {
                ((d.b.j0.x.a0) aVar).d(true);
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        this.f59461b.getAdapter().notifyDataSetChanged();
    }

    public void q() {
        this.f59461b.getAdapter().notifyDataSetChanged();
    }

    public void r(int i) {
    }

    public void s() {
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar instanceof k) {
                ((k) aVar).m0();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public void t() {
        this.f59461b.setData(this.f59466g);
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
        List<d.b.c.j.e.a> list = this.f59463d;
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
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.b.j0.q0.t)) {
            frsViewData.setThreadList(arrayList);
        }
        z(frsViewData);
        y();
        u(arrayList);
        v.f(arrayList, 1);
        k(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.f59461b.setData(switchThreadDataToThreadCardInfo);
        this.f59466g = switchThreadDataToThreadCardInfo;
        this.f59465f = arrayList;
        this.f59467h = frsViewData;
        C();
    }

    public void x(boolean z) {
        List<d.b.c.j.e.a> list = this.f59463d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        if (ListUtils.isEmpty(this.f59463d) || this.f59460a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f59460a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.b.c.j.e.a> list = this.f59463d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59463d) {
            if (aVar instanceof k) {
                ((k) aVar).p0(frsViewData);
            }
        }
    }
}
