package d.b.i0.p0.e2;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.c3.v;
import d.b.i0.p0.n1.d.a0;
import d.b.i0.p0.n1.d.b0;
import d.b.i0.p0.n1.d.c0;
import d.b.i0.p0.n1.d.d0;
import d.b.i0.p0.n1.d.e0;
import d.b.i0.p0.n1.d.o;
import d.b.i0.p0.n1.d.p;
import d.b.i0.p0.n1.d.q;
import d.b.i0.p0.n1.d.t;
import d.b.i0.p0.n1.d.w;
import d.b.i0.p0.n1.d.x;
import d.b.i0.p0.n1.d.y;
import d.b.i0.p0.n1.d.z;
import d.b.i0.p0.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f57449a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57450b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f57451c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f57453e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.b.b.j.e.n> f57454f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f57455g;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f57452d = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f57456h = new a(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(f.this.f57451c)) {
                f fVar = f.this;
                fVar.g(fVar.f57450b);
                f fVar2 = f.this;
                fVar2.q(fVar2.f57454f, f.this.f57455g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f57450b = bdTypeRecyclerView;
        this.f57453e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57449a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f57449a.registerListener(this.f57456h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57449a != null && bdTypeRecyclerView != null) {
            this.f57451c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    d.b.i0.p0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = d.b.i0.p0.e.e().a(this.f57449a.getPageContext(), g2.get(i), this.f57449a.getUniqueId());
                    if (a2 != null) {
                        this.f57452d.add(a2);
                        this.f57451c.add(a2);
                    }
                }
                if (ListUtils.isEmpty(this.f57451c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f57451c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> h() {
        return this.f57453e;
    }

    public final void i(ArrayList<d.b.b.j.e.n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.b.j.e.n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f57453e) != null && !hashMap.containsValue(nVar)) {
                this.f57453e.put(Integer.valueOf(i), (a2) nVar);
            }
        }
    }

    public List<d.b.b.j.e.n> j() {
        return this.f57454f;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57449a = frsNewAreaFragment;
        c0 c0Var = new c0(frsNewAreaFragment.q(), a2.N2, this.f57449a.getUniqueId());
        c0Var.q0(bdTypeRecyclerView);
        o oVar = new o(frsNewAreaFragment.q(), a2.O2, this.f57449a.getUniqueId());
        oVar.q0(bdTypeRecyclerView);
        z zVar = new z(frsNewAreaFragment.q(), a2.Q2, this.f57449a.getUniqueId());
        zVar.q0(bdTypeRecyclerView);
        w wVar = new w(frsNewAreaFragment.q(), a2.R2, this.f57449a.getUniqueId());
        wVar.q0(bdTypeRecyclerView);
        d.b.i0.p0.n1.d.n nVar = new d.b.i0.p0.n1.d.n(frsNewAreaFragment.q(), a2.T2, this.f57449a.getUniqueId());
        nVar.q0(bdTypeRecyclerView);
        q qVar = new q(frsNewAreaFragment.q(), a2.U2, this.f57449a.getUniqueId());
        qVar.q0(bdTypeRecyclerView);
        e0 e0Var = new e0(frsNewAreaFragment.q(), a2.Z2, this.f57449a.getUniqueId());
        e0Var.q0(bdTypeRecyclerView);
        a0 a0Var = new a0(frsNewAreaFragment.q(), a2.s3, this.f57449a.getUniqueId());
        a0Var.q0(bdTypeRecyclerView);
        y yVar = new y(frsNewAreaFragment.q(), a2.a3, this.f57449a.getUniqueId());
        d.b.i0.p0.n1.d.v vVar = new d.b.i0.p0.n1.d.v(frsNewAreaFragment.q(), a2.b3, this.f57449a.getUniqueId());
        d0 d0Var = new d0(frsNewAreaFragment.getPageContext(), a2.e3, this.f57449a.getUniqueId());
        d0Var.q0(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), a2.x3, this.f57449a.getUniqueId());
        pVar.q0(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getPageContext(), a2.c3, this.f57449a.getUniqueId());
        tVar.q0(bdTypeRecyclerView);
        d.b.i0.p0.n1.d.b bVar = new d.b.i0.p0.n1.d.b(frsNewAreaFragment.getPageContext(), a2.l3, this.f57449a.getUniqueId());
        bVar.q0(bdTypeRecyclerView);
        d.b.i0.p0.n1.d.i iVar = new d.b.i0.p0.n1.d.i(frsNewAreaFragment.getPageContext(), a2.k3, this.f57449a.getUniqueId());
        iVar.q0(bdTypeRecyclerView);
        d.b.i0.p0.n1.d.j jVar = new d.b.i0.p0.n1.d.j(frsNewAreaFragment.getPageContext(), a2.m3, this.f57449a.getUniqueId());
        jVar.q0(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getPageContext(), a2.d3, this.f57449a.getUniqueId());
        xVar.q0(bdTypeRecyclerView);
        d0 d0Var2 = new d0(frsNewAreaFragment.getPageContext(), a2.n3, this.f57449a.getUniqueId());
        d0Var2.q0(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), d.b.i0.p0.t.f58578f);
        sVar.q0(bdTypeRecyclerView);
        d.b.b.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = d.b.i0.p0.e.e().d(frsNewAreaFragment.getPageContext(), this.f57449a.getUniqueId(), true);
        d.b.b.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = d.b.i0.p0.e.e().c(frsNewAreaFragment.getPageContext(), a2.B3, this.f57449a.getUniqueId());
        d.b.b.j.e.a<?, ?> i = d.b.i0.r2.s.o().i(this.f57449a, AdvertAppInfo.h4);
        d.b.b.j.e.a<?, ?> i2 = d.b.i0.r2.s.o().i(this.f57449a, AdvertAppInfo.k4);
        b0 b0Var = new b0(frsNewAreaFragment.getPageContext(), a2.j3, this.f57449a.getUniqueId());
        b0Var.q0(bdTypeRecyclerView);
        d.b.i0.p0.n1.d.g gVar = new d.b.i0.p0.n1.d.g(frsNewAreaFragment.getPageContext(), a2.Y2, this.f57449a.getUniqueId());
        gVar.l0(bdTypeRecyclerView);
        this.f57452d.add(c0Var);
        this.f57452d.add(oVar);
        this.f57452d.add(zVar);
        this.f57452d.add(wVar);
        this.f57452d.add(nVar);
        this.f57452d.add(qVar);
        this.f57452d.add(a0Var);
        this.f57452d.add(e0Var);
        this.f57452d.add(yVar);
        this.f57452d.add(vVar);
        this.f57452d.add(d0Var);
        this.f57452d.add(tVar);
        this.f57452d.add(bVar);
        this.f57452d.add(iVar);
        this.f57452d.add(jVar);
        this.f57452d.add(xVar);
        this.f57452d.add(sVar);
        this.f57452d.add(pVar);
        this.f57452d.add(d0Var2);
        this.f57452d.add(b0Var);
        this.f57452d.add(gVar);
        if (d2 != null) {
            this.f57452d.add(d2);
        }
        if (c2 != null) {
            this.f57452d.add(c2);
        }
        this.f57452d.add(i);
        this.f57452d.add(i2);
        d.b.b.j.e.a<?, ?> c3 = d.b.i0.q0.b.d().c(this.f57449a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        d.b.b.j.e.a<?, ?> c4 = d.b.i0.q0.b.d().c(this.f57449a.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.f57452d.add(c3);
        this.f57452d.add(c4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f57449a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.b.b.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.b.b.j.e.a<?, ?> next = it.next();
                if (next instanceof d.b.i0.p0.k) {
                    ((d.b.i0.p0.k) next).i(this.f57449a.getPageContext(), this.f57449a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.b.b.j.e.a> list = this.f57452d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        f(bdTypeRecyclerView);
        d.b.i0.e.f.b bVar2 = new d.b.i0.e.f.b(this.f57449a, 1);
        bVar2.t(this.f57452d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f57452d);
    }

    public void l() {
        this.f57450b.getAdapter().notifyDataSetChanged();
    }

    public void m() {
        this.f57450b.getAdapter().notifyDataSetChanged();
    }

    public void n(int i) {
    }

    public void o() {
        for (d.b.b.j.e.a aVar : this.f57452d) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).m0();
            } else if (aVar instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar).onDestroy();
            }
        }
    }

    public void p() {
        this.f57450b.setData(this.f57454f);
        l();
    }

    public void q(ArrayList<d.b.b.j.e.n> arrayList, FrsViewData frsViewData) {
        t(frsViewData);
        s();
        v.f(arrayList, 1);
        i(arrayList);
        this.f57450b.setData(arrayList);
        this.f57454f = arrayList;
        this.f57455g = frsViewData;
        v();
    }

    public void r(boolean z) {
        List<d.b.b.j.e.a> list = this.f57452d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57452d) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        if (ListUtils.isEmpty(this.f57452d) || this.f57449a == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57452d) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).r0(this.f57449a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.b.b.j.e.a> list = this.f57452d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57452d) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).p0(frsViewData);
            }
        }
    }

    public void u(d.b.b.j.e.w wVar) {
        List<d.b.b.j.e.a> list = this.f57452d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57452d) {
            if (aVar != null && (aVar instanceof d.b.i0.p0.k)) {
                ((d.b.i0.p0.k) aVar).c0(wVar);
            }
        }
    }

    public final void v() {
        d.b.i0.p0.j2.b b2;
        if (this.f57455g == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57452d) {
            if ((aVar instanceof d.b.i0.p0.j2.d) && (b2 = ((d.b.i0.p0.j2.d) aVar).b()) != null) {
                if (this.f57455g.needLog == 1) {
                    b2.f57699a = true;
                } else {
                    b2.f57699a = false;
                }
                if (this.f57455g.getForum() != null) {
                    b2.f57701c = this.f57455g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57450b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f57450b.getData().size() == 0) {
            return;
        }
        for (d.b.b.j.e.n nVar : this.f57450b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.U2();
                }
            }
        }
    }
}
