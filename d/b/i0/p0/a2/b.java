package d.b.i0.p0.a2;

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
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.c3.v;
import d.b.i0.m.f;
import d.b.i0.p0.e;
import d.b.i0.p0.j2.d;
import d.b.i0.p0.k;
import d.b.i0.p0.n1.d.a0;
import d.b.i0.p0.n1.d.b0;
import d.b.i0.p0.n1.d.c0;
import d.b.i0.p0.n1.d.d0;
import d.b.i0.p0.n1.d.e0;
import d.b.i0.p0.n1.d.g;
import d.b.i0.p0.n1.d.i;
import d.b.i0.p0.n1.d.j;
import d.b.i0.p0.n1.d.o;
import d.b.i0.p0.n1.d.q;
import d.b.i0.p0.n1.d.t;
import d.b.i0.p0.n1.d.x;
import d.b.i0.p0.n1.d.y;
import d.b.i0.p0.s;
import d.b.i0.x.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f57340a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57341b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f57342c;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, a2> f57344e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f57345f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f57346g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f57347h;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f57343d = new LinkedList();
    public CustomMessageListener i = new a(2003008);
    public CustomMessageListener j = new C1377b(2016470);

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
                Iterator<d.b.b.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.b.b.j.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).i(b.this.f57340a.getPageContext(), b.this.f57340a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.f57343d != null) {
                    b.this.f57343d.addAll(arrayList);
                }
                if (b.this.f57341b != null) {
                    b.this.f57341b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.b.i0.p0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1377b extends CustomMessageListener {
        public C1377b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(b.this.f57342c)) {
                b bVar = b.this;
                bVar.i(bVar.f57341b);
                b bVar2 = b.this;
                bVar2.w(bVar2.f57345f, b.this.f57347h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f57341b = bdTypeRecyclerView;
        this.f57344e = new HashMap<>();
    }

    public void A() {
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar instanceof z) {
                ((z) aVar).p(3);
            }
        }
    }

    public void B(w wVar) {
        List<d.b.b.j.e.a> list = this.f57343d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).c0(wVar);
            }
        }
    }

    public final void C() {
        d.b.i0.p0.j2.b b2;
        if (this.f57347h == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if ((aVar instanceof d) && (b2 = ((d) aVar).b()) != null) {
                if (this.f57347h.needLog == 1) {
                    b2.f57700a = true;
                } else {
                    b2.f57700a = false;
                }
                if (this.f57347h.getForum() != null) {
                    b2.f57702c = this.f57347h.getForum().getId();
                }
                if (this.f57340a != null) {
                    b2.f57701b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57341b;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getData() == null || this.f57341b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f57341b.getData()) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.U2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57340a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f57340a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.f57340a != null && bdTypeRecyclerView != null) {
            this.f57342c = new ArrayList();
            ArrayList<BdUniqueId> g2 = v.g();
            if (g2 != null && g2.size() > 0) {
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(this.f57340a.getPageContext(), g2.get(i), this.f57340a.getUniqueId());
                    if (a2 != null) {
                        this.f57343d.add(a2);
                        this.f57342c.add(a2);
                    }
                }
                if (ListUtils.isEmpty(this.f57342c)) {
                    return true;
                }
                bdTypeRecyclerView.a(this.f57342c);
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, a2> j() {
        return this.f57344e;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, a2> hashMap;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f57344e) != null && !hashMap.containsValue(nVar)) {
                this.f57344e.put(Integer.valueOf(i), (a2) nVar);
            }
        }
    }

    public List<n> l() {
        return this.f57345f;
    }

    public List<n> m() {
        return this.f57346g;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57340a = frsGoodFragment;
        this.i.setPriority(1);
        this.i.setSelfListener(true);
        this.f57340a.registerListener(this.i);
        c0 c0Var = new c0(frsGoodFragment.q(), a2.N2, this.f57340a.getUniqueId());
        o oVar = new o(frsGoodFragment.q(), a2.O2, this.f57340a.getUniqueId());
        d.b.i0.p0.n1.d.z zVar = new d.b.i0.p0.n1.d.z(frsGoodFragment.q(), a2.Q2, this.f57340a.getUniqueId());
        d.b.i0.p0.n1.d.w wVar = new d.b.i0.p0.n1.d.w(frsGoodFragment.q(), a2.R2, this.f57340a.getUniqueId());
        d.b.i0.p0.n1.d.n nVar = new d.b.i0.p0.n1.d.n(frsGoodFragment.q(), a2.T2, this.f57340a.getUniqueId());
        q qVar = new q(frsGoodFragment.q(), a2.U2, this.f57340a.getUniqueId());
        e0 e0Var = new e0(frsGoodFragment.q(), a2.Z2, this.f57340a.getUniqueId());
        a0 a0Var = new a0(frsGoodFragment.q(), a2.s3, this.f57340a.getUniqueId());
        y yVar = new y(frsGoodFragment.q(), a2.a3, this.f57340a.getUniqueId());
        d.b.i0.p0.n1.d.v vVar = new d.b.i0.p0.n1.d.v(frsGoodFragment.q(), a2.b3, this.f57340a.getUniqueId());
        d0 d0Var = new d0(frsGoodFragment.getPageContext(), a2.e3, this.f57340a.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), a2.c3, this.f57340a.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), a2.d3, this.f57340a.getUniqueId());
        d0 d0Var2 = new d0(frsGoodFragment.getPageContext(), a2.n3, this.f57340a.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), d.b.i0.p0.t.f58579f);
        d.b.b.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), this.f57340a.getUniqueId(), true);
        d.b.b.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = e.e().c(frsGoodFragment.getPageContext(), a2.B3, this.f57340a.getUniqueId());
        d.b.b.j.e.a<?, ?> i = d.b.i0.r2.s.o().i(this.f57340a, AdvertAppInfo.h4);
        d.b.b.j.e.a<?, ?> i2 = d.b.i0.r2.s.o().i(this.f57340a, AdvertAppInfo.k4);
        b0 b0Var = new b0(frsGoodFragment.getPageContext(), a2.j3, this.f57340a.getUniqueId());
        d.b.i0.p0.n1.d.b bVar = new d.b.i0.p0.n1.d.b(frsGoodFragment.getPageContext(), a2.l3, this.f57340a.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), a2.k3, this.f57340a.getUniqueId());
        j jVar = new j(frsGoodFragment.getPageContext(), a2.m3, this.f57340a.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), a2.Y2, this.f57340a.getUniqueId());
        gVar.l0(bdTypeRecyclerView);
        this.f57343d.add(c0Var);
        this.f57343d.add(oVar);
        this.f57343d.add(zVar);
        this.f57343d.add(wVar);
        this.f57343d.add(nVar);
        this.f57343d.add(qVar);
        this.f57343d.add(a0Var);
        this.f57343d.add(e0Var);
        this.f57343d.add(yVar);
        this.f57343d.add(vVar);
        this.f57343d.add(d0Var);
        this.f57343d.add(tVar);
        this.f57343d.add(tVar);
        this.f57343d.add(xVar);
        this.f57343d.add(sVar);
        this.f57343d.add(d0Var);
        this.f57343d.add(d0Var2);
        this.f57343d.add(b0Var);
        this.f57343d.add(bVar);
        this.f57343d.add(iVar);
        this.f57343d.add(jVar);
        this.f57343d.add(gVar);
        if (d2 != null) {
            this.f57343d.add(d2);
        }
        if (c2 != null) {
            this.f57343d.add(c2);
        }
        this.f57343d.add(i);
        this.f57343d.add(i2);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f57340a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        h(bdTypeRecyclerView);
        this.f57343d.add(d.b.i0.q0.b.d().c(this.f57340a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        this.f57343d.add(d.b.i0.q0.b.d().c(this.f57340a.getBaseFragmentActivity(), AdvertAppInfo.m4));
        d.b.i0.e.f.b bVar2 = new d.b.i0.e.f.b(this.f57340a, 1);
        bVar2.t(this.f57343d);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        bdTypeRecyclerView.a(this.f57343d);
        v("page_frs_good");
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar instanceof d.b.i0.x.a0) {
                ((d.b.i0.x.a0) aVar).d(true);
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        this.f57341b.getAdapter().notifyDataSetChanged();
    }

    public void q() {
        this.f57341b.getAdapter().notifyDataSetChanged();
    }

    public void r(int i) {
    }

    public void s() {
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar instanceof k) {
                ((k) aVar).m0();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public void t() {
        this.f57341b.setData(this.f57346g);
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
        List<d.b.b.j.e.a> list = this.f57343d;
        if (list == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).o(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.b.i0.p0.t)) {
            frsViewData.setThreadList(arrayList);
        }
        z(frsViewData);
        y();
        u(arrayList);
        v.f(arrayList, 1);
        k(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.f57341b.setData(switchThreadDataToThreadCardInfo);
        this.f57346g = switchThreadDataToThreadCardInfo;
        this.f57345f = arrayList;
        this.f57347h = frsViewData;
        C();
    }

    public void x(boolean z) {
        List<d.b.b.j.e.a> list = this.f57343d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        if (ListUtils.isEmpty(this.f57343d) || this.f57340a == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f57340a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.b.b.j.e.a> list = this.f57343d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57343d) {
            if (aVar instanceof k) {
                ((k) aVar).p0(frsViewData);
            }
        }
    }
}
