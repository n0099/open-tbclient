package d.a.k0.q0.a2;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.k0.d3.v;
import d.a.k0.m.f;
import d.a.k0.q0.e;
import d.a.k0.q0.j2.d;
import d.a.k0.q0.k;
import d.a.k0.q0.n1.d.a0;
import d.a.k0.q0.n1.d.g;
import d.a.k0.q0.n1.d.h;
import d.a.k0.q0.n1.d.j;
import d.a.k0.q0.n1.d.m;
import d.a.k0.q0.n1.d.p;
import d.a.k0.q0.n1.d.r;
import d.a.k0.q0.n1.d.s;
import d.a.k0.q0.n1.d.t;
import d.a.k0.q0.n1.d.u;
import d.a.k0.q0.n1.d.y;
import d.a.k0.s2.x;
import d.a.k0.x.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f58242a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58243b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58244c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f58246e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f58247f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f58248g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f58249h;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58245d = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f58250i = new a(2003008);
    public CustomMessageListener j = new C1475b(2016470);

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
                        ((k) next).n(b.this.f58242a.getPageContext(), b.this.f58242a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.f58245d != null) {
                    b.this.f58245d.addAll(arrayList);
                }
                if (b.this.f58243b != null) {
                    b.this.f58243b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.a.k0.q0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1475b extends CustomMessageListener {
        public C1475b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(b.this.f58244c)) {
                b bVar = b.this;
                bVar.i(bVar.f58243b);
                b bVar2 = b.this;
                bVar2.w(bVar2.f58247f, b.this.f58249h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f58243b = bdTypeRecyclerView;
        this.f58246e = new HashMap<>();
    }

    public void A() {
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar instanceof z) {
                ((z) aVar).q(3);
            }
        }
    }

    public void B(w wVar) {
        List<d.a.c.j.e.a> list = this.f58245d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).Z(wVar);
            }
        }
    }

    public final void C() {
        d.a.k0.q0.j2.b i2;
        if (this.f58249h == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if ((aVar instanceof d) && (i2 = ((d) aVar).i()) != null) {
                if (this.f58249h.needLog == 1) {
                    i2.f58633a = true;
                } else {
                    i2.f58633a = false;
                }
                if (this.f58249h.getForum() != null) {
                    i2.f58635c = this.f58249h.getForum().getId();
                }
                if (this.f58242a != null) {
                    i2.f58634b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58243b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f58243b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f58243b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.X2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58242a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f58242a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58242a != null && bdTypeRecyclerView != null) {
            this.f58244c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f58242a.getPageContext(), g2.get(i2), this.f58242a.getUniqueId());
                    if (b2 != null) {
                        this.f58245d.add(b2);
                        this.f58244c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f58244c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f58244c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> j() {
        return this.f58246e;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f58246e) != null && !hashMap.containsValue(nVar)) {
                this.f58246e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<n> l() {
        return this.f58247f;
    }

    public List<n> m() {
        return this.f58248g;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58242a = frsGoodFragment;
        this.f58250i.setPriority(1);
        this.f58250i.setSelfListener(true);
        this.f58242a.registerListener(this.f58250i);
        y yVar = new y(frsGoodFragment.o(), a2.O2, this.f58242a.getUniqueId());
        d.a.k0.q0.n1.d.k kVar = new d.a.k0.q0.n1.d.k(frsGoodFragment.o(), a2.P2, this.f58242a.getUniqueId());
        d.a.k0.q0.n1.d.v vVar = new d.a.k0.q0.n1.d.v(frsGoodFragment.o(), a2.R2, this.f58242a.getUniqueId());
        s sVar = new s(frsGoodFragment.o(), a2.S2, this.f58242a.getUniqueId());
        j jVar = new j(frsGoodFragment.o(), a2.U2, this.f58242a.getUniqueId());
        m mVar = new m(frsGoodFragment.o(), a2.V2, this.f58242a.getUniqueId());
        a0 a0Var = new a0(frsGoodFragment.o(), a2.a3, this.f58242a.getUniqueId());
        d.a.k0.q0.n1.d.w wVar = new d.a.k0.q0.n1.d.w(frsGoodFragment.o(), a2.t3, this.f58242a.getUniqueId());
        u uVar = new u(frsGoodFragment.o(), a2.b3, this.f58242a.getUniqueId());
        r rVar = new r(frsGoodFragment.o(), a2.c3, this.f58242a.getUniqueId());
        d.a.k0.q0.n1.d.z zVar = new d.a.k0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.f3, this.f58242a.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), a2.d3, this.f58242a.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), a2.e3, this.f58242a.getUniqueId());
        d.a.k0.q0.n1.d.z zVar2 = new d.a.k0.q0.n1.d.z(frsGoodFragment.getPageContext(), a2.o3, this.f58242a.getUniqueId());
        d.a.k0.q0.s sVar2 = new d.a.k0.q0.s(frsGoodFragment.getPageContext(), d.a.k0.q0.t.f59517f);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f58242a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), a2.C3, this.f58242a.getUniqueId());
        d.a.c.j.e.a<?, ?> h2 = x.p().h(this.f58242a, AdvertAppInfo.Z3);
        d.a.c.j.e.a<?, ?> h3 = x.p().h(this.f58242a, AdvertAppInfo.c4);
        d.a.k0.q0.n1.d.x xVar = new d.a.k0.q0.n1.d.x(frsGoodFragment.getPageContext(), a2.k3, this.f58242a.getUniqueId());
        d.a.k0.q0.n1.d.b bVar = new d.a.k0.q0.n1.d.b(frsGoodFragment.getPageContext(), a2.m3, this.f58242a.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), a2.l3, this.f58242a.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), a2.n3, this.f58242a.getUniqueId());
        d.a.k0.q0.n1.d.e eVar = new d.a.k0.q0.n1.d.e(frsGoodFragment.getPageContext(), a2.Z2, this.f58242a.getUniqueId());
        eVar.h0(bdTypeRecyclerView);
        this.f58245d.add(yVar);
        this.f58245d.add(kVar);
        this.f58245d.add(vVar);
        this.f58245d.add(sVar);
        this.f58245d.add(jVar);
        this.f58245d.add(mVar);
        this.f58245d.add(wVar);
        this.f58245d.add(a0Var);
        this.f58245d.add(uVar);
        this.f58245d.add(rVar);
        this.f58245d.add(zVar);
        this.f58245d.add(pVar);
        this.f58245d.add(pVar);
        this.f58245d.add(tVar);
        this.f58245d.add(sVar2);
        this.f58245d.add(zVar);
        this.f58245d.add(zVar2);
        this.f58245d.add(xVar);
        this.f58245d.add(bVar);
        this.f58245d.add(gVar);
        this.f58245d.add(hVar);
        this.f58245d.add(eVar);
        if (a2 != null) {
            this.f58245d.add(a2);
        }
        if (d2 != null) {
            this.f58245d.add(d2);
        }
        this.f58245d.add(h2);
        this.f58245d.add(h3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f58242a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        h(bdTypeRecyclerView);
        this.f58245d.add(d.a.k0.r0.b.e().b(this.f58242a.getBaseFragmentActivity(), AdvertAppInfo.k4));
        this.f58245d.add(d.a.k0.r0.b.e().b(this.f58242a.getBaseFragmentActivity(), AdvertAppInfo.j4));
        d.a.k0.e.f.b bVar2 = new d.a.k0.e.f.b(this.f58242a, 1);
        bVar2.t(this.f58245d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f58245d);
        v("page_frs_good");
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar instanceof d.a.k0.x.a0) {
                ((d.a.k0.x.a0) aVar).k(true);
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        this.f58243b.getAdapter().notifyDataSetChanged();
    }

    public void q() {
        this.f58243b.getAdapter().notifyDataSetChanged();
    }

    public void r(int i2) {
    }

    public void s() {
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar instanceof k) {
                ((k) aVar).h0();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.f58250i);
    }

    public void t() {
        this.f58243b.setData(this.f58248g);
        p();
    }

    public final void u(ArrayList<n> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == a2.H2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<d.a.c.j.e.a> list = this.f58245d;
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
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.a.k0.q0.t)) {
            frsViewData.setThreadList(arrayList);
        }
        z(frsViewData);
        y();
        u(arrayList);
        v.f(arrayList, 1);
        k(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.f58243b.setData(switchThreadDataToThreadCardInfo);
        this.f58248g = switchThreadDataToThreadCardInfo;
        this.f58247f = arrayList;
        this.f58249h = frsViewData;
        C();
    }

    public void x(boolean z) {
        List<d.a.c.j.e.a> list = this.f58245d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        if (ListUtils.isEmpty(this.f58245d) || this.f58242a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f58242a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f58245d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58245d) {
            if (aVar instanceof k) {
                ((k) aVar).m0(frsViewData);
            }
        }
    }
}
