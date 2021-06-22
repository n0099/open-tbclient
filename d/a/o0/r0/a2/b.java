package d.a.o0.r0.a2;

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
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.e3.v;
import d.a.o0.o.f;
import d.a.o0.r0.e;
import d.a.o0.r0.j2.d;
import d.a.o0.r0.k;
import d.a.o0.r0.n1.d.a0;
import d.a.o0.r0.n1.d.g;
import d.a.o0.r0.n1.d.h;
import d.a.o0.r0.n1.d.j;
import d.a.o0.r0.n1.d.m;
import d.a.o0.r0.n1.d.p;
import d.a.o0.r0.n1.d.r;
import d.a.o0.r0.n1.d.s;
import d.a.o0.r0.n1.d.t;
import d.a.o0.r0.n1.d.u;
import d.a.o0.r0.n1.d.y;
import d.a.o0.t2.x;
import d.a.o0.z.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f62199a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62200b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62201c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f62203e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f62204f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f62205g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f62206h;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62202d = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f62207i = new a(2003008);
    public CustomMessageListener j = new C1548b(2016470);

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
                Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(b.this.f62199a.getPageContext(), b.this.f62199a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.f62202d != null) {
                    b.this.f62202d.addAll(arrayList);
                }
                if (b.this.f62200b != null) {
                    b.this.f62200b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.a.o0.r0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1548b extends CustomMessageListener {
        public C1548b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(b.this.f62201c)) {
                b bVar = b.this;
                bVar.i(bVar.f62200b);
                b bVar2 = b.this;
                bVar2.w(bVar2.f62204f, b.this.f62206h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f62200b = bdTypeRecyclerView;
        this.f62203e = new HashMap<>();
    }

    public void A() {
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof z) {
                ((z) aVar).r(3);
            }
        }
    }

    public void B(w wVar) {
        List<d.a.c.k.e.a> list = this.f62202d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).a0(wVar);
            }
        }
    }

    public final void C() {
        d.a.o0.r0.j2.b j;
        if (this.f62206h == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if ((aVar instanceof d) && (j = ((d) aVar).j()) != null) {
                if (this.f62206h.needLog == 1) {
                    j.f62590a = true;
                } else {
                    j.f62590a = false;
                }
                if (this.f62206h.getForum() != null) {
                    j.f62592c = this.f62206h.getForum().getId();
                }
                if (this.f62199a != null) {
                    j.f62591b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62200b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f62200b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f62200b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.y0() != 0) {
                    z1Var.w.Z2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f62199a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f62199a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f62199a != null && bdTypeRecyclerView != null) {
            this.f62201c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f62199a.getPageContext(), g2.get(i2), this.f62199a.getUniqueId());
                    if (b2 != null) {
                        this.f62202d.add(b2);
                        this.f62201c.add(b2);
                    }
                }
                if (ListUtils.isEmpty(this.f62201c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f62201c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> j() {
        return this.f62203e;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f62203e) != null && !hashMap.containsValue(nVar)) {
                this.f62203e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<n> l() {
        return this.f62204f;
    }

    public List<n> m() {
        return this.f62205g;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62199a = frsGoodFragment;
        this.f62207i.setPriority(1);
        this.f62207i.setSelfListener(true);
        this.f62199a.registerListener(this.f62207i);
        y yVar = new y(frsGoodFragment.p(), a2.S2, this.f62199a.getUniqueId());
        d.a.o0.r0.n1.d.k kVar = new d.a.o0.r0.n1.d.k(frsGoodFragment.p(), a2.T2, this.f62199a.getUniqueId());
        d.a.o0.r0.n1.d.v vVar = new d.a.o0.r0.n1.d.v(frsGoodFragment.p(), a2.V2, this.f62199a.getUniqueId());
        s sVar = new s(frsGoodFragment.p(), a2.W2, this.f62199a.getUniqueId());
        j jVar = new j(frsGoodFragment.p(), a2.Y2, this.f62199a.getUniqueId());
        m mVar = new m(frsGoodFragment.p(), a2.Z2, this.f62199a.getUniqueId());
        a0 a0Var = new a0(frsGoodFragment.p(), a2.e3, this.f62199a.getUniqueId());
        d.a.o0.r0.n1.d.w wVar = new d.a.o0.r0.n1.d.w(frsGoodFragment.p(), a2.x3, this.f62199a.getUniqueId());
        u uVar = new u(frsGoodFragment.p(), a2.f3, this.f62199a.getUniqueId());
        r rVar = new r(frsGoodFragment.p(), a2.g3, this.f62199a.getUniqueId());
        d.a.o0.r0.n1.d.z zVar = new d.a.o0.r0.n1.d.z(frsGoodFragment.getPageContext(), a2.j3, this.f62199a.getUniqueId());
        p pVar = new p(frsGoodFragment.getPageContext(), a2.h3, this.f62199a.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), a2.i3, this.f62199a.getUniqueId());
        d.a.o0.r0.n1.d.z zVar2 = new d.a.o0.r0.n1.d.z(frsGoodFragment.getPageContext(), a2.s3, this.f62199a.getUniqueId());
        d.a.o0.r0.s sVar2 = new d.a.o0.r0.s(frsGoodFragment.getPageContext(), d.a.o0.r0.t.f63474f);
        d.a.c.k.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f62199a.getUniqueId(), true);
        d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), a2.G3, this.f62199a.getUniqueId());
        d.a.c.k.e.a<?, ?> h2 = x.p().h(this.f62199a, AdvertAppInfo.d4);
        d.a.c.k.e.a<?, ?> h3 = x.p().h(this.f62199a, AdvertAppInfo.g4);
        d.a.o0.r0.n1.d.x xVar = new d.a.o0.r0.n1.d.x(frsGoodFragment.getPageContext(), a2.o3, this.f62199a.getUniqueId());
        d.a.o0.r0.n1.d.b bVar = new d.a.o0.r0.n1.d.b(frsGoodFragment.getPageContext(), a2.q3, this.f62199a.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), a2.p3, this.f62199a.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), a2.r3, this.f62199a.getUniqueId());
        d.a.o0.r0.n1.d.e eVar = new d.a.o0.r0.n1.d.e(frsGoodFragment.getPageContext(), a2.d3, this.f62199a.getUniqueId());
        eVar.i0(bdTypeRecyclerView);
        this.f62202d.add(yVar);
        this.f62202d.add(kVar);
        this.f62202d.add(vVar);
        this.f62202d.add(sVar);
        this.f62202d.add(jVar);
        this.f62202d.add(mVar);
        this.f62202d.add(wVar);
        this.f62202d.add(a0Var);
        this.f62202d.add(uVar);
        this.f62202d.add(rVar);
        this.f62202d.add(zVar);
        this.f62202d.add(pVar);
        this.f62202d.add(pVar);
        this.f62202d.add(tVar);
        this.f62202d.add(sVar2);
        this.f62202d.add(zVar);
        this.f62202d.add(zVar2);
        this.f62202d.add(xVar);
        this.f62202d.add(bVar);
        this.f62202d.add(gVar);
        this.f62202d.add(hVar);
        this.f62202d.add(eVar);
        if (a2 != null) {
            this.f62202d.add(a2);
        }
        if (d2 != null) {
            this.f62202d.add(d2);
        }
        this.f62202d.add(h2);
        this.f62202d.add(h3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f62199a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        h(bdTypeRecyclerView);
        this.f62202d.add(d.a.o0.s0.b.e().b(this.f62199a.getBaseFragmentActivity(), AdvertAppInfo.o4));
        this.f62202d.add(d.a.o0.s0.b.e().b(this.f62199a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        d.a.o0.e.f.b bVar2 = new d.a.o0.e.f.b(this.f62199a, 1);
        bVar2.t(this.f62202d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f62202d);
        v("page_frs_good");
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof d.a.o0.z.a0) {
                ((d.a.o0.z.a0) aVar).l(true);
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar != null && aVar.H() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        this.f62200b.getAdapter().notifyDataSetChanged();
    }

    public void q() {
        this.f62200b.getAdapter().notifyDataSetChanged();
    }

    public void r(int i2) {
    }

    public void s() {
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof k) {
                ((k) aVar).i0();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.f62207i);
    }

    public void t() {
        this.f62200b.setData(this.f62205g);
        p();
    }

    public final void u(ArrayList<n> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == a2.L2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<d.a.c.k.e.a> list = this.f62202d;
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.a.o0.r0.t)) {
            frsViewData.setThreadList(arrayList);
        }
        z(frsViewData);
        y();
        u(arrayList);
        v.f(arrayList, 1);
        k(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.f62200b.setData(switchThreadDataToThreadCardInfo);
        this.f62205g = switchThreadDataToThreadCardInfo;
        this.f62204f = arrayList;
        this.f62206h = frsViewData;
        C();
    }

    public void x(boolean z) {
        List<d.a.c.k.e.a> list = this.f62202d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        if (ListUtils.isEmpty(this.f62202d) || this.f62199a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f62199a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list = this.f62202d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof k) {
                ((k) aVar).l0(frsViewData);
            }
        }
    }
}
