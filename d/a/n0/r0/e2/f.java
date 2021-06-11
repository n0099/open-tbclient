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
    public FrsNewAreaFragment f62199a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62200b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62201c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f62203e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f62204f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f62205g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62202d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f62206h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f62201c)) {
                f fVar = f.this;
                fVar.g(fVar.f62200b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f62204f, f.this.f62205g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f62200b = bdTypeRecyclerView;
        this.f62203e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f62199a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f62199a.registerListener(this.f62206h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f62199a != null && bdTypeRecyclerView != null) {
            this.f62201c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.n0.r0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = d.a.n0.r0.e.e().b(this.f62199a.getPageContext(), g2.get(i2), this.f62199a.getUniqueId());
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

    public HashMap<Integer, a2> h() {
        return this.f62203e;
    }

    public final void i(ArrayList<d.a.c.k.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.k.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f62203e) != null && !hashMap.containsValue(nVar)) {
                this.f62203e.put(Integer.valueOf(i2), (a2) nVar);
            }
        }
    }

    public List<d.a.c.k.e.n> j() {
        return this.f62204f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62199a = frsNewAreaFragment;
        y yVar = new y(frsNewAreaFragment.p(), a2.S2, this.f62199a.getUniqueId());
        yVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.k kVar = new d.a.n0.r0.n1.d.k(frsNewAreaFragment.p(), a2.T2, this.f62199a.getUniqueId());
        kVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.v vVar = new d.a.n0.r0.n1.d.v(frsNewAreaFragment.p(), a2.V2, this.f62199a.getUniqueId());
        vVar.m0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.p(), a2.W2, this.f62199a.getUniqueId());
        sVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.j jVar = new d.a.n0.r0.n1.d.j(frsNewAreaFragment.p(), a2.Y2, this.f62199a.getUniqueId());
        jVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.m mVar = new d.a.n0.r0.n1.d.m(frsNewAreaFragment.p(), a2.Z2, this.f62199a.getUniqueId());
        mVar.m0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.p(), a2.e3, this.f62199a.getUniqueId());
        a0Var.m0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.p(), a2.x3, this.f62199a.getUniqueId());
        wVar.m0(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.p(), a2.f3, this.f62199a.getUniqueId());
        r rVar = new r(frsNewAreaFragment.p(), a2.g3, this.f62199a.getUniqueId());
        z zVar = new z(frsNewAreaFragment.getPageContext(), a2.j3, this.f62199a.getUniqueId());
        zVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.l lVar = new d.a.n0.r0.n1.d.l(frsNewAreaFragment.getPageContext(), a2.C3, this.f62199a.getUniqueId());
        lVar.m0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.h3, this.f62199a.getUniqueId());
        pVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.b bVar = new d.a.n0.r0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.q3, this.f62199a.getUniqueId());
        bVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.g gVar = new d.a.n0.r0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.p3, this.f62199a.getUniqueId());
        gVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.h hVar = new d.a.n0.r0.n1.d.h(frsNewAreaFragment.getPageContext(), a2.r3, this.f62199a.getUniqueId());
        hVar.m0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.i3, this.f62199a.getUniqueId());
        tVar.m0(bdTypeRecyclerView);
        z zVar2 = new z(frsNewAreaFragment.getPageContext(), a2.s3, this.f62199a.getUniqueId());
        zVar2.m0(bdTypeRecyclerView);
        d.a.n0.r0.s sVar2 = new d.a.n0.r0.s(frsNewAreaFragment.getPageContext(), d.a.n0.r0.t.f63349f);
        sVar2.m0(bdTypeRecyclerView);
        d.a.c.k.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.n0.r0.e.e().a(frsNewAreaFragment.getPageContext(), this.f62199a.getUniqueId(), true);
        d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.n0.r0.e.e().d(frsNewAreaFragment.getPageContext(), a2.G3, this.f62199a.getUniqueId());
        d.a.c.k.e.a<?, ?> h2 = x.p().h(this.f62199a, AdvertAppInfo.d4);
        d.a.c.k.e.a<?, ?> h3 = x.p().h(this.f62199a, AdvertAppInfo.g4);
        d.a.n0.r0.n1.d.x xVar = new d.a.n0.r0.n1.d.x(frsNewAreaFragment.getPageContext(), a2.o3, this.f62199a.getUniqueId());
        xVar.m0(bdTypeRecyclerView);
        d.a.n0.r0.n1.d.e eVar = new d.a.n0.r0.n1.d.e(frsNewAreaFragment.getPageContext(), a2.d3, this.f62199a.getUniqueId());
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
        this.f62202d.add(bVar);
        this.f62202d.add(gVar);
        this.f62202d.add(hVar);
        this.f62202d.add(tVar);
        this.f62202d.add(sVar2);
        this.f62202d.add(lVar);
        this.f62202d.add(zVar2);
        this.f62202d.add(xVar);
        this.f62202d.add(eVar);
        if (a2 != null) {
            this.f62202d.add(a2);
        }
        if (d2 != null) {
            this.f62202d.add(d2);
        }
        this.f62202d.add(h2);
        this.f62202d.add(h3);
        d.a.c.k.e.a<?, ?> b2 = d.a.n0.s0.b.e().b(this.f62199a.getBaseFragmentActivity(), AdvertAppInfo.o4);
        d.a.c.k.e.a<?, ?> b3 = d.a.n0.s0.b.e().b(this.f62199a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        this.f62202d.add(b2);
        this.f62202d.add(b3);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f62199a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.k.e.a<?, ?> next = it.next();
                if (next instanceof d.a.n0.r0.k) {
                    ((d.a.n0.r0.k) next).o(this.f62199a.getPageContext(), this.f62199a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.k.e.a> list = this.f62202d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.a.n0.e.f.b bVar2 = new d.a.n0.e.f.b(this.f62199a, 1);
        bVar2.t(this.f62202d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f62202d);
    }

    public void l() {
        this.f62200b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f62200b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
    }

    public void o() {
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).i0();
            } else if (aVar instanceof d.a.n0.t2.p) {
                ((d.a.n0.t2.p) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f62200b.setData(this.f62204f);
        l();
    }

    public void q(ArrayList<d.a.c.k.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f62200b.setData(arrayList);
        this.f62204f = arrayList;
        this.f62205g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.a.c.k.e.a> list = this.f62202d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f62202d) || this.f62199a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).p0(this.f62199a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list = this.f62202d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).l0(frsViewData);
            }
        }
    }

    public void u(d.a.c.k.e.w wVar) {
        List<d.a.c.k.e.a> list = this.f62202d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if (aVar != null && (aVar instanceof d.a.n0.r0.k)) {
                ((d.a.n0.r0.k) aVar).a0(wVar);
            }
        }
    }

    public final void v() {
        d.a.n0.r0.j2.b j;
        if (this.f62205g == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62202d) {
            if ((aVar instanceof d.a.n0.r0.j2.d) && (j = ((d.a.n0.r0.j2.d) aVar).j()) != null) {
                if (this.f62205g.needLog == 1) {
                    j.f62465a = true;
                } else {
                    j.f62465a = false;
                }
                if (this.f62205g.getForum() != null) {
                    j.f62467c = this.f62205g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62200b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f62200b.getData().size() == 0) {
            return;
        }
        for (d.a.c.k.e.n nVar : this.f62200b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.y0() != 0) {
                    z1Var.w.Z2();
                }
            }
        }
    }
}
