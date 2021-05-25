package d.a.n0.r0.a2;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.e3.v;
import d.a.n0.o.f;
import d.a.n0.r0.e;
import d.a.n0.r0.j2.d;
import d.a.n0.r0.k;
import d.a.n0.r0.n1.d.a0;
import d.a.n0.r0.n1.d.g;
import d.a.n0.r0.n1.d.h;
import d.a.n0.r0.n1.d.j;
import d.a.n0.r0.n1.d.m;
import d.a.n0.r0.n1.d.p;
import d.a.n0.r0.n1.d.r;
import d.a.n0.r0.n1.d.s;
import d.a.n0.r0.n1.d.t;
import d.a.n0.r0.n1.d.u;
import d.a.n0.r0.n1.d.y;
import d.a.n0.t2.x;
import d.a.n0.z.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f58383a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58384b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58385c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f58387e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f58388f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f58389g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f58390h;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58386d = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f58391i = new a(2003008);
    public CustomMessageListener j = new C1488b(2016470);

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
                        ((k) next).n(b.this.f58383a.getPageContext(), b.this.f58383a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.f58386d != null) {
                    b.this.f58386d.addAll(arrayList);
                }
                if (b.this.f58384b != null) {
                    b.this.f58384b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.a.n0.r0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1488b extends CustomMessageListener {
        public C1488b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(b.this.f58385c)) {
                b bVar = b.this;
                bVar.i(bVar.f58384b);
                b bVar2 = b.this;
                bVar2.w(bVar2.f58388f, b.this.f58390h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f58384b = bdTypeRecyclerView;
        this.f58387e = new HashMap<>();
    }

    public void A() {
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar instanceof z) {
                ((z) aVar).q(3);
            }
        }
    }

    public void B(w wVar) {
        List<d.a.c.j.e.a> list = this.f58386d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).Z(wVar);
            }
        }
    }

    public final void C() {
        d.a.n0.r0.j2.b i2;
        if (this.f58390h == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if ((aVar instanceof d) && (i2 = ((d) aVar).i()) != null) {
                if (this.f58390h.needLog == 1) {
                    i2.f58774a = true;
                } else {
                    i2.f58774a = false;
                }
                if (this.f58390h.getForum() != null) {
                    i2.f58776c = this.f58390h.getForum().getId();
                }
                if (this.f58383a != null) {
                    i2.f58775b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58384b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f58384b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f58384b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.y0() != 0) {
                    z1Var.w.Y2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58383a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f58383a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f58383a != null && bdTypeRecyclerView != null) {
            this.f58385c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f58383a.getPageContext(), g2.get(i2), this.f58383a.getUniqueId());
                    if (b2 != null) {
                        this.f58386d.add(b2);
                        this.f58385c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f58385c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f58385c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> j() {
        return this.f58387e;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f58387e) != null && !hashMap.containsValue(nVar)) {
                this.f58387e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<n> l() {
        return this.f58388f;
    }

    public List<n> m() {
        return this.f58389g;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58383a = frsGoodFragment;
        this.f58391i.setPriority(1);
        this.f58391i.setSelfListener(true);
        this.f58383a.registerListener(this.f58391i);
        y yVar = new y(frsGoodFragment.o(), a2.P2, this.f58383a.getUniqueId());
        d.a.n0.r0.n1.d.k kVar = new d.a.n0.r0.n1.d.k(frsGoodFragment.o(), a2.Q2, this.f58383a.getUniqueId());
        d.a.n0.r0.n1.d.v vVar = new d.a.n0.r0.n1.d.v(frsGoodFragment.o(), a2.S2, this.f58383a.getUniqueId());
        s sVar = new s(frsGoodFragment.o(), a2.T2, this.f58383a.getUniqueId());
        j jVar = new j(frsGoodFragment.o(), a2.V2, this.f58383a.getUniqueId());
        m mVar = new m(frsGoodFragment.o(), a2.W2, this.f58383a.getUniqueId());
        a0 a0Var = new a0(frsGoodFragment.o(), a2.b3, this.f58383a.getUniqueId());
        d.a.n0.r0.n1.d.w wVar = new d.a.n0.r0.n1.d.w(frsGoodFragment.o(), a2.u3, this.f58383a.getUniqueId());
        u uVar = new u(frsGoodFragment.o(), a2.c3, this.f58383a.getUniqueId());
        r rVar = new r(frsGoodFragment.o(), a2.d3, this.f58383a.getUniqueId());
        d.a.n0.r0.n1.d.z zVar = new d.a.n0.r0.n1.d.z(frsGoodFragment.getPageContext(), a2.g3, this.f58383a.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), a2.e3, this.f58383a.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), a2.f3, this.f58383a.getUniqueId());
        d.a.n0.r0.n1.d.z zVar2 = new d.a.n0.r0.n1.d.z(frsGoodFragment.getPageContext(), a2.p3, this.f58383a.getUniqueId());
        d.a.n0.r0.s sVar2 = new d.a.n0.r0.s(frsGoodFragment.getPageContext(), d.a.n0.r0.t.f59658f);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f58383a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), a2.D3, this.f58383a.getUniqueId());
        d.a.c.j.e.a<?, ?> h2 = x.p().h(this.f58383a, AdvertAppInfo.a4);
        d.a.c.j.e.a<?, ?> h3 = x.p().h(this.f58383a, AdvertAppInfo.d4);
        d.a.n0.r0.n1.d.x xVar = new d.a.n0.r0.n1.d.x(frsGoodFragment.getPageContext(), a2.l3, this.f58383a.getUniqueId());
        d.a.n0.r0.n1.d.b bVar = new d.a.n0.r0.n1.d.b(frsGoodFragment.getPageContext(), a2.n3, this.f58383a.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), a2.m3, this.f58383a.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), a2.o3, this.f58383a.getUniqueId());
        d.a.n0.r0.n1.d.e eVar = new d.a.n0.r0.n1.d.e(frsGoodFragment.getPageContext(), a2.a3, this.f58383a.getUniqueId());
        eVar.h0(bdTypeRecyclerView);
        this.f58386d.add(yVar);
        this.f58386d.add(kVar);
        this.f58386d.add(vVar);
        this.f58386d.add(sVar);
        this.f58386d.add(jVar);
        this.f58386d.add(mVar);
        this.f58386d.add(wVar);
        this.f58386d.add(a0Var);
        this.f58386d.add(uVar);
        this.f58386d.add(rVar);
        this.f58386d.add(zVar);
        this.f58386d.add(pVar);
        this.f58386d.add(pVar);
        this.f58386d.add(tVar);
        this.f58386d.add(sVar2);
        this.f58386d.add(zVar);
        this.f58386d.add(zVar2);
        this.f58386d.add(xVar);
        this.f58386d.add(bVar);
        this.f58386d.add(gVar);
        this.f58386d.add(hVar);
        this.f58386d.add(eVar);
        if (a2 != null) {
            this.f58386d.add(a2);
        }
        if (d2 != null) {
            this.f58386d.add(d2);
        }
        this.f58386d.add(h2);
        this.f58386d.add(h3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f58383a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        h(bdTypeRecyclerView);
        this.f58386d.add(d.a.n0.s0.b.e().b(this.f58383a.getBaseFragmentActivity(), AdvertAppInfo.l4));
        this.f58386d.add(d.a.n0.s0.b.e().b(this.f58383a.getBaseFragmentActivity(), AdvertAppInfo.k4));
        d.a.n0.e.f.b bVar2 = new d.a.n0.e.f.b(this.f58383a, 1);
        bVar2.t(this.f58386d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f58386d);
        v("page_frs_good");
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar instanceof d.a.n0.z.a0) {
                ((d.a.n0.z.a0) aVar).k(true);
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        this.f58384b.getAdapter().notifyDataSetChanged();
    }

    public void q() {
        this.f58384b.getAdapter().notifyDataSetChanged();
    }

    public void r(int i2) {
    }

    public void s() {
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar instanceof k) {
                ((k) aVar).h0();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.f58391i);
    }

    public void t() {
        this.f58384b.setData(this.f58389g);
        p();
    }

    public final void u(ArrayList<n> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == a2.I2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<d.a.c.j.e.a> list = this.f58386d;
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
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.a.n0.r0.t)) {
            frsViewData.setThreadList(arrayList);
        }
        z(frsViewData);
        y();
        u(arrayList);
        v.f(arrayList, 1);
        k(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.f58384b.setData(switchThreadDataToThreadCardInfo);
        this.f58389g = switchThreadDataToThreadCardInfo;
        this.f58388f = arrayList;
        this.f58390h = frsViewData;
        C();
    }

    public void x(boolean z) {
        List<d.a.c.j.e.a> list = this.f58386d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        if (ListUtils.isEmpty(this.f58386d) || this.f58383a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f58383a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f58386d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58386d) {
            if (aVar instanceof k) {
                ((k) aVar).m0(frsViewData);
            }
        }
    }
}
